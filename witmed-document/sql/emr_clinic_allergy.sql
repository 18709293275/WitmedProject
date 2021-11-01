drop table if exists emr_clinic_allergy;
create table emr_clinic_allergy(
	id varchar(100) not null comment '主键',
	clinic varchar(100) not null comment '所属门(急)诊病历',
	allergyHistory varchar(500) comment '过敏史',
	allergen varchar(500) comment '过敏原',
	allergySx varchar(500) comment '过敏症状',
	allergySxCode varchar(100) comment '过敏症状代码',
	allergenCode varchar(100) comment '过敏原代码',
	allergyMedicine varchar(500) comment '过敏药物名称',
	allergyStatusCode varchar(100) comment '过敏病情状态代码',
	allergySeriousCode varchar(100) comment '过敏严重性代码',
	allergySignCode varchar(100) comment '过敏史标识代码',
	status varchar(10) not null default 1 comment '系统状态：0-禁用，1-启用',
	createAdmin varchar(100) comment '创建人',
	createTime timestamp not null default current_timestamp comment '创建时间',
	updateAdmin varchar(100) comment '修改人',
	updateTime timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
	primary key(id)
)Engine=InnoDB charset=utf8mb4 comment='门(急)诊病历过敏史信息表';