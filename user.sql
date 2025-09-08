
-- 사용자



-- 사업자
INSERT INTO business_info (user_id, region_id, industry_id, business_num, sales_scope, company_name, estb_date)
VALUES (
		   1,
		   47210,  -- 경상북도 경주시
		   9,  -- 숙박 및 음식점업
		   '596-18-01709',
		   'SALES_SCOPE1',
		   '피자스쿨',
        '2021-12-22'
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
INSERT INTO user_policy_bookmarks (user_id, policy_id, status)
VALUES
	(1, '304000000186', '서류 수집/업로드'),
	(1, '142100000050', '제출 완료/결과');

-- 사용자 대출 즐겨찾기
INSERT INTO user_loan_bookmarks (user_id, loan_id)
VALUES
	(1, 57),
	(1, 67),
	(1, 94);

-- 사용자 서류
INSERT INTO user_documents (user_document_id, user_id, document_id, document_name, issued_at, file_key)
VALUES
	(1, 1, 5, '사업자등록증명', '2025-05-10', 'userDocuments/1:5:사업자등록증명.pdf');
