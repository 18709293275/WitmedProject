drop table if exists emr_summary_communication;
create table emr_summary_communication(
	id varchar(100) not null comment '主键',
	summary varchar(100) not null comment '所属病历概要',
	phoneCat varchar(100) comment '联系电话-类别',
	phoneCatCode varchar(100) comment '联系电话-类别代码',
	phoneNo varchar(100) comment '联系电话-号码',
	email varchar(100) comment '电子邮件地址',
	status varchar(10) not null default 1 comment '系统状态：0-禁用，1-启用',
	createUser varchar(100) comment '创建人',
	createTime timestamp not null default current_timestamp comment '创建时间',
	updateUser varchar(100) comment '修改人',
	updateTime timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
	primary key(id)
)Engine=InnoDB charset=utf8mb4 comment='病历概要通信信息表';