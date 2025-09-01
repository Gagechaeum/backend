DROP DATABASE IF EXISTS gagechaeum_db;
CREATE DATABASE gagechaeum_db;
USE gagechaeum_db;

-- 1. 사용자 및 사업자 정보
CREATE TABLE `users` (
    `user_id`           BIGINT       NOT NULL AUTO_INCREMENT,
    `email`             VARCHAR(255) NOT NULL UNIQUE,
    `password`          VARCHAR(255) NOT NULL,
    `nick`              VARCHAR(255) NOT NULL UNIQUE,
    `name`              VARCHAR(255) NOT NULL,
    `phone`             VARCHAR(255) NULL,
    `created_at`        DATETIME     DEFAULT CURRENT_TIMESTAMP,
    `social`            VARCHAR(255) NULL COMMENT '소셜 provider',
    `social_id`         VARCHAR(255) NULL COMMENT '소셜 계정',
    `deleted_at`        DATETIME     NULL,
    `notification`      BOOLEAN      NOT NULL DEFAULT TRUE,
    `profile_image_url` VARCHAR(255) NULL,
    PRIMARY KEY (`user_id`)
);

CREATE TABLE `business_info` (
    `business_info_id` BIGINT       NOT NULL AUTO_INCREMENT,
    `user_id`          BIGINT       NOT NULL,
    `region_id`        BIGINT       NOT NULL COMMENT '법정동 코드',
    `industry_id`      VARCHAR(255) NOT NULL COMMENT '업종 코드',
    `business_num`     VARCHAR(255) NOT NULL,
    `owner_name`       VARCHAR(255) NOT NULL,
    `company_name`     VARCHAR(255) NOT NULL,
    PRIMARY KEY (`business_info_id`)
);

-- 2. 정책 및 대출 원본 데이터
CREATE TABLE `policies` (
    `policy_id`                     BIGINT       NOT NULL COMMENT '공고의 서비스ID',
    `industry_id`                   VARCHAR(255) NULL,
    `region_id`                     BIGINT       NULL COMMENT '법정동 코드',
    `department_name`               VARCHAR(255) NOT NULL,
    `user_type`                     VARCHAR(255) NULL COMMENT '"법인/시설/단체", "개인", ...',
    `announcement_url`              VARCHAR(255) NOT NULL,
    `policy_name`                   VARCHAR(255) NOT NULL,
    `policy_summary`                TEXT         NOT NULL,
    `policy_field`                  VARCHAR(255) NOT NULL COMMENT '"생활안정", "고용·창업", ...',
    `selection_criteria`            TEXT         NULL,
    `supervising_organization_name` VARCHAR(255) NOT NULL,
    `receiving_organization_name`   VARCHAR(255) NULL,
    `notice_date`                   DATETIME     NOT NULL,
    `modification_date`             DATETIME     NULL,
    `begin_date`                    DATE         NULL,
    `end_date`                      DATE         NULL,
    `application_method`            VARCHAR(255) NOT NULL,
    `contact`                       VARCHAR(255) NULL,
    `support_detail`                TEXT         NOT NULL,
    `support_target`                TEXT         NOT NULL,
    PRIMARY KEY (`policy_id`)
);

CREATE TABLE `loans` (
    `loan_id`          BIGINT       NOT NULL AUTO_INCREMENT,
    `industry_id`      VARCHAR(255) NULL,
    `region_id`        BIGINT       NULL COMMENT '법정동 코드',
    `company_name`     VARCHAR(255) NOT NULL,
    `product_name`     VARCHAR(255) NOT NULL,
    `join_way`         VARCHAR(255) NOT NULL,
    `begin_date`       DATE         NOT NULL,
    `end_date`         DATE         NOT NULL,
    `product_page_url` VARCHAR(255) NOT NULL,
    `min_limit`        BIGINT       NULL,
    `max_limit`        BIGINT       NULL,
    PRIMARY KEY (`loan_id`)
);

CREATE TABLE `rates` (
    `rate_id`      BIGINT        NOT NULL AUTO_INCREMENT,
    `loan_id`      BIGINT        NOT NULL,
    `rate_type`    VARCHAR(255)  NOT NULL COMMENT '"대출금리", "기준금리", "가산금리"',
    `average_rate` DECIMAL(5, 2) NULL,
    `rate_range1`  DECIMAL(5, 2) NULL COMMENT '800점 초과',
    `rate_range2`  DECIMAL(5, 2) NULL COMMENT '701 ~ 800점',
    `rate_range3`  DECIMAL(5, 2) NULL COMMENT '601 ~ 700점',
    `rate_range4`  DECIMAL(5, 2) NULL COMMENT '501 ~ 600점',
    `rate_range5`  DECIMAL(5, 2) NULL COMMENT '401 ~ 500점',
    `rate_range6`  DECIMAL(5, 2) NULL COMMENT '301 ~ 400점',
    `rate_range7`  DECIMAL(5, 2) NULL COMMENT '201 ~ 300점',
    `rate_range8`  DECIMAL(5, 2) NULL COMMENT '200점 이하',
    PRIMARY KEY (`rate_id`)
);

-- 3. 사용자 활동 데이터
CREATE TABLE `user_loans` (
    `user_loan_id`       BIGINT       NOT NULL AUTO_INCREMENT,
    `user_id`            BIGINT       NOT NULL,
    `loan_id`            BIGINT       NULL,
    `collect_data_at`    DATETIME     NOT NULL,
    `account_num`        VARCHAR(255) NOT NULL,
    `product_name`       VARCHAR(255) NOT NULL,
    `account_type`       VARCHAR(255) NOT NULL COMMENT '"신용대출", "담보대출"',
    `issue_date`         DATE         NOT NULL,
    `expiry_date`        DATE         NOT NULL,
    `last_offered_rate`  DECIMAL(5, 2) NOT NULL,
    `repay_date`         INT          NOT NULL COMMENT '월 상환일 (e.g., 15)',
    `repay_method`       VARCHAR(255) NOT NULL COMMENT '"만기일시상환", "원금균등분할상환"',
    `repay_organization` VARCHAR(255) NOT NULL COMMENT '자동이체 계좌 소속 기관',
    `repay_account_num`  VARCHAR(255) NOT NULL COMMENT '자동이체 계좌번호',
    `balance_amount`     BIGINT       NOT NULL,
    `loan_principal`     BIGINT       NOT NULL,
    `next_repay_date`    DATE         NOT NULL,
    `loan_organization`  VARCHAR(255) NOT NULL,
    PRIMARY KEY (`user_loan_id`)
);

CREATE TABLE `user_policies` (
    `user_policy_id`  BIGINT       NOT NULL AUTO_INCREMENT,
    `user_id`         BIGINT       NOT NULL,
    `policy_id`       BIGINT       NOT NULL,
    `status`          VARCHAR(255) NOT NULL COMMENT '"관심", "신청중", "완료"',
    `approved_amount` INT          NULL,
    `deposit_date`    DATE         NULL,
    `created_at`      DATETIME     DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`user_policy_id`)
);

CREATE TABLE `repayments` (
    `repayment_id`            BIGINT        NOT NULL AUTO_INCREMENT,
    `user_loan_id`            BIGINT        NOT NULL,
    `amount`                  BIGINT        NOT NULL,
    `status`                  VARCHAR(255)  NOT NULL,
    `paid_date`               DATE          NOT NULL,
    `balance_amount`          BIGINT        NOT NULL,
    `principal_amount`        BIGINT        NOT NULL,
    `interest_amount`         BIGINT        NOT NULL,
    `return_interest_amount`  BIGINT        NULL,
    `interest_start_date`     DATE          NOT NULL,
    `interest_end_date`       DATE          NOT NULL,
    `interest_rate`           DECIMAL(5, 2) NOT NULL,
    `applied_interest_amount` BIGINT        NOT NULL COMMENT '이자 기간과 적용이율을 통해 계산된 금액',
    `interest_type`           VARCHAR(255)  NOT NULL COMMENT '"정상이자", "지연이자", "잔액연체이자"',
    PRIMARY KEY (`repayment_id`)
);

CREATE TABLE `user_loan_scraps` (
    `user_loan_scrap_id` BIGINT NOT NULL AUTO_INCREMENT,
    `user_id`            BIGINT NOT NULL,
    `loan_id`            BIGINT NOT NULL,
    PRIMARY KEY (`user_loan_scrap_id`),
    UNIQUE KEY `UK_user_loan` (`user_id`, `loan_id`)
);

CREATE TABLE `user_policy_scraps` (
    `user_policy_scrap_id` BIGINT NOT NULL AUTO_INCREMENT,
    `user_id`              BIGINT NOT NULL,
    `policy_id`            BIGINT NOT NULL,
    PRIMARY KEY (`user_policy_scrap_id`),
    UNIQUE KEY `UK_user_policy` (`user_id`, `policy_id`)
);

-- 4. 서류 관련
CREATE TABLE `documents` (
    `document_id`           INT          NOT NULL AUTO_INCREMENT,
    `document_name`         VARCHAR(255) NOT NULL,
    `issuing_authority`     VARCHAR(255) NULL,
    `issuing_authority_url` VARCHAR(255) NULL,
    PRIMARY KEY (`document_id`)
);

CREATE TABLE `required_documents` (
    `required_document_id` BIGINT NOT NULL AUTO_INCREMENT,
    `document_id`          INT    NOT NULL,
    `policy_id`            BIGINT NULL,
    `loan_id`              BIGINT NULL,
    PRIMARY KEY (`required_document_id`)
);

CREATE TABLE `uploaded_documents` (
    `submission_id` BIGINT       NOT NULL AUTO_INCREMENT,
    `user_id`       BIGINT       NOT NULL,
    `document_id`   INT          NOT NULL,
    `issued_at`     DATE         NOT NULL,
    `file_url`      VARCHAR(255) NOT NULL,
    PRIMARY KEY (`submission_id`)
);

-- 5. 커뮤니티 관련
CREATE TABLE `chat_rooms` (
    `room_id`     BIGINT       NOT NULL AUTO_INCREMENT,
    `industry_id` VARCHAR(255) NULL,
    `region_id`   BIGINT       NULL,
    `room_type`   ENUM('업종', '지역', '정책', '대출') NOT NULL,
    `room_name`   VARCHAR(255) NOT NULL,
    `target_id`   BIGINT       NULL COMMENT '정책/대출 ID',
    PRIMARY KEY (`room_id`)
);

CREATE TABLE `user_chat_rooms` (
    `user_chat_room_id` BIGINT   NOT NULL AUTO_INCREMENT,
    `user_id`           BIGINT   NOT NULL,
    `room_id`           BIGINT   NOT NULL,
    `last_left_at`      DATETIME NULL,
    PRIMARY KEY (`user_chat_room_id`)
);

CREATE TABLE `chat_messages` (
    `message_id` BIGINT    NOT NULL AUTO_INCREMENT,
    `room_id`    BIGINT    NOT NULL,
    `user_id`    BIGINT    NOT NULL,
    `content`    TEXT      NULL,
    `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`message_id`)
);

CREATE TABLE `chat_contents` (
    `content_id` BIGINT       NOT NULL AUTO_INCREMENT,
    `message_id` BIGINT       NOT NULL,
    `file_url`   VARCHAR(255) NOT NULL,
    `file_type`  VARCHAR(255) NOT NULL COMMENT '"IMAGE", "VIDEO", "AUDIO", "PDF", "DOCX", ...',
    `file_name`  VARCHAR(255) NOT NULL,
    `file_size`  BIGINT       NOT NULL,
    PRIMARY KEY (`content_id`)
);


-- 6. 분류 및 집계 테이블
CREATE TABLE `regions` (
    `region_id` BIGINT       NOT NULL COMMENT '법정동 코드',
    `super_id`  BIGINT       NULL,
    `depth`     INT          NOT NULL COMMENT '1: 전국 2:시도 3:시군구',
    `name`      VARCHAR(255) NOT NULL COMMENT '"종로구"',
    `full_name` VARCHAR(255) NOT NULL COMMENT '"서울 종로구"',
    PRIMARY KEY (`region_id`)
);

CREATE TABLE `industry` (
    `industry_id` VARCHAR(255) NOT NULL COMMENT '업종 코드',
    `name`        VARCHAR(255) NOT NULL,
    `keywords`    TEXT         NULL COMMENT '매칭용 키워드',
    PRIMARY KEY (`industry_id`)
);

CREATE TABLE `loan_scrap_counts` (
    `loan_scrap_count_id` BIGINT       NOT NULL AUTO_INCREMENT,
    `loan_id`             BIGINT       NOT NULL,
    `industry_id`         VARCHAR(255) NOT NULL,
    `scrap_count`         BIGINT       NOT NULL DEFAULT 0,
    PRIMARY KEY (`loan_scrap_count_id`)
);

CREATE TABLE `policy_scrap_counts` (
    `policy_scrap_count_id` BIGINT       NOT NULL AUTO_INCREMENT,
    `policy_id`             BIGINT       NOT NULL,
    `industry_id`           VARCHAR(255) NOT NULL,
    `scrap_count`           BIGINT       NOT NULL DEFAULT 0,
    PRIMARY KEY (`policy_scrap_count_id`)
);

-- 7. 외래 키(FK) 제약조건 설정
ALTER TABLE `business_info` ADD CONSTRAINT `FK_users_TO_business_info` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);
ALTER TABLE `business_info` ADD CONSTRAINT `FK_regions_TO_business_info` FOREIGN KEY (`region_id`) REFERENCES `regions` (`region_id`);
ALTER TABLE `business_info` ADD CONSTRAINT `FK_industry_TO_business_info` FOREIGN KEY (`industry_id`) REFERENCES `industry` (`industry_id`);

ALTER TABLE `policies` ADD CONSTRAINT `FK_regions_TO_policies` FOREIGN KEY (`region_id`) REFERENCES `regions` (`region_id`);
ALTER TABLE `policies` ADD CONSTRAINT `FK_industry_TO_policies` FOREIGN KEY (`industry_id`) REFERENCES `industry` (`industry_id`);

ALTER TABLE `loans` ADD CONSTRAINT `FK_regions_TO_loans` FOREIGN KEY (`region_id`) REFERENCES `regions` (`region_id`);
ALTER TABLE `loans` ADD CONSTRAINT `FK_industry_TO_loans` FOREIGN KEY (`industry_id`) REFERENCES `industry` (`industry_id`);

ALTER TABLE `rates` ADD CONSTRAINT `FK_loans_TO_rates` FOREIGN KEY (`loan_id`) REFERENCES `loans` (`loan_id`);

ALTER TABLE `user_loans` ADD CONSTRAINT `FK_users_TO_user_loans` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);
ALTER TABLE `user_loans` ADD CONSTRAINT `FK_loans_TO_user_loans` FOREIGN KEY (`loan_id`) REFERENCES `loans` (`loan_id`);

ALTER TABLE `user_policies` ADD CONSTRAINT `FK_users_TO_user_policies` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);
ALTER TABLE `user_policies` ADD CONSTRAINT `FK_policies_TO_user_policies` FOREIGN KEY (`policy_id`) REFERENCES `policies` (`policy_id`);

ALTER TABLE `repayments` ADD CONSTRAINT `FK_user_loans_TO_repayments` FOREIGN KEY (`user_loan_id`) REFERENCES `user_loans` (`user_loan_id`);

ALTER TABLE `user_loan_scraps` ADD CONSTRAINT `FK_users_TO_user_loan_scraps` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);
ALTER TABLE `user_loan_scraps` ADD CONSTRAINT `FK_loans_TO_user_loan_scraps` FOREIGN KEY (`loan_id`) REFERENCES `loans` (`loan_id`);

ALTER TABLE `user_policy_scraps` ADD CONSTRAINT `FK_users_TO_user_policy_scraps` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);
ALTER TABLE `user_policy_scraps` ADD CONSTRAINT `FK_policies_TO_user_policy_scraps` FOREIGN KEY (`policy_id`) REFERENCES `policies` (`policy_id`);

ALTER TABLE `required_documents` ADD CONSTRAINT `FK_documents_TO_required_documents` FOREIGN KEY (`document_id`) REFERENCES `documents` (`document_id`);

ALTER TABLE `uploaded_documents` ADD CONSTRAINT `FK_users_TO_uploaded_documents` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);
ALTER TABLE `uploaded_documents` ADD CONSTRAINT `FK_documents_TO_uploaded_documents` FOREIGN KEY (`document_id`) REFERENCES `documents` (`document_id`);

ALTER TABLE `user_chat_rooms` ADD CONSTRAINT `FK_users_TO_user_chat_rooms` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);
ALTER TABLE `user_chat_rooms` ADD CONSTRAINT `FK_chat_rooms_TO_user_chat_rooms` FOREIGN KEY (`room_id`) REFERENCES `chat_rooms` (`room_id`);

ALTER TABLE `chat_messages` ADD CONSTRAINT `FK_chat_rooms_TO_chat_messages` FOREIGN KEY (`room_id`) REFERENCES `chat_rooms` (`room_id`);
ALTER TABLE `chat_messages` ADD CONSTRAINT `FK_users_TO_chat_messages` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`);

ALTER TABLE `chat_contents` ADD CONSTRAINT `FK_chat_messages_TO_chat_contents` FOREIGN KEY (`message_id`) REFERENCES `chat_messages` (`message_id`);