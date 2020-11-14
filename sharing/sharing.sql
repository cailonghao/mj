DROP TABLE IF EXISTS `product`;

create table `product`
(
    `id`          bigint(20)     NOT NULL auto_increment,
    `title`       varchar(255)   NOT NULL,
    `ftitle`      varchar(255) DEFAULT NULL,
    `pic`         varchar(255) DEFAULT NULL,
    `price`       decimal(10, 2) NOT NULL COMMENT '原价',
    `curPrice`    decimal(10, 2) NOT NULL COMMENT '现价',
    `sort`        int(5)       DEFAULT NULL COMMENT '排序',
    `sale`        int(5)       DEFAULT NULL COMMENT '销量',
    `description` varchar(255) COMMENT '商品描述',
    `stock`       int(5)       DEFAULT NULL COMMENT '库存',
    primary key (`id`)
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

DROP TABLE IF EXISTS `user`;

create table `user`
(
    `id`       bigint(32)   NOT NULL auto_increment,
    `nickName` varchar(255) DEFAULT NULL,
    `userhead` varchar(255) DEFAULT NULL,
    `account`  varchar(255) NOT NULL,
    `password` varchar(255) NOT NULL,
    primary key (`id`)
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

DROP TABLE IF EXISTS `userCart`;

create table `userCart`
(
    `id`          bigint(32) NOT NULL auto_increment,
    `userId`      bigint(32) NOT NULL,
    `pid`         bigint(32) NOT NULL,
    `prodcutName` varchar(255) default NULL,
    `num`         int(2)       default null,
    `status`      int(2)       default null,
    `create_time` datetime     default null,
    `update_time` datetime     default null,
    primary key (`id`)
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

DROP TABLE IF EXISTS `order`;

create table `order`
(
    `id`             bigint(32) NOT NULL auto_increment,
    `uid`            bigint(32) NOT NULL,
    `isPay`          bigint(1)      default NULL,
    `isSend`         bigint(1)      default NULL,
    `type`           bigint(1)      default NULL,
    `orderNumber`    varchar(50)    default NULL,
    `pay_price`      decimal(10, 2) default null,
    `base_price`     decimal(10, 2) default null,
    `delivery`       varchar(50)    default null,
    `deliveryNumber` varchar(50)    default null,
    `payTime`        datetime       default null,
    `send_Time`      datetime       default null,
    `create_time`    datetime       default null,
    `update_time`    datetime       default null,
    primary key (`id`)
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

DROP TABLE IF EXISTS `OrderAndProduct`;

create table `OrderAndProduct`
(
    `id`      bigint(32) NOT NULL auto_increment,
    `pid`     bigint(32) NOT NULL,
    `orderId` bigint(32)     default NULL,
    `price`   decimal(10, 2) default NULL,
    `image`   bigint(100)    default NULL,
    `title`   varchar(50)    default NULL,
    primary key (`id`)
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;



