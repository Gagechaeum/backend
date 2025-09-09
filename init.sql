DROP DATABASE gagechaeum_db;

CREATE DATABASE gagechaeum_db;
USE gagechaeum_db;

-- 테이블 설정

--	사용자
CREATE TABLE users (
	user_id	BIGINT	AUTO_INCREMENT PRIMARY KEY,
	email	VARCHAR(255)	NOT NULL,
	password	VARCHAR(255)	NOT NULL,
	nickname	VARCHAR(255)	NOT NULL,
	name	VARCHAR(255)	NOT NULL,
	phone	VARCHAR(255)	NULL,
	created_at	DATETIME	NOT NULL,
	social	VARCHAR(255)	NULL	COMMENT '소셜 provider',
	social_id	VARCHAR(255)	NULL	COMMENT '소셜 계정',
	deleted_at	DATETIME	NULL,
	notification	BOOLEAN	NOT NULL	DEFAULT true,
	profile_image_key	VARCHAR(255)	NOT NULL ,
  is_verified BOOLEAN NOT NULL DEFAULT false
);

-- 지역
CREATE TABLE regions (
	region_id	BIGINT	PRIMARY KEY	COMMENT '법정동 코드',
	super_id	BIGINT	NULL,
	depth	INT	NOT NULL	COMMENT '1: 전국 2: 시/도 3: 시/군/구',
	name	VARCHAR(255)	NOT NULL	COMMENT '"종로구"',
	full_name	VARCHAR(255)	NOT NULL	COMMENT '"서울 종로구"',
	CONSTRAINT fk_regions_super_id FOREIGN KEY (super_id)
		REFERENCES regions (region_id)
		ON DELETE RESTRICT
);

-- 업종
CREATE TABLE industry (
	industry_id	BIGINT	AUTO_INCREMENT PRIMARY KEY,
	name	VARCHAR(255)	NOT NULL,
	keywords	VARCHAR(255)	NULL	COMMENT '매칭용 키워드'
);

-- 사업자
CREATE TABLE business_info (
	business_info_id	BIGINT	AUTO_INCREMENT PRIMARY KEY,
	user_id	BIGINT	NOT NULL,
	region_id	BIGINT	NOT NULL	COMMENT '법정동 코드',
	industry_id	BIGINT	NOT NULL	COMMENT '업종 코드',
	business_num	VARCHAR(255)	NOT NULL,
	sales_scope	ENUM(
			'SALES_SCOPE1',
			'SALES_SCOPE2',
			'SALES_SCOPE3',
			'SALES_SCOPE4',
			'SALES_SCOPE5'
		)	NOT NULL,
	company_name	VARCHAR(255)	NOT NULL,
    estb_date date not null comment '개업일자',
	CONSTRAINT fk_business_info_user_id FOREIGN KEY (user_id)
		REFERENCES users (user_id)
		ON DELETE CASCADE,
	CONSTRAINT fk_business_info_region_id FOREIGN KEY (region_id)
		REFERENCES regions (region_id),
	CONSTRAINT fk_business_info_industry_id FOREIGN KEY (industry_id)
		REFERENCES industry (industry_id)
);


-- 정책
CREATE TABLE policies (
	policy_id	VARCHAR(255) PRIMARY KEY	COMMENT '공고의 서비스ID',
	industry_id	BIGINT	NULL,
	region_id	BIGINT	NULL	COMMENT '법정동 코드',
	department_name	VARCHAR(255)	NOT NULL,
	user_type	VARCHAR(255)	NOT NULL	COMMENT '"법인/시설/단체", "개인", ...',
	announcement_url	VARCHAR(255)	NOT NULL,
	policy_name	VARCHAR(255)	NOT NULL,
	policy_summary	TEXT	NOT NULL,
	policy_field	VARCHAR(255)	NOT NULL	COMMENT '"생활안정", "고용·창업", ...',
	selection_criteria	TEXT	NULL,
	supervising_organization_name	VARCHAR(255)	NOT NULL,
	receiving_organization_name	VARCHAR(255)	NULL,
	notice_date	DATETIME	NOT NULL,
	modification_date	DATETIME	NOT NULL,
	application_period	VARCHAR(255) NOT NULL,
	begin_date	DATE	NULL,
	end_date	DATE	NULL,
	application_method	VARCHAR(255)	NOT NULL,
	contact	TEXT	NULL,
	support_detail	TEXT	NOT NULL,
	support_target	TEXT	NOT NULL,
    required_documents_raw_text TEXT NULL COMMENT '외부 API에서 받은 원본 구비서류 텍스트',
	CONSTRAINT fk_policies_industry_id FOREIGN KEY (industry_id)
		REFERENCES industry (industry_id),
	CONSTRAINT fk_policies_region_id FOREIGN KEY (region_id)
		REFERENCES regions (region_id)
);

CREATE TABLE policy_bookmark_counts (
	policy_bookmark_count_id	BIGINT	AUTO_INCREMENT PRIMARY KEY,
	policy_id	VARCHAR(255)	NOT NULL	COMMENT '공고의 서비스ID',
	industry_id	BIGINT	NOT NULL,
	bookmark_count	BIGINT	NOT NULL	DEFAULT 0,
	CONSTRAINT fk_policy_bookmark_counts_policy_id FOREIGN KEY (policy_id)
		REFERENCES policies (policy_id)
		ON DELETE CASCADE,
	CONSTRAINT fk_policy_bookmark_counts_industry_id FOREIGN KEY (industry_id)
		REFERENCES industry (industry_id)
		ON DELETE CASCADE
);

-- 대출 상품
CREATE TABLE loans (
	loan_id	BIGINT	AUTO_INCREMENT PRIMARY KEY,
	industry_id	BIGINT	NULL,
	region_id	BIGINT	NULL	COMMENT '법정동 코드',
	company_name	VARCHAR(255)	NOT NULL,
	product_name	VARCHAR(255)	NOT NULL,
	join_way	VARCHAR(255)	NOT NULL,
	begin_date	DATE	NOT NULL,
	end_date	DATE	NULL,
	product_page_url	VARCHAR(255)	NOT NULL,
	min_limit	BIGINT	NOT NULL,
	max_limit	BIGINT	NOT NULL,
	basic_rate	DECIMAL(5,2)	NOT NULL,
	CONSTRAINT fk_loans_industry_id FOREIGN KEY (industry_id)
		REFERENCES industry (industry_id),
	CONSTRAINT fk_loans_region_id FOREIGN KEY (region_id)
		REFERENCES regions (region_id)
);

CREATE TABLE rates (
	rate_id	BIGINT	AUTO_INCREMENT PRIMARY KEY,
	loan_id	BIGINT	NOT NULL,
	rate_type	VARCHAR(255)	NOT NULL	COMMENT '"대출금리", "기준금리", "가산금리"',
	average_rate	DECIMAL(5,2)	NULL,
	rate_range1	DECIMAL(5,2)	NULL	COMMENT '800점 초과',
	rate_range2	DECIMAL(5,2)	NULL	COMMENT '701 ~ 800점',
	rate_range3	DECIMAL(5,2)	NULL	COMMENT '601 ~ 700점',
	rate_range4	DECIMAL(5,2)	NULL	COMMENT '501 ~ 600점',
	rate_range5	DECIMAL(5,2)	NULL	COMMENT '401 ~ 500점',
	rate_range6	DECIMAL(5,2)	NULL	COMMENT '301 ~ 400점',
	rate_range7	DECIMAL(5,2)	NULL	COMMENT '201 ~ 300점',
	rate_range8	DECIMAL(5,2)	NULL	COMMENT '200점 이하',
	CONSTRAINT fk_rates_loan_id FOREIGN KEY (loan_id)
		REFERENCES loans (loan_id)
		ON DELETE CASCADE
);

CREATE TABLE loan_bookmark_counts (
	loan_bookmark_count_id	BIGINT	AUTO_INCREMENT PRIMARY KEY,
	loan_id	BIGINT	NOT NULL,
	industry_id	BIGINT	NOT NULL	COMMENT '업종 코드',
	bookmark_count	BIGINT	NOT NULL	DEFAULT 0,
	CONSTRAINT fk_loan_bookmark_counts_loan_id FOREIGN KEY (loan_id)
		REFERENCES loans (loan_id)
		ON DELETE CASCADE,
	CONSTRAINT fk_loan_bookmark_counts_industry_id FOREIGN KEY (industry_id)
		REFERENCES industry (industry_id)
		ON DELETE CASCADE
);

-- 사용자 정책
CREATE TABLE user_policies (
    user_policy_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    policy_id VARCHAR(255) NULL,
    start_date DATE NOT NULL,
    end_date DATE NULL,
    first_payment_date DATE NULL,
    monthly_amount INT NULL, 
    total_amount INT NULL,
    CONSTRAINT fk_user_policies_user_id FOREIGN KEY (user_id)
        REFERENCES users (user_id)
        ON DELETE CASCADE,
    CONSTRAINT fk_user_policies_policy_id FOREIGN KEY (policy_id)
        REFERENCES policies (policy_id)
        ON DELETE SET NULL
);

-- 사용자 대출
CREATE TABLE user_loans (
	user_loan_id	BIGINT	AUTO_INCREMENT PRIMARY KEY,
	user_id	BIGINT	NOT NULL,
	loan_id	BIGINT	NULL,
	collect_data	DATETIME	NOT NULL,
	account_num	VARCHAR(255)	NOT NULL,
	product_name	VARCHAR(255)	NOT NULL,
	account_type	VARCHAR(255)	NOT NULL	COMMENT '"신용대출", "담보대출"',
	issue_date	DATE	NOT NULL,
	expiry_date	DATE	NOT NULL,
	last_offered_rate	DECIMAL(5,2)	NOT NULL,
	repay_date	DATE	NOT NULL	COMMENT '대출거래약정서상의 월 상환일',
	repay_method	VARCHAR(255)	NOT NULL	COMMENT '"만기일시상환", "원금균등분할상환"',
	repay_organization	VARCHAR(255)	NOT NULL	COMMENT '자동이체 계좌 소속 기관',
	repay_account_num	VARCHAR(255)	NOT NULL	COMMENT '자동이체 계좌번호',
	balance_amount	BIGINT	NOT NULL,
	loan_principal	BIGINT	NOT NULL,
	next_repay_date	DATE	NOT NULL,
	loan_organization	VARCHAR(255)	NOT NULL,
	CONSTRAINT fk_user_loans_user_id FOREIGN KEY (user_id)
		REFERENCES users (user_id)
		ON DELETE CASCADE,
	CONSTRAINT fk_user_loans_loan_id FOREIGN KEY (loan_id)
		REFERENCES loans (loan_id)
		ON DELETE SET NULL
);

CREATE TABLE repayments (
	repayment_id	BIGINT	AUTO_INCREMENT PRIMARY KEY,
	user_loan_id	BIGINT	NOT NULL,
	amount	INT	NOT NULL,
	status	VARCHAR(255)	NOT NULL,
	paid_date	DATE	NOT NULL,
	balance_amount	BIGINT	NOT NULL,
	principal_amount	BIGINT	NOT NULL,
	interest_amount	BIGINT	NOT NULL,
	return_interest_amount	BIGINT	NOT NULL,
	interest_start_date	DATE	NOT NULL,
	interest_end_date	DATE	NOT NULL,
	interest_rate	DECIMAL(5,2)	NOT NULL,
	applied_interest_amount	BIGINT	NOT NULL	COMMENT '이자 기간과 적용이율을 통해 계산된 금액',
	interest_type	VARCHAR(255)	NOT NULL	COMMENT '"정상이자", "지연이자", "잔액연체이자"',
	CONSTRAINT fk_repayments_user_loan_id FOREIGN KEY (user_loan_id)
		REFERENCES user_loans (user_loan_id)
		ON DELETE CASCADE
);

-- 즐겨찾기
CREATE TABLE user_policy_bookmarks (
	bookmark_policy_id	BIGINT	AUTO_INCREMENT PRIMARY KEY,
	user_id	BIGINT	NOT NULL,
	policy_id	VARCHAR(255)	NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT '요건확인' COMMENT '"요건확인", "서류 수집/업로드", "제출 준비", "제출 완료/결과"',
	created_at DATETIME	NOT NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT fk_user_policy_bookmarks_user_id FOREIGN KEY (user_id)
		REFERENCES users (user_id)
		ON DELETE CASCADE,
	CONSTRAINT fk_user_policy_bookmarks_policy_id FOREIGN KEY (policy_id)
		REFERENCES policies (policy_id)
		ON DELETE CASCADE
);

CREATE TABLE user_loan_bookmarks (
	bookmark_loan_id	BIGINT	AUTO_INCREMENT PRIMARY KEY,
	user_id	BIGINT	NOT NULL,
	loan_id	BIGINT	NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT '요건확인' COMMENT '"요건확인", "서류 수집/업로드", "제출 준비", "제출 완료/결과"',
	created_at DATETIME	NOT NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT fk_user_loan_bookmarks_user_id FOREIGN KEY (user_id)
		REFERENCES users (user_id)
		ON DELETE CASCADE,
	CONSTRAINT fk_user_loan_bookmarks_loan_id FOREIGN KEY (loan_id)
		REFERENCES loans (loan_id)
		ON DELETE CASCADE
);

-- 서류
CREATE TABLE documents (
	document_id	BIGINT	AUTO_INCREMENT PRIMARY KEY,
	document_name	VARCHAR(255)	NOT NULL,
	issuing_authority	VARCHAR(255)	NULL,
	issuing_authority_url	VARCHAR(255)	NULL,
    keywords VARCHAR(255) NULL COMMENT '매칭용 키워드, 쉼표(,)로 구분'
);

CREATE TABLE required_documents (
	required_document_id	BIGINT	AUTO_INCREMENT PRIMARY KEY,
	document_id	BIGINT	NOT NULL,
	policy_id	VARCHAR(255)	NULL,
	loan_id	BIGINT	NULL,
	CONSTRAINT fk_required_documents_document_id FOREIGN KEY (document_id)
		REFERENCES documents (document_id)
		ON DELETE CASCADE,
	CONSTRAINT fk_required_documents_policy_id FOREIGN KEY (policy_id)
		REFERENCES policies (policy_id)
		ON DELETE CASCADE,
	CONSTRAINT fk_required_documents_loan_id FOREIGN KEY (loan_id)
		REFERENCES loans (loan_id)
		ON DELETE CASCADE
);

CREATE TABLE user_documents (
	user_document_id	BIGINT	AUTO_INCREMENT PRIMARY KEY,
	user_id	BIGINT NOT NULL,
	document_id	BIGINT	NOT NULL,
	document_name VARCHAR(255) NOT NULL,
	issued_at	DATE	NOT NULL,
	file_key	VARCHAR(255)	NOT NULL,
	CONSTRAINT fk_user_documents_user_id FOREIGN KEY (user_id)
		REFERENCES users (user_id)
		ON DELETE CASCADE,
	CONSTRAINT fk_user_documents_document_id FOREIGN KEY (document_id)
		REFERENCES documents (document_id)
		ON DELETE CASCADE
);

-- 채팅
CREATE TABLE chat_rooms (
	room_id	BIGINT	AUTO_INCREMENT PRIMARY KEY,
	industry_id	BIGINT	NULL,
	region_id	BIGINT	NULL,
	loan_id	BIGINT	NULL,
	policy_id	VARCHAR(255)	NULL,
	room_type	VARCHAR(255)	NOT NULL	COMMENT '"업종", "지역", "대출", "정책"',
	CONSTRAINT fk_chat_rooms_industry_id FOREIGN KEY (industry_id)
		REFERENCES industry (industry_id)
		ON DELETE CASCADE,
	CONSTRAINT fk_chat_rooms_region_id FOREIGN KEY (region_id)
		REFERENCES regions (region_id)
		ON DELETE CASCADE,
	CONSTRAINT fk_chat_rooms_policy_id FOREIGN KEY (policy_id)
		REFERENCES policies (policy_id)
		ON DELETE CASCADE,
	CONSTRAINT fk_chat_rooms_loan_id FOREIGN KEY (loan_id)
		REFERENCES loans (loan_id)
		ON DELETE CASCADE
);

CREATE TABLE chat_messages (
	message_id	BIGINT	AUTO_INCREMENT PRIMARY KEY,
	room_id	BIGINT	NOT NULL,
	user_id	BIGINT	NULL,
	content	TEXT	NOT NULL,
	created_at	TIMESTAMP	DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT fk_chat_messages_room_id FOREIGN KEY (room_id)
		REFERENCES chat_rooms (room_id)
		ON DELETE CASCADE,
	CONSTRAINT fk_chat_messages_user_id FOREIGN KEY (user_id)
		REFERENCES users (user_id)
		ON DELETE SET NULL
);

CREATE TABLE chat_attachments (
	attachment_id	BIGINT	AUTO_INCREMENT PRIMARY KEY,
	message_id	BIGINT	NOT NULL,
	file_key	VARCHAR(255)	NOT NULL,
	file_extension	VARCHAR(255)	NOT NULL,
	file_name	VARCHAR(255)	NOT NULL,
	file_size	BIGINT	NOT NULL,
	CONSTRAINT fk_chat_attachments_message_id FOREIGN KEY (message_id)
		REFERENCES chat_messages (message_id)
		ON DELETE CASCADE
);

CREATE TABLE user_chat_rooms (
	user_chat_room_id	BIGINT	AUTO_INCREMENT PRIMARY KEY,
	user_id	BIGINT	NOT NULL,
	room_id	BIGINT	NOT NULL,
	last_left_at	DATETIME	NULL,
	CONSTRAINT fk_user_chat_rooms_user_id FOREIGN KEY (user_id)
		REFERENCES users (user_id)
		ON DELETE CASCADE,
	CONSTRAINT fk_user_chat_rooms_room_id FOREIGN KEY (room_id)
		REFERENCES chat_rooms (room_id)
		ON DELETE CASCADE
);

-- 업종/서류/지역/채팅방 데이터 삽입

-- 업종 데이터
INSERT INTO industry (name, keywords) VALUES
	('농업, 임업 및 어업', '농업, 임업, 어업, 축산, 채소, 과수, 곡물, 산림, 수산, 양식, 어류, 농산물, 축산물'),
	('광업', '광업, 채굴, 금속, 석탄, 석유, 천연가스, 광물, 채광, 채석'),
	('제조업', '제조업, 식음료, 제과, 제빵, 음료, 의류, 섬유, 신발, 가방, 전자, 기계, 자동차, 화학, 철강, 금속, 플라스틱, 종이, 가구, 목재, 기계부품, 의료기기'),
	('전기, 가스, 증기 및 공기조절 공급업', '전기, 가스, 증기, 냉난방, 공기조절, 에너지, 발전, 배전, 공급'),
	('수도, 하수, 폐기물 처리, 원료 재생업', '상수도, 하수, 폐수, 폐기물, 재활용, 환경, 처리, 수처리'),
	('건설업', '건설, 건축, 토목, 인테리어, 주택, 도로, 교량, 설비, 조경, 건설자재, 공사'),
	('도소매업', '도소매, 소매, 도매, 슈퍼마켓, 편의점, 의류, 패션, 가전, 전자제품, 자동차, 연료, 건축자재, 잡화'),
	('운수 및 창고업', '운송, 물류, 창고, 택배, 배송, 항공, 철도, 버스, 트럭, 해운, 선박, 항만, 물류센터, 운수서비스'),
	('숙박 및 음식점업', '숙박, 호텔, 모텔, 여관, 게스트하우스, 호스텔, 음식점, 식당, 카페, 커피숍, 주점, 술집, 호프'),
	('정보통신업', '정보통신, IT, 소프트웨어, 앱, 인터넷, 통신, 네트워크, 데이터, 방송, 콘텐츠, 플랫폼, 클라우드'),
	('금융 및 보험업', '금융, 은행, 증권, 보험, 대출, 카드, 투자, 자산운용, 펀드, 연금, 신용, 재무, 회계, 캐피탈, 저축은행'),
	('부동산업', '부동산, 임대, 전대, 부동산중개, 개발, 건물관리, 부동산서비스'),
	('전문, 과학 및 기술 서비스업', '전문서비스, 과학, 기술, 연구, 컨설팅, 회계, 법률, 설계, 엔지니어링, IT컨설팅, 디자인, 분석, 특허'),
	('사업시설관리, 사업지원 및 임대 서비스업', '시설관리, 사업지원, 임대, 경비, 청소, 사무지원, 렌탈, 장비대여'),
	('공공행정, 국방 및 사회보장행정', '공공행정, 국방, 사회보장, 행정, 정부, 정책, 공공서비스'),
	('교육서비스업', '교육, 학원, 학교, 강의, 훈련, 유아교육, 초중고, 대학, 직업교육, 온라인교육'),
	('보건업 및 사회복지 서비스업', '보건, 의료, 병원, 요양, 복지, 간호, 사회복지, 재활, 건강관리, 클리닉'),
	('예술, 스포츠 및 여가관련 서비스업', '예술, 문화, 스포츠, 여가, 공연, 영화, 음악, 전시, 미술, 체육, 레저, 여행, 오락'),
	('협회 및 단체, 수리 및 기타 개인 서비스업', '협회, 단체, 수리, 개인서비스, 미용, 세탁, 세차, 애완, 이벤트, 상담'),
	('전체', '');


-- 서류 데이터
INSERT INTO documents (document_name, issuing_authority, issuing_authority_url) VALUES
	('지방세 납세증명서', '정부24', 'https://www.gov.kr'),
	('납세증명서', '정부24, 홈택스', 'https://www.gov.kr, https://www.hometax.go.kr'),
	('부가가치세과세표준증명', '정부24, 홈택스', 'https://www.gov.kr, https://www.hometax.go.kr'),
	('부가가치세면세사업자수입금액증명', '정부24, 홈택스', 'https://www.gov.kr, https://www.hometax.go.kr'),
	('사업자등록증명', '정부24, 홈택스', 'https://www.gov.kr, https://www.hometax.go.kr'),
	('소득금액증명', '정부24, 홈택스', 'https://www.gov.kr, https://www.hometax.go.kr'),
	('폐업사실증명', '정부24, 홈택스', 'https://www.gov.kr, https://www.hometax.go.kr'),
	('표준재무제표증명', '정부24, 홈택스', 'https://www.gov.kr, https://www.hometax.go.kr'),
	('휴업사실증명', '정부24, 홈택스', 'https://www.gov.kr, https://www.hometax.go.kr'),
	('금융거래확인서', '정부24', 'https://www.gov.kr'),
	('중소기업확인서', '중소벤처24', 'https://smb.go.kr'),
	('법인등기사항전부증명서(말소사항 포함)', '인터넷등기소', 'http://www.iros.go.kr'),
	('4대사회보험 가입자 가입내역 확인서', '정부24, 국민연금공단 4대사회보험 정보연계센터', 'https://www.gov.kr, https://www.4insure.or.kr'),
	('기타', NULL, NULL);

-- 서류 데이터 키워드 추가
UPDATE documents SET keywords = '지방세,지방세납세' WHERE document_name = '지방세 납세증명서';
UPDATE documents SET keywords = '납세증명,국세완납,세금완납,완납증명' WHERE document_name = '납세증명서';
UPDATE documents SET keywords = '부가가치세,부가세,과세표준' WHERE document_name = '부가가치세과세표준증명';
UPDATE documents SET keywords = '면세사업자,수입금액증명' WHERE document_name = '부가가치세면세사업자수입금액증명';
UPDATE documents SET keywords = '사업자등록,사업자,개인사업자,법인사업자' WHERE document_name = '사업자등록증명';
UPDATE documents SET keywords = '소득금액,소득증명,소득확인' WHERE document_name = '소득금액증명';
UPDATE documents SET keywords = '폐업사실,폐업' WHERE document_name = '폐업사실증명';
UPDATE documents SET keywords = '재무제표,재무상태표,손익계산서' WHERE document_name = '표준재무제표증명';
UPDATE documents SET keywords = '휴업사실,휴업' WHERE document_name = '휴업사실증명';
UPDATE documents SET keywords = '금융거래' WHERE document_name = '금융거래확인서';
UPDATE documents SET keywords = '중소기업,벤처기업,중소기업확인' WHERE document_name = '중소기업확인서';
UPDATE documents SET keywords = '법인등기,등기부등본,등기사항전부' WHERE document_name = '법인등기사항전부증명서(말소사항 포함)';
UPDATE documents SET keywords = '4대보험,4대 사회보험,가입내역,자격득실' WHERE document_name = '4대사회보험 가입자 가입내역 확인서';

-- 지역 데이터
-- 1. 전국
INSERT INTO regions (region_id, super_id, depth, name, full_name) VALUES
	(1, NULL, 1, '전국', '전국');

-- 2. 시/도
INSERT INTO regions (region_id, super_id, depth, name, full_name) VALUES
	(11, 1, 2, '서울특별시', '서울특별시'),
	(26, 1, 2, '부산광역시', '부산광역시'),
	(27, 1, 2, '대구광역시', '대구광역시'),
	(28, 1, 2, '인천광역시', '인천광역시'),
	(29, 1, 2, '광주광역시', '광주광역시'),
	(30, 1, 2, '대전광역시', '대전광역시'),
	(31, 1, 2, '울산광역시', '울산광역시'),
	(41, 1, 2, '경기도', '경기도'),
	(42, 1, 2, '강원도', '강원도'),
	(43, 1, 2, '충청북도', '충청북도'),
	(44, 1, 2, '충청남도', '충청남도'),
	(45, 1, 2, '전라북도', '전라북도'),
	(46, 1, 2, '전라남도', '전라남도'),
	(47, 1, 2, '경상북도', '경상북도'),
	(48, 1, 2, '경상남도', '경상남도'),
	(50, 1, 2, '제주특별자치도', '제주특별자치도');

-- 3. 시/군/구
-- 서울특별시
INSERT INTO regions (region_id, super_id, depth, name, full_name) VALUES
	(11010, 11, 3, '종로구', '서울특별시 종로구'),
	(11020, 11, 3, '중구', '서울특별시 중구'),
	(11030, 11, 3, '용산구', '서울특별시 용산구'),
	(11040, 11, 3, '성동구', '서울특별시 성동구'),
	(11050, 11, 3, '광진구', '서울특별시 광진구'),
	(11060, 11, 3, '동대문구', '서울특별시 동대문구'),
	(11070, 11, 3, '중랑구', '서울특별시 중랑구'),
	(11080, 11, 3, '성북구', '서울특별시 성북구'),
	(11090, 11, 3, '강북구', '서울특별시 강북구'),
	(11100, 11, 3, '도봉구', '서울특별시 도봉구'),
	(11110, 11, 3, '노원구', '서울특별시 노원구'),
	(11120, 11, 3, '은평구', '서울특별시 은평구'),
	(11130, 11, 3, '서대문구', '서울특별시 서대문구'),
	(11140, 11, 3, '마포구', '서울특별시 마포구'),
	(11150, 11, 3, '양천구', '서울특별시 양천구'),
	(11160, 11, 3, '강서구', '서울특별시 강서구'),
	(11170, 11, 3, '구로구', '서울특별시 구로구'),
	(11180, 11, 3, '금천구', '서울특별시 금천구'),
	(11190, 11, 3, '영등포구', '서울특별시 영등포구'),
	(11200, 11, 3, '동작구', '서울특별시 동작구'),
	(11210, 11, 3, '관악구', '서울특별시 관악구'),
	(11220, 11, 3, '서초구', '서울특별시 서초구'),
	(11230, 11, 3, '강남구', '서울특별시 강남구'),
	(11240, 11, 3, '송파구', '서울특별시 송파구'),
	(11250, 11, 3, '강동구', '서울특별시 강동구');

-- 부산광역시
INSERT INTO regions (region_id, super_id, depth, name, full_name) VALUES
	(26010, 26, 3, '중구', '부산광역시 중구'),
	(26020, 26, 3, '서구', '부산광역시 서구'),
	(26030, 26, 3, '동구', '부산광역시 동구'),
	(26040, 26, 3, '영도구', '부산광역시 영도구'),
	(26050, 26, 3, '부산진구', '부산광역시 부산진구'),
	(26060, 26, 3, '동래구', '부산광역시 동래구'),
	(26070, 26, 3, '남구', '부산광역시 남구'),
	(26080, 26, 3, '북구', '부산광역시 북구'),
	(26090, 26, 3, '해운대구', '부산광역시 해운대구'),
	(26100, 26, 3, '사하구', '부산광역시 사하구'),
	(26110, 26, 3, '금정구', '부산광역시 금정구'),
	(26120, 26, 3, '강서구', '부산광역시 강서구'),
	(26130, 26, 3, '연제구', '부산광역시 연제구'),
	(26140, 26, 3, '수영구', '부산광역시 수영구'),
	(26150, 26, 3, '사상구', '부산광역시 사상구'),
	(26160, 26, 3, '기장군', '부산광역시 기장군');

-- 대구광역시
INSERT INTO regions (region_id, super_id, depth, name, full_name) VALUES
	(27010, 27, 3, '중구', '대구광역시 중구'),
	(27020, 27, 3, '동구', '대구광역시 동구'),
	(27030, 27, 3, '서구', '대구광역시 서구'),
	(27040, 27, 3, '남구', '대구광역시 남구'),
	(27050, 27, 3, '북구', '대구광역시 북구'),
	(27060, 27, 3, '수성구', '대구광역시 수성구'),
	(27070, 27, 3, '달서구', '대구광역시 달서구'),
	(27080, 27, 3, '달성군', '대구광역시 달성군');

-- 인천광역시
INSERT INTO regions (region_id, super_id, depth, name, full_name) VALUES
	(28010, 28, 3, '중구', '인천광역시 중구'),
	(28020, 28, 3, '동구', '인천광역시 동구'),
	(28030, 28, 3, '미추홀구', '인천광역시 미추홀구'),
	(28040, 28, 3, '연수구', '인천광역시 연수구'),
	(28050, 28, 3, '남동구', '인천광역시 남동구'),
	(28060, 28, 3, '부평구', '인천광역시 부평구'),
	(28070, 28, 3, '계양구', '인천광역시 계양구'),
	(28080, 28, 3, '서구', '인천광역시 서구'),
	(28090, 28, 3, '강화군', '인천광역시 강화군'),
	(28100, 28, 3, '옹진군', '인천광역시 옹진군');

-- 광주광역시
INSERT INTO regions (region_id, super_id, depth, name, full_name) VALUES
	(29010, 29, 3, '동구', '광주광역시 동구'),
	(29020, 29, 3, '서구', '광주광역시 서구'),
	(29030, 29, 3, '남구', '광주광역시 남구'),
	(29040, 29, 3, '북구', '광주광역시 북구'),
	(29050, 29, 3, '광산구', '광주광역시 광산구');

-- 대전광역시
INSERT INTO regions (region_id, super_id, depth, name, full_name) VALUES
	(30010, 30, 3, '동구', '대전광역시 동구'),
	(30020, 30, 3, '중구', '대전광역시 중구'),
	(30030, 30, 3, '서구', '대전광역시 서구'),
	(30040, 30, 3, '유성구', '대전광역시 유성구'),
	(30050, 30, 3, '대덕구', '대전광역시 대덕구');

-- 울산광역시
INSERT INTO regions (region_id, super_id, depth, name, full_name) VALUES
	(31010, 31, 3, '중구', '울산광역시 중구'),
	(31020, 31, 3, '남구', '울산광역시 남구'),
	(31030, 31, 3, '동구', '울산광역시 동구'),
	(31040, 31, 3, '북구', '울산광역시 북구'),
	(31050, 31, 3, '울주군', '울산광역시 울주군');

-- 경기도
INSERT INTO regions (region_id, super_id, depth, name, full_name) VALUES
	(41110, 41, 3, '수원시 장안구', '경기도 수원시 장안구'),
	(41120, 41, 3, '수원시 권선구', '경기도 수원시 권선구'),
	(41130, 41, 3, '수원시 팔달구', '경기도 수원시 팔달구'),
	(41140, 41, 3, '수원시 영통구', '경기도 수원시 영통구'),
	(41210, 41, 3, '성남시 수정구', '경기도 성남시 수정구'),
	(41220, 41, 3, '성남시 중원구', '경기도 성남시 중원구'),
	(41230, 41, 3, '성남시 분당구', '경기도 성남시 분당구'),
	(41310, 41, 3, '의정부시', '경기도 의정부시'),
	(41320, 41, 3, '안양시 만안구', '경기도 안양시 만안구'),
	(41330, 41, 3, '안양시 동안구', '경기도 안양시 동안구'),
	(41410, 41, 3, '부천시', '경기도 부천시'),
	(41420, 41, 3, '광명시', '경기도 광명시'),
	(41430, 41, 3, '평택시', '경기도 평택시'),
	(41440, 41, 3, '동두천시', '경기도 동두천시'),
	(41450, 41, 3, '안산시 상록구', '경기도 안산시 상록구'),
	(41460, 41, 3, '안산시 단원구', '경기도 안산시 단원구'),
	(41470, 41, 3, '고양시 덕양구', '경기도 고양시 덕양구'),
	(41480, 41, 3, '고양시 일산동구', '경기도 고양시 일산동구'),
	(41490, 41, 3, '고양시 일산서구', '경기도 고양시 일산서구'),
	(41510, 41, 3, '과천시', '경기도 과천시'),
	(41520, 41, 3, '의왕시', '경기도 의왕시'),
	(41530, 41, 3, '구리시', '경기도 구리시'),
	(41540, 41, 3, '남양주시', '경기도 남양주시'),
	(41550, 41, 3, '오산시', '경기도 오산시'),
	(41560, 41, 3, '시흥시', '경기도 시흥시'),
	(41570, 41, 3, '군포시', '경기도 군포시'),
	(41580, 41, 3, '의정부시', '경기도 의정부시'),
	(41590, 41, 3, '하남시', '경기도 하남시'),
	(41600, 41, 3, '용인시 처인구', '경기도 용인시 처인구'),
	(41610, 41, 3, '용인시 기흥구', '경기도 용인시 기흥구'),
	(41620, 41, 3, '용인시 수지구', '경기도 용인시 수지구'),
	(41630, 41, 3, '파주시', '경기도 파주시'),
	(41640, 41, 3, '이천시', '경기도 이천시'),
	(41650, 41, 3, '안성시', '경기도 안성시'),
	(41660, 41, 3, '김포시', '경기도 김포시'),
	(41670, 41, 3, '화성시', '경기도 화성시'),
	(41680, 41, 3, '광주시', '경기도 광주시'),
	(41690, 41, 3, '양주시', '경기도 양주시'),
	(41700, 41, 3, '포천시', '경기도 포천시'),
	(41710, 41, 3, '여주시', '경기도 여주시'),
	(41720, 41, 3, '연천군', '경기도 연천군'),
	(41730, 41, 3, '가평군', '경기도 가평군'),
	(41740, 41, 3, '양평군', '경기도 양평군');

-- 강원도
INSERT INTO regions (region_id, super_id, depth, name, full_name) VALUES
	(42110, 42, 3, '춘천시', '강원도 춘천시'),
	(42120, 42, 3, '원주시', '강원도 원주시'),
	(42130, 42, 3, '강릉시', '강원도 강릉시'),
	(42140, 42, 3, '동해시', '강원도 동해시'),
	(42150, 42, 3, '태백시', '강원도 태백시'),
	(42160, 42, 3, '속초시', '강원도 속초시'),
	(42170, 42, 3, '삼척시', '강원도 삼척시'),
	(42210, 42, 3, '홍천군', '강원도 홍천군'),
	(42220, 42, 3, '횡성군', '강원도 횡성군'),
	(42230, 42, 3, '영월군', '강원도 영월군'),
	(42240, 42, 3, '평창군', '강원도 평창군'),
	(42250, 42, 3, '정선군', '강원도 정선군'),
	(42260, 42, 3, '철원군', '강원도 철원군'),
	(42270, 42, 3, '화천군', '강원도 화천군'),
	(42280, 42, 3, '양구군', '강원도 양구군'),
	(42290, 42, 3, '인제군', '강원도 인제군'),
	(42300, 42, 3, '고성군', '강원도 고성군'),
	(42310, 42, 3, '양양군', '강원도 양양군');

-- 충청북도
INSERT INTO regions (region_id, super_id, depth, name, full_name) VALUES
	(43110, 43, 3, '청주시 상당구', '충청북도 청주시 상당구'),
	(43120, 43, 3, '청주시 서원구', '충청북도 청주시 서원구'),
	(43130, 43, 3, '청주시 흥덕구', '충청북도 청주시 흥덕구'),
	(43140, 43, 3, '청주시 청원구', '충청북도 청주시 청원구'),
	(43210, 43, 3, '충주시', '충청북도 충주시'),
	(43220, 43, 3, '제천시', '충청북도 제천시'),
	(43230, 43, 3, '보은군', '충청북도 보은군'),
	(43240, 43, 3, '옥천군', '충청북도 옥천군'),
	(43250, 43, 3, '영동군', '충청북도 영동군'),
	(43260, 43, 3, '진천군', '충청북도 진천군'),
	(43270, 43, 3, '괴산군', '충청북도 괴산군'),
	(43280, 43, 3, '음성군', '충청북도 음성군'),
	(43290, 43, 3, '단양군', '충청북도 단양군');

-- 충청남도
INSERT INTO regions (region_id, super_id, depth, name, full_name) VALUES
	(44130, 44, 3, '천안시 동남구', '충청남도 천안시 동남구'),
	(44131, 44, 3, '천안시 서북구', '충청남도 천안시 서북구'),
	(44150, 44, 3, '공주시', '충청남도 공주시'),
	(44160, 44, 3, '보령시', '충청남도 보령시'),
	(44170, 44, 3, '아산시', '충청남도 아산시'),
	(44190, 44, 3, '서산시', '충청남도 서산시'),
	(44200, 44, 3, '논산시', '충청남도 논산시'),
	(44210, 44, 3, '계룡시', '충청남도 계룡시'),
	(44220, 44, 3, '당진시', '충청남도 당진시'),
	(44230, 44, 3, '금산군', '충청남도 금산군'),
	(44240, 44, 3, '부여군', '충청남도 부여군'),
	(44250, 44, 3, '서천군', '충청남도 서천군'),
	(44260, 44, 3, '청양군', '충청남도 청양군'),
	(44270, 44, 3, '홍성군', '충청남도 홍성군'),
	(44280, 44, 3, '예산군', '충청남도 예산군'),
	(44990, 44, 3, '태안군', '충청남도 태안군');

-- 전라북도
INSERT INTO regions (region_id, super_id, depth, name, full_name) VALUES
	(45110, 45, 3, '전주시 완산구', '전라북도 전주시 완산구'),
	(45120, 45, 3, '전주시 덕진구', '전라북도 전주시 덕진구'),
	(45210, 45, 3, '군산시', '전라북도 군산시'),
	(45220, 45, 3, '익산시', '전라북도 익산시'),
	(45230, 45, 3, '정읍시', '전라북도 정읍시'),
	(45240, 45, 3, '남원시', '전라북도 남원시'),
	(45250, 45, 3, '김제시', '전라북도 김제시'),
	(45280, 45, 3, '완주군', '전라북도 완주군'),
	(45290, 45, 3, '진안군', '전라북도 진안군'),
	(45300, 45, 3, '무주군', '전라북도 무주군'),
	(45310, 45, 3, '장수군', '전라북도 장수군'),
	(45320, 45, 3, '임실군', '전라북도 임실군'),
	(45330, 45, 3, '순창군', '전라북도 순창군'),
	(45340, 45, 3, '고창군', '전라북도 고창군'),
	(45370, 45, 3, '부안군', '전라북도 부안군');

-- 전라남도
INSERT INTO regions (region_id, super_id, depth, name, full_name) VALUES
	(46110, 46, 3, '목포시', '전라남도 목포시'),
	(46120, 46, 3, '여수시', '전라남도 여수시'),
	(46130, 46, 3, '순천시', '전라남도 순천시'),
	(46140, 46, 3, '나주시', '전라남도 나주시'),
	(46150, 46, 3, '광양시', '전라남도 광양시'),
	(46210, 46, 3, '담양군', '전라남도 담양군'),
	(46220, 46, 3, '곡성군', '전라남도 곡성군'),
	(46230, 46, 3, '구례군', '전라남도 구례군'),
	(46240, 46, 3, '고흥군', '전라남도 고흥군'),
	(46250, 46, 3, '보성군', '전라남도 보성군'),
	(46260, 46, 3, '화순군', '전라남도 화순군'),
	(46270, 46, 3, '장흥군', '전라남도 장흥군'),
	(46280, 46, 3, '강진군', '전라남도 강진군'),
	(46290, 46, 3, '해남군', '전라남도 해남군'),
	(46300, 46, 3, '영암군', '전라남도 영암군'),
	(46310, 46, 3, '무안군', '전라남도 무안군'),
	(46320, 46, 3, '함평군', '전라남도 함평군'),
	(46330, 46, 3, '영광군', '전라남도 영광군'),
	(46340, 46, 3, '장성군', '전라남도 장성군'),
	(46350, 46, 3, '완도군', '전라남도 완도군'),
	(46360, 46, 3, '진도군', '전라남도 진도군'),
	(46370, 46, 3, '신안군', '전라남도 신안군');

-- 경상북도
INSERT INTO regions (region_id, super_id, depth, name, full_name) VALUES
	(47110, 47, 3, '포항시 남구', '경상북도 포항시 남구'),
	(47120, 47, 3, '포항시 북구', '경상북도 포항시 북구'),
	(47210, 47, 3, '경주시', '경상북도 경주시'),
	(47220, 47, 3, '김천시', '경상북도 김천시'),
	(47230, 47, 3, '안동시', '경상북도 안동시'),
	(47240, 47, 3, '구미시', '경상북도 구미시'),
	(47250, 47, 3, '영주시', '경상북도 영주시'),
	(47260, 47, 3, '영천시', '경상북도 영천시'),
	(47270, 47, 3, '상주시', '경상북도 상주시'),
	(47280, 47, 3, '문경시', '경상북도 문경시'),
	(47290, 47, 3, '경산시', '경상북도 경산시'),
	(47310, 47, 3, '군위군', '경상북도 군위군'),
	(47320, 47, 3, '의성군', '경상북도 의성군'),
	(47330, 47, 3, '청송군', '경상북도 청송군'),
	(47340, 47, 3, '영양군', '경상북도 영양군'),
	(47350, 47, 3, '영덕군', '경상북도 영덕군'),
	(47360, 47, 3, '청도군', '경상북도 청도군'),
	(47370, 47, 3, '고령군', '경상북도 고령군'),
	(47380, 47, 3, '성주군', '경상북도 성주군'),
	(47390, 47, 3, '칠곡군', '경상북도 칠곡군'),
	(47410, 47, 3, '예천군', '경상북도 예천군'),
	(47420, 47, 3, '봉화군', '경상북도 봉화군'),
	(47430, 47, 3, '울진군', '경상북도 울진군'),
	(47440, 47, 3, '울릉군', '경상북도 울릉군');

-- 경상남도
INSERT INTO regions (region_id, super_id, depth, name, full_name) VALUES
	(48110, 48, 3, '창원시 의창구', '경상남도 창원시 의창구'),
	(48120, 48, 3, '창원시 성산구', '경상남도 창원시 성산구'),
	(48130, 48, 3, '창원시 마산합포구', '경상남도 창원시 마산합포구'),
	(48140, 48, 3, '창원시 마산회원구', '경상남도 창원시 마산회원구'),
	(48150, 48, 3, '창원시 진해구', '경상남도 창원시 진해구'),
	(48210, 48, 3, '진주시', '경상남도 진주시'),
	(48220, 48, 3, '통영시', '경상남도 통영시'),
	(48230, 48, 3, '사천시', '경상남도 사천시'),
	(48240, 48, 3, '김해시', '경상남도 김해시'),
	(48250, 48, 3, '밀양시', '경상남도 밀양시'),
	(48260, 48, 3, '거제시', '경상남도 거제시'),
	(48270, 48, 3, '양산시', '경상남도 양산시'),
	(48310, 48, 3, '의령군', '경상남도 의령군'),
	(48320, 48, 3, '창녕군', '경상남도 창녕군'),
	(48330, 48, 3, '고성군', '경상남도 고성군'),
	(48340, 48, 3, '남해군', '경상남도 남해군'),
	(48350, 48, 3, '하동군', '경상남도 하동군'),
	(48360, 48, 3, '산청군', '경상남도 산청군'),
	(48370, 48, 3, '함안군', '경상남도 함안군'),
	(48380, 48, 3, '거창군', '경상남도 거창군'),
	(48390, 48, 3, '합천군', '경상남도 합천군');

-- 제주도
INSERT INTO regions (region_id, super_id, depth, name, full_name) VALUES
	(50110, 50, 3, '제주시', '제주특별자치도 제주시'),
	(50130, 50, 3, '서귀포시', '제주특별자치도 서귀포시');

-- 채팅방 데이터
-- 업종별 채팅방
INSERT INTO chat_rooms (industry_id, region_id, room_type) VALUES
	(1, NULL, 'industry'),
	(2, NULL, 'industry'),
	(3, NULL, 'industry'),
	(4, NULL, 'industry'),
	(5, NULL, 'industry'),
	(6, NULL, 'industry'),
	(7, NULL, 'industry'),
	(8, NULL, 'industry'),
	(9, NULL, 'industry'),
	(10, NULL, 'industry'),
	(11, NULL, 'industry'),
	(12, NULL, 'industry'),
	(13, NULL, 'industry'),
	(14, NULL, 'industry'),
	(15, NULL, 'industry'),
	(16, NULL, 'industry'),
	(17, NULL, 'industry'),
	(18, NULL, 'industry'),
	(19, NULL, 'industry');

-- 시/도별 채팅방
INSERT INTO chat_rooms (industry_id, region_id, room_type) VALUES
	(NULL, 11, 'region'),
	(NULL, 26, 'region'),
	(NULL, 27, 'region'),
	(NULL, 28, 'region'),
	(NULL, 29, 'region'),
	(NULL, 30, 'region'),
	(NULL, 31, 'region'),
	(NULL, 41, 'region'),
	(NULL, 42, 'region'),
	(NULL, 43, 'region'),
	(NULL, 44, 'region'),
	(NULL, 45, 'region'),
	(NULL, 46, 'region'),
	(NULL, 47, 'region'),
	(NULL, 48, 'region'),
	(NULL, 50, 'region');