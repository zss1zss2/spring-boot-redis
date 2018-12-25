CREATE TABLE person (
  id VARCHAR (50) NOT NULL DEFAULT '' COMMENT '主键',
  name VARCHAR (50) DEFAULT '' COMMENT '名字',
  gender VARCHAR (50) DEFAULT '' COMMENT '性别',
  last_modified_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  created_time TIMESTAMP NOT NULL,
  PRIMARY KEY (id)
) DEFAULT CHARSET=UTF8 COMMENT '你好初始化表';
