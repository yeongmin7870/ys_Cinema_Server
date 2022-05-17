--음식 대분류
INSERT INTO Food_Kind VALUES (100, "음식");
INSERT INTO Food_Kind VALUES (200, "음료");
INSERT INTO Food_Kind VALUES (300, "콤보");

--음식 메뉴 100번 대분류에 속함
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(11, '팝콘 단품',sysdate,'현재없음', 100, '없음', '오리지널 팝콘', 5000);
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(12, '팝콘 단품',sysdate,'현재없음', 100, '없음', '캬라멜 팝콘', 5500);
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(13, '팝콘 단품',sysdate,'현재없음', 100, '없음', '버터갈릭 팝콘', 5500);
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(14, '나초+소스',sysdate,'현재없음', 100, '없음', '오리지날 나쵸', 6000);
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(15, '나초샐러드',sysdate,'현재없음', 100, '없음', '나초 샐러드', 7000);
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(16, '감자 튀김',sysdate,'현재없음', 100, '없음', '감자 튀김', 6000);
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(17, '감자튀김+치즈스틱',sysdate,'현재없음', 100, '없음', '감자 튀김+치즈 스틱', 8000);
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(18, '버터 오징어',sysdate,'현재없음', 100, '없음', '버터 오징어', 6000);
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(19, 'BBQ 핫도그',sysdate,'현재없음', 100, '없음', 'BBQ 핫도그', 6000);

--음식 메뉴 200번 대분류에 속함
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(21, '탄산 음료',sysdate,'현재없음', 200, '없음', '콜라', 3500);
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(22, '탄산 음료',sysdate,'현재없음', 200, '없음', '사이다(스프라이트)', 3500);
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(23, '탄산 음료',sysdate,'현재없음', 200, '없음', '환타', 3500);
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(24, '에이드',sysdate,'현재없음', 200, '없음', '레몬 에이드', 5000);
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(25, '에이드',sysdate,'현재없음', 200, '없음', '복숭아 에이드', 5000);
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(26, '에이드',sysdate,'현재없음', 200, '없음', '청포도 에이드', 5000);
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(27, '주류',sysdate,'현재없음', 200, '19세', '생맥주 500cc', 6000);
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(28, '주류',sysdate,'현재없음', 200, '없음', '하이볼', 6500);
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(29, '커피',sysdate,'현재없음', 200, '없음', '아메리카노', 4500);

--음식 메뉴 300번 대분류에 속함
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(31, '팝콘 1개 + 음료 1 컵',sysdate,'현재없음', 300, '없음', '싱글콤보', 8000);
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(32, '팝콘 1개 + 음료 2 컵',sysdate,'현재없음', 300, '없음', '커플콤보', 10000);
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(33, '팝콘 2개 + 음료 2 컵',sysdate,'현재없음', 300, '없음', '더블 콤보', 15000);
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(34, '감자튀김&치즈스틱 1개 + 생맥주500cc 한 잔',sysdate,'현재없음', 300, '19세', '어른의 코보', 12000);
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(35, '나초샐러드 1개+ 에이드 한 잔',sysdate,'현재없음', 300, '없음', '상큼 콤보', 11000);
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(36, '핫도그 1개 + 음료 1컵 ',sysdate,'현재없음', 300, '없음', '핫도그 콤보', 8500);

--고객 기본정보
INSERT INTO CUSTOMER (c_id, c_address, c_name,c_nikname, c_phone, c_point, c_profile, c_profile_path, c_pw, c_total) values ('PYM', 'ANSAN','박영민','왼손에 청룡이','01011112222', 0, '이미지명', '이미지 경로','1234',0);
INSERT INTO CUSTOMER (c_id, c_address, c_name,c_nikname, c_phone, c_point, c_profile, c_profile_path, c_pw, c_total) values ('LSG', 'ANYANG','이상기','오른손에 주작이','01033334444', 0, '이미지명', '이미지 경로','1234',0);
INSERT INTO CUSTOMER (c_id, c_address, c_name,c_nikname, c_phone, c_point, c_profile, c_profile_path, c_pw, c_total) values ('YSJ', 'ANYANG','양석준','머리에 탈모가...','01055556666', 0, '이미지명', '이미지 경로','1234',0);
INSERT INTO CUSTOMER (c_id, c_address, c_name,c_nikname, c_phone, c_point, c_profile, c_profile_path, c_pw, c_total) values ('HJY', 'SIHEUNG','한정엽','왼발에 백호가','01077778888', 0, '이미지명', '이미지 경로','1234',0);
INSERT INTO CUSTOMER (c_id, c_address, c_name,c_nikname, c_phone, c_point, c_profile, c_profile_path, c_pw, c_total) values ('BSH', 'GWANGJU','박영민','오른발에 현무가','01099990000', 0, '이미지명', '이미지 경로','1234',0);

--자주찾는질문
INSERT INTO often_question (often_id, often_answer, often_content, often_subject)
values (1,'티켓 취소는 영화 시작 20분 전까지 취소가 가능하며, 20분 이후 취소 시 수수료가 발생됩니다.','모바일로 예매한 영화티켓 예매 및 취소는 어떻게 하나요? 그리고 혹시 수수료가 발생하나요?','영화티켓 예매 및 취소')
INSERT INTO often_question (often_id, often_answer, often_content, often_subject)
values (2,'SWEET SPOT이란, 스크린 가운데에서 상영관 뒤 벽까지 직선 거리의 2/3 지점으로 추가요금은 없습니다.','SWEET SPOT 이라는게 있다고 들었는데 이것은 무엇이고 추가요금이 발생 되나여?','SWEET SPOT이 무엇인가여?')
INSERT INTO often_question (often_id, often_answer, often_content, often_subject)
values (3,'모두 섭취 가능합니다. ','영화관 내부에서 취식이 가능한가여?','영화관 내부에서 취식 여부?')
INSERT INTO often_question (often_id, often_answer, often_content, often_subject)
values (4,'각 영화관의 매점에 해당하는 부분에 방문하여서 질문을 해주시면 수량 확인이 가능합니다.','영화 별 굿즈의 잔여 수량을 알 수 있는 방법이 있을까요?','영화 경품(굿즈) 수량 확인')
INSERT INTO often_question (often_id, often_answer, often_content, often_subject)
values (5,'소지물품을 분실하신 경우에는 통합콜센터 1234-1234로 연락하시어 확인 할 수 있습니다.','영화를 보고 나왔는데 휴대폰을 분실했습니다. 어떻게 해야하나요?','분실문은 어떻하나여?')


--좌석
INSERT INTO movie ()
