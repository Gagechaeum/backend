USE gagechaeum_db;

-- 대출 상품
-- 1. 국민은행 - KB 동반성장협약 상생대출
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '국민은행', 'KB 동반성장협약 상생대출', '영업점', '2025-08-18',
             NULL, 'https://www.kbstar.com', 0, 0, 0.45
         );
INSERT INTO rates (
    loan_id, rate_type, average_rate
) VALUES (
             LAST_INSERT_ID(), '대출금리', 1.04
         );

-- 2. 농협은행주식회사 - 채움 상생론
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '농협은행주식회사', '채움 상생론', '영업점', '2025-08-18',
             NULL, 'https://www.nhbank.com', 0, 0, 5.04
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1)
VALUES
    (LAST_INSERT_ID(), '대출금리', 1.89, 1.89),
    (LAST_INSERT_ID(), '기준금리', 2.51, 2.51),
    (LAST_INSERT_ID(), '가산금리', 0.62, 0.62);

-- 3. 주식회사 케이뱅크 - 사장님 부동산담보대출
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             12, 1, '주식회사 케이뱅크', '사장님 부동산담보대출', '스마트폰', '2025-08-18',
             NULL, 'https://www.kbanknow.com', 10000000, 1000000000, 2.69
         );
INSERT INTO rates (
    loan_id, rate_type, average_rate
) VALUES (
             LAST_INSERT_ID(), '대출금리', 3.20
         );

-- 4. 우리은행 - 우리CUBE론-X(우리자산신탁)
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             11, 1, '우리은행', '우리CUBE론-X(우리자산신탁)', '영업점', '2025-08-18',
             NULL, 'https://www.wooribank.com', 1000000000, 0, 3.20
         );
INSERT INTO rates (
    loan_id, rate_type, average_rate
) VALUES (
             LAST_INSERT_ID(), '대출금리', 3.22
         );

-- 5. 우리은행 - 우리CUBE론-X(BIZ프라임)
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '우리은행', '우리CUBE론-X(BIZ프라임)', '영업점', '2025-08-18',
             NULL, 'https://www.wooribank.com', 0, 0, 3.86
         );
INSERT INTO rates (
    loan_id, rate_type, average_rate
) VALUES (
             LAST_INSERT_ID(), '대출금리', 3.30
         );

-- 6. 농협은행주식회사 - 이노메인비즈대출
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '농협은행주식회사', '이노메인비즈대출', '영업점', '2025-08-18',
             NULL, 'https://www.nhbank.com', 0, 0, 3.40
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range2)
VALUES
    (LAST_INSERT_ID(), '대출금리', 3.32, 3.32),
    (LAST_INSERT_ID(), '기준금리', 2.51, 2.51),
    (LAST_INSERT_ID(), '가산금리', 0.81, 0.81);

-- 7. 국민은행 - KB 우량산업단지기업 우대대출
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             3, 1, '국민은행', 'KB 우량산업단지기업 우대대출', '영업점', '2025-08-18',
             NULL, 'https://www.kbstar.com', 0, 0, 2.60
         );
INSERT INTO rates (
    loan_id, rate_type, average_rate
) VALUES (
             LAST_INSERT_ID(), '대출금리', 3.43
         );

-- 8. 한국스탠다드차타드은행 - 비즈니스모기지(Mortgage)
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '한국스탠다드차타드은행', '비즈니스모기지(Mortgage)', '영업점', '2025-08-18',
             NULL, 'https://www.sc.co.kr', 100000000, 6800000000, 4.25
         );
INSERT INTO rates (
    loan_id, rate_type, average_rate
) VALUES (
             LAST_INSERT_ID(), '대출금리', 3.44
         );

-- 9. 국민은행 - KB 더드림(The Dream) 소호대출
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '국민은행', 'KB 더드림(The Dream) 소호대출', '영업점', '2025-08-18',
             NULL, 'https://www.kbstar.com', 0, 1000000000, 3.57
         );
INSERT INTO rates (
    loan_id, rate_type, average_rate
) VALUES (
             LAST_INSERT_ID(), '대출금리', 3.57
         );

-- 10. 국민은행 - KB 유망분야 성장기업 우대대출
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '국민은행', 'KB 유망분야 성장기업 우대대출', '영업점', '2025-08-18',
             NULL, 'https://www.kbstar.com', 0, 0, 2.67
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2)
VALUES
    (LAST_INSERT_ID(), '대출금리', 4.24, 4.16, 5.08),
    (LAST_INSERT_ID(), '기준금리', 2.52, 2.53, 2.51),
    (LAST_INSERT_ID(), '가산금리', NULL, 1.63, 2.57);

-- 11. 아이엠뱅크 - 무브온(Move-On) 특별대출
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '아이엠뱅크', '무브온(Move-On) 특별대출', '영업점', '2025-08-18',
             NULL, 'https://www.dgb.co.kr', 0, 30000000000, 0.00
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range3)
VALUES
    (LAST_INSERT_ID(), '대출금리', 4.96, 4.92, 6.90),
    (LAST_INSERT_ID(), '기준금리', 2.52, 2.52, 2.51),
    (LAST_INSERT_ID(), '가산금리', 2.44, 2.40, 4.39);

-- 12. 신한은행 - 신한SOHO명품대출III(시설자금)
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '신한은행', '신한SOHO명품대출III(시설자금)', '영업점', '2025-08-18',
             NULL, 'https://www.shinhan.com', 300000000, 0, 3.91
         );
INSERT INTO rates (
    loan_id, rate_type, average_rate
) VALUES (
             LAST_INSERT_ID(), '대출금리', 3.62
         );

-- 13. 국민은행 - KB 일사천리소호대출
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '국민은행', 'KB 일사천리소호대출', '영업점', '2025-08-18',
             NULL, 'https://www.kbstar.com', 0, 1000000000, 2.82
         );
INSERT INTO rates (
    loan_id, rate_type, average_rate
) VALUES (
             LAST_INSERT_ID(), '대출금리', 3.65
         );

-- 14. 신한은행 - 신한SOHO명품대출(시설자금)
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '신한은행', '신한SOHO명품대출(시설자금)', '영업점', '2025-08-18',
             NULL, 'https://www.shinhan.com', 300000000, 0, 3.91
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1)
VALUES
    (LAST_INSERT_ID(), '대출금리', 3.79, 3.79),
    (LAST_INSERT_ID(), '기준금리', 2.51, 2.51),
    (LAST_INSERT_ID(), '가산금리', 1.28, 1.28);

-- 15. 국민은행 - 기업일반시설자금대출
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '국민은행', '기업일반시설자금대출', '영업점', '2025-08-18',
             NULL, 'https://www.kbstar.com', 0, 0, 2.07
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1)
VALUES
    (LAST_INSERT_ID(), '대출금리', 4.18, 4.18),
    (LAST_INSERT_ID(), '기준금리', 2.50, 2.50),
    (LAST_INSERT_ID(), '가산금리', 2.22, 1.68);

-- 16. 농협은행주식회사 - 채움 성공비즈니스대출
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '농협은행주식회사', '채움 성공비즈니스대출', '영업점', '2025-08-18',
             NULL, 'https://www.nhbank.com', 0, 0, 4.13
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2, rate_range3)
VALUES
    (LAST_INSERT_ID(), '대출금리', 3.67, 3.69, 4.33, 3.54),
    (LAST_INSERT_ID(), '기준금리', 2.55, 2.51, 2.51, 2.68),
    (LAST_INSERT_ID(), '가산금리', 1.12, 1.18, 1.82, 0.86);

-- 17. 아이엠뱅크 - 착한 건물주 특별대출
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             12, 1, '아이엠뱅크', '착한 건물주 특별대출', '영업점', '2025-08-18',
             NULL, 'https://www.dgb.co.kr', 0, 0, 3.58
         );
INSERT INTO rates (
    loan_id, rate_type, average_rate
) VALUES (
             LAST_INSERT_ID(), '대출금리', 3.67
         );

-- 18. 수협은행 - Sh특별출연협약보증대출
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '수협은행', 'Sh특별출연협약보증대출', '영업점', '2025-08-18',
             NULL, 'https://www.suhyup-bank.com', 0, 0, 3.91
         );
INSERT INTO rates (
    loan_id, rate_type, average_rate
) VALUES (
             LAST_INSERT_ID(), '대출금리', 3.72
         );

-- 19. 우리은행 - 우리CUBE론-X(일반,산업단지)
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             3, 1, '우리은행', '우리CUBE론-X(일반,산업단지)', '영업점', '2025-08-18',
             NULL, 'https://www.wooribank.com', 0, 0, 3.86
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2, rate_range3)
VALUES
    (LAST_INSERT_ID(), '대출금리', 4.13, 3.95, 4.27, 4.64),
    (LAST_INSERT_ID(), '기준금리', 2.54, 2.55, 2.52, 2.55),
    (LAST_INSERT_ID(), '가산금리', 1.59, 1.40, 1.75, 2.09);

-- 20. 농협은행주식회사 - 중소기업보증료지원대출
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '농협은행주식회사', '중소기업보증료지원대출', '영업점', '2025-08-18',
             NULL, 'https://www.nhbank.com', 0, 0, 4.13
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range4)
VALUES
    (LAST_INSERT_ID(), '대출금리', 3.78, 3.85, 3.45),
    (LAST_INSERT_ID(), '기준금리', 2.51, 2.50, 2.53),
    (LAST_INSERT_ID(), '가산금리', 1.27, 1.35, 0.92);

-- 21. 제주은행 - 전문직우대론
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             13, 1, '제주은행', '전문직우대론', '영업점', '2025-08-18',
             NULL, 'https://www.e-jejubank.com', 0, 0, 3.78
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2, rate_range7)
VALUES
    (LAST_INSERT_ID(), '대출금리', 3.78, 3.69, 4.06, 4.03),
    (LAST_INSERT_ID(), '기준금리', 2.84, 2.81, 2.82, 4.03),
    (LAST_INSERT_ID(), '가산금리', 0.93, 0.88, 1.24, 0.00);

-- 22. 농협은행주식회사 - NH기업성장론_착한임대인우대(임대사업자 전용)
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             12, 1, '농협은행주식회사', 'NH기업성장론_착한임대인우대(임대사업자 전용)', '영업점', '2025-08-18',
             NULL, 'https://www.nhbank.com', 0, 0, 4.23
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2, rate_range3, rate_range4)
VALUES
    (LAST_INSERT_ID(), '대출금리', 3.79, 3.78, 3.80, 4.11, 4.16),
    (LAST_INSERT_ID(), '기준금리', 2.59, 2.59, 2.60, 2.65, 2.71),
    (LAST_INSERT_ID(), '가산금리', 1.20, 1.19, 1.20, 1.46, 1.45);

-- 23. 신한은행 - 신한SOHO명품대출(분할상환)(시설자금)
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '신한은행', '신한SOHO명품대출(분할상환)(시설자금)', '영업점', '2025-08-18',
             NULL, 'https://www.shinhan.com', 300000000, 0, 3.91
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 3.81);

-- 24. 농협은행주식회사 - NH기술평가우수기업대출
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             13, 1, '농협은행주식회사', 'NH기술평가우수기업대출', '영업점', '2025-08-18',
             NULL, 'https://www.nhbank.com', 0, 0, 4.33
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2, rate_range3, rate_range4)
VALUES
    (LAST_INSERT_ID(), '대출금리', 3.83, 3.77, 4.14, 3.93, 3.95),
    (LAST_INSERT_ID(), '기준금리', 2.52, 2.52, 2.54, 2.51, 2.51),
    (LAST_INSERT_ID(), '가산금리', 1.31, 1.25, 1.61, 1.42, 1.44);

-- 25. 아이엠뱅크 - 기업시설자금대출
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '아이엠뱅크', '기업시설자금대출', '영업점', '2025-08-18',
             NULL, 'https://www.dgb.co.kr', 0, 0, 0.12
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1)
VALUES
    (LAST_INSERT_ID(), '대출금리', 4.81, 4.81),
    (LAST_INSERT_ID(), '기준금리', 2.51, 2.51),
    (LAST_INSERT_ID(), '가산금리', 2.30, 2.30);

-- 26. 국민은행 - KB 투게더론
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '국민은행', 'KB 투게더론', '영업점', '2025-08-18',
             NULL, 'https://www.kbstar.com', 0, 0, 2.94
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2)
VALUES
    (LAST_INSERT_ID(), '대출금리', 4.58, 4.83, 3.74),
    (LAST_INSERT_ID(), '기준금리', 2.52, 2.52, 2.53),
    (LAST_INSERT_ID(), '가산금리', NULL, 2.31, 1.21);

-- 27. 경남은행 - 3D프린팅 연관기업 특례보증 대출
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             3, 1, '경남은행', '3D프린팅 연관기업 특례보증 대출', '영업점', '2025-08-18',
             NULL, 'https://www.knbank.co.kr', 0, 200000000, 3.75
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 3.87);

-- 28. 국민은행 - KB 모아드림론
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '국민은행', 'KB 모아드림론', '영업점', '2025-08-18',
             NULL, 'https://www.kbstar.com', 0, 0, 2.83
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2)
VALUES
    (LAST_INSERT_ID(), '대출금리', 4.39, 4.40, 4.37),
    (LAST_INSERT_ID(), '기준금리', 2.52, 2.52, 2.50),
    (LAST_INSERT_ID(), '가산금리', 1.72, 1.88, 1.87);

-- 29. 국민은행 - 기업일반운전자금대출
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '국민은행', '기업일반운전자금대출', '영업점', '2025-08-18',
             NULL, 'https://www.kbstar.com', 0, 0, 2.46
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2, rate_range3, rate_range4)
VALUES
    (LAST_INSERT_ID(), '대출금리', 4.61, 4.50, 4.81, 6.41, 5.76),
    (LAST_INSERT_ID(), '기준금리', 2.52, 2.52, 2.51, 2.50, 2.50),
    (LAST_INSERT_ID(), '가산금리', 2.35, 1.98, 2.30, 3.91, 3.26);

-- 30. 아이엠뱅크 - 기업운전자금대출
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '아이엠뱅크', '기업운전자금대출', '영업점', '2025-08-18',
             NULL, 'https://www.dgb.co.kr', 0, 0, 0.00
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2, rate_range3, rate_range4, rate_range8)
VALUES
    (LAST_INSERT_ID(), '대출금리', 5.65, 5.13, 5.98, 7.37, 13.00, 13.00),
    (LAST_INSERT_ID(), '기준금리', 2.51, 2.52, 2.51, 2.51, 2.57, 2.55),
    (LAST_INSERT_ID(), '가산금리', 3.13, 2.62, 3.47, 4.86, 10.43, 10.45);

-- 31. 경남은행 - 무역금융
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             7, 1, '경남은행', '무역금융', '영업점', '2025-08-18',
             NULL, 'https://www.knbank.co.kr', 0, 0, 4.38
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1)
VALUES
    (LAST_INSERT_ID(), '대출금리', 4.86, 4.86),
    (LAST_INSERT_ID(), '기준금리', 2.55, 2.55),
    (LAST_INSERT_ID(), '가산금리', 2.31, 2.31);

-- 32. 국민은행 - KB 커머셜모기지론
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             12, 1, '국민은행', 'KB 커머셜모기지론', '영업점', '2025-08-18',
             NULL, 'https://www.kbstar.com', 0, 0, 3.23
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 3.93);

-- 33. 신한은행 - 신한 프랜차이즈론(분할상환)(시설자금)
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '신한은행', '신한 프랜차이즈론(분할상환)(시설자금)', '영업점', '2025-08-18',
             NULL, 'https://www.shinhan.com', 0, 200000000, 3.91
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 3.93);

-- 34. 경남은행 - 하이테크자금대출
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             13, 1, '경남은행', '하이테크자금대출', '영업점', '2025-08-18',
             NULL, 'https://www.knbank.co.kr', 0, 0, 3.73
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 3.94);

-- 35. 경남은행 - 위더스론
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '경남은행', '위더스론', '영업점', '2025-08-18',
             NULL, 'https://www.knbank.co.kr', 0, 3000000000, 3.43
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 3.97);

-- 36. 국민은행 - ONE KB 기업 우대대출
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '국민은행', 'ONE KB 기업 우대대출', '영업점', '2025-08-18',
             NULL, 'https://www.kbstar.com', 0, 0, 2.80
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 3.97);

-- 37. 아이엠뱅크 - Tech biz(테크비즈)론
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             13, 1, '아이엠뱅크', 'Tech biz(테크비즈)론', '영업점', '2025-08-18',
             NULL, 'https://www.dgb.co.kr', 0, 0, 0.42
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2)
VALUES
    (LAST_INSERT_ID(), '대출금리', 5.17, 5.15, 5.23),
    (LAST_INSERT_ID(), '기준금리', 2.52, 2.51, 2.56),
    (LAST_INSERT_ID(), '가산금리', 2.65, 2.64, 2.67);

-- 38. 광주은행 - KJB SOLAR-LOAN
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             4, 1, '광주은행', 'KJB SOLAR-LOAN', '영업점', '2025-08-18',
             NULL, 'https://www.kjbank.com', 0, 0, 3.67
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 3.98);

-- 39. 주식회사 하나은행 - 파워메디론
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             17, 1, '주식회사 하나은행', '파워메디론', '영업점,스마트폰', '2025-08-18',
             NULL, 'https://www.hanabank.com', 0, 0, 3.99
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2)
VALUES
    (LAST_INSERT_ID(), '대출금리', 3.99, 3.99, 4.10),
    (LAST_INSERT_ID(), '기준금리', 2.51, 2.51, 2.51),
    (LAST_INSERT_ID(), '가산금리', 1.47, 1.47, 1.59);

-- 40. 신한은행 - 신한SOHO명품대출(운전자금)
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '신한은행', '신한SOHO명품대출(운전자금)', '영업점', '2025-08-18',
             NULL, 'https://www.shinhan.com', 300000000, 0, 4.33
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 4.00);

-- 41. 경남은행 - 중소기업 신용보증서 우대대출 업무매뉴얼
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '경남은행', '중소기업 신용보증서 우대대출 업무매뉴얼', '영업점', '2025-08-18',
             NULL, 'https://www.knbank.co.kr', 0, 0, 3.28
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 4.01);

-- 42. 신한은행 - 신용보증재단 특례보증대출(재창업 소상공인지원)
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '신한은행', '신용보증재단 특례보증대출(재창업 소상공인지원)', '영업점', '2025-08-18',
             NULL, 'https://www.shinhan.com', 0, 100000000, 4.01
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 4.01);

-- 43. 신한은행 - 신한 의(醫)사랑대출(운전자금)
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             17, 1, '신한은행', '신한 의(醫)사랑대출(운전자금)', '영업점', '2025-08-18',
             NULL, 'https://www.shinhan.com', 0, 1000000000, 4.23
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2)
VALUES
    (LAST_INSERT_ID(), '대출금리', 4.15, 4.11, 4.33),
    (LAST_INSERT_ID(), '기준금리', 2.57, 2.58, 2.51),
    (LAST_INSERT_ID(), '가산금리', 1.58, 1.53, 1.82);

-- 44. 우리은행 - 단기수요자금융
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '우리은행', '단기수요자금융', '영업점,인터넷', '2025-08-18',
             NULL, 'https://www.wooribank.com', 0, 0, 3.85
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range5)
VALUES
    (LAST_INSERT_ID(), '대출금리', 4.01, 4.01),
    (LAST_INSERT_ID(), '기준금리', 2.51, 2.51),
    (LAST_INSERT_ID(), '가산금리', 1.50, 1.50);

-- 45. 주식회사 하나은행 - HANA 전문직 소호대출
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             13, 1, '주식회사 하나은행', 'HANA 전문직 소호대출', '영업점', '2025-08-18',
             NULL, 'https://www.hanabank.com', 0, 0, 4.02
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2)
VALUES
    (LAST_INSERT_ID(), '대출금리', 4.02, 4.00, 4.29),
    (LAST_INSERT_ID(), '기준금리', 2.55, 2.55, 2.51),
    (LAST_INSERT_ID(), '가산금리', 1.47, 1.45, 1.78);

-- 46. 경남은행 - 토지분양자금대출
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             12, 1, '경남은행', '토지분양자금대출', '영업점', '2025-08-18',
             NULL, 'https://www.knbank.co.kr', 0, 0, 4.53
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 4.03);

-- 47. 주식회사 하나은행 - 닥터클럽대출-플래티늄
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             17, 1, '주식회사 하나은행', '닥터클럽대출-플래티늄', '영업점', '2025-08-18',
             NULL, 'https://www.hanabank.com', 0, 0, 4.03
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2)
VALUES
    (LAST_INSERT_ID(), '대출금리', 4.03, 4.03, 4.10),
    (LAST_INSERT_ID(), '기준금리', 2.51, 2.51, 2.51),
    (LAST_INSERT_ID(), '가산금리', 1.52, 1.52, 1.59);

-- 48. 농협은행주식회사 - NH농식품기업우대론
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             1, 1, '농협은행주식회사', 'NH농식품기업우대론', '영업점', '2025-08-18',
             NULL, 'https://www.nhbank.com', 0, 0, 3.05
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2, rate_range3, rate_range4, rate_range5, rate_range6, rate_range8)
VALUES
    (LAST_INSERT_ID(), '대출금리', 4.04, 3.98, 4.16, 3.95, 4.90, 5.29, 5.25, 4.95),
    (LAST_INSERT_ID(), '기준금리', 2.52, 2.53, 2.52, 2.51, 2.52, 2.53, 2.51, 2.51),
    (LAST_INSERT_ID(), '가산금리', 1.52, 1.45, 1.64, 1.44, 2.38, 2.76, 2.74, 2.44);

-- 49. 농협은행주식회사 - NH기업성장론
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '농협은행주식회사', 'NH기업성장론', '영업점', '2025-08-18',
             NULL, 'https://www.nhbank.com', 0, 0, 4.13
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2, rate_range3, rate_range4, rate_range5, rate_range6, rate_range7, rate_range8)
VALUES
    (LAST_INSERT_ID(), '대출금리', 4.05, 3.97, 4.18, 4.37, 4.69, 4.47, 5.08, 4.88, 5.28),
    (LAST_INSERT_ID(), '기준금리', 2.55, 2.55, 2.54, 2.53, 2.53, 2.53, 2.51, 2.51, 2.57),
    (LAST_INSERT_ID(), '가산금리', 1.50, 1.42, 1.64, 1.84, 2.16, 1.94, 2.57, 2.37, 2.71);

-- 50. 국민은행 - KB 메디칼론
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             17, 1, '국민은행', 'KB 메디칼론', '영업점', '2025-08-18',
             NULL, 'https://www.kbstar.com', 0, 0, 3.53
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2, rate_range3, rate_range4)
VALUES
    (LAST_INSERT_ID(), '대출금리', 4.12, 4.06, 4.70, 4.41, 4.62),
    (LAST_INSERT_ID(), '기준금리', 2.51, 2.51, 2.50, 2.51, 2.52),
    (LAST_INSERT_ID(), '가산금리', NULL, 1.55, 2.20, 1.90, 2.10);

-- 51. 한국투자저축은행 - 수입육담보대출
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             7, 1, '한국투자저축은행', '수입육담보대출', '영업점', '2025-08-15',
             NULL, 'https://www.kisb.co.kr', 0, 0, 8.50
         );
INSERT INTO rates (loan_id, rate_type)
VALUES (LAST_INSERT_ID(), '대출금리');

-- 52. 신한은행 - 신한 동물병원대출(종합통장대출)
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             17, 1, '신한은행', '신한 동물병원대출(종합통장대출)', '영업점', '2025-08-18',
             NULL, 'https://www.shinhan.com', 0, 50000000, 4.23
         );
INSERT INTO rates (loan_id, rate_type)
VALUES (LAST_INSERT_ID(), '대출금리');

-- 53. 수협은행 - 고시원사업자대출
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             9, 1, '수협은행', '고시원사업자대출', '영업점', '2025-08-18',
             NULL, 'https://www.suhyup-bank.com', 0, 0, 4.03
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1)
VALUES
    (LAST_INSERT_ID(), '대출금리', 4.10, 4.10),
    (LAST_INSERT_ID(), '기준금리', 2.43, 2.43),
    (LAST_INSERT_ID(), '가산금리', 1.67, 1.67);

-- 54. 수협은행 - 냉동수산물담보대출
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             7, 1, '수협은행', '냉동수산물담보대출', '영업점', '2025-08-18',
             NULL, 'https://www.suhyup-bank.com', 0, 0, 5.75
         );
INSERT INTO rates (loan_id, rate_type)
VALUES (LAST_INSERT_ID(), '대출금리');

-- 55. 농협은행주식회사 - NH농식품그린성장론
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             1, 1, '농협은행주식회사', 'NH농식품그린성장론', '영업점', '2025-08-18',
             NULL, 'https://www.nhbank.com', 0, 0, 3.35
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2, rate_range3, rate_range4, rate_range5, rate_range6)
VALUES
    (LAST_INSERT_ID(), '대출금리', 4.19, 4.17, 4.19, 4.54, 4.08, 4.52, 5.64),
    (LAST_INSERT_ID(), '기준금리', 2.52, 2.52, 2.52, 2.52, 2.53, 2.53, 2.51),
    (LAST_INSERT_ID(), '가산금리', 1.67, 1.64, 1.67, 2.02, 1.55, 1.99, 3.13);

-- 56. 수협은행 - MY편의점대출
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             7, 1, '수협은행', 'MY편의점대출', '영업점', '2025-08-18',
             NULL, 'https://www.suhyup-bank.com', 0, 0, 4.03
         );
INSERT INTO rates (loan_id, rate_type)
VALUES (LAST_INSERT_ID(), '대출금리');
-- 57. 우리은행 - 우리 프랜차이즈론
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '우리은행', '우리 프랜차이즈론', '영업점', '2025-08-18',
             NULL, 'https://www.wooribank.com', 0, 200000000, 4.46
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.06);

-- 58. 제주은행 - 병원약국우대대출
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             17, 1, '제주은행', '병원약국우대대출', '영업점', '2025-08-18',
             NULL, 'https://www.e-jejubank.com', 0, 300000000, 4.66
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2)
VALUES
    (LAST_INSERT_ID(), '대출금리', 5.08, 5.03, 5.40),
    (LAST_INSERT_ID(), '기준금리', 2.75, 2.74, 2.89),
    (LAST_INSERT_ID(), '가산금리', 2.31, 2.29, 2.51);

-- 59. 국민은행 - 상업어음할인
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             11, 1, '국민은행', '상업어음할인', '영업점', '2025-08-18',
             NULL, 'https://www.kbstar.com', 0, 0, 4.53
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range2)
VALUES
    (LAST_INSERT_ID(), '대출금리', 4.66, 4.66),
    (LAST_INSERT_ID(), '기준금리', 2.51, 2.51),
    (LAST_INSERT_ID(), '가산금리', NULL, 2.15);

-- 60. 국민은행 - KB메가셀러론
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             7, 1, '국민은행', 'KB메가셀러론', '영업점', '2025-08-18',
             NULL, 'https://www.kbstar.com', 0, 0, 3.98
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2, rate_range3, rate_range4)
VALUES
    (LAST_INSERT_ID(), '대출금리', 5.15, 5.00, 5.20, 5.58, 5.66),
    (LAST_INSERT_ID(), '기준금리', 2.52, 2.52, 2.53, 2.51, 2.52),
    (LAST_INSERT_ID(), '가산금리', 2.63, 2.48, 2.67, 3.07, 3.14);

-- 61. 신한은행 - TOPS전문직우대론(종합통장대출)
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             13, 1, '신한은행', 'TOPS전문직우대론(종합통장대출)', '영업점', '2025-08-18',
             NULL, 'https://www.shinhan.com', 0, 300000000, 4.23
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range4)
VALUES
    (LAST_INSERT_ID(), '대출금리', 5.24, 5.36, 4.59),
    (LAST_INSERT_ID(), '기준금리', 2.54, 2.55, 2.51),
    (LAST_INSERT_ID(), '가산금리', 2.70, 2.81, 2.08);

-- 62. 아이엠뱅크 - 상업어음할인
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             11, 1, '아이엠뱅크', '상업어음할인', '영업점', '2025-08-18',
             NULL, 'https://www.dgb.co.kr', 0, 0, 4.76
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2)
VALUES
    (LAST_INSERT_ID(), '대출금리', 5.23, 4.95, 5.71),
    (LAST_INSERT_ID(), '기준금리', 2.52, 2.53, 2.50),
    (LAST_INSERT_ID(), '가산금리', 2.71, 2.42, 3.21);

-- 63. 현대커머셜㈜ - 현대자동차 신차 할부
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             7, 1, '현대커머셜㈜', '현대자동차 신차 할부', '영업점,스마트폰,모집인', '2025-08-13',
             NULL, 'https://www.hyundaicommercial.com', 0, 0, 4.90
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.32);

-- 64. 수협은행 - 집단주택자금대출
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             6, 1, '수협은행', '집단주택자금대출', '영업점', '2025-08-18',
             NULL, 'https://www.suhyup-bank.com', 0, 0, 5.06
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.38);

-- 65. 하나캐피탈㈜ - 정상오토론
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             7, 1, '하나캐피탈㈜', '정상오토론', '모집인', '2025-08-13',
             NULL, 'https://www.hanacapital.co.kr', 0, 0, 4.90
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.38);

-- 66. 아이엠뱅크 - 기업통장대출
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '아이엠뱅크', '기업통장대출', '영업점', '2025-08-18',
             NULL, 'https://www.dgb.co.kr', 0, 0, 3.73
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2, rate_range3, rate_range4, rate_range6)
VALUES
    (LAST_INSERT_ID(), '대출금리', 6.66, 6.19, 7.76, 11.93, 12.99, 13.00),
    (LAST_INSERT_ID(), '기준금리', 2.51, 2.51, 2.51, 2.51, 2.51, 2.52),
    (LAST_INSERT_ID(), '가산금리', 4.15, 3.67, 5.25, 9.42, 10.48, 10.48);

-- 67. 주식회사 카카오뱅크 - 개인사업자 신용대출
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '주식회사 카카오뱅크', '개인사업자 신용대출', '스마트폰', '2025-08-18',
             NULL, 'https://www.kakaobank.com', 0, 0, 5.41
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2, rate_range3, rate_range6)
VALUES
    (LAST_INSERT_ID(), '대출금리', 5.44, 5.24, 6.27, 6.61, 5.15),
    (LAST_INSERT_ID(), '기준금리', 2.52, 2.52, 2.52, 2.52, 2.51),
    (LAST_INSERT_ID(), '가산금리', 2.89, 2.72, 3.75, 4.09, 2.64);

-- 68. 엔에이치농협캐피탈㈜ - 할부수입상용1
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             8, 1, '엔에이치농협캐피탈㈜', '할부수입상용1', '영업점,스마트폰', '2025-08-12',
             NULL, 'https://www.nhcapital.co.kr', 0, 0, 5.60
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.47);

-- 69. 현대커머셜㈜ - 현대자동차 신차 특장차 할부
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             8, 1, '현대커머셜㈜', '현대자동차 신차 특장차 할부', '영업점,스마트폰,모집인', '2025-08-13',
             NULL, 'https://www.hyundaicommercial.com', 0, 0, 4.90
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.47);

-- 70. 대백저축은행 - 자영업자주택담보대출
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '대백저축은행', '자영업자주택담보대출', '영업점', '2025-08-15',
             NULL, 'https://www.daebaekbank.co.kr', 0, 0, 5.00
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.50);

-- 71. 흥국화재해상보험주식회사 - 2502흥국SOHO아파트대출
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '흥국화재해상보험주식회사', '2502흥국SOHO아파트대출', '모집인', '2025-08-14',
             NULL, 'https://www.heungkukfire.co.kr', 0, 3000000000, 5.06
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.50);

-- 72. 농협은행주식회사 - 기업구매자금대출
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '농협은행주식회사', '기업구매자금대출', '영업점', '2025-08-18',
             NULL, 'https://www.nhbank.com', 0, 0, 4.20
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range2)
VALUES
    (LAST_INSERT_ID(), '대출금리', 4.99, 4.99),
    (LAST_INSERT_ID(), '기준금리', 2.53, 2.53),
    (LAST_INSERT_ID(), '가산금리', 2.46, 2.46);

-- 73. 엔에이치농협캐피탈㈜ - 사료구매자금대출
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             1, 1, '엔에이치농협캐피탈㈜', '사료구매자금대출', '영업점', '2025-08-13',
             NULL, 'https://www.nhcapital.co.kr', 0, 5000000000, 5.53
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.53);

-- 74. ㈜아이엠캐피탈 - 장비대출_신차버스(일반)
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             8, 1, '㈜아이엠캐피탈', '장비대출_신차버스(일반)', '모집인', '2025-08-14',
             NULL, 'https://www.imcapital.co.kr', 0, 0, 5.40
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range8)
VALUES
    (LAST_INSERT_ID(), '대출금리', 7.48, 7.48),
    (LAST_INSERT_ID(), '기준금리', NULL, NULL),
    (LAST_INSERT_ID(), '가산금리', NULL, NULL);

-- 75. 우리은행 - 세이프e-구매자금대출
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '우리은행', '세이프e-구매자금대출', '영업점', '2025-08-18',
             NULL, 'https://www.wooribank.com', 0, 0, 3.99
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range4)
VALUES
    (LAST_INSERT_ID(), '대출금리', 5.54, 5.54),
    (LAST_INSERT_ID(), '기준금리', 2.51, 2.51),
    (LAST_INSERT_ID(), '가산금리', 3.03, 3.03);

-- 76. 신한은행 - 신한 프랜차이즈론(운전자금)
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '신한은행', '신한 프랜차이즈론(운전자금)', '영업점', '2025-08-18',
             NULL, 'https://www.shinhan.com', 0, 200000000, 4.33
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range2, rate_range4)
VALUES
    (LAST_INSERT_ID(), '대출금리', 6.89, 6.91, 6.77),
    (LAST_INSERT_ID(), '기준금리', 2.52, 2.51, 2.57),
    (LAST_INSERT_ID(), '가산금리', 4.37, 4.40, 4.20);

-- 77. 엔에이치농협캐피탈㈜ - 수입상용론1
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             8, 1, '엔에이치농협캐피탈㈜', '수입상용론1', '영업점,스마트폰', '2025-08-12',
             NULL, 'https://www.nhcapital.co.kr', 0, 0, 5.60
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.58);

-- 78. 산은캐피탈㈜ - 신차승용 오토론
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             7, 1, '산은캐피탈㈜', '신차승용 오토론', '모집인', '2025-08-13',
             NULL, 'https://www.kdbcapital.co.kr', 0, 0, 5.60
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.60);

-- 79. 우리은행 - 협력기업 상생대출
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '우리은행', '협력기업 상생대출', '영업점', '2025-08-18',
             NULL, 'https://www.wooribank.com', 0, 0, 3.46
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2)
VALUES
    (LAST_INSERT_ID(), '대출금리', 5.60, 5.35, 6.31),
    (LAST_INSERT_ID(), '기준금리', 2.52, 2.52, 2.52),
    (LAST_INSERT_ID(), '가산금리', 3.08, 2.83, 3.79);

-- 80. 우리은행 - 파워브랜드 가맹점 창업대출
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '우리은행', '파워브랜드 가맹점 창업대출', '영업점', '2025-08-18',
             NULL, 'https://www.wooribank.com', 0, 100000000, 4.46
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2)
VALUES
    (LAST_INSERT_ID(), '대출금리', 5.66, 5.66, 5.66),
    (LAST_INSERT_ID(), '기준금리', 2.51, 2.51, 2.51),
    (LAST_INSERT_ID(), '가산금리', 3.15, 3.15, 3.15);

-- 81. 엔에이치농협캐피탈㈜ - 할부수입상용2
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             8, 1, '엔에이치농협캐피탈㈜', '할부수입상용2', '영업점,스마트폰', '2025-08-12',
             NULL, 'https://www.nhcapital.co.kr', 0, 0, 5.60
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.67);

-- 82. 현대커머셜㈜ - 부동산PF
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             12, 1, '현대커머셜㈜', '부동산PF', '기타', '2025-08-13',
             NULL, 'https://www.hyundaicommercial.com', 0, 0, 3.00
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.68);

-- 83. 엔에이치농협캐피탈㈜ - 수입상용론2
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             8, 1, '엔에이치농협캐피탈㈜', '수입상용론2', '영업점,스마트폰', '2025-08-12',
             NULL, 'https://www.nhcapital.co.kr', 0, 0, 5.60
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.70);

-- 84. 청주저축은행 - 중도금대출
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '청주저축은행', '중도금대출', '영업점', '2025-08-15',
             NULL, 'https://www.chjsb.co.kr', 0, 0, 4.50
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.70);

-- 85. 엔에이치농협캐피탈㈜ - 국내상용론2
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             8, 1, '엔에이치농협캐피탈㈜', '국내상용론2', '영업점,스마트폰', '2025-08-12',
             NULL, 'https://www.nhcapital.co.kr', 0, 0, 5.60
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.74);

-- 86. 우리은행 - 우리카드 가맹점 우대 대출
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '우리은행', '우리카드 가맹점 우대 대출', '스마트폰', '2025-08-18',
             NULL, 'https://www.wooribank.com', 0, 0, 5.77
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2, rate_range3)
VALUES
    (LAST_INSERT_ID(), '대출금리', 5.77, 5.77, 5.72, 6.12),
    (LAST_INSERT_ID(), '기준금리', 2.52, 2.52, 2.52, 2.53),
    (LAST_INSERT_ID(), '가산금리', 3.25, 3.25, 3.20, 3.59);

-- 87. 롯데캐피탈㈜ - 운영자금/오토론
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             7, 1, '롯데캐피탈㈜', '운영자금/오토론', '기타', '2025-08-14',
             NULL, 'https://www.lottecap.com', 0, 0, 5.80
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1)
VALUES
    (LAST_INSERT_ID(), '대출금리', 5.80, 5.80),
    (LAST_INSERT_ID(), '기준금리', NULL, NULL),
    (LAST_INSERT_ID(), '가산금리', NULL, NULL);

-- 88. 신한은행 - 신한 프랜차이즈론(분할상환)(운전자금)
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '신한은행', '신한 프랜차이즈론(분할상환)(운전자금)', '영업점', '2025-08-18',
             NULL, 'https://www.shinhan.com', 0, 200000000, 4.33
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2, rate_range3)
VALUES
    (LAST_INSERT_ID(), '대출금리', 5.80, 6.69, 4.97, 6.72),
    (LAST_INSERT_ID(), '기준금리', 2.52, 2.51, 2.52, 2.52),
    (LAST_INSERT_ID(), '가산금리', 3.28, 4.18, 2.45, 4.20);

-- 89. 엔에이치농협캐피탈㈜ - 국내상용론1
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             8, 1, '엔에이치농협캐피탈㈜', '국내상용론1', '영업점,스마트폰', '2025-08-12',
             NULL, 'https://www.nhcapital.co.kr', 0, 0, 5.60
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.80);

-- 90. 신한은행 - 신한 가맹점 사업자대출(분할상환)
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '신한은행', '신한 가맹점 사업자대출(분할상환)', '영업점', '2025-08-18',
             NULL, 'https://www.shinhan.com', 0, 200000000, 4.33
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2)
VALUES
    (LAST_INSERT_ID(), '대출금리', 5.81, 6.20, 5.42),
    (LAST_INSERT_ID(), '기준금리', 2.50, 2.50, 2.51),
    (LAST_INSERT_ID(), '가산금리', 3.31, 3.70, 2.91);

-- 91. 엔에이치농협캐피탈㈜ - 할부특장
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             8, 1, '엔에이치농협캐피탈㈜', '할부특장', '영업점,스마트폰', '2025-08-12',
             NULL, 'https://www.nhcapital.co.kr', 0, 0, 5.70
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.83);

-- 92. ㈜아이엠캐피탈 - 장비대출_신차화물(중소형)
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             8, 1, '㈜아이엠캐피탈', '장비대출_신차화물(중소형)', '모집인', '2025-08-14',
             NULL, 'https://www.imcapital.co.kr', 0, 0, 5.10
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.85);

-- 93. 엔에이치농협캐피탈㈜ - 할부국내상용2
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             8, 1, '엔에이치농협캐피탈㈜', '할부국내상용2', '영업점,스마트폰', '2025-08-12',
             NULL, 'https://www.nhcapital.co.kr', 0, 0, 5.60
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.86);

-- 94. 농협은행주식회사 - NH e사장님 바로대출
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '농협은행주식회사', 'NH e사장님 바로대출', '스마트폰', '2025-08-18',
             NULL, 'https://www.nhbank.com', 0, 0, 5.87
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2, rate_range3, rate_range4)
VALUES
    (LAST_INSERT_ID(), '대출금리', 5.87, 5.76, 6.40, 5.88, 6.10),
    (LAST_INSERT_ID(), '기준금리', 2.53, 2.52, 2.52, 2.56, 2.56),
    (LAST_INSERT_ID(), '가산금리', 3.34, 3.24, 3.89, 3.32, 3.54);

-- 95. 토스뱅크 주식회사 - 사장님신용대출
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '토스뱅크 주식회사', '사장님신용대출', '스마트폰', '2025-08-18',
             NULL, 'https://www.tossbank.com', 0, 0, 5.87
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2, rate_range3)
VALUES
    (LAST_INSERT_ID(), '대출금리', 5.87, 5.71, 6.43, 10.14),
    (LAST_INSERT_ID(), '기준금리', 2.51, 2.51, 2.51, 2.51),
    (LAST_INSERT_ID(), '가산금리', 3.36, 3.19, 3.92, 7.67);

-- 96. 현대커머셜㈜ - HD현대건설기계 신차 건설기계 어태치포함형 할부
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             6, 1, '현대커머셜㈜', 'HD현대건설기계 신차 건설기계 어태치포함형 할부', '영업점,스마트폰,모집인', '2025-08-13',
             NULL, 'https://www.hyundaicommercial.com', 0, 0, 5.40
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.88);

-- 97. 현대커머셜㈜ - HD현대건설기계 신차 건설기계 할부
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             6, 1, '현대커머셜㈜', 'HD현대건설기계 신차 건설기계 할부', '영업점,스마트폰,모집인', '2025-08-13',
             NULL, 'https://www.hyundaicommercial.com', 0, 0, 5.40
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.88);

-- 98. 비엠더블유파이낸셜서비스코리아㈜ - 재고금융 B
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             7, 1, '비엠더블유파이낸셜서비스코리아㈜', '재고금융 B', '영업점', '2025-08-12',
             NULL, 'https://www.bmwfs.co.kr', 0, 0, 5.90
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.90);

-- 99. 하나캐피탈㈜ - 중고차론
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             7, 1, '하나캐피탈㈜', '중고차론', '영업점,인터넷,스마트폰,모집인', '2025-08-14',
             NULL, 'https://www.hanacapital.co.kr', 0, 0, 5.30
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.90);

-- 100. 현대커머셜㈜ - HD현대건설기계 신차 건설기계 변동금리형 할부
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             6, 1, '현대커머셜㈜', 'HD현대건설기계 신차 건설기계 변동금리형 할부', '영업점,스마트폰,모집인', '2025-08-13',
             NULL, 'https://www.hyundaicommercial.com', 0, 0, 5.90
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.90);

-- 101. SBI저축은행 - SBI주택대출(사업자)
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, 'SBI저축은행', 'SBI주택대출(사업자)', '영업점,인터넷,스마트폰', '2025-08-15',
             NULL, 'https://www.sbisb.co.kr', 10000000, 5000000000, 4.54
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.90);

-- 102. 엔에이치농협캐피탈㈜ - 특장론2
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             8, 1, '엔에이치농협캐피탈㈜', '특장론2', '영업점,스마트폰', '2025-08-12',
             NULL, 'https://www.nhcapital.co.kr', 0, 0, 5.70
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.91);

-- 103. 엔에이치농협캐피탈㈜ - 건설기계론
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             6, 1, '엔에이치농협캐피탈㈜', '건설기계론', '영업점,스마트폰', '2025-08-12',
             NULL, 'https://www.nhcapital.co.kr', 0, 0, 5.70
         );
INSERT INTO rates (loan_id, rate_type, average_rate)
VALUES (LAST_INSERT_ID(), '대출금리', 5.94);

-- 104. 경남은행 - 가맹점우대대출
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '경남은행', '가맹점우대대출', '영업점', '2025-08-18',
             NULL, 'https://www.knbank.co.kr', 0, 0, 5.96
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range1, rate_range2, rate_range3)
VALUES
    (LAST_INSERT_ID(), '대출금리', 5.96, 5.39, 7.00, 5.78),
    (LAST_INSERT_ID(), '기준금리', 2.54, 2.53, 2.54, 2.54),
    (LAST_INSERT_ID(), '가산금리', 3.42, 2.86, 4.46, 3.24);

-- 105. 케이비캐피탈㈜ - 수입신차
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             7, 1, '케이비캐피탈㈜', '수입신차', '영업점,인터넷,스마트폰,모집인', '2025-08-18',
             NULL, 'https://www.kbcapital.co.kr', 0, 0, 0.00
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range2, rate_range8)
VALUES
    (LAST_INSERT_ID(), '대출금리', 5.97, 5.75, 2.17),
    (LAST_INSERT_ID(), '기준금리', NULL, 5.75, 2.17),
    (LAST_INSERT_ID(), '가산금리', NULL, NULL, NULL);

-- 106. 신한은행 - 신한 가맹점 사업자대출
INSERT INTO loans (
    industry_id, region_id, company_name, product_name, join_way, begin_date,
    end_date, product_page_url, min_limit, max_limit, basic_rate
) VALUES (
             20, 1, '신한은행', '신한 가맹점 사업자대출', '영업점', '2025-08-18',
             NULL, 'https://www.shinhan.com', 0, 200000000, 4.33
         );
INSERT INTO rates (loan_id, rate_type, average_rate, rate_range2, rate_range3, rate_range4)
VALUES
    (LAST_INSERT_ID(), '대출금리', 7.61, 6.89, 8.02, 9.88),
    (LAST_INSERT_ID(), '기준금리', 2.59, 2.51, 2.51, 4.00),
    (LAST_INSERT_ID(), '가산금리', 5.02, 4.38, 5.51, 5.88);


-- 대출 더미데이터에 해당하는 채팅방 생성
INSERT INTO chat_rooms (loan_id, room_type) VALUES
	(1, 'loan'), (2, 'loan'), (3, 'loan'), (4, 'loan'), (5, 'loan'), (6, 'loan'), (7, 'loan'), (8, 'loan'), (9, 'loan'), (10, 'loan'), (11, 'loan'), (12, 'loan'), (13, 'loan'), (14, 'loan'), (15, 'loan'), (16, 'loan'), (17, 'loan'), (18, 'loan'), (19, 'loan'), (20, 'loan'), (21, 'loan'), (22, 'loan'), (23, 'loan'), (24, 'loan'), (25, 'loan'), (26, 'loan'), (27, 'loan'), (28, 'loan'), (29, 'loan'), (30, 'loan'), (31, 'loan'), (32, 'loan'), (33, 'loan'), (34, 'loan'), (35, 'loan'), (36, 'loan'), (37, 'loan'), (38, 'loan'), (39, 'loan'), (40, 'loan'), (41, 'loan'), (42, 'loan'), (43, 'loan'), (44, 'loan'), (45, 'loan'), (46, 'loan'), (47, 'loan'), (48, 'loan'), (49, 'loan'), (50, 'loan'), (51, 'loan'), (52, 'loan'), (53, 'loan'), (54, 'loan'), (55, 'loan'), (56, 'loan'), (57, 'loan'), (58, 'loan'), (59, 'loan'), (60, 'loan'), (61, 'loan'), (62, 'loan'), (63, 'loan'), (64, 'loan'), (65, 'loan'), (66, 'loan'), (67, 'loan'), (68, 'loan'), (69, 'loan'), (70, 'loan'), (71, 'loan'), (72, 'loan'), (73, 'loan'), (74, 'loan'), (75, 'loan'), (76, 'loan'), (77, 'loan'), (78, 'loan'), (79, 'loan'), (80, 'loan'), (81, 'loan'), (82, 'loan'), (83, 'loan'), (84, 'loan'), (85, 'loan'), (86, 'loan'), (87, 'loan'), (88, 'loan'), (89, 'loan'), (90, 'loan'), (91, 'loan'), (92, 'loan'), (93, 'loan'), (94, 'loan'), (95, 'loan'), (96, 'loan'), (97, 'loan'), (98, 'loan'), (99, 'loan'), (100, 'loan'), (101, 'loan'), (102, 'loan'), (103, 'loan'), (104, 'loan'), (105, 'loan'), (106, 'loan');

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
INSERT INTO business_info (user_id, region_id, industry_id, business_num, estb_date)
VALUES (
		   1,
		   47210,
		   9,
		   '596-18-01709',
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
INSERT INTO chat_attachments (message_id, file_key, file_name)
VALUES
	(4, 'dummy-key-1', 'image1'),
	(4, 'dummy-key-2', 'document1');

-- ------------ loan/policy_bookmark_count 더미 데이터 ------------

-- 정책 상품별 업종별 북마크 수 더미 데이터
INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('451000000125', 1, 150), ('451000000125', 3, 45), ('451000000125', 7, 82), ('451000000125', 9, 33), ('451000000125', 10, 58);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('482000000135', 1, 180), ('482000000135', 2, 25), ('482000000135', 5, 68), ('482000000135', 11, 42), ('482000000135', 15, 55);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('493000000109', 1, 130), ('493000000109', 4, 38), ('493000000109', 8, 71), ('493000000109', 12, 49), ('493000000109', 16, 63);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('516000000124', 1, 160), ('516000000124', 6, 52), ('516000000124', 10, 88), ('516000000124', 14, 31), ('516000000124', 18, 76);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('559000000127', 1, 145), ('559000000127', 5, 49), ('559000000127', 9, 92), ('559000000127', 13, 28), ('559000000127', 17, 67);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('642000000679', 1, 170), ('642000000679', 7, 61), ('642000000679', 11, 85), ('642000000679', 15, 40), ('642000000679', 19, 79);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('B55307700040', 1, 190), ('B55307700040', 8, 73), ('B55307700040', 12, 54), ('B55307700040', 16, 37), ('B55307700040', 20, 95);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('SD0000007975', 1, 120), ('SD0000007975', 2, 33), ('SD0000007975', 6, 78), ('SD0000007975', 10, 51), ('SD0000007975', 14, 69);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('643000000144', 2, 140), ('643000000144', 1, 48), ('643000000144', 3, 62), ('643000000144', 5, 29), ('643000000144', 7, 57);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('142000000072', 3, 180), ('142000000072', 1, 55), ('142000000072', 7, 91), ('142000000072', 10, 68), ('142000000072', 13, 74);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('508000000690', 3, 165), ('508000000690', 2, 41), ('508000000690', 8, 83), ('508000000690', 12, 58), ('508000000690', 15, 70);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('B41000200004', 4, 155), ('B41000200004', 1, 39), ('B41000200004', 5, 72), ('B41000200004', 9, 47), ('B41000200004', 13, 65);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('B41000200005', 4, 175), ('B41000200005', 2, 48), ('B41000200005', 6, 80), ('B41000200005', 10, 55), ('B41000200005', 14, 73);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('B41000200007', 4, 140), ('B41000200007', 3, 36), ('B41000200007', 7, 85), ('B41000200007', 11, 50), ('B41000200007', 15, 68);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('B41000200008', 4, 190), ('B41000200008', 1, 60), ('B41000200008', 8, 93), ('B41000200008', 12, 44), ('B41000200008', 16, 78);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('B41000200009', 4, 135), ('B41000200009', 2, 29), ('B41000200009', 9, 76), ('B41000200009', 13, 53), ('B41000200009', 17, 66);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('B41000200012', 4, 160), ('B41000200012', 3, 42), ('B41000200012', 10, 82), ('B41000200012', 14, 34), ('B41000200012', 18, 71);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('B41000200013', 4, 150), ('B41000200013', 1, 31), ('B41000200013', 11, 89), ('B41000200013', 15, 57), ('B41000200013', 19, 75);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('B41000200020', 4, 180), ('B41000200020', 2, 53), ('B41000200020', 12, 91), ('B41000200020', 16, 39), ('B41000200020', 20, 98);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('B41000200021', 4, 125), ('B41000200021', 3, 28), ('B41000200021', 13, 74), ('B41000200021', 17, 61), ('B41000200021', 1, 46);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('B41000200038', 4, 195), ('B41000200038', 5, 63), ('B41000200038', 14, 81), ('B41000200038', 18, 43), ('B41000200038', 2, 59);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('142000000045', 5, 148), ('142000000045', 1, 41), ('142000000045', 6, 79), ('142000000045', 10, 56), ('142000000045', 14, 70);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('345000000109', 5, 162), ('345000000109', 2, 34), ('345000000109', 7, 84), ('345000000109', 11, 48), ('345000000109', 15, 64);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('427000000239', 5, 138), ('427000000239', 3, 30), ('427000000239', 8, 77), ('427000000239', 12, 52), ('427000000239', 16, 69);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('439000000849', 5, 188), ('439000000849', 4, 58), ('439000000849', 9, 94), ('439000000849', 13, 32), ('439000000849', 17, 72);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('443000000662', 5, 128), ('443000000662', 1, 27), ('443000000662', 10, 75), ('443000000662', 14, 54), ('443000000662', 18, 68);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('493000000131', 5, 172), ('493000000131', 2, 45), ('493000000131', 11, 87), ('493000000131', 15, 36), ('493000000131', 19, 77);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('547000000152', 5, 158), ('547000000152', 3, 37), ('547000000152', 12, 81), ('547000000152', 16, 59), ('547000000152', 20, 93);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('547000000153', 5, 182), ('547000000153', 4, 51), ('547000000153', 13, 90), ('547000000153', 17, 33), ('547000000153', 1, 61);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('631000000138', 5, 132), ('631000000138', 1, 25), ('631000000138', 14, 73), ('631000000138', 18, 56), ('631000000138', 2, 49);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('641000000185', 5, 192), ('641000000185', 2, 57), ('641000000185', 15, 86), ('641000000185', 19, 41), ('641000000185', 3, 66);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('648000001090', 5, 142), ('648000001090', 3, 32), ('648000001090', 16, 78), ('648000001090', 20, 60), ('648000001090', 4, 50);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('654000000010', 5, 178), ('654000000010', 4, 47), ('654000000010', 17, 83), ('654000000010', 1, 35), ('654000000010', 6, 62);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('O00089100003', 5, 122), ('O00089100003', 6, 26), ('O00089100003', 18, 71), ('O00089100003', 2, 53), ('O00089100003', 7, 48);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('O00089100006', 5, 198), ('O00089100006', 7, 65), ('O00089100006', 19, 88), ('O00089100006', 3, 40), ('O00089100006', 8, 64);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('174100000071', 6, 152), ('174100000071', 1, 43), ('174100000071', 7, 80), ('174100000071', 11, 58), ('174100000071', 15, 71);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('427000000235', 9, 168), ('427000000235', 2, 38), ('427000000235', 8, 86), ('427000000235', 12, 51), ('427000000235', 16, 67);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('478000000108', 9, 142), ('478000000108', 3, 31), ('478000000108', 9, 79), ('478000000108', 13, 55), ('478000000108', 17, 69);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('493000000111', 9, 182), ('493000000111', 4, 56), ('493000000111', 10, 92), ('493000000111', 14, 33), ('493000000111', 18, 74);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('494000000189', 9, 132), ('494000000189', 1, 29), ('494000000189', 11, 78), ('494000000189', 15, 57), ('494000000189', 19, 72);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('647000000165', 9, 172), ('647000000165', 2, 47), ('647000000165', 12, 89), ('647000000165', 16, 38), ('647000000165', 20, 96);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('SD0000003276', 9, 152), ('SD0000003276', 3, 39), ('SD0000003276', 13, 83), ('SD0000003276', 17, 62), ('SD0000003276', 1, 49);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('502000000237', 10, 185), ('502000000237', 4, 54), ('502000000237', 14, 84), ('502000000237', 18, 45), ('502000000237', 2, 60);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('O00046700025', 10, 135), ('O00046700025', 1, 28), ('O00046700025', 15, 76), ('O00046700025', 19, 59), ('O00046700025', 3, 51);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('O00089100002', 10, 195), ('O00089100002', 2, 61), ('O00089100002', 16, 90), ('O00089100002', 20, 42), ('O00089100002', 4, 67);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('O00108000004', 10, 145), ('O00108000004', 3, 35), ('O00108000004', 17, 80), ('O00108000004', 1, 63), ('O00108000004', 5, 52);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('142000000088', 11, 175), ('142000000088', 4, 50), ('142000000088', 18, 82), ('142000000088', 2, 37), ('142000000088', 6, 65);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('142100000050', 11, 125), ('142100000050', 5, 24), ('142100000050', 19, 70), ('142100000050', 3, 54), ('142100000050', 7, 47);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('149200005008', 11, 185), ('149200005008', 6, 59), ('149200005008', 20, 94), ('149200005008', 4, 43), ('149200005008', 8, 68);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('358000000125', 11, 155), ('358000000125', 7, 33), ('358000000125', 1, 79), ('358000000125', 5, 61), ('358000000125', 9, 53);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('496000000109', 11, 165), ('496000000109', 8, 46), ('496000000109', 2, 81), ('496000000109', 6, 30), ('496000000109', 10, 71);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('497000000128', 11, 135), ('497000000128', 9, 23), ('497000000128', 3, 72), ('497000000128', 7, 58), ('497000000128', 11, 50);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('510000000132', 11, 175), ('510000000132', 10, 55), ('510000000132', 4, 88), ('510000000132', 8, 36), ('510000000132', 12, 74);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('629000000193', 11, 145), ('629000000193', 1, 38), ('629000000193', 5, 75), ('629000000193', 9, 60), ('629000000193', 13, 49);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('645000000124', 11, 185), ('645000000124', 2, 52), ('645000000124', 6, 91), ('645000000124', 10, 41), ('645000000124', 14, 78);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('650000000330', 11, 195), ('650000000330', 4, 62), ('650000000330', 8, 95), ('650000000330', 12, 39), ('650000000330', 16, 80);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('B49000100216', 11, 165), ('B49000100216', 5, 40), ('B49000100216', 9, 84), ('B49000100216', 13, 64), ('B49000100216', 17, 54);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('O00082800005', 11, 135), ('O00082800005', 6, 22), ('O00082800005', 10, 67), ('O00082800005', 14, 51), ('O00082800005', 18, 73);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('493000000273', 12, 155), ('493000000273', 1, 44), ('493000000273', 7, 83), ('493000000273', 11, 60), ('493000000273', 15, 75);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('497000000137', 13, 170), ('497000000137', 2, 42), ('497000000137', 8, 89), ('497000000137', 12, 57), ('497000000137', 16, 72);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('SD0000007429', 15, 160), ('SD0000007429', 3, 36), ('SD0000007429', 9, 81), ('SD0000007429', 13, 59), ('SD0000007429', 17, 68);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('142100000058', 16, 180), ('142100000058', 4, 53), ('142100000058', 10, 93), ('142100000058', 14, 35), ('142100000058', 18, 77);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('B49000100207', 16, 130), ('B49000100207', 1, 29), ('B49000100207', 11, 77), ('B49000100207', 15, 58), ('B49000100207', 19, 74);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('650000000312', 17, 190), ('650000000312', 2, 50), ('650000000312', 12, 92), ('650000000312', 16, 40), ('650000000312', 20, 97);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('319000000149', 19, 150), ('319000000149', 3, 38), ('319000000149', 13, 82), ('319000000149', 17, 63), ('319000000149', 1, 50);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('343000000131', 19, 170), ('343000000131', 4, 55), ('343000000131', 14, 87), ('343000000131', 18, 44), ('343000000131', 2, 62);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('142000000090', 20, 160), ('142000000090', 1, 33), ('142000000090', 5, 74), ('142000000090', 9, 58), ('142000000090', 13, 71);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('142100000051', 20, 180), ('142100000051', 2, 49), ('142100000051', 6, 85), ('142100000051', 10, 62), ('142100000051', 14, 76);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('142100000052', 20, 140), ('142100000052', 3, 34), ('142100000052', 7, 88), ('142100000052', 11, 53), ('142100000052', 15, 69);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('304000000186', 20, 190), ('304000000186', 4, 59), ('304000000186', 8, 94), ('304000000186', 12, 37), ('304000000186', 16, 79);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('349000000115', 20, 130), ('349000000115', 1, 26), ('349000000115', 9, 73), ('349000000115', 13, 56), ('349000000115', 17, 67);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('355000000111', 20, 170), ('355000000111', 2, 46), ('355000000111', 10, 86), ('355000000111', 14, 39), ('355000000111', 18, 78);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('383000000165', 20, 150), ('383000000165', 3, 40), ('383000000165', 11, 80), ('383000000165', 15, 61), ('383000000165', 19, 73);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('427000000215', 20, 180), ('427000000215', 4, 52), ('427000000215', 12, 90), ('427000000215', 16, 42), ('427000000215', 20, 99);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('428000000112', 20, 120), ('428000000112', 5, 23), ('428000000112', 13, 68), ('428000000112', 17, 59), ('428000000112', 1, 48);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('451000000141', 20, 190), ('451000000141', 6, 60), ('451000000141', 14, 83), ('451000000141', 18, 46), ('451000000141', 2, 63);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('477000000112', 20, 140), ('477000000112', 7, 31), ('477000000112', 15, 75), ('477000000112', 19, 62), ('477000000112', 3, 53);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('486000000122', 20, 170), ('486000000122', 8, 48), ('486000000122', 16, 89), ('486000000122', 20, 44), ('486000000122', 4, 69);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('493000000285', 20, 160), ('493000000285', 9, 36), ('493000000285', 17, 79), ('493000000285', 1, 64), ('493000000285', 5, 55);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('497000000129', 20, 180), ('497000000129', 10, 54), ('497000000129', 18, 85), ('497000000129', 2, 38), ('497000000129', 6, 66);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('560000000139', 20, 130), ('560000000139', 11, 27), ('560000000139', 19, 72), ('560000000139', 3, 57), ('560000000139', 7, 50);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('569000000371', 20, 190), ('569000000371', 12, 63), ('569000000371', 20, 96), ('569000000371', 4, 45), ('569000000371', 8, 70);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('627000000160', 20, 150), ('627000000160', 13, 32), ('627000000160', 1, 78), ('627000000160', 5, 60), ('627000000160', 9, 52);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('629000000805', 20, 170), ('629000000805', 14, 49), ('629000000805', 2, 82), ('629000000805', 6, 33), ('629000000805', 10, 73);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('630000000162', 20, 160), ('630000000162', 15, 25), ('630000000162', 3, 71), ('630000000162', 7, 59), ('630000000162', 11, 51);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('631000000137', 20, 180), ('631000000137', 16, 56), ('631000000137', 4, 90), ('631000000137', 8, 39), ('631000000137', 12, 76);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('641000000184', 20, 140), ('641000000184', 17, 41), ('641000000184', 5, 77), ('641000000184', 9, 63), ('641000000184', 13, 54);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('641000000186', 20, 190), ('641000000186', 18, 58), ('641000000186', 6, 92), ('641000000186', 10, 43), ('641000000186', 14, 80);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('642000000735', 20, 120), ('642000000735', 19, 29), ('642000000735', 7, 69), ('642000000735', 11, 57), ('642000000735', 15, 49);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('644000000239', 20, 180), ('644000000239', 20, 64), ('644000000239', 8, 96), ('644000000239', 12, 40), ('644000000239', 16, 81);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('650000000317', 20, 160), ('650000000317', 3, 37), ('650000000317', 11, 79), ('650000000317', 15, 62), ('650000000317', 19, 76);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('999000000070', 20, 180), ('999000000070', 4, 56), ('999000000070', 12, 91), ('999000000070', 16, 41), ('999000000070', 20, 98);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('999000000071', 20, 130), ('999000000071', 5, 28), ('999000000071', 13, 70), ('999000000071', 17, 60), ('999000000071', 1, 47);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('B41000200010', 20, 190), ('B41000200010', 6, 61), ('B41000200010', 14, 84), ('B41000200010', 18, 45), ('B41000200010', 2, 64);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('B41000200011', 20, 140), ('B41000200011', 7, 30), ('B41000200011', 15, 74), ('B41000200011', 19, 61), ('B41000200011', 3, 52);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('B41000200037', 20, 170), ('B41000200037', 8, 47), ('B41000200037', 16, 87), ('B41000200037', 20, 43), ('B41000200037', 4, 68);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('B55284200012', 20, 160), ('B55284200012', 9, 35), ('B55284200012', 17, 78), ('B55284200012', 1, 63), ('B55284200012', 5, 54);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('B55307700024', 20, 180), ('B55307700024', 10, 53), ('B55307700024', 18, 86), ('B55307700024', 2, 39), ('B55307700024', 6, 67);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('O00093000020', 20, 130), ('O00093000020', 11, 26), ('O00093000020', 19, 71), ('O00093000020', 3, 58), ('O00093000020', 7, 51);

INSERT INTO policy_bookmark_counts (policy_id, industry_id, bookmark_count) VALUES
	('SD0000003857', 20, 190), ('SD0000003857', 12, 62), ('SD0000003857', 20, 95), ('SD0000003857', 4, 46), ('SD0000003857', 8, 71);

-- 대출 상품별 업종별 북마크 수 더미 데이터

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(1, 3, 25), (1, 7, 40), (1, 9, 33), (1, 10, 28), (1, 12, 15), (1, 17, 22);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(2, 3, 30), (2, 7, 35), (2, 9, 28), (2, 10, 25), (2, 13, 18);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(3, 12, 120), (3, 6, 30), (3, 9, 25), (3, 20, 40);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(4, 11, 95), (4, 12, 40), (4, 20, 30);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(5, 3, 45), (5, 7, 50), (5, 10, 35), (5, 13, 28);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(6, 10, 88), (6, 13, 60), (6, 3, 40), (6, 20, 55);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(7, 3, 150), (7, 7, 40), (7, 8, 35), (7, 20, 50);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(8, 12, 110), (8, 6, 45), (8, 9, 30), (8, 20, 60);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(9, 7, 80), (9, 9, 65), (9, 3, 50), (9, 10, 45);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(10, 10, 95), (10, 13, 70), (10, 3, 55), (10, 20, 60);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(11, 7, 40), (11, 8, 30), (11, 9, 35), (11, 20, 50);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(12, 6, 70), (12, 9, 45), (12, 3, 30), (12, 20, 55);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(13, 7, 90), (13, 9, 75), (13, 3, 60), (13, 10, 50);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(14, 6, 80), (14, 9, 50), (14, 3, 35), (14, 20, 60);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(15, 3, 60), (15, 6, 55), (15, 7, 40), (15, 20, 50);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(16, 7, 70), (16, 9, 60), (16, 10, 50), (16, 3, 40);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(17, 12, 130), (17, 9, 40), (17, 20, 50);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(18, 3, 40), (18, 7, 35), (18, 10, 30), (18, 20, 45);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(19, 3, 140), (19, 7, 50), (19, 8, 40), (19, 20, 60);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(20, 3, 50), (20, 7, 45), (20, 10, 40), (20, 13, 35);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(21, 13, 160), (21, 10, 50), (21, 17, 40), (21, 20, 70);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(22, 12, 125), (22, 9, 35), (22, 20, 45);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(23, 6, 75), (23, 9, 55), (23, 3, 40), (23, 20, 65);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(24, 13, 110), (24, 10, 80), (24, 3, 60), (24, 20, 70);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(25, 3, 65), (25, 6, 60), (25, 7, 45), (25, 20, 55);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(26, 7, 55), (26, 9, 50), (26, 3, 35), (26, 10, 30);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(27, 3, 130), (27, 10, 60), (27, 13, 50), (27, 20, 40);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(28, 7, 60), (28, 9, 55), (28, 3, 40), (28, 10, 35);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(29, 3, 70), (29, 7, 65), (29, 8, 50), (29, 10, 45);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(30, 3, 75), (30, 7, 70), (30, 8, 55), (30, 10, 50);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(31, 7, 140), (31, 8, 60), (31, 3, 40), (31, 20, 50);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(32, 12, 115), (32, 6, 40), (32, 9, 30), (32, 20, 55);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(33, 9, 90), (33, 7, 60), (33, 6, 40), (33, 20, 50);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(34, 13, 120), (34, 10, 90), (34, 3, 70), (34, 20, 80);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(35, 7, 45), (35, 9, 40), (35, 3, 30), (35, 10, 25);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(36, 3, 60), (36, 7, 55), (36, 10, 45), (36, 13, 40);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(37, 13, 130), (37, 10, 100), (37, 3, 80), (37, 20, 90);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(38, 4, 110), (38, 6, 40), (38, 3, 30), (38, 20, 50);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(39, 17, 180), (39, 13, 60), (39, 9, 40), (39, 20, 70);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(40, 7, 85), (40, 9, 70), (40, 3, 55), (40, 10, 50);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(41, 3, 55), (41, 7, 50), (41, 10, 40), (41, 13, 35);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(42, 9, 70), (42, 7, 60), (42, 19, 50), (42, 20, 65);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(43, 17, 170), (43, 13, 50), (43, 9, 35), (43, 20, 60);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(44, 7, 50), (44, 9, 45), (44, 3, 30), (44, 10, 25);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(45, 13, 150), (45, 10, 60), (45, 11, 50), (45, 20, 70);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(46, 12, 100), (46, 6, 50), (46, 20, 40);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(47, 17, 190), (47, 13, 70), (47, 11, 50), (47, 20, 80);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(48, 1, 160), (48, 3, 50), (48, 7, 40), (48, 20, 60);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(49, 3, 80), (49, 7, 75), (49, 10, 60), (49, 13, 50);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(50, 17, 200), (50, 13, 80), (50, 9, 50), (50, 20, 90);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(51, 7, 130), (51, 1, 40), (51, 3, 30), (51, 20, 50);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(52, 17, 150), (52, 19, 50), (52, 20, 60);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(53, 9, 110), (53, 12, 40), (53, 20, 50);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(54, 7, 120), (54, 1, 50), (54, 8, 40), (54, 20, 60);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(55, 1, 140), (55, 3, 45), (55, 5, 35), (55, 20, 55);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(56, 7, 180), (56, 9, 60), (56, 20, 70);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(57, 9, 100), (57, 7, 80), (57, 3, 50), (57, 20, 70);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(58, 17, 160), (58, 13, 50), (58, 20, 60);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(59, 11, 100), (59, 3, 40), (59, 7, 30), (59, 20, 50);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(60, 7, 150), (60, 10, 70), (60, 8, 50), (60, 20, 60);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(61, 13, 170), (61, 10, 60), (61, 11, 50), (61, 20, 80);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(62, 11, 90), (62, 3, 35), (62, 7, 25), (62, 20, 45);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(63, 7, 250), (63, 8, 100), (63, 20, 120);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(64, 6, 130), (64, 12, 60), (64, 20, 70);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(65, 7, 180), (65, 8, 80), (65, 20, 90);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(66, 3, 80), (66, 7, 70), (66, 10, 60), (66, 20, 75);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(67, 9, 120), (67, 7, 100), (67, 10, 80), (67, 3, 70), (67, 19, 90);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(68, 8, 110), (68, 7, 50), (68, 3, 30), (68, 20, 40);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(69, 8, 130), (69, 7, 60), (69, 3, 40), (69, 20, 50);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(70, 9, 80), (70, 12, 70), (70, 7, 60), (70, 20, 75);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(71, 12, 90), (71, 9, 50), (71, 20, 60);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(72, 3, 70), (72, 7, 60), (72, 8, 50), (72, 20, 65);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(73, 1, 150), (73, 3, 40), (73, 7, 30), (73, 20, 50);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(74, 8, 120), (74, 7, 50), (74, 20, 60);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(75, 3, 65), (75, 7, 55), (75, 10, 45), (75, 20, 60);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(76, 9, 110), (76, 7, 90), (76, 3, 60), (76, 20, 80);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(77, 8, 100), (77, 7, 45), (77, 3, 25), (77, 20, 35);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(78, 7, 170), (78, 8, 70), (78, 20, 80);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(79, 3, 80), (79, 7, 70), (79, 10, 60), (79, 20, 75);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(80, 9, 130), (80, 7, 100), (80, 20, 90);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(81, 8, 90), (81, 7, 40), (81, 3, 20), (81, 20, 30);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(82, 12, 140), (82, 6, 70), (82, 20, 80);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(83, 8, 80), (83, 7, 35), (83, 3, 15), (83, 20, 25);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(84, 6, 100), (84, 12, 80), (84, 20, 90);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(85, 8, 70), (85, 7, 30), (85, 3, 10), (85, 20, 20);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(86, 7, 120), (86, 9, 100), (86, 19, 80), (86, 20, 90);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(87, 7, 160), (87, 8, 80), (87, 20, 90);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(88, 9, 120), (88, 7, 100), (88, 3, 70), (88, 20, 90);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(89, 8, 60), (89, 7, 25), (89, 3, 10), (89, 20, 15);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(90, 7, 110), (90, 9, 90), (90, 19, 70), (90, 20, 80);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(91, 8, 100), (91, 7, 40), (91, 3, 20), (91, 20, 30);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(92, 8, 110), (92, 7, 50), (92, 20, 60);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(93, 8, 90), (93, 7, 35), (93, 3, 15), (93, 20, 25);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(94, 9, 130), (94, 7, 110), (94, 10, 90), (94, 3, 80), (94, 19, 100);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(95, 9, 140), (95, 7, 120), (95, 10, 100), (95, 3, 90), (95, 19, 110);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(96, 6, 150), (96, 8, 70), (96, 3, 50), (96, 20, 60);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(97, 6, 160), (97, 8, 80), (97, 3, 60), (97, 20, 70);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(98, 7, 200), (98, 8, 90), (98, 20, 100);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(99, 7, 190), (99, 8, 80), (99, 20, 90);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(100, 6, 140), (100, 8, 60), (100, 3, 40), (100, 20, 50);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(101, 12, 100), (101, 9, 70), (101, 20, 80);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(102, 8, 80), (102, 7, 30), (102, 3, 10), (102, 20, 20);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(103, 6, 120), (103, 8, 50), (103, 3, 30), (103, 20, 40);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(104, 7, 100), (104, 9, 80), (104, 19, 60), (104, 20, 70);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(105, 7, 220), (105, 8, 100), (105, 20, 110);

INSERT INTO loan_bookmark_counts (loan_id, industry_id, bookmark_count) VALUES
	(106, 7, 130), (106, 9, 110), (106, 19, 90), (106, 20, 100);

-- policies 테이블의 begin_date와 end_date 업데이트
UPDATE policies SET begin_date = '2025-03-14', end_date = '2025-04-02' WHERE policy_id = '142100000058';
UPDATE policies SET begin_date = '2025-05-01', end_date = '2025-05-30' WHERE policy_id = '451000000125';
UPDATE policies SET begin_date = '2024-06-01' WHERE policy_id = '496000000109';
UPDATE policies SET begin_date = '2025-05-01', end_date = '2025-11-28' WHERE policy_id = '497000000128';
UPDATE policies SET begin_date = '2025-05-13' WHERE policy_id = '497000000137';
UPDATE policies SET begin_date = '2025-01-01', end_date = '2025-12-31' WHERE policy_id = '508000000690';
UPDATE policies SET begin_date = '2025-02-01' WHERE policy_id = '629000000193';
UPDATE policies SET begin_date = '2025-01-01', end_date = '2025-12-31' WHERE policy_id = '642000000735';
UPDATE policies SET begin_date = '2025-02-01' WHERE policy_id = '648000001087';
UPDATE policies SET begin_date = '2025-02-01', end_date = '2025-03-31' WHERE policy_id = 'B55307700024';
UPDATE policies SET begin_date = '2025-07-10', end_date = '2025-07-31' WHERE policy_id = 'O00108000004';
