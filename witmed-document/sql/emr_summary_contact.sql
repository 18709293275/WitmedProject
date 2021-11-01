drop table if exists emr_summary_contact;
create table emr_summary_contact(
	id varchar(100) not null comment '主键',
	summary varchar(100) not null comment '所属病历概要',
	noCatCode varchar(100) comment '标识号-类别代码',
	no varchar(100) comment '标识号-号码',
	noEffDate date comment '标识号-生效日期',
	noExpDate date comment '标识号-失效日期',
	noOrgName varchar(100) comment '标识号-提供标识的机构名称',
	objCat varchar(100) comment '姓名-标识对象',
	objCatCode varchar(100) comment '姓名-标识对象代码',
	name varchar(100) comment '姓名',
	status varchar(10) not null default 1 comment '系统状态：0-禁用，1-启用',
	createUser varchar(100) comment '创建人',
	createTime timestamp not null default current_timestamp comment '创建时间',
	updateUser varchar(100) comment '修改人',
	updateTime timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
	primary key(id)
)Engine=InnoDB charset=utf8mb4 comment='病历概要联系人信息表';