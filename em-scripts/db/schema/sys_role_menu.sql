DROP TABLE IF EXISTS `sys_role_menu`;

CREATE TABLE `sys_role_menu`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT "id",
  `role_id` bigint(0) NOT NULL  COMMENT "role id",
  `menu_id` bigint(0) NOT NULL  COMMENT "menu id",
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_role_id`(`role_id`) USING BTREE COMMENT 'role id索引',
  INDEX `idx_menu_id`(`menu_id`) USING BTREE COMMENT 'menu id索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = 'role_menu表' ROW_FORMAT = Dynamic;


