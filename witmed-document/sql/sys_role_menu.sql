drop table if exists sys_role_menu;
create table sys_role_menu(
	role varchar(100) comment '角色信息',
	menu varchar(100) comment '菜单信息'
)Engine=InnoDB charset=utf8mb4 comment='职责角色信息表';