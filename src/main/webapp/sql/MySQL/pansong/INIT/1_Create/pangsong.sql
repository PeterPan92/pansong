
-- ----------------------------
-- Table structure for `pan_song_login`
-- ----------------------------
DROP TABLE IF EXISTS `pan_song_login`;
CREATE TABLE `pan_song_login`(
  `login_id` VARCHAR(32)  NOT NULL COMMENT '登陆id',
  `user_name` VARCHAR(32) NOT NULL COMMENT '用户名',
  `password` VARCHAR(32) NOT NULL COMMENT '密码',
  `status` VARCHAR(6) COMMENT '用户是否开通登陆权限',
  `created_time` datetime COMMENT '应用创建时间',
  `update_time` datetime COMMENT '应用更新时间',
  PRIMARY KEY (`login_id`) COMMENT ' 主键login_id'
)ENGINE=InnoDb DEFAULT CHARSET=utf8   COMMENT='登陆'

-- ----------------------------
-- Table structure for `pan_song_data`
-- ----------------------------
