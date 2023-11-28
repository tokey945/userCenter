-- auto-generated definition
create database user_center;
create table user
(
    id           bigint auto_increment comment '用户ID'
        primary key,
    username     varchar(256) null comment '昵称',
    userAccount  varchar(256) null comment '账号',
    email        varchar(256) null comment '邮箱',
    avatarUrl    varchar(1024) null comment '头像',
    gender       tinyint null comment '性别',
    userPassword varchar(256)       not null comment '密码',
    phone        varchar(256) null comment '手机号',
    userStatus   int      default 0 not null comment '状态 0 - 正常',
    userRole     int      default 0 not null comment '用户角色    0 - 普通用户    1 - 管理员',
    createTime   datetime default CURRENT_TIMESTAMP null comment '创建时间',
    updateTime   datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     int      default 0 null comment '逻辑删除',
    planetCode   varchar(512) null comment '星球编号'
);


INSERT INTO tokey.user (id, username, userAccount, email, avatarUrl, gender, userPassword, phone, userStatus, userRole,
                        createTime, updateTime, isDelete, planetCode)
VALUES (2, 'admin', 'admin', '204722754@gmail.com',
        'https://cdn.sspai.com/article/7e60f485-2e83-5d1c-2b82-7dcbcd9a1d49.png?imageMogr2/auto-orient/quality/95/thumbnail/!200x200r/gravity/Center/crop/200x200/interlace/1',
        1, 'a30b1ce78569d07f1f301a4de7292eeb', '1798969822', 0, 1, '2023-11-07 22:07:30', '2023-11-20 23:21:58', 0,
        '12321');
INSERT INTO tokey.user (id, username, userAccount, email, avatarUrl, gender, userPassword, phone, userStatus, userRole,
                        createTime, updateTime, isDelete, planetCode)
VALUES (3, 'tokey', 'tokey', '204723452@qq.com',
        'https://cdn.sspai.com/ui/otter_avatar_placeholder.png?imageMogr2/auto-orient/quality/95/thumbnail/!80x80r/gravity/Center/crop/80x80/interlace/1',
        1, 'a30b1ce78569d07f1f301a4de7292eeb', '1767345222', 0, 0, '2023-11-13 23:49:01', '2023-11-20 23:21:58', 0,
        null);
INSERT INTO tokey.user (id, username, userAccount, email, avatarUrl, gender, userPassword, phone, userStatus, userRole,
                        createTime, updateTime, isDelete, planetCode)
VALUES (8, 'GNwCmc', '我是张三', null, 'https://cdn-static.sspai.com/ui/otter_avatar_placeholder.png', null,
        'a30b1ce78569d07f1f301a4de7292eeb', null, 0, 0, '2023-11-20 23:25:32', '2023-11-20 23:25:32', 0, '42343');
INSERT INTO tokey.user (id, username, userAccount, email, avatarUrl, gender, userPassword, phone, userStatus, userRole,
                        createTime, updateTime, isDelete, planetCode)
VALUES (9, 'JTikNb', 'tokey3', null, 'https://cdn-static.sspai.com/ui/otter_avatar_placeholder.png', null,
        'a30b1ce78569d07f1f301a4de7292eeb', null, 0, 0, '2023-11-23 23:27:17', '2023-11-23 23:27:17', 0, '12345');
INSERT INTO tokey.user (id, username, userAccount, email, avatarUrl, gender, userPassword, phone, userStatus, userRole,
                        createTime, updateTime, isDelete, planetCode)
VALUES (10, 'QkEozo', '小李Li', null, 'https://cdn-static.sspai.com/ui/otter_avatar_placeholder.png', null,
        'a30b1ce78569d07f1f301a4de7292eeb', null, 0, 0, '2023-11-23 23:35:40', '2023-11-23 23:35:40', 0, '12343');
