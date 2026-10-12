DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT "id",
  `user_id` bigint(0) NOT NULL  COMMENT "user id",
  `role_id` bigint(0) NOT NULL  COMMENT "role id",
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_user_id`(`user_id`) USING BTREE COMMENT 'user id索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = 'user_role表' ROW_FORMAT = Dynamic;
