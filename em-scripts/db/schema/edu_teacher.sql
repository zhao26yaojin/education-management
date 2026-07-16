DROP TABLE IF EXISTS `edu_teacher`;

CREATE TABLE `edu_teacher`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT "id",
  `name` varchar(50) NOT NULL  COMMENT "名字",
  `level` int(0) NULL DEFAULT NULL  COMMENT "级别",
  `avatar` varchar(0) NULL DEFAULT NULL  COMMENT "头像",
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_name`(`name`) USING BTREE COMMENT '名字索引',
  INDEX `idx_level`(`level`) USING BTREE COMMENT '级别索引'
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '讲师表表' ROW_FORMAT = Dynamic;


