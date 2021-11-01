drop table if exists emr_clinic_present;
create table emr_clinic_present(
	id varchar(100) not null comment '主键',
	clinic varchar(100) not null comment '所属门(急)诊病历',
	beginDate date comment '起病时间',
	situationDesc varchar(100) comment '起病情况描述',
	sxReason varchar(100) comment '症状开始原因/诱因',
	sxFeature varchar(100) comment '症状特点',
	sxOther varchar(100) comment '伴随症状',
	treatment varchar(100) comment '本疾病既往诊疗经过',
	ordinarySituation varchar(100) comment comment '起病后一般情况',
	baseSxSituation varchar(100) comment '基础疾病诊疗情况',
	status varchar(10) not null default 1 comment '系统状态：0-禁用，1-启用',
	createAdmin varchar(100) comment '创建人',
	createTime timestamp not null default current_timestamp comment '创建时间',
	updateAdmin varchar(100) comment '修改人',
	updateTime timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
	primary key(id)
)Engine=InnoDB charset=utf8mb4 comment='门(急)诊病历现病史信息表';