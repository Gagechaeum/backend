
-- 사용자
INSERT INTO users (user_id, email, password, nickname, name, phone, created_at, social, social_id, notification, profile_image_key)
VALUES (
		   1,
		   'test@example.com',
		   '$2a$10$4DKsqy/vPc05zfqNSyy6Fe43KNk3Q6GeDatsjesWKjKyzsdUvt87i',
		   'angela4',
		   '사윤민',
		   '010-1234-5678',
		   NOW(),
		   NULL,
		   NULL,
		   true,
		   NULL
		);

-- 사업자
INSERT INTO business_info (user_id, region_id, industry_id, business_num, sales_scope, company_name)
VALUES (
		   1,
		   47210,  -- 경상북도 경주시
		   9,  -- 숙박 및 음식점업
		   '596-18-01709',
		   'SALES_SCOPE1',
		   '피자스쿨'
		);

-- 사용자 정책
INSERT INTO user_policies (user_id, policy_id, start_date, end_date, first_payment_date, monthly_amount, total_amount)
VALUES (
		   1,
		   '142000000088',
		   '2025-05-01',
		   '2025-08-01',
		   '2025-06-01',
		   50000,
		   1200000
		),
	   (
		   1,
		   '149200005008',
		   '2025-04-01',
		   '2025-04-01',
		   '2025-05-01',
		   3000000,
		   3000000
	   );

-- 사용자 대출
INSERT INTO user_loans (user_id, loan_id, collect_data, account_num, product_name, account_type, issue_date, expiry_date, last_offered_rate, repay_date, repay_method, repay_organization, repay_account_num, balance_amount, loan_principal, next_repay_date, loan_organization)
VALUES (
		   1,
		   1,
		   NOW(),
		   '123-456-789012',
		   'KB 동반성장협약 상생대출',
		   '신용대출',
		   '2024-11-01',
		   '2029-11-01',
		   3.55,
		   '2025-01-20',
		   '원금균등분할상환',
		   '국민은행',
		   '987-654-321098',
		   4800000,
		   5000000,
		   '2025-02-20',
		   '하나은행'
		);

INSERT INTO repayments (user_loan_id, amount, status, paid_date, balance_amount, principal_amount, interest_amount, return_interest_amount, interest_start_date, interest_end_date, interest_rate, applied_interest_amount, interest_type)
VALUES (
		   1,
		   250000,
		   '완납',
		   '2025-01-20',
		   4750000,
		   200000,
		   50000,
		   0,
		   '2024-12-21',
		   '2025-01-20',
		   3.55,
		   50000,
		   '정상이자'
		);

-- 사용자 정책 즐겨찾기
INSERT INTO user_policy_bookmarks (user_id, policy_id, status, created_at)
VALUES
	(1, '304000000186', '서류 수집/업로드', '2025-09-03 14:30:00'),
	(1, '142100000050', '제출 완료/결과', '2025-09-06 21:20:00');

-- 사용자 대출 즐겨찾기
INSERT INTO user_loan_bookmarks (user_id, loan_id, created_at)
VALUES
	(1, 57, '2025-09-01 10:00:00'),
	(1, 67, '2025-09-03 14:30:00'),
	(1, 94, '2025-09-05 09:10:00');

-- 사용자 서류
INSERT INTO user_documents (user_document_id, user_id, document_id, document_name, issued_at, file_key)
VALUES
	(1, 1, 5, '사업자등록증명', '2025-05-10', 'userDocuments/1:5:사업자등록증명.pdf');

-- 사용자 채팅방
-- 우리 프랜차이즈론
INSERT INTO user_chat_rooms (user_id, room_id, last_left_at)
VALUES (1, 198, '2025-09-08 10:00:00');

-- 경상북도
INSERT INTO user_chat_rooms (user_id, room_id, last_left_at)
VALUES (1, 33, '2025-09-01 10:30:00');

-- 숙박 및 음식점업
INSERT INTO user_chat_rooms (user_id, room_id, last_left_at)
VALUES (1, 9, '2025-09-05 14:30:00');

-- 나머지 더미 유저 id 2~10
INSERT INTO users (
	user_id, email, password, nickname, name, created_at, notification, is_verified
) VALUES
	  (2, 'user2@example.com', 'dummy_password', '성공창업가', '김민준', NOW(), TRUE, TRUE),
	  (3, 'user3@example.com', 'dummy_password', '대박사장님', '박서연', NOW(), TRUE, TRUE),
	  (4, 'user4@example.com', 'dummy_password', '오늘도야근', '이도윤', NOW(), TRUE, TRUE),
	  (5, 'user5@example.com', 'dummy_password', '돈세는날', '정하준', NOW(), TRUE, TRUE),
	  (6, 'user6@example.com', 'dummy_password', '사업1년차', '최지호', NOW(), TRUE, TRUE),
	  (7, 'user7@example.com', 'dummy_password', '스마트경영', '김시우', NOW(), TRUE, TRUE),
	  (8, 'user8@example.com', 'dummy_password', '성장하는가게', '한예준', NOW(), TRUE, TRUE),
	  (9, 'user9@example.com', 'dummy_password', '월매출천만', '강서준', NOW(), TRUE, TRUE),
	  (10, 'user10@example.com', 'dummy_password', '폐업은안돼', '윤지환', NOW(), TRUE, TRUE);
