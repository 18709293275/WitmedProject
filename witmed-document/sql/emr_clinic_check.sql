drop table if exists emr_clinic_check;
create table emr_clinic_check(
	id varchar(100) not null comment '主键',
	clinic varchar(100) not null comment '所属门(急)诊病历',
	obsCat varchar(100) comment '观察-类别',
	obsCatCode varchar(100) comment '观察-类别代码',
	obsItemName varchar(100) comment '观察项目名称',
	obsItemCode varchar(100) comment '观察-项目代码',
	obsResultDesc varchar(100) comment '观察-结果描述',
	obsResult decimal(10, 2) comment '观察-结果(数值)',
	obsUnit varchar(100) comment comment '观察-计量单位',
	obsResultCode varchar(100) comment '观察-结果代码',
	status varchar(10) not null default 1 comment '系统状态：0-禁用，1-启用',
	createAdmin varchar(100) comment '创建人',
	createTime timestamp not null default current_timestamp comment '创建时间',
	updateAdmin varchar(100) comment '修改人',
	updateTime timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
	primary key(id)
)Engine=InnoDB charset=utf8mb4 comment='门(急)诊病历体格检查信息表';