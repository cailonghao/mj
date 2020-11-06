DROP TABLE IF EXISTS `product`;

create table `product` (
    `id` int(32) NOT NULL auto_increment,
    `title` varchar(255) NOT NULL,
    `ftitle` varchar(255) NOT NULL,
    `price` double NOT NULL,
    primary key (`id`)
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = DYNAMIC;