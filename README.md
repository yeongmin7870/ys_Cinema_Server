<h3>:movie_camera:영화예매 어플</h3>
<hr>
<p>영화 예매 어플 서비스
Server</p>
<br>
<h3>1.제작 기간 & 참여 인원</h3>
<hr>
<ul>
  <li>개발 기간: 2022.03.08 ~ 2022.05.31</li>
  <li>총 5명 중 3명 서버</li>
</ul>
<br>
<h3>2.Back-End 사용 기술</h3>
<hr>
<p>
   <ul>
      <li>Java 11</li>
      <li>Java Spring Boot</li>
      <li>JPA</li>
      <li>Oracle</li>
      <li>Swagger</li>
      <li>Maven</li>
      <li>Thymeleaf</li>
   </ul>
   <br>
   <h3>3. ERD 설계</h3>
   <hr>
   <img width="461" src="https://user-images.githubusercontent.com/73753121/210053968-7ac4cd2f-a388-4a1c-a46f-0e998ab7f760.png"/>
</p>
<br>
    <h3>4. Swagger Api 문서</h3>
    <hr>
    <img width="461" src="https://user-images.githubusercontent.com/73753121/210088205-9a3a0ce3-4e18-47db-bbfc-83cf117d37cb.png"/>    
<h3>5. 핵심 기능</h3>
<hr>
<p>이 어플 서비스 핵심 기능은 영화 예매 기능 입니다. <br>
   그 외 음식 주문, 회원, 비회원, 상영 영화 정보, 댓글 기능들이 있습니다.<br>
   일반 영화관 어플 처럼 비슷하게 만들어 보고 싶었습니다.
</p>
<details>
    <summary>핵심 기능 설명 보기</summary><br>
  <h4>5.1 전체 흐름</h4> 
    <img width="461" src="https://user-images.githubusercontent.com/73753121/210095351-dd3ab35a-c23c-4a67-ab2e-f1d35c36de5e.png"/>   
    <br>
  <h4>5.2 Controller</h4> 
    <img width="461" src="https://user-images.githubusercontent.com/73753121/210096934-6573bb7d-0c1e-47e7-b16d-fd89503f223c.png"/>
    <p>Rest Api를 사용했습니다.  <a href="https://github.com/yeongmin7870/ys_Cinema_Server/blob/e598e5dab0b38d1478db86b35c204b23c92f35a5/TheaterApp/src/main/java/com/example/demo/theater/controller/ReservationController.java#L21">:white_check_mark: 코드보기</a>   
    </p>       
   <ul>
      <li> UrI 자원을 만들어 사용 했습니다.</li>
      <li> 안드로이드와 HTTP 통신을 할때 rest api는 URI만 보고 무슨 자원인지 쉽게 판단 가능합니다.</li>
      <li> 어떤 HTTP method를 사용할 것인지도 알 수 있어 결론적으로 가독성이 좋았습니다.</li>        
   </ul>
    <p>Api문서를 작성했습니다.  <a href="https://github.com/yeongmin7870/ys_Cinema_Server/blob/e598e5dab0b38d1478db86b35c204b23c92f35a5/TheaterApp/src/main/java/com/example/demo/theater/controller/ReservationController.java#L22">:white_check_mark: 코드보기</a>   
    </p>  
   <ul>
      <li> Swagger는 Api 메뉴얼들을 자동생성 할 수 있어 편리했습니다.</li>
      <li> Html 문서화를 해주었기 때문에 클라이언트들과 소통하기도 수월했습니다.</li>
   </ul>
   <br>
   <h4>5.3 Dao</h4>
    <img width="461" src="https://user-images.githubusercontent.com/73753121/210123301-01363266-8853-48d7-a9e9-8a3f3ff7b7cd.png"/>   
   <br>
   <p>Repository가 제공하는 메소드를 이용했습니다.  <a href="https://github.com/yeongmin7870/ys_Cinema_Server/blob/a15e337322b181487579431220702265b7b3f72c/TheaterApp/src/main/java/com/example/demo/theater/dao/ReservationDaoService.java#L49">:white_check_mark: 코드보기</a>   
    </p>  
   <ul>
      <li> 반복적인 Insert문 쿼리를 써야 했던 것을 Repository 인터페이스가 대신 작성해주어 코드양이 줄었습니다.</li>
   </ul>
   <p>JPQL을 사용했습니다.  <a href="https://github.com/yeongmin7870/ys_Cinema_Server/blob/a15e337322b181487579431220702265b7b3f72c/TheaterApp/src/main/java/com/example/demo/theater/dao/ReservationDaoService.java#L53">:white_check_mark: 코드보기</a>   
    </p>  
   <ul>
      <li> Query method를 사용하면 되지만 구현할때 JPA에 대한 공부가 부족했고 대안으로 JPQL을 사용했습니다.</li>
   </ul>
  <br>
   <h4>5.4 Repository</h4>
    <img width="461" src="https://user-images.githubusercontent.com/73753121/210124139-30746983-039e-4ab2-8a53-af01c8e635ed.png"/>   
   <br>
   <p>JPQL을 사용했습니다.  <a href="https://github.com/yeongmin7870/ys_Cinema_Server/blob/71e7922715ca475df26a467c42f68340245fa682/TheaterApp/src/main/java/com/example/demo/theater/repository/ReservationRepository.java#L17">:white_check_mark: 코드보기</a>   
    </p>  
   <ul>
      <li> 조인같은 경우에는 쿼리문 JPQL를 사용했습니다.</li>
   </ul>
   <h4>5.5 Vo</h4>
    <img width="461" src="https://user-images.githubusercontent.com/73753121/210123261-5672a9ab-e73f-46ec-a2b6-187a73524583.png"/>   
   <br>
   <p>엔티티 설정을 해줬습니다.  <a href="https://github.com/yeongmin7870/ys_Cinema_Server/blob/73d02369f7e475c9dd6bde617d5c8089bc4bd566/TheaterApp/src/main/java/com/example/demo/theater/vo/Reservation.java#L9">:white_check_mark: 코드보기</a>   
    </p>  
   <ul>
      <li>object와 RDB를 Mapping 시켜주어 반복적인 코드를 줄일 수 있었습니다.</li>
      <li>초기 설계 때 라서 디비가 꼬이면 서버에서 crate,drop을 할 수 있어서 편했습니다.</li>
   </ul>
  </details>
<h3>6. 맞닥 뜨린 문제점</h3>
<hr>
<h3>7. 느낀 점</h3>
<hr>
<p>혼자 공부해서 Spring Boot 프레임워크를 이용한 서버를 구축해 보았는데 ORM 이기 때문에 디비에 타입이나 이름만 바꿔줘도 <br>
   서버 오류가 나는 경우가 있었고 바로 바로 서버도 수정을 해줘야 하기 때문에 처음 설계를 꼼꼼하게 잘해야 하겠다 라는 생각이 들었습니다.<br>
   <br><br>
   부족했던 프로젝트 라고 생각하지만 jpa가 어떻게 돌아가는지 알게 되었습니다.
</p>



