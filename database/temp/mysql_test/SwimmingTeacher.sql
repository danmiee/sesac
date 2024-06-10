DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
	`oauth_login_id`	varchar(255)	NOT NULL,
	`oauth_login_platform`	varchar(32)	NOT NULL,
	`Name`	varchar(32)	NOT NULL,
	`Gender`	varchar(2)	NOT NULL,
	`BirthDate`	date	NOT NULL,
	`Height`	float	NULL,
	`Weight`	float	NULL,
	`Preference`	varchar(16)	NOT NULL,
	`Goal`	varchar(16)	NOT NULL	COMMENT '다이어트 / 재활 / 근력강화 등등',
	`Created`	datetime	NOT NULL,
	`Updated`	datetime	NOT NULL	DEFAULT 생성일시
);

DROP TABLE IF EXISTS `Level Log`;

CREATE TABLE `Level Log` (
	`levellog_id`	number	NOT NULL,
	`oauth_login_id`	varchar(255)	NOT NULL,
	`oauth_login_platform`	varchar(32)	NOT NULL,
	`training_name`	varchar(10)	NOT NULL	COMMENT 'meta참조',
	`user_level`	varchar(3)	NOT NULL	COMMENT 'meta참조',
	`standard_name`	varchar(10)	NOT NULL	COMMENT 'meta참조',
	`created`	datetime	NOT NULL,
	`updated`	datetime	NOT NULL	DEFAULT 생성일시
);

DROP TABLE IF EXISTS `performance`;

CREATE TABLE `performance` (
	`performance_name`	varchar(10)	NOT NULL	COMMENT 'meta참조',
	`oauth_login_id`	varchar(255)	NOT NULL,
	`oauth_login_platform`	varchar(32)	NOT NULL,
	`created`	datetime	NOT NULL,
	`updated`	datetime	NOT NULL	DEFAULT 생성일시
);

DROP TABLE IF EXISTS `routine`;

CREATE TABLE `routine` (
	`routine_id`	number	NOT NULL	COMMENT '유저별 넘버링 / Auto Increment',
	`oauth_login_id`	varchar(255)	NOT NULL,
	`oauth_login_platform`	varchar(32)	NOT NULL,
	`routine_name`	varchar(20)	NOT NULL	DEFAULT id	COMMENT '사용자가 수정 가능한 루틴명',
	`unit_length`	number	NOT NULL	COMMENT '루틴 생성 시 선택한 레인 길이',
	`target_distance`	number	NOT NULL	DEFAULT 1000	COMMENT '루틴 생성 시 선택한 목표 거리',
	`sel_strokes`	text	NOT NULL	COMMENT '루틴 생성 시 선택한 영법 목록',
	`created`	datetime	NOT NULL,
	`updated`	datetime	NOT NULL	DEFAULT 생성일시
);

DROP TABLE IF EXISTS `Level Classification`;

CREATE TABLE `Level Classification` (
	`training_name`	varchar(10)	NOT NULL	COMMENT 'meta참조',
	`user_level`	varchar(3)	NOT NULL	COMMENT 'meta참조',
	`standard_name`	varchar(10)	NOT NULL	COMMENT 'meta참조',
	`content`	varchar(255)	NOT NULL	COMMENT '설문내용',
	`created`	datetime	NOT NULL,
	`updated`	datetime	NOT NULL	DEFAULT 생성일시
);

DROP TABLE IF EXISTS `training`;

CREATE TABLE `training` (
	`training_id`	number	NOT NULL	COMMENT 'Auto Increment',
	`training_name`	varchar(10)	NOT NULL	COMMENT 'meta참조',
	`training_level`	varchar(3)	NOT NULL	COMMENT 'meta참조',
	`distance`	number	NOT NULL	COMMENT '세트 당 훈련 거리',
	`set`	number	NOT NULL	COMMENT '훈련 반복 횟수',
	`created`	datetime	NOT NULL,
	`updated`	datetime	NOT NULL	DEFAULT 생성일시
);

DROP TABLE IF EXISTS `oauth_login`;

CREATE TABLE `oauth_login` (
	`oauth_login_id`	varchar(255)	NOT NULL	COMMENT '플랫폼에서 제공하는 id (ex. 구글이메일)',
	`oauth_login_platform`	varchar(32)	NOT NULL,
	`id_token`	varchar(255)	NOT NULL,
	`access_token`	varchar(255)	NOT NULL,
	`refresh_token`	varchar(255)	NOT NULL,
	`token_expiry`	date	NOT NULL,
	`created`	datetime	NOT NULL,
	`updated`	datetime	NOT NULL	DEFAULT 생성일시
);

DROP TABLE IF EXISTS `oauth_data`;

CREATE TABLE `oauth_data` (
	`data_type`	varchar(10)	NOT NULL	COMMENT 'meta참조',
	`oauth_login_id`	varchar(255)	NOT NULL	COMMENT '난수생성',
	`oauth_login_platform`	varchar(32)	NOT NULL,
	`oauth_app_id`	varchar(255)	NOT NULL	COMMENT '헬스커넥트 id ( id + 변경토큰 + 생성일시 기준으로 데이터 동기화 변경사항 검색함)',
	`changes_token`	varchar(255)	NOT NULL	COMMENT '데이터 유형별 토큰 (다음 요청을 위해서 저장)',
	`expire_date`	date	NOT NULL	COMMENT '토큰 유효기간 30일 (매일 back에서 토큰 유효기간이 7일 이내인 데이터 확인필요)',
	`created`	datetime	NOT NULL	COMMENT '업데이트시 가장 최근 기록을 불러오는 용도',
	`updated`	datetime	NOT NULL	DEFAULT 생성일시
);

DROP TABLE IF EXISTS `meta`;

CREATE TABLE `meta` (
	`section`	VARCHAR(255)	NOT NULL,
	`item`	VARCHAR(255)	NOT NULL,
	`value`	VARCHAR(255)	NOT NULL,
	`description`	VARCHAR(255)	NULL
);

DROP TABLE IF EXISTS `training for routine`;

CREATE TABLE `training for routine` (
	`routine_id`	number	NOT NULL	COMMENT '유저별 넘버링 / Auto Increment',
	`oauth_login_id`	varchar(255)	NOT NULL,
	`oauth_login_platform`	varchar(32)	NOT NULL,
	`session`	varchar(10)	NOT NULL	COMMENT 'meta참조',
	`training_id`	number	NOT NULL	COMMENT 'Auto Increment',
	`training_name`	varchar(10)	NOT NULL	COMMENT 'meta참조',
	`created`	datetime	NOT NULL,
	`updated`	datetime	NOT NULL	DEFAULT 생성일시
);

DROP TABLE IF EXISTS `level`;

CREATE TABLE `level` (
	`levellog_id`	number	NOT NULL,
	`oauth_login_id`	varchar(255)	NOT NULL,
	`oauth_login_platform`	varchar(32)	NOT NULL,
	`created`	datetime	NOT NULL,
	`updated`	datetime	NOT NULL	DEFAULT 생성일시
);

DROP TABLE IF EXISTS `record`;

CREATE TABLE `record` (
	`starttime`	datetime	NOT NULL,
	`stoptime`	datetime	NOT NULL,
	`info`	varchar(10)	NOT NULL,
	`value`	bigint	NOT NULL,
	`oauth_login_id`	varchar(255)	NOT NULL,
	`oauth_login_platform`	varchar(32)	NOT NULL,
	`created`	datetime	NOT NULL,
	`updated`	datetime	NOT NULL	DEFAULT 생성일시
);

ALTER TABLE `user` ADD CONSTRAINT `PK_USER` PRIMARY KEY (
	`oauth_login_id`,
	`oauth_login_platform`
);

ALTER TABLE `Level Log` ADD CONSTRAINT `PK_LEVEL LOG` PRIMARY KEY (
	`levellog_id`,
	`oauth_login_id`,
	`oauth_login_platform`
);

ALTER TABLE `performance` ADD CONSTRAINT `PK_PERFORMANCE` PRIMARY KEY (
	`performance_name`,
	`oauth_login_id`,
	`oauth_login_platform`
);

ALTER TABLE `routine` ADD CONSTRAINT `PK_ROUTINE` PRIMARY KEY (
	`routine_id`,
	`oauth_login_id`,
	`oauth_login_platform`
);

ALTER TABLE `Level Classification` ADD CONSTRAINT `PK_LEVEL CLASSIFICATION` PRIMARY KEY (
	`training_name`,
	`user_level`,
	`standard_name`
);

ALTER TABLE `training` ADD CONSTRAINT `PK_TRAINING` PRIMARY KEY (
	`training_id`,
	`training_name`
);

ALTER TABLE `oauth_login` ADD CONSTRAINT `PK_OAUTH_LOGIN` PRIMARY KEY (
	`oauth_login_id`,
	`oauth_login_platform`
);

ALTER TABLE `oauth_data` ADD CONSTRAINT `PK_OAUTH_DATA` PRIMARY KEY (
	`data_type`,
	`oauth_login_id`,
	`oauth_login_platform`
);

ALTER TABLE `meta` ADD CONSTRAINT `PK_META` PRIMARY KEY (
	`section`,
	`item`,
	`value`
);

ALTER TABLE `training for routine` ADD CONSTRAINT `PK_TRAINING FOR ROUTINE` PRIMARY KEY (
	`routine_id`,
	`oauth_login_id`,
	`oauth_login_platform`
);

ALTER TABLE `level` ADD CONSTRAINT `PK_LEVEL` PRIMARY KEY (
	`levellog_id`,
	`oauth_login_id`,
	`oauth_login_platform`
);

ALTER TABLE `record` ADD CONSTRAINT `PK_RECORD` PRIMARY KEY (
	`starttime`
);

ALTER TABLE `user` ADD CONSTRAINT `FK_oauth_login_TO_user_1` FOREIGN KEY (
	`oauth_login_id`
)
REFERENCES `oauth_login` (
	`oauth_login_id`
);

ALTER TABLE `user` ADD CONSTRAINT `FK_oauth_login_TO_user_2` FOREIGN KEY (
	`oauth_login_platform`
)
REFERENCES `oauth_login` (
	`oauth_login_platform`
);

ALTER TABLE `Level Log` ADD CONSTRAINT `FK_user_TO_Level Log_1` FOREIGN KEY (
	`oauth_login_id`
)
REFERENCES `user` (
	`oauth_login_id`
);

ALTER TABLE `Level Log` ADD CONSTRAINT `FK_user_TO_Level Log_2` FOREIGN KEY (
	`oauth_login_platform`
)
REFERENCES `user` (
	`oauth_login_platform`
);

ALTER TABLE `Level Log` ADD CONSTRAINT `FK_Level Classification_TO_Level Log_1` FOREIGN KEY (
	`training_name`
)
REFERENCES `Level Classification` (
	`training_name`
);

ALTER TABLE `Level Log` ADD CONSTRAINT `FK_Level Classification_TO_Level Log_2` FOREIGN KEY (
	`user_level`
)
REFERENCES `Level Classification` (
	`user_level`
);

ALTER TABLE `Level Log` ADD CONSTRAINT `FK_Level Classification_TO_Level Log_3` FOREIGN KEY (
	`standard_name`
)
REFERENCES `Level Classification` (
	`standard_name`
);

ALTER TABLE `performance` ADD CONSTRAINT `FK_user_TO_performance_1` FOREIGN KEY (
	`oauth_login_id`
)
REFERENCES `user` (
	`oauth_login_id`
);

ALTER TABLE `performance` ADD CONSTRAINT `FK_user_TO_performance_2` FOREIGN KEY (
	`oauth_login_platform`
)
REFERENCES `user` (
	`oauth_login_platform`
);

ALTER TABLE `routine` ADD CONSTRAINT `FK_user_TO_routine_1` FOREIGN KEY (
	`oauth_login_id`
)
REFERENCES `user` (
	`oauth_login_id`
);

ALTER TABLE `routine` ADD CONSTRAINT `FK_user_TO_routine_2` FOREIGN KEY (
	`oauth_login_platform`
)
REFERENCES `user` (
	`oauth_login_platform`
);

ALTER TABLE `oauth_data` ADD CONSTRAINT `FK_user_TO_oauth_data_1` FOREIGN KEY (
	`oauth_login_id`
)
REFERENCES `user` (
	`oauth_login_id`
);

ALTER TABLE `oauth_data` ADD CONSTRAINT `FK_user_TO_oauth_data_2` FOREIGN KEY (
	`oauth_login_platform`
)
REFERENCES `user` (
	`oauth_login_platform`
);

ALTER TABLE `training for routine` ADD CONSTRAINT `FK_routine_TO_training for routine_1` FOREIGN KEY (
	`routine_id`
)
REFERENCES `routine` (
	`routine_id`
);

ALTER TABLE `training for routine` ADD CONSTRAINT `FK_routine_TO_training for routine_2` FOREIGN KEY (
	`oauth_login_id`
)
REFERENCES `routine` (
	`oauth_login_id`
);

ALTER TABLE `training for routine` ADD CONSTRAINT `FK_routine_TO_training for routine_3` FOREIGN KEY (
	`oauth_login_platform`
)
REFERENCES `routine` (
	`oauth_login_platform`
);

ALTER TABLE `training for routine` ADD CONSTRAINT `FK_training_TO_training for routine_1` FOREIGN KEY (
	`training_id`
)
REFERENCES `training` (
	`training_id`
);

ALTER TABLE `training for routine` ADD CONSTRAINT `FK_training_TO_training for routine_2` FOREIGN KEY (
	`training_name`
)
REFERENCES `training` (
	`training_name`
);

ALTER TABLE `level` ADD CONSTRAINT `FK_Level Log_TO_level_1` FOREIGN KEY (
	`levellog_id`
)
REFERENCES `Level Log` (
	`levellog_id`
);

ALTER TABLE `level` ADD CONSTRAINT `FK_Level Log_TO_level_2` FOREIGN KEY (
	`oauth_login_id`
)
REFERENCES `Level Log` (
	`oauth_login_id`
);

ALTER TABLE `level` ADD CONSTRAINT `FK_Level Log_TO_level_3` FOREIGN KEY (
	`oauth_login_platform`
)
REFERENCES `Level Log` (
	`oauth_login_platform`
);

ALTER TABLE `record` ADD CONSTRAINT `FK_user_TO_record_1` FOREIGN KEY (
	`oauth_login_id`
)
REFERENCES `user` (
	`oauth_login_id`
);

ALTER TABLE `record` ADD CONSTRAINT `FK_user_TO_record_2` FOREIGN KEY (
	`oauth_login_platform`
)
REFERENCES `user` (
	`oauth_login_platform`
);

