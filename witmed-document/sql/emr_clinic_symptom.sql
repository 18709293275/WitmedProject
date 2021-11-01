drop table if exists emr_clinic_symptom;
create table emr_clinic_symptom(
	id varchar(100) not null comment '主键',
	clinic varchar(100) not null comment '所属门(急)诊病历',
	symptom varchar(500) comment '主诉',
	symptomCodeName varchar(100) comment '症状代码编码体系名称',
	symptomCode varchar(100) comment '症状代码',
	symptomBeginTime timestamp comment '症状开始日期时间',
	symptomEndTime timestamp comment '症状停止日期时间',
	symptomDesc varchar(500) comment '症状描述',
	acuteDegreeCode varchar(100) comment '症状急性程度代码',
	SeverityCode varchar(100) comment '严重程度代码',
	firstVisitSign varchar(100) comment '初诊标志',
	status varchar(10) not null default 1 comment '系统状态：0-禁用，1-启用',
	createAdmin varchar(100) comment '创建人',
	createTime timestamp not null default current_timestamp comment '创建时间',
	updateAdmin varchar(100) comment '修改人',
	updateTime timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
	primary key(id)
)Engine=InnoDB charset=utf8mb4 comment='门(急)诊病历主诉（症状/体征）信息表';