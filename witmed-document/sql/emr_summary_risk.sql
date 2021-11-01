drop table if exists emr_summary_risk;
create table emr_summary_risk(
	id varchar(100) not null comment '主键',
	summary varchar(100) not null comment '所属病历概要',
	riskName varchar(100) comment '个体危险性名称',
	riskCode varchar(100) comment '个体危险性代码',
	status varchar(10) not null default 1 comment '系统状态：0-禁用，1-启用',
	createUser varchar(100) comment '创建人',
	createTime timestamp not null default current_timestamp comment '创建时间',
	updateUser varchar(100) comment '修改人',
	updateTime timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
	primary key(id)
)Engine=InnoDB charset=utf8mb4 comment='病历概要个体危险性信息表';