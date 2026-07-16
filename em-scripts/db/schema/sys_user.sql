DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT "id",
  `name` varchar(50) NOT NULL  COMMENT "用户名",
  `password` varchar(50) NOT NULL  COMMENT "密码",
  `gender` varchar(10) NULL DEFAULT NULL  COMMENT "性别",
  `email` varchar(100) NULL DEFAULT NULL  COMMENT "邮箱",
  `phone` varchar(20) NULL DEFAULT NULL  COMMENT "手机",
  `status` int(0) NOT NULL  COMMENT "状态",
  `deleted` bigint(0) NULL DEFAULT NULL  COMMENT "逻辑删除",
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_name`(`name`) USING BTREE COMMENT '用户名索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = 'user表' ROW_FORMAT = Dynamic;


