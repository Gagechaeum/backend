
USE gagechaeum_db;
-- --------------------------------------------------------
-- 1. 국민은행 - KB 동반성장협약 상생대출
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '국민은행', 'KB 동반성장협약 상생대출', '영업점', '2025-08-18',
             NULL, 'https://www.kbstar.com', 0, 0, 0.45
         );
INSERT INTO rates (
    loan_id, rate_type, average_rate
) VALUES (
             LAST_INSERT_ID(), '대출금리', 1.04
         );


-- --------------------------------------------------------
-- 2. 농협은행주식회사 - 채움 상생론
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '농협은행주식회사', '채움 상생론', '영업점', '2025-08-18',
             NULL, 'https://www.nhbank.com', 0, 0, 5.04
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1)
VALUES
    (LAST_INSERT_ID(), '대출금리', 1.89, 1.89),
    (LAST_INSERT_ID(), '기준금리', 2.51, 2.51),
    (LAST_INSERT_ID(), '가산금리', 0.62, 0.62);


-- --------------------------------------------------------
-- 3. 주식회사 케이뱅크 - 사장님 부동산담보대출
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             12, NULL, '주식회사 케이뱅크', '사장님 부동산담보대출', '스마트폰', '2025-08-18',
             NULL, 'https://www.kbanknow.com', 10000000, 1000000000, 2.69
         );
INSERT INTO rates (
    loan_id, rate_type, average_rate
) VALUES (
             LAST_INSERT_ID(), '대출금리', 3.20
         );


-- --------------------------------------------------------
-- 4. 우리은행 - 우리CUBE론-X(우리자산신탁)
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             11, NULL, '우리은행', '우리CUBE론-X(우리자산신탁)', '영업점', '2025-08-18',
             NULL, 'https://www.wooribank.com', 1000000000, 0, 3.20
         );
INSERT INTO rates (
    loan_id, rate_type, average_rate
) VALUES (
             LAST_INSERT_ID(), '대출금리', 3.22
         );


-- --------------------------------------------------------
-- 5. 우리은행 - 우리CUBE론-X(BIZ프라임)
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '우리은행', '우리CUBE론-X(BIZ프라임)', '영업점', '2025-08-18',
             NULL, 'https://www.wooribank.com', 0, 0, 3.86
         );
INSERT INTO rates (
    loan_id, rate_type, average_rate
) VALUES (
             LAST_INSERT_ID(), '대출금리', 3.30
         );


-- --------------------------------------------------------
-- 6. 농협은행주식회사 - 이노메인비즈대출
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '농협은행주식회사', '이노메인비즈대출', '영업점', '2025-08-18',
             NULL, 'https://www.nhbank.com', 0, 0, 3.40
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range2)
VALUES
    (LAST_INSERT_ID(), '대출금리', 3.32, 3.32),
    (LAST_INSERT_ID(), '기준금리', 2.51, 2.51),
    (LAST_INSERT_ID(), '가산금리', 0.81, 0.81);


-- --------------------------------------------------------
-- 7. 국민은행 - KB 우량산업단지기업 우대대출
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             3, NULL, '국민은행', 'KB 우량산업단지기업 우대대출', '영업점', '2025-08-18',
             NULL, 'https://www.kbstar.com', 0, 0, 2.60
         );
INSERT INTO rates (
    loan_id, rate_type, average_rate
) VALUES (
             LAST_INSERT_ID(), '대출금리', 3.43
         );


-- --------------------------------------------------------
-- 8. 한국스탠다드차타드은행 - 비즈니스모기지(Mortgage)
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '한국스탠다드차타드은행', '비즈니스모기지(Mortgage)', '영업점', '2025-08-18',
             NULL, 'https://www.sc.co.kr', 100000000, 6800000000, 4.25
         );
INSERT INTO rates (
    loan_id, rate_type, average_rate
) VALUES (
             LAST_INSERT_ID(), '대출금리', 3.44
         );


-- --------------------------------------------------------
-- 9. 국민은행 - KB 더드림(The Dream) 소호대출
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '국민은행', 'KB 더드림(The Dream) 소호대출', '영업점', '2025-08-18',
             NULL, 'https://www.kbstar.com', 0, 1000000000, 3.57
         );
INSERT INTO rates (
    loan_id, rate_type, average_rate
) VALUES (
             LAST_INSERT_ID(), '대출금리', 3.57
         );


-- --------------------------------------------------------
-- 10. 국민은행 - KB 유망분야 성장기업 우대대출
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '국민은행', 'KB 유망분야 성장기업 우대대출', '영업점', '2025-08-18',
             NULL, 'https://www.kbstar.com', 0, 0, 2.67
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2)
VALUES
    (LAST_INSERT_ID(), '대출금리', 4.24, 4.16, 5.08),
    (LAST_INSERT_ID(), '기준금리', 2.52, 2.53, 2.51),
    (LAST_INSERT_ID(), '가산금리', NULL, 1.63, 2.57);


-- --------------------------------------------------------
-- 11. 아이엠뱅크 - 무브온(Move-On) 특별대출
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '아이엠뱅크', '무브온(Move-On) 특별대출', '영업점', '2025-08-18',
             NULL, 'https://www.dgb.co.kr', 0, 30000000000, 0.00
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range3)
VALUES
    (LAST_INSERT_ID(), '대출금리', 4.96, 4.92, 6.90),
    (LAST_INSERT_ID(), '기준금리', 2.52, 2.52, 2.51),
    (LAST_INSERT_ID(), '가산금리', 2.44, 2.40, 4.39);


-- --------------------------------------------------------
-- 12. 신한은행 - 신한SOHO명품대출III(시설자금)
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '신한은행', '신한SOHO명품대출III(시설자금)', '영업점', '2025-08-18',
             NULL, 'https://www.shinhan.com', 300000000, 0, 3.91
         );
INSERT INTO rates (
    loan_id, rate_type, average_rate
) VALUES (
             LAST_INSERT_ID(), '대출금리', 3.62
         );


-- --------------------------------------------------------
-- 13. 국민은행 - KB 일사천리소호대출
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '국민은행', 'KB 일사천리소호대출', '영업점', '2025-08-18',
             NULL, 'https://www.kbstar.com', 0, 1000000000, 2.82
         );
INSERT INTO rates (
    loan_id, rate_type, average_rate
) VALUES (
             LAST_INSERT_ID(), '대출금리', 3.65
         );


-- --------------------------------------------------------
-- 14. 신한은행 - 신한SOHO명품대출(시설자금)
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '신한은행', '신한SOHO명품대출(시설자금)', '영업점', '2025-08-18',
             NULL, 'https://www.shinhan.com', 300000000, 0, 3.91
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1)
VALUES
    (LAST_INSERT_ID(), '대출금리', 3.79, 3.79),
    (LAST_INSERT_ID(), '기준금리', 2.51, 2.51),
    (LAST_INSERT_ID(), '가산금리', 1.28, 1.28);


-- --------------------------------------------------------
-- 15. 국민은행 - 기업일반시설자금대출
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '국민은행', '기업일반시설자금대출', '영업점', '2025-08-18',
             NULL, 'https://www.kbstar.com', 0, 0, 2.07
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1)
VALUES
    (LAST_INSERT_ID(), '대출금리', 4.18, 4.18),
    (LAST_INSERT_ID(), '기준금리', 2.50, 2.50),
    (LAST_INSERT_ID(), '가산금리', 2.22, 1.68);


-- --------------------------------------------------------
-- 16. 농협은행주식회사 - 채움 성공비즈니스대출
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '농협은행주식회사', '채움 성공비즈니스대출', '영업점', '2025-08-18',
             NULL, 'https://www.nhbank.com', 0, 0, 4.13
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2, rate_range3)
VALUES
    (LAST_INSERT_ID(), '대출금리', 3.67, 3.69, 4.33, 3.54),
    (LAST_INSERT_ID(), '기준금리', 2.55, 2.51, 2.51, 2.68),
    (LAST_INSERT_ID(), '가산금리', 1.12, 1.18, 1.82, 0.86);


-- --------------------------------------------------------
-- 17. 아이엠뱅크 - 착한 건물주 특별대출
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             12, NULL, '아이엠뱅크', '착한 건물주 특별대출', '영업점', '2025-08-18',
             NULL, 'https://www.dgb.co.kr', 0, 0, 3.58
         );
INSERT INTO rates (
    loan_id, rate_type, average_rate
) VALUES (
             LAST_INSERT_ID(), '대출금리', 3.67
         );


-- --------------------------------------------------------
-- 18. 수협은행 - Sh특별출연협약보증대출
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '수협은행', 'Sh특별출연협약보증대출', '영업점', '2025-08-18',
             NULL, 'https://www.suhyup-bank.com', 0, 0, 3.91
         );
INSERT INTO rates (
    loan_id, rate_type, average_rate
) VALUES (
             LAST_INSERT_ID(), '대출금리', 3.72
         );


-- --------------------------------------------------------
-- 19. 우리은행 - 우리CUBE론-X(일반,산업단지)
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             3, NULL, '우리은행', '우리CUBE론-X(일반,산업단지)', '영업점', '2025-08-18',
             NULL, 'https://www.wooribank.com', 0, 0, 3.86
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2, rate_range3)
VALUES
    (LAST_INSERT_ID(), '대출금리', 4.13, 3.95, 4.27, 4.64),
    (LAST_INSERT_ID(), '기준금리', 2.54, 2.55, 2.52, 2.55),
    (LAST_INSERT_ID(), '가산금리', 1.59, 1.40, 1.75, 2.09);


-- --------------------------------------------------------
-- 20. 농협은행주식회사 - 중소기업보증료지원대출
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '농협은행주식회사', '중소기업보증료지원대출', '영업점', '2025-08-18',
             NULL, 'https://www.nhbank.com', 0, 0, 4.13
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range4)
VALUES
    (LAST_INSERT_ID(), '대출금리', 3.78, 3.85, 3.45),
    (LAST_INSERT_ID(), '기준금리', 2.51, 2.50, 2.53),
    (LAST_INSERT_ID(), '가산금리', 1.27, 1.35, 0.92);


-- --------------------------------------------------------
-- 21. 제주은행 - 전문직우대론
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             13, NULL, '제주은행', '전문직우대론', '영업점', '2025-08-18',
             NULL, 'https://www.e-jejubank.com', 0, 0, 3.78
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2, rate_range7)
VALUES
    (LAST_INSERT_ID(), '대출금리', 3.78, 3.69, 4.06, 4.03),
    (LAST_INSERT_ID(), '기준금리', 2.84, 2.81, 2.82, 4.03),
    (LAST_INSERT_ID(), '가산금리', 0.93, 0.88, 1.24, 0.00);


-- --------------------------------------------------------
-- 22. 농협은행주식회사 - NH기업성장론_착한임대인우대(임대사업자 전용)
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             12, NULL, '농협은행주식회사', 'NH기업성장론_착한임대인우대(임대사업자 전용)', '영업점', '2025-08-18',
             NULL, 'https://www.nhbank.com', 0, 0, 4.23
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2, rate_range3, rate_range4)
VALUES
    (LAST_INSERT_ID(), '대출금리', 3.79, 3.78, 3.80, 4.11, 4.16),
    (LAST_INSERT_ID(), '기준금리', 2.59, 2.59, 2.60, 2.65, 2.71),
    (LAST_INSERT_ID(), '가산금리', 1.20, 1.19, 1.20, 1.46, 1.45);


-- --------------------------------------------------------
-- 23. 신한은행 - 신한SOHO명품대출(분할상환)(시설자금)
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '신한은행', '신한SOHO명품대출(분할상환)(시설자금)', '영업점', '2025-08-18',
             NULL, 'https://www.shinhan.com', 300000000, 0, 3.91
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 3.81);


-- --------------------------------------------------------
-- 24. 농협은행주식회사 - NH기술평가우수기업대출
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             13, NULL, '농협은행주식회사', 'NH기술평가우수기업대출', '영업점', '2025-08-18',
             NULL, 'https://www.nhbank.com', 0, 0, 4.33
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2, rate_range3, rate_range4)
VALUES
    (LAST_INSERT_ID(), '대출금리', 3.83, 3.77, 4.14, 3.93, 3.95),
    (LAST_INSERT_ID(), '기준금리', 2.52, 2.52, 2.54, 2.51, 2.51),
    (LAST_INSERT_ID(), '가산금리', 1.31, 1.25, 1.61, 1.42, 1.44);


-- --------------------------------------------------------
-- 25. 아이엠뱅크 - 기업시설자금대출
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '아이엠뱅크', '기업시설자금대출', '영업점', '2025-08-18',
             NULL, 'https://www.dgb.co.kr', 0, 0, 0.12
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1)
VALUES
    (LAST_INSERT_ID(), '대출금리', 4.81, 4.81),
    (LAST_INSERT_ID(), '기준금리', 2.51, 2.51),
    (LAST_INSERT_ID(), '가산금리', 2.30, 2.30);


-- --------------------------------------------------------
-- 26. 국민은행 - KB 투게더론
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '국민은행', 'KB 투게더론', '영업점', '2025-08-18',
             NULL, 'https://www.kbstar.com', 0, 0, 2.94
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2)
VALUES
    (LAST_INSERT_ID(), '대출금리', 4.58, 4.83, 3.74),
    (LAST_INSERT_ID(), '기준금리', 2.52, 2.52, 2.53),
    (LAST_INSERT_ID(), '가산금리', NULL, 2.31, 1.21);


-- --------------------------------------------------------
-- 27. 경남은행 - 3D프린팅 연관기업 특례보증 대출
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             3, NULL, '경남은행', '3D프린팅 연관기업 특례보증 대출', '영업점', '2025-08-18',
             NULL, 'https://www.knbank.co.kr', 0, 200000000, 3.75
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 3.87);


-- --------------------------------------------------------
-- 28. 국민은행 - KB 모아드림론
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '국민은행', 'KB 모아드림론', '영업점', '2025-08-18',
             NULL, 'https://www.kbstar.com', 0, 0, 2.83
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2)
VALUES
    (LAST_INSERT_ID(), '대출금리', 4.39, 4.40, 4.37),
    (LAST_INSERT_ID(), '기준금리', 2.52, 2.52, 2.50),
    (LAST_INSERT_ID(), '가산금리', 1.72, 1.88, 1.87);


-- --------------------------------------------------------
-- 29. 국민은행 - 기업일반운전자금대출
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '국민은행', '기업일반운전자금대출', '영업점', '2025-08-18',
             NULL, 'https://www.kbstar.com', 0, 0, 2.46
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2, rate_range3, rate_range4)
VALUES
    (LAST_INSERT_ID(), '대출금리', 4.61, 4.50, 4.81, 6.41, 5.76),
    (LAST_INSERT_ID(), '기준금리', 2.52, 2.52, 2.51, 2.50, 2.50),
    (LAST_INSERT_ID(), '가산금리', 2.35, 1.98, 2.30, 3.91, 3.26);


-- --------------------------------------------------------
-- 30. 아이엠뱅크 - 기업운전자금대출
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '아이엠뱅크', '기업운전자금대출', '영업점', '2025-08-18',
             NULL, 'https://www.dgb.co.kr', 0, 0, 0.00
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2, rate_range3, rate_range4, rate_range8)
VALUES
    (LAST_INSERT_ID(), '대출금리', 5.65, 5.13, 5.98, 7.37, 13.00, 13.00),
    (LAST_INSERT_ID(), '기준금리', 2.51, 2.52, 2.51, 2.51, 2.57, 2.55),
    (LAST_INSERT_ID(), '가산금리', 3.13, 2.62, 3.47, 4.86, 10.43, 10.45);


-- --------------------------------------------------------
-- 31. 경남은행 - 무역금융
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             7, NULL, '경남은행', '무역금융', '영업점', '2025-08-18',
             NULL, 'https://www.knbank.co.kr', 0, 0, 4.38
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1)
VALUES
    (LAST_INSERT_ID(), '대출금리', 4.86, 4.86),
    (LAST_INSERT_ID(), '기준금리', 2.55, 2.55),
    (LAST_INSERT_ID(), '가산금리', 2.31, 2.31);


-- --------------------------------------------------------
-- 32. 국민은행 - KB 커머셜모기지론
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             12, NULL, '국민은행', 'KB 커머셜모기지론', '영업점', '2025-08-18',
             NULL, 'https://www.kbstar.com', 0, 0, 3.23
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 3.93);


-- --------------------------------------------------------
-- 33. 신한은행 - 신한 프랜차이즈론(분할상환)(시설자금)
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '신한은행', '신한 프랜차이즈론(분할상환)(시설자금)', '영업점', '2025-08-18',
             NULL, 'https://www.shinhan.com', 0, 200000000, 3.91
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 3.93);


-- --------------------------------------------------------
-- 34. 경남은행 - 하이테크자금대출
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             13, NULL, '경남은행', '하이테크자금대출', '영업점', '2025-08-18',
             NULL, 'https://www.knbank.co.kr', 0, 0, 3.73
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 3.94);


-- --------------------------------------------------------
-- 35. 경남은행 - 위더스론
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '경남은행', '위더스론', '영업점', '2025-08-18',
             NULL, 'https://www.knbank.co.kr', 0, 3000000000, 3.43
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 3.97);


-- --------------------------------------------------------
-- 36. 국민은행 - ONE KB 기업 우대대출
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '국민은행', 'ONE KB 기업 우대대출', '영업점', '2025-08-18',
             NULL, 'https://www.kbstar.com', 0, 0, 2.80
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 3.97);


-- --------------------------------------------------------
-- 37. 아이엠뱅크 - Tech biz(테크비즈)론
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             13, NULL, '아이엠뱅크', 'Tech biz(테크비즈)론', '영업점', '2025-08-18',
             NULL, 'https://www.dgb.co.kr', 0, 0, 0.42
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2)
VALUES
    (LAST_INSERT_ID(), '대출금리', 5.17, 5.15, 5.23),
    (LAST_INSERT_ID(), '기준금리', 2.52, 2.51, 2.56),
    (LAST_INSERT_ID(), '가산금리', 2.65, 2.64, 2.67);


-- --------------------------------------------------------
-- 38. 광주은행 - KJB SOLAR-LOAN
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             4, NULL, '광주은행', 'KJB SOLAR-LOAN', '영업점', '2025-08-18',
             NULL, 'https://www.kjbank.com', 0, 0, 3.67
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 3.98);


-- --------------------------------------------------------
-- 39. 주식회사 하나은행 - 파워메디론
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             17, NULL, '주식회사 하나은행', '파워메디론', '영업점,스마트폰', '2025-08-18',
             NULL, 'https://www.hanabank.com', 0, 0, 3.99
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2)
VALUES
    (LAST_INSERT_ID(), '대출금리', 3.99, 3.99, 4.10),
    (LAST_INSERT_ID(), '기준금리', 2.51, 2.51, 2.51),
    (LAST_INSERT_ID(), '가산금리', 1.47, 1.47, 1.59);


-- --------------------------------------------------------
-- 40. 신한은행 - 신한SOHO명품대출(운전자금)
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '신한은행', '신한SOHO명품대출(운전자금)', '영업점', '2025-08-18',
             NULL, 'https://www.shinhan.com', 300000000, 0, 4.33
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 4.00);


-- --------------------------------------------------------
-- 41. 경남은행 - 중소기업 신용보증서 우대대출 업무매뉴얼
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '경남은행', '중소기업 신용보증서 우대대출 업무매뉴얼', '영업점', '2025-08-18',
             NULL, 'https://www.knbank.co.kr', 0, 0, 3.28
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 4.01);


-- --------------------------------------------------------
-- 42. 신한은행 - 신용보증재단 특례보증대출(재창업 소상공인지원)
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '신한은행', '신용보증재단 특례보증대출(재창업 소상공인지원)', '영업점', '2025-08-18',
             NULL, 'https://www.shinhan.com', 0, 100000000, 4.01
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 4.01);


-- --------------------------------------------------------
-- 43. 신한은행 - 신한 의(醫)사랑대출(운전자금)
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             17, NULL, '신한은행', '신한 의(醫)사랑대출(운전자금)', '영업점', '2025-08-18',
             NULL, 'https://www.shinhan.com', 0, 1000000000, 4.23
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2)
VALUES
    (LAST_INSERT_ID(), '대출금리', 4.15, 4.11, 4.33),
    (LAST_INSERT_ID(), '기준금리', 2.57, 2.58, 2.51),
    (LAST_INSERT_ID(), '가산금리', 1.58, 1.53, 1.82);


-- --------------------------------------------------------
-- 44. 우리은행 - 단기수요자금융
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '우리은행', '단기수요자금융', '영업점,인터넷', '2025-08-18',
             NULL, 'https://www.wooribank.com', 0, 0, 3.85
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range5)
VALUES
    (LAST_INSERT_ID(), '대출금리', 4.01, 4.01),
    (LAST_INSERT_ID(), '기준금리', 2.51, 2.51),
    (LAST_INSERT_ID(), '가산금리', 1.50, 1.50);


-- --------------------------------------------------------
-- 45. 주식회사 하나은행 - HANA 전문직 소호대출
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             13, NULL, '주식회사 하나은행', 'HANA 전문직 소호대출', '영업점', '2025-08-18',
             NULL, 'https://www.hanabank.com', 0, 0, 4.02
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2)
VALUES
    (LAST_INSERT_ID(), '대출금리', 4.02, 4.00, 4.29),
    (LAST_INSERT_ID(), '기준금리', 2.55, 2.55, 2.51),
    (LAST_INSERT_ID(), '가산금리', 1.47, 1.45, 1.78);


-- --------------------------------------------------------
-- 46. 경남은행 - 토지분양자금대출
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             12, NULL, '경남은행', '토지분양자금대출', '영업점', '2025-08-18',
             NULL, 'https://www.knbank.co.kr', 0, 0, 4.53
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 4.03);


-- --------------------------------------------------------
-- 47. 주식회사 하나은행 - 닥터클럽대출-플래티늄
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             17, NULL, '주식회사 하나은행', '닥터클럽대출-플래티늄', '영업점', '2025-08-18',
             NULL, 'https://www.hanabank.com', 0, 0, 4.03
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2)
VALUES
    (LAST_INSERT_ID(), '대출금리', 4.03, 4.03, 4.10),
    (LAST_INSERT_ID(), '기준금리', 2.51, 2.51, 2.51),
    (LAST_INSERT_ID(), '가산금리', 1.52, 1.52, 1.59);


-- --------------------------------------------------------
-- 48. 농협은행주식회사 - NH농식품기업우대론
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             1, NULL, '농협은행주식회사', 'NH농식품기업우대론', '영업점', '2025-08-18',
             NULL, 'https://www.nhbank.com', 0, 0, 3.05
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2, rate_range3, rate_range4, rate_range5, rate_range6, rate_range8)
VALUES
    (LAST_INSERT_ID(), '대출금리', 4.04, 3.98, 4.16, 3.95, 4.90, 5.29, 5.25, 4.95),
    (LAST_INSERT_ID(), '기준금리', 2.52, 2.53, 2.52, 2.51, 2.52, 2.53, 2.51, 2.51),
    (LAST_INSERT_ID(), '가산금리', 1.52, 1.45, 1.64, 1.44, 2.38, 2.76, 2.74, 2.44);


-- --------------------------------------------------------
-- 49. 농협은행주식회사 - NH기업성장론
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '농협은행주식회사', 'NH기업성장론', '영업점', '2025-08-18',
             NULL, 'https://www.nhbank.com', 0, 0, 4.13
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2, rate_range3, rate_range4, rate_range5, rate_range6, rate_range7, rate_range8)
VALUES
    (LAST_INSERT_ID(), '대출금리', 4.05, 3.97, 4.18, 4.37, 4.69, 4.47, 5.08, 4.88, 5.28),
    (LAST_INSERT_ID(), '기준금리', 2.55, 2.55, 2.54, 2.53, 2.53, 2.53, 2.51, 2.51, 2.57),
    (LAST_INSERT_ID(), '가산금리', 1.50, 1.42, 1.64, 1.84, 2.16, 1.94, 2.57, 2.37, 2.71);


-- --------------------------------------------------------
-- 50. 국민은행 - KB 메디칼론
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             17, NULL, '국민은행', 'KB 메디칼론', '영업점', '2025-08-18',
             NULL, 'https://www.kbstar.com', 0, 0, 3.53
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2, rate_range3, rate_range4)
VALUES
    (LAST_INSERT_ID(), '대출금리', 4.12, 4.06, 4.70, 4.41, 4.62),
    (LAST_INSERT_ID(), '기준금리', 2.51, 2.51, 2.50, 2.51, 2.52),
    (LAST_INSERT_ID(), '가산금리', NULL, 1.55, 2.20, 1.90, 2.10);


-- --------------------------------------------------------
-- 51. 한국투자저축은행 - 수입육담보대출
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             7, NULL, '한국투자저축은행', '수입육담보대출', '영업점', '2025-08-15',
             NULL, 'https://www.kisb.co.kr', 0, 0, 8.50
         );
INSERT INTO rates (loan_id, rate_type)
VALUES (LAST_INSERT_ID(), '대출금리');


-- --------------------------------------------------------
-- 52. 신한은행 - 신한 동물병원대출(종합통장대출)
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             17, NULL, '신한은행', '신한 동물병원대출(종합통장대출)', '영업점', '2025-08-18',
             NULL, 'https://www.shinhan.com', 0, 50000000, 4.23
         );
INSERT INTO rates (loan_id, rate_type)
VALUES (LAST_INSERT_ID(), '대출금리');


-- --------------------------------------------------------
-- 53. 수협은행 - 고시원사업자대출
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             9, NULL, '수협은행', '고시원사업자대출', '영업점', '2025-08-18',
             NULL, 'https://www.suhyup-bank.com', 0, 0, 4.03
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1)
VALUES
    (LAST_INSERT_ID(), '대출금리', 4.10, 4.10),
    (LAST_INSERT_ID(), '기준금리', 2.43, 2.43),
    (LAST_INSERT_ID(), '가산금리', 1.67, 1.67);


-- --------------------------------------------------------
-- 54. 수협은행 - 냉동수산물담보대출
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             7, NULL, '수협은행', '냉동수산물담보대출', '영업점', '2025-08-18',
             NULL, 'https://www.suhyup-bank.com', 0, 0, 5.75
         );
INSERT INTO rates (loan_id, rate_type)
VALUES (LAST_INSERT_ID(), '대출금리');


-- --------------------------------------------------------
-- 55. 농협은행주식회사 - NH농식품그린성장론
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             1, NULL, '농협은행주식회사', 'NH농식품그린성장론', '영업점', '2025-08-18',
             NULL, 'https://www.nhbank.com', 0, 0, 3.35
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2, rate_range3, rate_range4, rate_range5, rate_range6)
VALUES
    (LAST_INSERT_ID(), '대출금리', 4.19, 4.17, 4.19, 4.54, 4.08, 4.52, 5.64),
    (LAST_INSERT_ID(), '기준금리', 2.52, 2.52, 2.52, 2.52, 2.53, 2.53, 2.51),
    (LAST_INSERT_ID(), '가산금리', 1.67, 1.64, 1.67, 2.02, 1.55, 1.99, 3.13);


-- --------------------------------------------------------
-- 56. 수협은행 - MY편의점대출
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             7, NULL, '수협은행', 'MY편의점대출', '영업점', '2025-08-18',
             NULL, 'https://www.suhyup-bank.com', 0, 0, 4.03
         );
INSERT INTO rates (loan_id, rate_type)
VALUES (LAST_INSERT_ID(), '대출금리');

-- --------------------------------------------------------
-- 1. 우리은행 - 우리 프랜차이즈론
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '우리은행', '우리 프랜차이즈론', '영업점', '2025-08-18',
             NULL, 'https://www.wooribank.com', 0, 200000000, 4.46
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.06);


-- --------------------------------------------------------
-- 2. 제주은행 - 병원약국우대대출
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             17, NULL, '제주은행', '병원약국우대대출', '영업점', '2025-08-18',
             NULL, 'https://www.e-jejubank.com', 0, 300000000, 4.66
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2)
VALUES
    (LAST_INSERT_ID(), '대출금리', 5.08, 5.03, 5.40),
    (LAST_INSERT_ID(), '기준금리', 2.75, 2.74, 2.89),
    (LAST_INSERT_ID(), '가산금리', 2.31, 2.29, 2.51);


-- --------------------------------------------------------
-- 3. 국민은행 - 상업어음할인
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             11, NULL, '국민은행', '상업어음할인', '영업점', '2025-08-18',
             NULL, 'https://www.kbstar.com', 0, 0, 4.53
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range2)
VALUES
    (LAST_INSERT_ID(), '대출금리', 4.66, 4.66),
    (LAST_INSERT_ID(), '기준금리', 2.51, 2.51),
    (LAST_INSERT_ID(), '가산금리', NULL, 2.15);


-- --------------------------------------------------------
-- 4. 국민은행 - KB메가셀러론
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             7, NULL, '국민은행', 'KB메가셀러론', '영업점', '2025-08-18',
             NULL, 'https://www.kbstar.com', 0, 0, 3.98
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2, rate_range3, rate_range4)
VALUES
    (LAST_INSERT_ID(), '대출금리', 5.15, 5.00, 5.20, 5.58, 5.66),
    (LAST_INSERT_ID(), '기준금리', 2.52, 2.52, 2.53, 2.51, 2.52),
    (LAST_INSERT_ID(), '가산금리', 2.63, 2.48, 2.67, 3.07, 3.14);


-- --------------------------------------------------------
-- 5. 신한은행 - TOPS전문직우대론(종합통장대출)
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             13, NULL, '신한은행', 'TOPS전문직우대론(종합통장대출)', '영업점', '2025-08-18',
             NULL, 'https://www.shinhan.com', 0, 300000000, 4.23
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range4)
VALUES
    (LAST_INSERT_ID(), '대출금리', 5.24, 5.36, 4.59),
    (LAST_INSERT_ID(), '기준금리', 2.54, 2.55, 2.51),
    (LAST_INSERT_ID(), '가산금리', 2.70, 2.81, 2.08);


-- --------------------------------------------------------
-- 6. 아이엠뱅크 - 상업어음할인
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             11, NULL, '아이엠뱅크', '상업어음할인', '영업점', '2025-08-18',
             NULL, 'https://www.dgb.co.kr', 0, 0, 4.76
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2)
VALUES
    (LAST_INSERT_ID(), '대출금리', 5.23, 4.95, 5.71),
    (LAST_INSERT_ID(), '기준금리', 2.52, 2.53, 2.50),
    (LAST_INSERT_ID(), '가산금리', 2.71, 2.42, 3.21);


-- --------------------------------------------------------
-- 7. 현대커머셜㈜ - 현대자동차 신차 할부
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             7, NULL, '현대커머셜㈜', '현대자동차 신차 할부', '영업점,스마트폰,모집인', '2025-08-13',
             NULL, 'https://www.hyundaicommercial.com', 0, 0, 4.90
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.32);


-- --------------------------------------------------------
-- 8. 수협은행 - 집단주택자금대출
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             6, NULL, '수협은행', '집단주택자금대출', '영업점', '2025-08-18',
             NULL, 'https://www.suhyup-bank.com', 0, 0, 5.06
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.38);


-- --------------------------------------------------------
-- 9. 하나캐피탈㈜ - 정상오토론
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             7, NULL, '하나캐피탈㈜', '정상오토론', '모집인', '2025-08-13',
             NULL, 'https://www.hanacapital.co.kr', 0, 0, 4.90
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.38);


-- --------------------------------------------------------
-- 10. 아이엠뱅크 - 기업통장대출
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '아이엠뱅크', '기업통장대출', '영업점', '2025-08-18',
             NULL, 'https://www.dgb.co.kr', 0, 0, 3.73
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2, rate_range3, rate_range4, rate_range6)
VALUES
    (LAST_INSERT_ID(), '대출금리', 6.66, 6.19, 7.76, 11.93, 12.99, 13.00),
    (LAST_INSERT_ID(), '기준금리', 2.51, 2.51, 2.51, 2.51, 2.51, 2.52),
    (LAST_INSERT_ID(), '가산금리', 4.15, 3.67, 5.25, 9.42, 10.48, 10.48);


-- --------------------------------------------------------
-- 11. 주식회사 카카오뱅크 - 개인사업자 신용대출
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '주식회사 카카오뱅크', '개인사업자 신용대출', '스마트폰', '2025-08-18',
             NULL, 'https://www.kakaobank.com', 0, 0, 5.41
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2, rate_range3, rate_range6)
VALUES
    (LAST_INSERT_ID(), '대출금리', 5.44, 5.24, 6.27, 6.61, 5.15),
    (LAST_INSERT_ID(), '기준금리', 2.52, 2.52, 2.52, 2.52, 2.51),
    (LAST_INSERT_ID(), '가산금리', 2.89, 2.72, 3.75, 4.09, 2.64);


-- --------------------------------------------------------
-- 12. 엔에이치농협캐피탈㈜ - 할부수입상용1
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             8, NULL, '엔에이치농협캐피탈㈜', '할부수입상용1', '영업점,스마트폰', '2025-08-12',
             NULL, 'https://www.nhcapital.co.kr', 0, 0, 5.60
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.47);


-- --------------------------------------------------------
-- 13. 현대커머셜㈜ - 현대자동차 신차 특장차 할부
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             8, NULL, '현대커머셜㈜', '현대자동차 신차 특장차 할부', '영업점,스마트폰,모집인', '2025-08-13',
             NULL, 'https://www.hyundaicommercial.com', 0, 0, 4.90
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.47);


-- --------------------------------------------------------
-- 14. 대백저축은행 - 자영업자주택담보대출
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '대백저축은행', '자영업자주택담보대출', '영업점', '2025-08-15',
             NULL, 'https://www.daebaekbank.co.kr', 0, 0, 5.00
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.50);


-- --------------------------------------------------------
-- 15. 흥국화재해상보험주식회사 - 2502흥국SOHO아파트대출
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '흥국화재해상보험주식회사', '2502흥국SOHO아파트대출', '모집인', '2025-08-14',
             NULL, 'https://www.heungkukfire.co.kr', 0, 3000000000, 5.06
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.50);


-- --------------------------------------------------------
-- 16. 농협은행주식회사 - 기업구매자금대출
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '농협은행주식회사', '기업구매자금대출', '영업점', '2025-08-18',
             NULL, 'https://www.nhbank.com', 0, 0, 4.20
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range2)
VALUES
    (LAST_INSERT_ID(), '대출금리', 4.99, 4.99),
    (LAST_INSERT_ID(), '기준금리', 2.53, 2.53),
    (LAST_INSERT_ID(), '가산금리', 2.46, 2.46);


-- --------------------------------------------------------
-- 17. 엔에이치농협캐피탈㈜ - 사료구매자금대출
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             1, NULL, '엔에이치농협캐피탈㈜', '사료구매자금대출', '영업점', '2025-08-13',
             NULL, 'https://www.nhcapital.co.kr', 0, 5000000000, 5.53
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.53);


-- --------------------------------------------------------
-- 18. ㈜아이엠캐피탈 - 장비대출_신차버스(일반)
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             8, NULL, '㈜아이엠캐피탈', '장비대출_신차버스(일반)', '모집인', '2025-08-14',
             NULL, 'https://www.imcapital.co.kr', 0, 0, 5.40
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range8)
VALUES
    (LAST_INSERT_ID(), '대출금리', 7.48, 7.48),
    (LAST_INSERT_ID(), '기준금리', NULL, NULL),
    (LAST_INSERT_ID(), '가산금리', NULL, NULL);


-- --------------------------------------------------------
-- 19. 우리은행 - 세이프e-구매자금대출
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '우리은행', '세이프e-구매자금대출', '영업점', '2025-08-18',
             NULL, 'https://www.wooribank.com', 0, 0, 3.99
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range4)
VALUES
    (LAST_INSERT_ID(), '대출금리', 5.54, 5.54),
    (LAST_INSERT_ID(), '기준금리', 2.51, 2.51),
    (LAST_INSERT_ID(), '가산금리', 3.03, 3.03);


-- --------------------------------------------------------
-- 20. 신한은행 - 신한 프랜차이즈론(운전자금)
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '신한은행', '신한 프랜차이즈론(운전자금)', '영업점', '2025-08-18',
             NULL, 'https://www.shinhan.com', 0, 200000000, 4.33
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range2, rate_range4)
VALUES
    (LAST_INSERT_ID(), '대출금리', 6.89, 6.91, 6.77),
    (LAST_INSERT_ID(), '기준금리', 2.52, 2.51, 2.57),
    (LAST_INSERT_ID(), '가산금리', 4.37, 4.40, 4.20);


-- --------------------------------------------------------
-- 21. 엔에이치농협캐피탈㈜ - 수입상용론1
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             8, NULL, '엔에이치농협캐피탈㈜', '수입상용론1', '영업점,스마트폰', '2025-08-12',
             NULL, 'https://www.nhcapital.co.kr', 0, 0, 5.60
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.58);


-- --------------------------------------------------------
-- 22. 산은캐피탈㈜ - 신차승용 오토론
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             7, NULL, '산은캐피탈㈜', '신차승용 오토론', '모집인', '2025-08-13',
             NULL, 'https://www.kdbcapital.co.kr', 0, 0, 5.60
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.60);


-- --------------------------------------------------------
-- 23. 우리은행 - 협력기업 상생대출
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '우리은행', '협력기업 상생대출', '영업점', '2025-08-18',
             NULL, 'https://www.wooribank.com', 0, 0, 3.46
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2)
VALUES
    (LAST_INSERT_ID(), '대출금리', 5.60, 5.35, 6.31),
    (LAST_INSERT_ID(), '기준금리', 2.52, 2.52, 2.52),
    (LAST_INSERT_ID(), '가산금리', 3.08, 2.83, 3.79);


-- --------------------------------------------------------
-- 24. 우리은행 - 파워브랜드 가맹점 창업대출
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '우리은행', '파워브랜드 가맹점 창업대출', '영업점', '2025-08-18',
             NULL, 'https://www.wooribank.com', 0, 100000000, 4.46
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2)
VALUES
    (LAST_INSERT_ID(), '대출금리', 5.66, 5.66, 5.66),
    (LAST_INSERT_ID(), '기준금리', 2.51, 2.51, 2.51),
    (LAST_INSERT_ID(), '가산금리', 3.15, 3.15, 3.15);


-- --------------------------------------------------------
-- 25. 엔에이치농협캐피탈㈜ - 할부수입상용2
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             8, NULL, '엔에이치농협캐피탈㈜', '할부수입상용2', '영업점,스마트폰', '2025-08-12',
             NULL, 'https://www.nhcapital.co.kr', 0, 0, 5.60
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.67);


-- --------------------------------------------------------
-- 26. 현대커머셜㈜ - 부동산PF
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             12, NULL, '현대커머셜㈜', '부동산PF', '기타', '2025-08-13',
             NULL, 'https://www.hyundaicommercial.com', 0, 0, 3.00
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.68);


-- --------------------------------------------------------
-- 27. 엔에이치농협캐피탈㈜ - 수입상용론2
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             8, NULL, '엔에이치농협캐피탈㈜', '수입상용론2', '영업점,스마트폰', '2025-08-12',
             NULL, 'https://www.nhcapital.co.kr', 0, 0, 5.60
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.70);


-- --------------------------------------------------------
-- 28. 청주저축은행 - 중도금대출
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '청주저축은행', '중도금대출', '영업점', '2025-08-15',
             NULL, 'https://www.chjsb.co.kr', 0, 0, 4.50
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.70);


-- --------------------------------------------------------
-- 29. 엔에이치농협캐피탈㈜ - 국내상용론2
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             8, NULL, '엔에이치농협캐피탈㈜', '국내상용론2', '영업점,스마트폰', '2025-08-12',
             NULL, 'https://www.nhcapital.co.kr', 0, 0, 5.60
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.74);


-- --------------------------------------------------------
-- 30. 우리은행 - 우리카드 가맹점 우대 대출
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '우리은행', '우리카드 가맹점 우대 대출', '스마트폰', '2025-08-18',
             NULL, 'https://www.wooribank.com', 0, 0, 5.77
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2, rate_range3)
VALUES
    (LAST_INSERT_ID(), '대출금리', 5.77, 5.77, 5.72, 6.12),
    (LAST_INSERT_ID(), '기준금리', 2.52, 2.52, 2.52, 2.53),
    (LAST_INSERT_ID(), '가산금리', 3.25, 3.25, 3.20, 3.59);


-- --------------------------------------------------------
-- 31. 롯데캐피탈㈜ - 운영자금/오토론
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             7, NULL, '롯데캐피탈㈜', '운영자금/오토론', '기타', '2025-08-14',
             NULL, 'https://www.lottecap.com', 0, 0, 5.80
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1)
VALUES
    (LAST_INSERT_ID(), '대출금리', 5.80, 5.80),
    (LAST_INSERT_ID(), '기준금리', NULL, NULL),
    (LAST_INSERT_ID(), '가산금리', NULL, NULL);


-- --------------------------------------------------------
-- 32. 신한은행 - 신한 프랜차이즈론(분할상환)(운전자금)
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '신한은행', '신한 프랜차이즈론(분할상환)(운전자금)', '영업점', '2025-08-18',
             NULL, 'https://www.shinhan.com', 0, 200000000, 4.33
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2, rate_range3)
VALUES
    (LAST_INSERT_ID(), '대출금리', 5.80, 6.69, 4.97, 6.72),
    (LAST_INSERT_ID(), '기준금리', 2.52, 2.51, 2.52, 2.52),
    (LAST_INSERT_ID(), '가산금리', 3.28, 4.18, 2.45, 4.20);


-- --------------------------------------------------------
-- 33. 엔에이치농협캐피탈㈜ - 국내상용론1
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             8, NULL, '엔에이치농협캐피탈㈜', '국내상용론1', '영업점,스마트폰', '2025-08-12',
             NULL, 'https://www.nhcapital.co.kr', 0, 0, 5.60
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.80);


-- --------------------------------------------------------
-- 34. 신한은행 - 신한 가맹점 사업자대출(분할상환)
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '신한은행', '신한 가맹점 사업자대출(분할상환)', '영업점', '2025-08-18',
             NULL, 'https://www.shinhan.com', 0, 200000000, 4.33
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2)
VALUES
    (LAST_INSERT_ID(), '대출금리', 5.81, 6.20, 5.42),
    (LAST_INSERT_ID(), '기준금리', 2.50, 2.50, 2.51),
    (LAST_INSERT_ID(), '가산금리', 3.31, 3.70, 2.91);


-- --------------------------------------------------------
-- 35. 엔에이치농협캐피탈㈜ - 할부특장
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             8, NULL, '엔에이치농협캐피탈㈜', '할부특장', '영업점,스마트폰', '2025-08-12',
             NULL, 'https://www.nhcapital.co.kr', 0, 0, 5.70
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.83);


-- --------------------------------------------------------
-- 36. ㈜아이엠캐피탈 - 장비대출_신차화물(중소형)
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             8, NULL, '㈜아이엠캐피탈', '장비대출_신차화물(중소형)', '모집인', '2025-08-14',
             NULL, 'https://www.imcapital.co.kr', 0, 0, 5.10
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.85);


-- --------------------------------------------------------
-- 37. 엔에이치농협캐피탈㈜ - 할부국내상용2
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             8, NULL, '엔에이치농협캐피탈㈜', '할부국내상용2', '영업점,스마트폰', '2025-08-12',
             NULL, 'https://www.nhcapital.co.kr', 0, 0, 5.60
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.86);


-- --------------------------------------------------------
-- 38. 농협은행주식회사 - NH e사장님 바로대출
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '농협은행주식회사', 'NH e사장님 바로대출', '스마트폰', '2025-08-18',
             NULL, 'https://www.nhbank.com', 0, 0, 5.87
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2, rate_range3, rate_range4)
VALUES
    (LAST_INSERT_ID(), '대출금리', 5.87, 5.76, 6.40, 5.88, 6.10),
    (LAST_INSERT_ID(), '기준금리', 2.53, 2.52, 2.52, 2.56, 2.56),
    (LAST_INSERT_ID(), '가산금리', 3.34, 3.24, 3.89, 3.32, 3.54);


-- --------------------------------------------------------
-- 39. 토스뱅크 주식회사 - 사장님신용대출
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '토스뱅크 주식회사', '사장님신용대출', '스마트폰', '2025-08-18',
             NULL, 'https://www.tossbank.com', 0, 0, 5.87
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2, rate_range3)
VALUES
    (LAST_INSERT_ID(), '대출금리', 5.87, 5.71, 6.43, 10.14),
    (LAST_INSERT_ID(), '기준금리', 2.51, 2.51, 2.51, 2.51),
    (LAST_INSERT_ID(), '가산금리', 3.36, 3.19, 3.92, 7.67);


-- --------------------------------------------------------
-- 40. 현대커머셜㈜ - HD현대건설기계 신차 건설기계 어태치포함형 할부
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             6, NULL, '현대커머셜㈜', 'HD현대건설기계 신차 건설기계 어태치포함형 할부', '영업점,스마트폰,모집인', '2025-08-13',
             NULL, 'https://www.hyundaicommercial.com', 0, 0, 5.40
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.88);


-- --------------------------------------------------------
-- 41. 현대커머셜㈜ - HD현대건설기계 신차 건설기계 할부
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             6, NULL, '현대커머셜㈜', 'HD현대건설기계 신차 건설기계 할부', '영업점,스마트폰,모집인', '2025-08-13',
             NULL, 'https://www.hyundaicommercial.com', 0, 0, 5.40
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.88);


-- --------------------------------------------------------
-- 42. 비엠더블유파이낸셜서비스코리아㈜ - 재고금융 B
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             7, NULL, '비엠더블유파이낸셜서비스코리아㈜', '재고금융 B', '영업점', '2025-08-12',
             NULL, 'https://www.bmwfs.co.kr', 0, 0, 5.90
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.90);


-- --------------------------------------------------------
-- 43. 하나캐피탈㈜ - 중고차론
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             7, NULL, '하나캐피탈㈜', '중고차론', '영업점,인터넷,스마트폰,모집인', '2025-08-14',
             NULL, 'https://www.hanacapital.co.kr', 0, 0, 5.30
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.90);


-- --------------------------------------------------------
-- 44. 현대커머셜㈜ - HD현대건설기계 신차 건설기계 변동금리형 할부
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             6, NULL, '현대커머셜㈜', 'HD현대건설기계 신차 건설기계 변동금리형 할부', '영업점,스마트폰,모집인', '2025-08-13',
             NULL, 'https://www.hyundaicommercial.com', 0, 0, 5.90
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.90);


-- --------------------------------------------------------
-- 45. SBI저축은행 - SBI주택대출(사업자)
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, 'SBI저축은행', 'SBI주택대출(사업자)', '영업점,인터넷,스마트폰', '2025-08-15',
             NULL, 'https://www.sbisb.co.kr', 10000000, 5000000000, 4.54
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.90);


-- --------------------------------------------------------
-- 46. 엔에이치농협캐피탈㈜ - 특장론2
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             8, NULL, '엔에이치농협캐피탈㈜', '특장론2', '영업점,스마트폰', '2025-08-12',
             NULL, 'https://www.nhcapital.co.kr', 0, 0, 5.70
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.91);


-- --------------------------------------------------------
-- 47. 엔에이치농협캐피탈㈜ - 건설기계론
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             6, NULL, '엔에이치농협캐피탈㈜', '건설기계론', '영업점,스마트폰', '2025-08-12',
             NULL, 'https://www.nhcapital.co.kr', 0, 0, 5.70
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.94);


-- --------------------------------------------------------
-- 48. 경남은행 - 가맹점우대대출
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '경남은행', '가맹점우대대출', '영업점', '2025-08-18',
             NULL, 'https://www.knbank.co.kr', 0, 0, 5.96
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2, rate_range3)
VALUES
    (LAST_INSERT_ID(), '대출금리', 5.96, 5.39, 7.00, 5.78),
    (LAST_INSERT_ID(), '기준금리', 2.54, 2.53, 2.54, 2.54),
    (LAST_INSERT_ID(), '가산금리', 3.42, 2.86, 4.46, 3.24);


-- --------------------------------------------------------
-- 49. 케이비캐피탈㈜ - 수입신차
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             7, NULL, '케이비캐피탈㈜', '수입신차', '영업점,인터넷,스마트폰,모집인', '2025-08-18',
             NULL, 'https://www.kbcapital.co.kr', 0, 0, 0.00
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range2, rate_range8)
VALUES
    (LAST_INSERT_ID(), '대출금리', 5.97, 5.75, 2.17),
    (LAST_INSERT_ID(), '기준금리', NULL, 5.75, 2.17),
    (LAST_INSERT_ID(), '가산금리', NULL, NULL, NULL);


-- --------------------------------------------------------
-- 50. 신한은행 - 신한 가맹점 사업자대출
-- --------------------------------------------------------
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             NULL, NULL, '신한은행', '신한 가맹점 사업자대출', '영업점', '2025-08-18',
             NULL, 'https://www.shinhan.com', 0, 200000000, 4.33
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range2, rate_range3, rate_range4)
VALUES
    (LAST_INSERT_ID(), '대출금리', 7.61, 6.89, 8.02, 9.88),
    (LAST_INSERT_ID(), '기준금리', 2.59, 2.51, 2.51, 4.00),
    (LAST_INSERT_ID(), '가산금리', 5.02, 4.38, 5.51, 5.88);

-- 대출 더미데이터에 해당하는 채팅방 생성
INSERT INTO chat_rooms (loan_id, room_type) VALUES
	(1, 'loan'),
	(2, 'loan'),
	(3, 'loan'),
	(4, 'loan'),
	(5, 'loan'),
	(6, 'loan'),
	(7, 'loan'),
	(8, 'loan'),
	(9, 'loan'),
	(10, 'loan'),
	(11, 'loan'),
	(12, 'loan'),
	(13, 'loan'),
	(14, 'loan'),
	(15, 'loan'),
	(16, 'loan'),
	(17, 'loan'),
	(18, 'loan'),
	(19, 'loan'),
	(20, 'loan'),
	(21, 'loan'),
	(22, 'loan'),
	(23, 'loan'),
	(24, 'loan'),
	(25, 'loan'),
	(26, 'loan'),
	(27, 'loan'),
	(28, 'loan'),
	(29, 'loan'),
	(30, 'loan'),
	(31, 'loan'),
	(32, 'loan'),
	(33, 'loan'),
	(34, 'loan'),
	(35, 'loan'),
	(36, 'loan'),
	(37, 'loan'),
	(38, 'loan'),
	(39, 'loan'),
	(40, 'loan'),
	(41, 'loan'),
	(42, 'loan'),
	(43, 'loan'),
	(44, 'loan'),
	(45, 'loan'),
	(46, 'loan'),
	(47, 'loan'),
	(48, 'loan'),
	(49, 'loan'),
	(50, 'loan'),
	(51, 'loan'),
	(52, 'loan'),
	(53, 'loan'),
	(54, 'loan'),
	(55, 'loan'),
	(56, 'loan'),
	(57, 'loan'),
	(58, 'loan'),
	(59, 'loan'),
	(60, 'loan'),
	(61, 'loan'),
	(62, 'loan'),
	(63, 'loan'),
	(64, 'loan'),
	(65, 'loan'),
	(66, 'loan'),
	(67, 'loan'),
	(68, 'loan'),
	(69, 'loan'),
	(70, 'loan'),
	(71, 'loan'),
	(72, 'loan'),
	(73, 'loan'),
	(74, 'loan'),
	(75, 'loan'),
	(76, 'loan'),
	(77, 'loan'),
	(78, 'loan'),
	(79, 'loan'),
	(80, 'loan'),
	(81, 'loan'),
	(82, 'loan'),
	(83, 'loan'),
	(84, 'loan'),
	(85, 'loan'),
	(86, 'loan'),
	(87, 'loan'),
	(88, 'loan'),
	(89, 'loan'),
	(90, 'loan'),
	(91, 'loan'),
	(92, 'loan'),
	(93, 'loan'),
	(94, 'loan'),
	(95, 'loan'),
	(96, 'loan'),
	(97, 'loan'),
	(98, 'loan'),
	(99, 'loan'),
	(100, 'loan'),
	(101, 'loan'),
	(102, 'loan'),
	(103, 'loan'),
	(104, 'loan'),
	(105, 'loan'),
	(106, 'loan');

-- 대출 상품 필요 서류 더미 데이터

-- 1. 일반 기업/소상공인 운전자금 및 신용대출 (가장 일반적인 서류 세트)
-- (사업자등록증명, 소득금액증명, 납세증명서 등)
INSERT INTO required_documents (loan_id, document_id) VALUES
                                                          (1, 5), (1, 6), (1, 2), -- 국민은행 - KB 동반성장협약 상생대출
                                                          (2, 5), (2, 6), (2, 2), -- 농협은행주식회사 - 채움 상생론
                                                          (5, 5), (5, 6), (5, 8), -- 우리은행 - 우리CUBE론-X(BIZ프라임) (재무제표 추가)
                                                          (9, 5), (9, 6), (9, 3), -- 국민은행 - KB 더드림(The Dream) 소호대출 (부가세 증명 추가)
                                                          (13, 5), (13, 6), -- 국민은행 - KB 일사천리소호대출
                                                          (16, 5), (16, 6), (16, 13), -- 농협은행주식회사 - 채움 성공비즈니스대출 (4대보험 추가)
                                                          (26, 5), (26, 6), -- 국민은행 - KB 투게더론
                                                          (28, 5), (28, 6), -- 국민은행 - KB 모아드림론
                                                          (29, 5), (29, 6), (29, 8), -- 국민은행 - 기업일반운전자금대출 (재무제표 추가)
                                                          (30, 5), (30, 6), (30, 8), (30, 12), -- 아이엠뱅크 - 기업운전자금대출 (법인 서류 추가)
                                                          (35, 5), (35, 6), -- 경남은행 - 위더스론
                                                          (36, 5), (36, 6), (36, 11), -- 국민은행 - ONE KB 기업 우대대출 (중소기업확인서 추가)
                                                          (40, 5), (40, 6), -- 신한은행 - 신한SOHO명품대출(운전자금)
                                                          (49, 5), (49, 6), (49, 8), -- 농협은행주식회사 - NH기업성장론
                                                          (57, 5), (57, 6), -- 우리은행 - 우리 프랜차이즈론
                                                          (60, 5), (60, 6), -- 국민은행 - KB메가셀러론
                                                          (67, 5), (67, 6), -- 주식회사 카카오뱅크 - 개인사업자 신용대출
                                                          (76, 5), (76, 6), -- 우리은행 - 협력기업 상생대출
                                                          (77, 5), (77, 6), (77, 13), -- 우리은행 - 파워브랜드 가맹점 창업대출
                                                          (83, 5), (83, 6), -- 우리은행 - 우리카드 가맹점 우대 대출
                                                          (87, 5), (87, 6), -- 신한은행 - 신한 가맹점 사업자대출(분할상환)
                                                          (91, 5), (91, 6), -- 토스뱅크 주식회사 - 사장님신용대출
                                                          (103, 5), (103, 6); -- 신한은행 - 신한 가맹점 사업자대출

-- 2. 부동산 담보 및 시설자금 대출 (재무 및 세금 관련 서류 강화)
-- (지방세 납세증명서, 표준재무제표증명 등)
INSERT INTO required_documents (loan_id, document_id) VALUES
                                                          (3, 1), (3, 2), (3, 5), (3, 6), -- 주식회사 케이뱅크 - 사장님 부동산담보대출
                                                          (4, 5), (4, 8), (4, 12), -- 우리은행 - 우리CUBE론-X(우리자산신탁) (법인 서류)
                                                          (8, 1), (8, 2), (8, 5), (8, 8), -- 한국스탠다드차타드은행 - 비즈니스모기지(Mortgage)
                                                          (12, 1), (12, 5), (12, 6), (12, 8), -- 신한은행 - 신한SOHO명품대출III(시설자금)
                                                          (14, 1), (14, 5), (14, 6), (14, 8), -- 신한은행 - 신한SOHO명품대출(시설자금)
                                                          (15, 5), (15, 8), (15, 12), -- 국민은행 - 기업일반시설자금대출 (법인 서류)
                                                          (17, 1), (17, 2), (17, 5), -- 아이엠뱅크 - 착한 건물주 특별대출
                                                          (23, 1), (23, 5), (23, 6), (23, 8), -- 신한은행 - 신한SOHO명품대출(분할상환)(시설자금)
                                                          (25, 5), (25, 8), (25, 12), -- 아이엠뱅크 - 기업시설자금대출 (법인 서류)
                                                          (32, 1), (32, 2), (32, 5), (32, 8), -- 국민은행 - KB 커머셜모기지론
                                                          (46, 1), (46, 5), (46, 6), -- 경남은행 - 토지분양자금대출
                                                          (64, 1), (64, 2), (64, 5), (64, 6), -- 대백저축은행 - 자영업자주택담보대출
                                                          (65, 1), (65, 2), (65, 5), (65, 6), -- 흥국화재해상보험주식회사 - 2502흥국SOHO아파트대출
                                                          (79, 1), (79, 2), (79, 5), (79, 6), -- 청주저축은행 - 중도금대출
                                                          (95, 1), (95, 2), (95, 5), (95, 6), -- SBI저축은행 - SBI주택대출(사업자)
                                                          (53, 1), (53, 5), (53, 6); -- 수협은행 - 고시원사업자대출 (시설 관련)


-- 3. 기술/특례보증/성장기업 등 정책 연관 대출 (중소기업확인서 등 추가)
INSERT INTO required_documents (loan_id, document_id) VALUES
                                                          (6, 5), (6, 6), (6, 11), -- 농협은행주식회사 - 이노메인비즈대출 (중소기업확인서)
                                                          (7, 5), (7, 8), (7, 11), (7, 12), -- 국민은행 - KB 우량산업단지기업 우대대출 (법인, 중기)
                                                          (10, 5), (10, 6), (10, 11), -- 국민은행 - KB 유망분야 성장기업 우대대출
                                                          (11, 5), (11, 6), (11, 11), -- 아이엠뱅크 - 무브온(Move-On) 특별대출
                                                          (18, 5), (18, 6), (18, 10), -- 수협은행 - Sh특별출연협약보증대출 (금융거래확인서)
                                                          (19, 5), (19, 8), (19, 11), (19, 12), -- 우리은행 - 우리CUBE론-X(일반,산업단지)
                                                          (20, 5), (20, 6), (20, 11), -- 농협은행주식회사 - 중소기업보증료지원대출
                                                          (24, 5), (24, 6), (24, 11), -- 농협은행주식회사 - NH기술평가우수기업대출
                                                          (27, 5), (27, 8), (27, 11), (27, 14), -- 경남은행 - 3D프린팅 연관기업 특례보증 대출 (기타 서류)
                                                          (34, 5), (34, 6), (34, 11), -- 경남은행 - 하이테크자금대출
                                                          (37, 5), (37, 6), (37, 11), -- 아이엠뱅크 - Tech biz(테크비즈)론
                                                          (41, 5), (41, 6), (41, 11), -- 경남은행 - 중소기업 신용보증서 우대대출
                                                          (42, 5), (42, 6), (42, 11); -- 신한은행 - 신용보증재단 특례보증대출(재창업 소상공인지원)

-- 4. 특정 업종 대상 대출 (의료, 농축산, 프랜차이즈, 자동차 등)
INSERT INTO required_documents (loan_id, document_id) VALUES
                                                          (21, 5), (21, 6), (21, 14), -- 제주은행 - 전문직우대론 (자격증 등 기타서류)
                                                          (31, 5), (31, 8), (31, 14), -- 경남은행 - 무역금융 (수출입관련 서류 등)
                                                          (33, 5), (33, 6), (33, 13), -- 신한은행 - 신한 프랜차이즈론(분할상환)(시설자금)
                                                          (38, 5), (38, 6), (38, 8), -- 광주은행 - KJB SOLAR-LOAN
                                                          (39, 5), (39, 6), (39, 14), -- 주식회사 하나은행 - 파워메디론 (의료 관련)
                                                          (43, 5), (43, 6), (43, 14), -- 신한은행 - 신한 의(醫)사랑대출(운전자금)
                                                          (45, 5), (45, 6), (45, 14), -- 주식회사 하나은행 - HANA 전문직 소호대출
                                                          (47, 5), (47, 6), (47, 14), -- 주식회사 하나은행 - 닥터클럽대출-플래티늄
                                                          (48, 5), (48, 6), (48, 14), -- 농협은행주식회사 - NH농식품기업우대론 (농업관련 서류)
                                                          (50, 5), (50, 6), (50, 14), -- 국민은행 - KB 메디칼론
                                                          (51, 5), (51, 6), (51, 8), -- 한국투자저축은행 - 수입육담보대출
                                                          (52, 5), (52, 6), (52, 14), -- 신한은행 - 신한 동물병원대출(종합통장대출)
                                                          (54, 5), (54, 6), (54, 8), -- 수협은행 - 냉동수산물담보대출
                                                          (55, 5), (55, 6), (55, 14), -- 농협은행주식회사 - NH농식품그린성장론
                                                          (56, 5), (56, 6), (56, 13), -- 수협은행 - MY편의점대출
                                                          (58, 5), (58, 6), (58, 14), -- 제주은행 - 병원약국우대대출
                                                          (66, 5), (66, 13), -- 엔에이치농협캐피탈㈜ - 사료구매자금대출
                                                          (84, 5), (84, 6), (84, 13); -- 신한은행 - 신한 프랜차이즈론(분할상환)(운전자금)

-- 5. 할부/오토론/장비/건설기계 대출 (상대적으로 간단한 서류)
INSERT INTO required_documents (loan_id, document_id) VALUES
                                                          (62, 5), (62, 6), -- 현대커머셜㈜ - 현대자동차 신차 할부
                                                          (63, 5), (63, 6), -- 수협은행 - 집단주택자금대출
                                                          (68, 5), (68, 6), -- 엔에이치농협캐피탈㈜ - 할부수입상용1
                                                          (69, 5), (69, 6), -- 현대커머셜㈜ - 현대자동차 신차 특장차 할부
                                                          (71, 5), (71, 6), -- ㈜아이엠캐피탈 - 장비대출_신차버스(일반)
                                                          (74, 5), (74, 6), -- 엔에이치농협캐피탈㈜ - 수입상용론1
                                                          (75, 5), (75, 6), -- 산은캐피탈㈜ - 신차승용 오토론
                                                          (78, 5), (78, 6), -- 엔에이치농협캐피탈㈜ - 할부수입상용2
                                                          (80, 5), (80, 6), -- 엔에이치농협캐피탈㈜ - 국내상용론2
                                                          (82, 5), (82, 6), -- 롯데캐피탈㈜ - 운영자금/오토론
                                                          (86, 5), (86, 6), -- 엔에이치농협캐피탈㈜ - 국내상용론1
                                                          (88, 5), (88, 6), -- 엔에이치농협캐피탈㈜ - 할부특장
                                                          (89, 5), (89, 6), -- ㈜아이엠캐피탈 - 장비대출_신차화물(중소형)
                                                          (90, 5), (90, 6), -- 엔에이치농협캐피탈㈜ - 할부국내상용2
                                                          (92, 5), (92, 6), -- 현대커머셜㈜ - HD현대건설기계 신차 건설기계 어태치포함형 할부
                                                          (93, 5), (93, 6), -- 현대커머셜㈜ - HD현대건설기계 신차 건설기계 할부
                                                          (94, 5), (94, 6), -- 비엠더블유파이낸셜서비스코리아㈜ - 재고금융 B
                                                          (96, 5), (96, 6), -- 현대커머셜㈜ - HD현대건설기계 신차 건설기계 변동금리형 할부
                                                          (98, 5), (98, 6), -- 엔에이치농협캐피탈㈜ - 특장론2
                                                          (99, 5), (99, 6), -- 엔에이치농협캐피탈㈜ - 건설기계론
                                                          (102, 5), (102, 6); -- 케이비캐피탈㈜ - 수입신차

-- 6. 기타 금융 상품 (어음 할인, 구매자금 등)
INSERT INTO required_documents (loan_id, document_id) VALUES
                                                          (44, 5), (44, 10), -- 우리은행 - 단기수요자금융 (금융거래확인서)
                                                          (59, 5), (59, 8), (59, 10), -- 국민은행 - 상업어음할인
                                                          (61, 5), (61, 8), (61, 10), -- 아이엠뱅크 - 상업어음할인
                                                          (70, 5), (70, 8), (70, 10), -- 농협은행주식회사 - 기업구매자금대출
                                                          (72, 5), (72, 8), (72, 10); -- 우리은행 - 세이프e-구매자금대출

-- 사업자(경상북도 경주시, 숙박 및 음식점업)
INSERT INTO business_info (user_id, region_id, industry_id, business_num, sales_scope, company_name, estb_date)
VALUES (
		   1,
		   47210,
		   9,
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
	(1, 1, 5, '사업자등록증명', '2025-05-10', 'userDocuments/1-5-사업자등록증명.pdf'),
	(2, 1, 2, '납세증명서', '2025-09-05', 'userDocuments/1-5-사업자등록증명.pdf');

-- 사용자 채팅방
-- 우리 프랜차이즈론
INSERT INTO user_chat_rooms (user_id, room_id, last_left_at)
VALUES (1, 92, '2025-09-08 10:00:00');

-- 경상북도
INSERT INTO user_chat_rooms (user_id, room_id, last_left_at)
VALUES (1, 33, '2025-09-01 10:30:00');

-- 숙박 및 음식점업
INSERT INTO user_chat_rooms (user_id, room_id, last_left_at)
VALUES (1, 9, '2025-09-05 14:30:00');

-- 나머지 더미 유저 id 2~10
INSERT INTO users (
	user_id, email, password, nickname, name, created_at, notification, is_verified,profile_image_key
) VALUES
	  (2, 'user2@example.com', 'dummy_password', '성공창업가', '김민준', NOW(), TRUE, TRUE,'userProfileImage/default.png'),
	  (3, 'user3@example.com', 'dummy_password', '대박사장님', '박서연', NOW(), TRUE, TRUE,'userProfileImage/default.png'),
	  (4, 'user4@example.com', 'dummy_password', '오늘도야근', '이도윤', NOW(), TRUE, TRUE,'userProfileImage/default.png'),
	  (5, 'user5@example.com', 'dummy_password', '돈세는날', '정하준', NOW(), TRUE, TRUE,'userProfileImage/default.png'),
	  (6, 'user6@example.com', 'dummy_password', '사업1년차', '최지호', NOW(), TRUE, TRUE,'userProfileImage/default.png'),
	  (7, 'user7@example.com', 'dummy_password', '스마트경영', '김시우', NOW(), TRUE, TRUE,'userProfileImage/default.png'),
	  (8, 'user8@example.com', 'dummy_password', '성장하는가게', '한예준', NOW(), TRUE, TRUE,'userProfileImage/default.png'),
	  (9, 'user9@example.com', 'dummy_password', '월매출천만', '강서준', NOW(), TRUE, TRUE,'userProfileImage/default.png'),
	  (10, 'user10@example.com', 'dummy_password', '폐업은안돼', '윤지환', NOW(), TRUE, TRUE,'userProfileImage/default.png');

-- 우리 프랜차이즈론 메시지
INSERT INTO chat_messages (room_id, user_id, content, created_at)
VALUES
	(92, 2, '대출 한도가 얼마나 되나요?', '2025-09-08 09:50:00'),
	(92, 3, '최대 2억까지 가능하다고 합니다.', '2025-09-08 10:05:00'),
	(92, 4, '최근 금리 변동이 있었나요?', '2025-09-08 10:15:00'),
	(92, 1, '제 가게 당근하실 분 구합니다.', '2025-09-08 18:00:00');

-- 경상북도 메시지
INSERT INTO chat_messages (room_id, user_id, content, created_at)
VALUES
	(33, 5, '경북 지역 정책 질문합니다.', '2025-09-01 10:20:00'),
	(33, 6, '궁금한 점이 있으면 물어보세요!', '2025-09-01 10:35:00');

-- 숙박 및 음식점업 메시지
INSERT INTO chat_messages (room_id, user_id, content, created_at)
VALUES
	(9, 7, '식당 창업 관련 정보 감사합니다.', '2025-09-05 14:20:00'),
	(9, 8, '대출 상품은 어떤게 있나요?', '2025-09-05 14:35:00'),
	(9, 9, '이 업종은 대출 받기 까다롭다고 하던데..', '2025-09-05 14:45:00'),
	(9, 10, '네, 서류 준비를 꼼꼼히 하셔야 해요.', '2025-09-05 14:55:00');

-- 첨부파일 더미
INSERT INTO chat_attachments (message_id, file_key, file_name, file_extension, file_size)
VALUES
	(4, 'dummy-key-1', 'image1', 'jpg', 102400),
	(4, 'dummy-key-2', 'document1', 'pdf', 204800);