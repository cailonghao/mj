package com.demo.sharing.controller.product;

import com.demo.sharing.pojo.Product;
import com.demo.sharing.service.ProductService;
import com.demo.sharing.util.Reply;
import com.demo.sharing.util.ReplyEnum;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Description TODO
 * @Date 2020/11/4 14:35
 * @Created by cai
 */
@Api("商品API")
@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    SpringTemplateEngine springTemplateEngine;
    @Resource
    ProductService productService;

    @ApiOperation(value = "编辑商品", produces = "application/json", notes = "编辑商品", httpMethod = "POST", response = Reply.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", value = "标题", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "ftitle", value = "副标题", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "pic", value = "图片", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "description", value = "描述", paramType = "query", dataType = "String", required = true),
            @ApiImplicitParam(name = "price", value = "原价", paramType = "query", dataType = "double", required = true),
            @ApiImplicitParam(name = "curPrice", value = "现价", paramType = "query", dataType = "double", required = true),
            @ApiImplicitParam(name = "sort", value = "排序", defaultValue = "0", paramType = "query", dataType = "int", required = false),
            @ApiImplicitParam(name = "sale", value = "销量", paramType = "query", dataType = "int", required = true),
            @ApiImplicitParam(name = "stock", value = "库存", paramType = "query", dataType = "int", required = true),
    })
    @RequestMapping("/addProduct")
    public Reply addProduct(@RequestParam String title,
                            @RequestParam String ftitle,
                            @RequestParam String pic,
                            @RequestParam String description,
                            @RequestParam Double price,
                            @RequestParam Double curPrice,
                            @RequestParam(defaultValue = "0") Integer sort,
                            @RequestParam Integer sale,
                            @RequestParam Integer stock) {
        Product p = new Product();
        p.setTitle(title);
        p.setFtitle(ftitle);
        p.setPic(pic);
        p.setDescription(description);
        p.setPrice(price);
        p.setCurPrice(curPrice);
        p.setSort(sort);
        p.setSale(sale);
        p.setStock(stock);
        Long id = productService.insertProduct(p);
        write(p);
        return Reply.otherError(ReplyEnum.SUCCESS);
    }

    @Async("taskExecutor")
    public void write(Product product) {
        log.info("创建商品模板:{}", product.getId());
        Context context = new Context();
        context.setVariable("product", product);
        File dir = new File("F:/nginx-1.18.0/html/product/");
        if (!(dir.exists())) {
            dir.mkdir();
        }
        File file = new File(dir, product.getId() + ".html");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            springTemplateEngine.process("product", context, writer);
        } catch (IOException e) {
            //todo
            e.printStackTrace();
        }
    }


}
