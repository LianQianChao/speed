drop table if exists user;
create table user(
     id int primary key auto_increment comment '主键',
     username varchar(100) not null  comment '用户名',
     nickname varchar(100) not null comment '用户昵称',
     password varchar(100) not null comment '用户密码',
     email varchar(100) not null comment '邮箱',
     enable int default 1 comment '是否启用，0：默认不启用',
     create_time datetime default now() comment '创建时间',
     update_time datetime default now() comment '更新时间',
     changer varchar(100) comment '变更人'
)ENGINE=INNODB DEFAULT CHARSET = UTF8mb4;

insert into user (id, username, nickname, password, email)
values (id,'aaa','一叶知秋','123456','i@lchao.cc');



drop table if exists role;
create table role(
    id int primary key auto_increment comment '主键',
    role varchar(100) not null comment '角色(英文)',
    role_name varchar(100) not null comment '角色名(中文)',
    sort int default 0 comment '排序',
    enable int default 0 comment '是否启用，0：默认不启用',
    create_time datetime default now() comment '创建时间',
    update_time datetime default now() comment '更新时间',
    changer varchar(100) comment '变更人'
)ENGINE = InnoDB default charset = utf8mb4;

insert into role (id, role, role_name) values (id,'admin','管理员');
insert into role (id, role, role_name) values (id,'user','用户');



drop table if exists user_role;
create table user_role(
    id int primary key auto_increment comment '主键',
    user_id int not null comment '用户ID',
    role_id int not null comment '角色ID',
    enable int default 1 comment '是否启用，0：默认不启用',
    create_time datetime default now() comment '创建时间',
    update_time datetime default now() comment '更新时间',
    changer varchar(100) comment '变更人'
)ENGINE = INNODB DEFAULT CHARSET = UTF8mb4;

insert into user_role (id, user_id, role_id) values (id,1,2);


drop table if exists resources;
create table resources(
     id int primary key auto_increment comment 'ID主键',
     name varchar(10) not null comment '名称',
     resource_type int comment '资源类型',
     resource_url varchar(100) comment '资源地址',
     sort int default 0 comment '排序',
     enable int default 1 comment '是否启用,0:默认不启用',
     create_time datetime default now() comment '创建时间',
     update_time datetime default now() comment '修改时间',
     changer varchar(100) comment '变更人'
)ENGINE=InnoDB DEFAULT CHARSET=UTF8mb4;

insert into resources (id, name, resource_type, resource_url) values (id,'日志列表',1,'/system/logs');
insert into resources (id, name, resource_type, resource_url) values (id,'用户列表',1,'/users/user');
insert into resources (id, name, resource_type, resource_url) values (id,'角色列表',1,'/roles/role');


drop table if exists role_resources;
create table role_resources(
    id int primary key auto_increment comment '主键',
    role_id int not null comment '角色ID',
    resources_id int not null comment '资源ID',
    enable int default 1 comment '是否启用，0：默认不启用',
    create_time datetime default now() comment '创建时间',
    update_time datetime default now() comment '更新时间',
    changer varchar(100) comment '变更人'
)ENGINE = INNODB DEFAULT CHARSET = UTF8mb4;

insert into role_resources(id, role_id, resources_id)  values (id,1,1);
insert into role_resources(id, role_id, resources_id)  values (id,1,2);
insert into role_resources(id, role_id, resources_id)  values (id,1,3);

insert into role_resources(id, role_id, resources_id)  values (id,2,1);
insert into role_resources(id, role_id, resources_id)  values (id,2,2);



drop table if exists resources_type;
create table resources_type(
    id int primary key auto_increment comment '主键',
    type_name varchar(100) not null comment '资源类型',
    enable int default 1 comment '是否启用，0：默认不启用',
    create_time datetime default now() comment '创建时间',
    update_time datetime default now() comment '更新时间',
    changer varchar(100) comment '变更人'
)ENGINE = INNODB DEFAULT CHARSET = UTF8mb4;

insert into resources_type (id, type_name) values (1,'菜单');
insert into resources_type (id, type_name) values (2,'按钮');
insert into resources_type (id, type_name) values (3,'功能');



update user_role set role_id = 1 where user_id = 1;

# 查询用户资源
select re.id,rt.type_name,re.resource_url,re.name,r.role_name
    from user u inner join user_role ur on u.id = ur.user_id
        inner join role r on ur.role_id = r.id
        inner join role_resources rr on r.id = rr.role_id
        inner join resources re on re.id = rr.resources_id
        inner join resources_type rt on re.resource_type = rt.id where u.username = 'aaa';