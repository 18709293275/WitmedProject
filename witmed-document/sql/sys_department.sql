drop table if exists sys_department;
create table sys_department(
	id varchar(100) not null comment '主键',
	parent varchar(100) not null unique comment '所属上级部门编码',
	name varchar(100) not null unique comment '部门名称',
	code varchar(100) not null unique comment '部门编码',
	status varchar(2) not null default '1' comment '系统状态：0-禁用，1-启用',
	createAdmin varchar(100) comment '创建人',
	createTime timestamp not null default current_timestamp comment '创建时间',
	updateAdmin varchar(100) comment '修改人',
	updateTime timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
	primary key(id)
)Engine=InnoDB charset=utf8mb4 comment='管理人员部门信息表';