ALTER SESSION SET NLS_DATE_FORMAT = 'YYYY-MM-DD-HH24:MI:SS';


drop sequence movie_schedule_seq;


CREATE SEQUENCE movie_schedule_seq INCREMENT BY 1 START WITH 1 MINVALUE 1 MAXVALUE 9999999999 NOCYCLE NOCACHE NOORDER;


--fk 작성

--내가쓴 리뷰의 내역
ALTER TABLE writed_review ADD CONSTRAINT c_wr_cid FOREIGN KEY (c_id) REFERENCES customer(c_id);
ALTER TABLE writed_review ADD CONSTRAINT mr_wr_mrNo FOREIGN KEY (mr_no) REFERENCES movie_review(mr_no);
ALTER TABLE writed_review ADD CONSTRAINT rc_wr_rcNo FOREIGN KEY (rc_no) REFERENCES review_comment(rc_no);

--회원 주문 내역
ALTER TABLE order_List ADD CONSTRAINT c_or_cid FOREIGN KEY (c_id) REFERENCES customer(c_id);
ALTER TABLE order_List ADD CONSTRAINT fp_or_fpNo FOREIGN KEY (fp_No) REFERENCES food_payment(fp_no);
ALTER TABLE order_List ADD CONSTRAINT r_or_rNo FOREIGN KEY (r_no) REFERENCES reservation(r_no);

--질문 게시판
ALTER TABLE question ADD CONSTRAINT c_q_cid FOREIGN KEY (c_id) REFERENCES customer(C_id);

--답변 게시판
ALTER TABLE answer ADD CONSTRAINT q_as_qno FOREIGN KEY (q_no) REFERENCES question(q_No);
ALTER TABLE answer ADD CONSTRAINT ad_as_adID FOREIGN KEY (ad_id) REFERENCES ADMIN(ad_id);

--이벤트 목록
ALTER TABLE event_list ADD CONSTRAINT ad_ev_adID FOREIGN KEY (ad_ID) REFERENCES admin(ad_ID);

--음식 메뉴
ALTER TABLE food_Menu ADD CONSTRAINT fk_fo_foodkindno FOREIGN KEY (food_kind_no) REFERENCES food_kind(food_kind_no);

--음식 결제 내역
ALTER TABLE food_Payment ADD CONSTRAINT fo_fo_foodno FOREIGN KEY (food_no) REFERENCES food_menu(food_no);

--비회원 주문 내역
ALTER TABLE nc_Order_List ADD CONSTRAINT n_nc_ncNo FOREIGN KEY (nc_no) REFERENCES non_customer(nc_no);
ALTER TABLE nc_Order_List ADD CONSTRAINT fp_ord_fpno foreign key (fp_No) REFERENCES food_payment(fp_no);
ALTER TABLE nc_Order_List ADD CONSTRAINT r_nonor_rNo FOREIGN KEY (r_no) REFERENCES Reservation(r_no);

--리뷰 댓글
ALTER TABLE review_comment ADD CONSTRAINT mr_mo_mrNo FOREIGN KEY (mr_no) REFERENCES movie_Review(mr_no);

--무비 리뷰
ALTER TABLE movie_review ADD CONSTRAINT mo_mo_mNo FOREIGN KEY (m_no) REFERENCES movie(m_no);

--예매
--ALTER TABLE reservation ADD CONSTRAINT re_mo_mNo FOREIGN KEY (m_no) REFERENCES movie(m_no);
--ALTER TABLE reservation ADD CONSTRAINT re_mos_msNo FOREIGN KEY (ms_no) REFERENCES movie_schedule(ms_no);
--ALTER TABLE reservation ADD CONSTRAINT re_nos_normalSeatId FOREIGN KEY (normal_Seat_Id)REFERENCES normal_Seat(normal_Seat_Id);
--ALTER TABLE reservation ADD CONSTRAINT re_nos_normalId FOREIGN KEY (normal_Screen_Id) REFERENCES normal_Screen(normal_Screen_Id);

--상영시간표
ALTER TABLE movie_schedule ADD CONSTRAINT mos_st_storeNo FOREIGN KEY (store_no) REFERENCES store_address(store_no);
ALTER TABLE movie_schedule ADD CONSTRAINT mos_mo_mNo FOREIGN KEY (m_no) REFERENCES movie(m_no);




--음식 대분류
INSERT INTO Food_Kind VALUES (100, '음식');
INSERT INTO Food_Kind VALUES (200, '음료');
INSERT INTO Food_Kind VALUES (300, '콤보');

--음식 메뉴 100번 대분류에 속함
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(11, '팝콘 단품',sysdate,'./src/main/resources/serverImage/foodImage/popcorn.png', 100, '제한 없음', '오리지널 팝콘', 5000);
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(12, '팝콘 단품',sysdate,'./src/main/resources/serverImage/foodImage/Caramelpopcorn.jpg', 100, '제한 없음', '캬라멜 팝콘', 5500);
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(13, '팝콘 단품',sysdate,'./src/main/resources/serverImage/foodImage/ButterPopCorn.png', 100, '제한 없음', '버터갈릭 팝콘', 5500);
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(14, '나초+소스',sysdate,'./src/main/resources/serverImage/foodImage/nacho.png', 100, '제한 없음', '오리지날 나쵸', 6000);
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(15, '나초샐러드',sysdate,'./src/main/resources/serverImage/foodImage/NachoSalad.jpg', 100, '제한 없음', '나초 샐러드', 7000);
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(16, '감자 튀김',sysdate,'./src/main/resources/serverImage/foodImage/Potato.jpg', 100, '제한 없음', '감자 튀김', 6000);
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(17, '감자튀김+치즈스틱',sysdate,'./src/main/resources/serverImage/foodImage/CheeseSticks.jpg', 100, '제한 없음', '감자 튀김+치즈 스틱', 8000);
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(18, '버터 오징어',sysdate,'./src/main/resources/serverImage/foodImage/Butter_Squid.jpg', 100, '제한 없음', '버터 오징어', 6000);
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(19, 'BBQ 핫도그',sysdate,'./src/main/resources/serverImage/foodImage/HotDog.jpg', 100, '제한 없음', 'BBQ 핫도그', 6000);

--음식 메뉴 200번 대분류에 속함
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(21, '탄산 음료',sysdate,'./src/main/resources/serverImage/foodImage/Coke.jpg', 200, '제한 없음', '콜라', 3500);
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(22, '탄산 음료',sysdate,'./src/main/resources/serverImage/foodImage/Sprite.jpg', 200, '제한 없음', '사이다(스프라이트)', 3500);
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(23, '탄산 음료',sysdate,'./src/main/resources/serverImage/foodImage/Fanta.jpg', 200, '제한 없음', '환타', 3500);
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(24, '에이드',sysdate,'./src/main/resources/serverImage/foodImage/Lemonade.jpg', 200, '제한 없음', '레몬 에이드', 5000);
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(25, '에이드',sysdate,'./src/main/resources/serverImage/foodImage/PeachIcedTea.jpg', 200, '제한 없음', '복숭아 에이드', 5000);
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(26, '에이드',sysdate,'./src/main/resources/serverImage/foodImage/GreenGrapeAde.jpg', 200, '제한 없음', '청포도 에이드', 5000);
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(27, '주류',sysdate,'./src/main/resources/serverImage/foodImage/Beer.jpg', 200, '19세 미만 판매 금지', '생맥주 500cc', 6000);
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(28, '주류',sysdate,'./src/main/resources/serverImage/foodImage/HighBall.jpg', 200, '19세 미만 판매 금지', '하이볼', 6500);
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(29, '커피',sysdate,'./src/main/resources/serverImage/foodImage/Americano.jpg', 200, '제한 없음', '아메리카노', 4500);

--음식 메뉴 300번 대분류에 속함
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(31, '팝콘 1개 + 음료 1 컵',sysdate,'./src/main/resources/serverImage/foodImage/SingleCombo.jpg', 300, '제한 없음', '싱글콤보', 8000);
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(32, '팝콘 1개 + 음료 2 컵',sysdate,'./src/main/resources/serverImage/foodImage/CoupleCombo.jpg', 300, '제한 없음', '커플콤보', 10000);
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(33, '팝콘 2개 + 음료 2 컵',sysdate,'./src/main/resources/serverImage/foodImage/DoubleCombo.jpg', 300, '제한 없음', '더블 콤보', 15000);
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(34, '감자튀김&치즈스틱 1개 + 생맥주500cc 한 잔',sysdate,'./src/main/resources/serverImage/foodImage/AdultCombo.jpg', 300, '19세', '어른의 코보', 12000);
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(35, '나초샐러드 1개+ 에이드 한 잔',sysdate,'./src/main/resources/serverImage/foodImage/FreshCombo.jpg', 300, '제한 없음', '상큼 콤보', 11000);
INSERT INTO FOOD_MENU (FOOD_NO, FOOD_COMPONENT, FOOD_DATE, FOOD_IMG, FOOD_KIND_NO,FOOD_LIMIT,FOOD_NAME,FOOD_PRICE) values(36, '핫도그 1개 + 음료 1컵 ',sysdate,'./src/main/resources/serverImage/foodImage/HotDogCombo.jpg', 300, '제한 없음', '핫도그 콤보', 8500);

--고객 기본정보
INSERT INTO CUSTOMER (c_id, c_address, c_name,c_nikname, c_phone, c_point, c_profile, c_profile_path, c_pw, c_total) values ('PYM', 'ANSAN','박영민','왼손에 청룡이','01011112222', 0, 'profile.png', './src/main/resources/serverImage/profile/','1234',0);
INSERT INTO CUSTOMER (c_id, c_address, c_name,c_nikname, c_phone, c_point, c_profile, c_profile_path, c_pw, c_total) values ('LSG', 'ANYANG','이상기','오른손에 주작이','01033334444', 0, 'profile.png', './src/main/resources/serverImage/profile/','1234',0);
INSERT INTO CUSTOMER (c_id, c_address, c_name,c_nikname, c_phone, c_point, c_profile, c_profile_path, c_pw, c_total) values ('YSJ', 'ANYANG','양석준','머리에 탈모가...','01055556666', 0, 'profile.png', './src/main/resources/serverImage/profile/','1234',0);
INSERT INTO CUSTOMER (c_id, c_address, c_name,c_nikname, c_phone, c_point, c_profile, c_profile_path, c_pw, c_total) values ('HJY', 'SIHEUNG','한정엽','왼발에 백호가','01077778888', 0, 'profile.png', './src/main/resources/serverImage/profile/','1234',0);
INSERT INTO CUSTOMER (c_id, c_address, c_name,c_nikname, c_phone, c_point, c_profile, c_profile_path, c_pw, c_total) values ('BSH', 'GWANGJU','박영민','오른발에 현무가','01099990000', 0, 'profile.png', './src/main/resources/serverImage/profile/','1234',0);

--자주찾는질문
INSERT INTO often_question (often_id, often_answer, often_content, often_subject)
values (1,'티켓 취소는 영화 시작 20분 전까지 취소가 가능하며, 20분 이후 취소 시 수수료가 발생됩니다.','모바일로 예매한 영화티켓 예매 및 취소는 어떻게 하나요? 그리고 혹시 수수료가 발생하나요?','영화티켓 예매 및 취소');
INSERT INTO often_question (often_id, often_answer, often_content, often_subject)
values (2,'SWEET SPOT이란,스크린 가운데에서 상영관 뒤 벽까지 2/3 지점으로 추가요금은 없습니다.','SWEET SPOT 이라는게 있다고 들었는데 이것은 무엇이고 추가요금이 발생 되나여?','SWEET SPOT이 무엇인가여?');
INSERT INTO often_question (often_id, often_answer, often_content, often_subject)
values (3,'모두 섭취 가능합니다. ','영화관 내부에서 취식이 가능한가여?','영화관 내부에서 취식 여부?');
INSERT INTO often_question (often_id, often_answer, often_content, often_subject)
values (4,'각 영화관의 매점에 해당하는 부분에 방문하여서 질문을 해주시면 수량 확인이 가능합니다.','영화 별 굿즈의 잔여 수량을 알 수 있는 방법이 있을까요?','영화 경품(굿즈) 수량 확인');
INSERT INTO often_question (often_id, often_answer, often_content, often_subject)
values (5,'소지물품을 분실하신 경우에는 통합콜센터 1234-1234로 연락하시어 확인 할 수 있습니다.','영화를 보고 나왔는데 휴대폰을 분실했습니다. 어떻게 해야하나요?','분실문은 어떻하나여?');


--영화
insert into movie (m_no,m_Actor2, m_Actor3,m_Actors,m_categories,m_content,m_director,m_end_date,m_hour,m_image_path,m_img,m_name,m_rating,m_star_score,m_start_date,movie_video_name,movie_video_path,m_tier) values (1,'필립 느와레','자끄 페렝','마르코 레오나르디','드라마','영화가 세상의 전부였던 소년 토토는 영사 기사의 친구로 지내며 영사기술을 배운다.','쥬세페 토르나토레','20220601','124','./src/main/resources/serverImage/movieImage/', 'CinemaParadiso.jpg', '시네마 천국',0,0.0,'20200504','./src/main/resources/movieVideo/','Iwannagosea.mp4','전체이용가');
insert into movie (m_no,m_Actor2, m_Actor3,m_Actors,m_categories,m_content,m_director,m_end_date,m_hour,m_image_path,m_img,m_name,m_rating,m_star_score,m_start_date,movie_video_name,movie_video_path,m_tier) values (2,'엠마 스톤','존 레전드','라이언 고슬링','드라마','별들의 도시 라라랜드. 두 사람은 미완성인 서로의 무대를 만들어가기 시작한다.','데이미언 셔젤','20220601','127','./src/main/resources/serverImage/movieImage/', 'LaLaLand.jpg', '라라랜드',0,0.0,'20201231','./src/main/resources/movieVideo/','Iwannagosea.mp4','12세 관람가');
insert into movie (m_no,m_Actor2, m_Actor3,m_Actors,m_categories,m_content,m_director,m_end_date,m_hour,m_image_path,m_img,m_name,m_rating,m_star_score,m_start_date,movie_video_name,movie_video_path,m_tier) values (3,'로버트 패틴슨','엘리자베스 데비키','존 데이비드 워싱턴','액션','현재와 미래를 오가며 세상을 파괴하려는 사토르에 맞서 제 3차 대전을 막아야 한다.','크리스토퍼 놀란','20220601','150','./src/main/resources/serverImage/movieImage/', 'tenet.jpg', '테넷',0,0.0,'20200826','./src/main/resources/movieVideo/','Iwannagosea.mp4','12세 관람가');
insert into movie (m_no,m_Actor2, m_Actor3,m_Actors,m_categories,m_content,m_director,m_end_date,m_hour,m_image_path,m_img,m_name,m_rating,m_star_score,m_start_date,movie_video_name,movie_video_path,m_tier) values (4,'케빈 스페이시','릴리 제임스','안셀 엘고트','액션','탈출 전문 드라이버 베이비. 어느 날,  데보라를 만나 베이비는 새 인생을 살려 하는데...','에드가 라이트','20220601','113','./src/main/resources/serverImage/movieImage/', 'BabyDriver.jpg', '베이비 드라이버',0,0.0,'20170913','./src/main/resources/movieVideo/','Iwannagosea.mp4','15세 관람가');
insert into movie (m_no,m_Actor2, m_Actor3,m_Actors,m_categories,m_content,m_director,m_end_date,m_hour,m_image_path,m_img,m_name,m_rating,m_star_score,m_start_date,movie_video_name,movie_video_path,m_tier) values (5,'폴 다노','조 크라비츠','로버트 패틴슨','액션','2년간 고담시에서 활동한 브루스웨인. 범인의 수사를 하며 숨겨진 진실이 드러나는데','맷 리브스','20220601','176','./src/main/resources/serverImage/movieImage/', 'TheBatMan.jpg', '더 배트맨',0,0.0,'20220301','./src/main/resources/movieVideo/','Iwannagosea.mp4','15세 관람가');
insert into movie (m_no,m_Actor2, m_Actor3,m_Actors,m_categories,m_content,m_director,m_end_date,m_hour,m_image_path,m_img,m_name,m_rating,m_star_score,m_start_date,movie_video_name,movie_video_path,m_tier) values (6,'재지 비츠','로버트 드니로','호아킨 피닉스','스릴러','고담시의 광대 아서 플렉은 모두 미쳐가는 세상 속에서 그가 설 자리가 없음을 깨닫는데...','토드 필립스','20220601','123','./src/main/resources/serverImage/movieImage/', 'joker.jpg', '조커',0,0.0,'20191002','./src/main/resources/movieVideo/','Iwannagosea.mp4','15세 관람가');
insert into movie (m_no,m_Actor2, m_Actor3,m_Actors,m_categories,m_content,m_director,m_end_date,m_hour,m_image_path,m_img,m_name,m_rating,m_star_score,m_start_date,movie_video_name,movie_video_path,m_tier) values (7,'테렌스 하워드','제프 브리지스','로버트 다우니 주니어','SF','천재적인 두뇌와 재능으로 세계 최강의 무기업체를 이끄는 CEO. 어느 날 납치를 당하는데...','존 파브로','20220601','125','./src/main/resources/serverImage/movieImage/', 'IronMan.jpg', '아이언맨 1',0,0.0,'20080430','./src/main/resources/movieVideo/','Iwannagosea.mp4','12세 관람가');
insert into movie (m_no,m_Actor2, m_Actor3,m_Actors,m_categories,m_content,m_director,m_end_date,m_hour,m_image_path,m_img,m_name,m_rating,m_star_score,m_start_date,movie_video_name,movie_video_path,m_tier) values (8,'밀리 샤피로','알렉스 울프','토니 콜렛','공포','애니의 엄마로부터 시작돼 딸 와 아들에게까지 이어진 저주의 정체를 드러내는데···','아리 애스터','20220601','127','./src/main/resources/serverImage/movieImage/', 'Hereditary.jpg', '유전',0,0.0,'20180607','./src/main/resources/movieVideo/','Iwannagosea.mp4','15세 관람가');
insert into movie (m_no,m_Actor2, m_Actor3,m_Actors,m_categories,m_content,m_director,m_end_date,m_hour,m_image_path,m_img,m_name,m_rating,m_star_score,m_start_date,movie_video_name,movie_video_path,m_tier) values (9,'에밀리 블런트','빌 팩스본','톰 크루즈','액션','근 미래 외계 종족의 침략으로 주인공은 전쟁에 참전하게 되어 죽고 타임 루프에 갇히는데...','더그 라이만','20220601','113','./src/main/resources/serverImage/movieImage/', 'EdgeOfTomorrow.jpg', '엣지 오브 투모로우',0,0.0,'20140604','./src/main/resources/movieVideo/','Iwannagosea.mp4','12세 관람가');
insert into movie (m_no,m_Actor2, m_Actor3,m_Actors,m_categories,m_content,m_director,m_end_date,m_hour,m_image_path,m_img,m_name,m_rating,m_star_score,m_start_date,movie_video_name,movie_video_path,m_tier) values (10,'마크 러팔러','애덤 리바인','키이라 나이틀리','드라마','스타 음반프도듀서에서 해고된 댄은 뮤직바에서 그레타의 자작곡을 듣고 다시 한 번 재개하는데','존 카니','20220601','104','./src/main/resources/serverImage/movieImage/', 'BeginAgain.jpg', '비긴 어게인',0,0.0,'20201231','./src/main/resources/movieVideo/','Iwannagosea.mp4','15세 관람가');

--좌석
--insert into normal_seat (normal_seat_id, normal_state) values ('A01','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('A02','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('A03','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('A04','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('A05','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('A06','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('A07','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('A08','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('B01','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('B02','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('B03','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('B04','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('B05','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('B06','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('B07','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('B08','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('C01','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('C02','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('C03','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('C04','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('C05','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('C06','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('C07','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('C08','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('D01','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('D02','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('D03','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('D04','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('D05','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('D06','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('D07','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('D08','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('E01','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('E02','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('E03','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('E04','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('E05','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('E06','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('E07','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('E08','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('F01','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('F02','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('F03','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('F04','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('F05','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('F06','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('F07','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('F08','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('G01','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('G02','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('G03','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('G04','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('G05','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('G06','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('G07','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('G08','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('H01','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('H02','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('H03','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('H04','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('H05','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('H06','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('H07','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('H08','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('I01','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('I02','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('I03','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('I04','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('I05','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('I06','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('I07','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('I08','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('J01','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('J02','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('J03','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('J04','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('J05','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('J06','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('J07','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('J08','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('K01','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('K02','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('K03','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('K04','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('K05','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('K06','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('K07','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('K08','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('L01','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('L02','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('L03','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('L04','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('L05','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('L06','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('L07','0');
--insert into normal_seat (normal_seat_id, normal_state) values ('L08','0');
--
insert into normal_Screen (normal_Screen_Id, normal_Screen) values ('S1', '1관');
insert into normal_Screen (normal_Screen_Id, normal_Screen) values ('S2', '2관');
insert into normal_Screen (normal_Screen_Id, normal_Screen) values ('S3', '3관');
insert into normal_Screen (normal_Screen_Id, normal_Screen) values ('S4', '4관');
insert into normal_Screen (normal_Screen_Id, normal_Screen) values ('S5', '5관');


insert into Store_Address (store_No, store_Address, store_Owner) values (1, '서울시 강남구', '금강선');
insert into Store_Address (store_No, store_Address, store_Owner) values (2, '안산시 단원구', '박영민');
insert into Store_Address (store_No, store_Address, store_Owner) values (3, '안양시 동안구', '연성머');
insert into Store_Address (store_No, store_Address, store_Owner) values (4, '부신시 서구', '사나인');
insert into Store_Address (store_No, store_Address, store_Owner) values (5, '청주시 청원구', '정시원');

insert into movie_schedule
(ms_no, ms_End_Time, ms_Star_Time, m_no, store_no)
select movie_schedule_seq.NEXTVAL,
sysdate + (interval '1' minute) * mv.m_hour,
sysdate,
1,
1
from movie mv
where mv.m_no = 1;


insert into movie_schedule
(ms_no, ms_End_Time, ms_Star_Time, m_no, store_no)
select movie_schedule_seq.NEXTVAL,
sysdate + (interval '1' minute) * mv.m_hour,
sysdate,
1,
1
from movie mv
where mv.m_no = 2;


insert into movie_schedule
(ms_no, ms_End_Time, ms_Star_Time, m_no, store_no)
select movie_schedule_seq.NEXTVAL,
sysdate + (interval '1' minute) * mv.m_hour,
sysdate,
1,
1
from movie mv
where mv.m_no = 3;


insert into movie_schedule
(ms_no, ms_End_Time, ms_Star_Time, m_no, store_no)
select movie_schedule_seq.NEXTVAL,
sysdate + (interval '1' minute) * mv.m_hour,
sysdate,
1,
1
from movie mv
where mv.m_no = 4;


insert into movie_schedule
(ms_no, ms_End_Time, ms_Star_Time, m_no, store_no)
select movie_schedule_seq.NEXTVAL,
sysdate + (interval '1' minute) * mv.m_hour,
sysdate,
1,
1
from movie mv
where mv.m_no = 5;


insert into movie_schedule
(ms_no, ms_End_Time, ms_Star_Time, m_no, store_no)
select movie_schedule_seq.NEXTVAL,
sysdate + (interval '1' minute) * mv.m_hour,
sysdate,
1,
1
from movie mv
where mv.m_no = 6;


insert into movie_schedule
(ms_no, ms_End_Time, ms_Star_Time, m_no, store_no)
select movie_schedule_seq.NEXTVAL,
sysdate + (interval '1' minute) * mv.m_hour,
sysdate,
1,
1
from movie mv
where mv.m_no = 7;


insert into movie_schedule
(ms_no, ms_End_Time, ms_Star_Time, m_no, store_no)
select movie_schedule_seq.NEXTVAL,
sysdate + (interval '1' minute) * mv.m_hour,
sysdate,
1,
1
from movie mv
where mv.m_no = 8;


insert into movie_schedule
(ms_no, ms_End_Time, ms_Star_Time, m_no, store_no)
select movie_schedule_seq.NEXTVAL,
sysdate + (interval '1' minute) * mv.m_hour,
sysdate,
1,
1
from movie mv
where mv.m_no = 9;


insert into movie_schedule
(ms_no, ms_End_Time, ms_Star_Time, m_no, store_no)
select movie_schedule_seq.NEXTVAL,
sysdate + (interval '1' minute) * mv.m_hour,
sysdate,
1,
1
from movie mv
where mv.m_no = 10;


insert into movie_schedule
(ms_no, ms_End_Time, ms_Star_Time, m_no, store_no)
select movie_schedule_seq.NEXTVAL,
(sysdate + (interval '2' hour)) + ((interval '1' minute) * mv.m_hour),
sysdate + (interval '1' hour),
1,
1
from movie mv
where mv.m_no = 11;


insert into movie_schedule
(ms_no, ms_End_Time, ms_Star_Time, m_no, store_no)
select movie_schedule_seq.NEXTVAL,
(sysdate + (interval '2' hour)) + ((interval '1' minute) * mv.m_hour),
sysdate + (interval '1' hour),
1,
1
from movie mv
where mv.m_no = 12;


insert into movie_schedule
(ms_no, ms_End_Time, ms_Star_Time, m_no, store_no)
select movie_schedule_seq.NEXTVAL,
(sysdate + (interval '2' hour)) + ((interval '1' minute) * mv.m_hour),
sysdate + (interval '1' hour),
1,
1
from movie mv
where mv.m_no = 13;


insert into movie_schedule
(ms_no, ms_End_Time, ms_Star_Time, m_no, store_no)
select movie_schedule_seq.NEXTVAL,
(sysdate + (interval '2' hour)) + ((interval '1' minute) * mv.m_hour),
sysdate + (interval '1' hour),
1,
1
from movie mv
where mv.m_no = 14;


insert into movie_schedule
(ms_no, ms_End_Time, ms_Star_Time, m_no, store_no)
select movie_schedule_seq.NEXTVAL,
(sysdate + (interval '2' hour)) + ((interval '1' minute) * mv.m_hour),
sysdate + (interval '1' hour),
1,
1
from movie mv
where mv.m_no = 15;


insert into movie_schedule
(ms_no, ms_End_Time, ms_Star_Time, m_no, store_no)
select movie_schedule_seq.NEXTVAL,
(sysdate + (interval '2' hour)) + ((interval '1' minute) * mv.m_hour),
sysdate + (interval '1' hour),
1,
1
from movie mv
where mv.m_no = 16;


insert into movie_schedule
(ms_no, ms_End_Time, ms_Star_Time, m_no, store_no)
select movie_schedule_seq.NEXTVAL,
(sysdate + (interval '2' hour)) + ((interval '1' minute) * mv.m_hour),
sysdate + (interval '1' hour),
1,
1
from movie mv
where mv.m_no = 17;


insert into movie_schedule
(ms_no, ms_End_Time, ms_Star_Time, m_no, store_no)
select movie_schedule_seq.NEXTVAL,
(sysdate + (interval '2' hour)) + ((interval '1' minute) * mv.m_hour),
sysdate + (interval '1' hour),
1,
1
from movie mv
where mv.m_no = 18;


insert into movie_schedule
(ms_no, ms_End_Time, ms_Star_Time, m_no, store_no)
select movie_schedule_seq.NEXTVAL,
(sysdate + (interval '2' hour)) + ((interval '1' minute) * mv.m_hour),
sysdate + (interval '1' hour),
1,
1
from movie mv
where mv.m_no = 19;


insert into movie_schedule
(ms_no, ms_End_Time, ms_Star_Time, m_no, store_no)
select movie_schedule_seq.NEXTVAL,
(sysdate + (interval '2' hour)) + ((interval '1' minute) * mv.m_hour),
sysdate + (interval '1' hour),
1,
1
from movie mv
where mv.m_no = 20;