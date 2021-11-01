drop table if exists emr_clinic_past;
create table emr_clinic_past(
	id varchar(100) not null comment '主键',
	clinic varchar(100) not null comment '所属门(急)诊病历',
	diseaseHistory varchar(100) comment '既往疾病史',
	mentalDiagnosis varchar(100) comment '既往精神类疾病诊断名称',
	diseaseName varchar(100) comment '既往疾病名称',
	diseaseCode varchar(100) comment '既往疾病代码',
	diagnosisOrg varchar(100) comment '既往疾病诊断机构',
	diagnosisCode varchar(100) comment '既往疾病诊断机构级别代码',
	diagnosisDate date comment '既往疾病诊断时间',
	diseaseStatusCode varchar(100) comment '疾病当前状态代码',
	status varchar(10) not null default 1 comment '系统状态：0-禁用，1-启用',
	createAdmin varchar(100) comment '创建人',
	createTime timestamp not null default current_timestamp comment '创建时间',
	updateAdmin varchar(100) comment '修改人',
	updateTime timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
	primary key(id)
)Engine=InnoDB charset=utf8mb4 comment='门(急)诊病历既往史信息表';