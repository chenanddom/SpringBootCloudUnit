# SpringBoot使用SpringDataJPA完成CRUD



sql:

    DROP TABLE IF EXISTS `t_user`;
    CREATE TABLE `t_user` (
      `t_id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
      `t_name` VARCHAR(30) DEFAULT NULL COMMENT '名称',
      `t_age` INT(10) DEFAULT NULL COMMENT '年龄',
      `t_address` VARCHAR(100) DEFAULT NULL COMMENT '家庭住址',
      PRIMARY KEY (`t_id`)
    ) ENGINE=INNODB CHARSET utf8 COLLATE utf8_general_ci;