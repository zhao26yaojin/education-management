DROP TABLE IF EXISTS `sys_role_menu`;

CREATE TABLE `sys_role_menu`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT "id",
  `role_id` bigint(0) NOT NULL  COMMENT "角色id",
  `menu_ids` varchar(500) NOT NULL  COMMENT "菜单id列表",
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_role_id`(`role_id`) USING BTREE COMMENT '角色id索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = 'role_menu表' ROW_FORMAT = Dynamic;


