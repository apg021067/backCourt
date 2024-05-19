<h1>BACK COURT</h1>
<h2>개요</h2>
<p>프로젝트 소개</p>
<ul>
  <li>Spring Framework를 이용한 농구 매칭 웹 프로젝트</li>
</ul>
<p>프로젝트 진행한 목적</p>
<ul>
  <li>기존의 불편한 농구 매칭 과정을 간편하게</li>
  <li>내 지역의 농구장 예약을 쉽고 빠르게</li>
  <li>이용자가 팀을 만들고 팀관리를 편리하게</li>
  <li>공식경기 시스템을 이용해 나와 수준이 비슷한 사람과 매칭</li>
</ul>
<p>일정</p>
<ul>
  <li>24.04.01 ~ 24.05.10</li>
</ul>
<p>개발 인원</p>
<ul>
  <li>5명</li>
</ul>
<p>주요 업무 및 성과</p>
<ol>
  <li>핵심 서비스 구현
    <ul>
      <li>관리자가 농구장을 등록,수정 하고 농구장 목록에서 사용자가 예약,결제 할수 있는 기능 구현</li>
      <li>관리자가 공식 경기 등록, 수정 하고 경기 목록에서 사용자가 예약,결제 할 수 있는 기능 구현</li>
    </ul>
  </li>
  <li>ajax 이용한 비동기 서비스 구현
    <ul>
      <li>사용자가 실시간으로 데이터를 주고받을 수 있게 하여, 보다 직관적이고 빠른 인터페이스를 제공</li>
    </ul>
  </li>
  <li>리스트 기능 리펙토링
    <ul>
      <li>기존 방식은 모든 데이터를 DB에서 받아와서 처리</li>
      <li>MyBatis DynamicSQL 사용, 필터 기능과 검색 기능의 코드 중복 제거</li>
      <li>백엔드와 프론트엔드의 코드변경 주기를 고려, 최대한 정제된 데이터를 넘기는 방향으로 변경</li>
    </ul>
  </li>
  <li>AWS EC2, Docker, Tomcat을 활용하여 서비스를 배포
  </li>
</ol>
<h2>개발 환경 및 기술</h2>
<ul>
  <li>OS : macOS Sonoma 14.4.1</li>
  <li>DB : mariaDB 11.3.2</li>
  <li>SERVER : Apache Tomcat 9.0, AWS EC2</li>
  <li>FRONTEND : JavaScript, HTML, CSS, JQuery, ajax</li>
  <li>BACKEND : JAVA, Spring Framework, MyBatis</li>
  <li>TOOL : SourceTree, STS3, DBeaver</li>
</ul>
