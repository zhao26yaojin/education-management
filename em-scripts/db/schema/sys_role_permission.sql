DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT "id",
  `role_id` bigint(0) NOT NULL  COMMENT "role id",
  `permission_id` bigint(0) NOT NULL  COMMENT "permission id",
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_role_id`(`role_id`) USING BTREE COMMENT 'role id索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = 'role_permission表' ROW_FORMAT = Dynamic;
