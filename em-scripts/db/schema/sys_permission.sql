DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT "id",
  `name` varchar(50) NOT NULL  COMMENT "权限名",
  `type` varchar(20) NOT NULL  COMMENT "权限类型: menu/operation",
  `parent_id` bigint(0) NULL DEFAULT NULL  COMMENT "父级id",
  `pid_path` varchar(500) NOT NULL  COMMENT "路径编码",
  `path` varchar(200) NULL DEFAULT NULL  COMMENT "路由",
  `component` varchar(200) NULL DEFAULT NULL  COMMENT "组件路径",
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_name`(`name`) USING BTREE COMMENT '权限名索引',
  INDEX `idx_type`(`type`) USING BTREE COMMENT '权限类型: menu/operation索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = 'permission表' ROW_FORMAT = Dynamic;
