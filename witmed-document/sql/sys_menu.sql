drop table if exists sys_menu;
create table sys_menu(
	id varchar(100) not null comment '主键',
	parent varchar(100) not null comment '上级菜单',
	text varchar(100) not null comment '菜单名称',
	url varchar(500) comment '操作连接地址',
	icon varchar(100) comment '菜单图标',
	sort int(10) comment '菜单顺序',
	status varchar(2) not null default '1' comment '系统状态：0-禁用，1-启用',
	createAdmin varchar(100) comment '创建人',
	createTime timestamp not null default current_timestamp comment '创建时间',
	updateAdmin varchar(100) comment '修改人',
	updateTime timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
	primary key(id)
)Engine=InnoDB charset=utf8mb4 comment='功能菜单信息表';