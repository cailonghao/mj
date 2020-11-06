package com.demo.sharing.controller.product;

import com.demo.sharing.pojo.Product;
import com.demo.sharing.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

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
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    SpringTemplateEngine springTemplateEngine;
    @Autowired
    ProductService productService;

    @RequestMapping("/html/addProduct/{id}")
    public String addProduct(@PathVariable long id) {
        Product product = new Product();
        product.setTitle("【网课推荐款】HP/惠普星14青春版星系列14英寸轻薄窄边框笔记本学生本便携办公手提电脑惠普官方旗舰店官网");
        product.setFtitle("超轻薄1.43kg 微边框6.5mm ID:" + id);
        product.setPrice(2099d);
        productService.insertProduct(product);
        return "success";
    }

    @ResponseBody
    @RequestMapping("/addProduct/{id}")
    public String addProduct(HttpServletRequest request, @PathVariable Long id) {
        write(productService.getProduct(id), id);
        return "success";
    }

    @Async("taskExecutor")
    public void write(Product product, Long id) {
        Context context = new Context();
        context.setVariable("product", product);
        context.setVariable("title", "哈士奇");
        context.setVariable("message", "哈士奇是个可爱的狗");
        File dir = new File("F:/nginx-1.18.0/html/product/");
        if (!(dir.exists())) {
            dir.mkdir();
        }
//        String path = "F:/nginx-1.18.0/html/product" + id + ".html";
        File file = new File(dir, id + ".html");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            springTemplateEngine.process("index", context, writer);
        } catch (IOException e) {
            //todo
            e.printStackTrace();
        }
    }


}
