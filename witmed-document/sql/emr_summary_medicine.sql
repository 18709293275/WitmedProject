drop table if exists emr_summary_medicine;
create table emr_summary_medicine(
	id varchar(100) not null comment '主键',
	summary varchar(100) not null comment '所属病历概要',
	medicineUsage varchar(100) comment '药物用法',
	medicineRate varchar(100) comment '药物使用-频率',
	medicineUnit varchar(100) comment '药物使用-剂量单位',
	medicinePerAmount varchar(100) comment '药物使用-次剂量',
	medicineTotalAmount varchar(100) comment '药物使用-总剂量',
	medicineWayCode varchar(100) comment '药物使用-途径代码',
	medicineName date comment '药物名称',
	medicineFormCode varchar(100) comment '药物剂型代码',
	medicineCat varchar(100) comment '药物类型',
	medicineNameCode varchar(100) comment '药物名称代码',
	status varchar(10) not null default 1 comment '系统状态：0-禁用，1-启用',
	createUser varchar(100) comment '创建人',
	createTime timestamp not null default current_timestamp comment '创建时间',
	updateUser varchar(100) comment '修改人',
	updateTime timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
	primary key(id)
)Engine=InnoDB charset=utf8mb4 comment='病历概要用药信息表';