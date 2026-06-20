DROP TABLE IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT "id",
  `name` varchar(100) NOT NULL  COMMENT "菜单名",
  `parent_id` bigint(0) NULL DEFAULT NULL  COMMENT "父级id",
  `pid_path` varchar(500) NOT NULL  COMMENT "路径编码",
  `url` varchar(200) NOT NULL  COMMENT "路由",
  `component` varchar(200) NOT NULL  COMMENT "组件路径",
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_name`(`name`) USING BTREE COMMENT '菜单名索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = 'menu表' ROW_FORMAT = Dynamic;


