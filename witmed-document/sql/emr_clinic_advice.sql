drop table if exists emr_clinic_advice;
create table emr_clinic_advice(
	id varchar(100) not null comment '主键',
	clinic varchar(100) not null comment '所属门(急)诊病历',
	beginTime varchar(100) comment '医嘱开嘱日期时间',
	endTime varchar(100) comment '长期医嘱停嘱日期时间',
	executeTime date comment '医嘱执行日期时间',
	executeTimeCatCode date comment '医嘱执行时间类别代码',
	cancelTime varchar(100) comment '医嘱取消日期时间',
	adviceCat varchar(100) comment '医嘱类别',
	adviceDetail varchar(100) comment '医嘱内容',
	status varchar(10) not null default 1 comment '系统状态：0-禁用，1-启用',
	createAdmin varchar(100) comment '创建人',
	createTime timestamp not null default current_timestamp comment '创建时间',
	updateAdmin varchar(100) comment '修改人',
	updateTime timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
	primary key(id)
)Engine=InnoDB charset=utf8mb4 comment='门(急)诊病历医嘱信息表';