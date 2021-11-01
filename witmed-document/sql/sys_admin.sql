drop table if exists sys_admin;
create table sys_admin(
	id varchar(100) not null comment '主键',
	name varchar(100) not null comment '姓名',
	cellphone varchar(100) not null unique comment '手机号码',
	password varchar(500) not null comment '登录密码：MD5 加密',
	identity varchar(2) comment '人员身份：0-行政人员，1-医护人员',
	role varchar(100) comment '人员职务',
	department varchar(100) comment '所属部门',
	idCard varchar(100) comment '身份证号码',
	techPosition varchar(100) comment '专业技术职务',
	eduBackground varchar(100) comment '学历',
	major varchar(100) comment '所学专业',
	techPositionRank varchar(100) comment '专业技术职务等级',
	position varchar(100) comment '职务',
	status varchar(2) not null default '1' comment '系统状态：0-禁用，1-启用',
	createAdmin varchar(100) comment '创建人',
	createTime timestamp not null default current_timestamp comment '创建时间',
	updateAdmin varchar(100) comment '修改人',
	updateTime timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
	primary key(id)
)Engine=InnoDB charset=utf8mb4 comment='医院人员信息表';