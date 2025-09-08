-- 우리 프랜차이즈론 메시지
INSERT INTO chat_messages (room_id, user_id, content, created_at)
VALUES
	(198, 2, '대출 한도가 얼마나 되나요?', '2025-09-08 09:50:00'),
	(198, 3, '최대 2억까지 가능하다고 합니다.', '2025-09-08 10:05:00'),
	(198, 4, '최근 금리 변동이 있었나요?', '2025-09-08 10:15:00'),
	(198, 1, '제 가게 당근하실 분 구합니다.', '2025-09-08 18:00:00');

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
	(13, 'dummy-key-1', 'image1', 'jpg', 102400),
	(13, 'dummy-key-2', 'document1', 'pdf', 204800);