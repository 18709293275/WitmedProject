drop table if exists emr_summary_expense;
create table emr_summary_expense(
	id varchar(100) not null comment '主键',
	summary varchar(100) not null comment '所属病历概要',
	expenseCat varchar(100) comment '门诊费用-分类',
	expenseCatCode varchar(100) comment '门诊费用-分类代码',
	expenseAmount decimal(10,2) comment '门诊费用-金额（元/人民币）',
	expensePayTypeCode varchar(100) comment '门诊费用-支付方式代码',
	personalAmount decimal(10,2) comment '个人承担费用（元）',
	status varchar(10) not null default 1 comment '系统状态：0-禁用，1-启用',
	createUser varchar(100) comment '创建人',
	createTime timestamp not null default current_timestamp comment '创建时间',
	updateUser varchar(100) comment '修改人',
	updateTime timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
	primary key(id)
)Engine=InnoDB charset=utf8mb4 comment='病历概要用药信息表';