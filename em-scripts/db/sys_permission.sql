DROP TABLE IF EXISTS `sys_permission`;

CREATE TABLE `sys_permission`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT "id",
  `name` varchar(50) NOT NULL  COMMENT "名字",
  `parent_id` bigint(0) NULL DEFAULT NULL  COMMENT "父级id",
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_name`(`name`) USING BTREE COMMENT '名字索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = 'permission表' ROW_FORMAT = Dynamic;


