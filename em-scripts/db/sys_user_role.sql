DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT "id",
  `user_id` bigint(0) NOT NULL  COMMENT "用户id",
  `role_ids` varchar(500) NOT NULL  COMMENT "角色id列表",
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_user_id`(`user_id`) USING BTREE COMMENT '用户id索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = 'user_role表' ROW_FORMAT = Dynamic;


