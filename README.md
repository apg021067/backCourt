# BACK COURT
## 프로젝트 소개
- BACK COURT는 사용자가 농구 경기에 쉽게 참여할수 있게 매칭 시켜주는 서비스 입니다.
- 사용자는 관리자가 등록한 공식경기에 참여 할 수 있으며, 다른 사용자가 등록한 게스트 모집에 참여 할 수 있습니다.
- 사용자는 관리자가 등록한 농구장을 예약 할 수 있습니다.
- 사용자는 팀을 만들고 팀장은 팀원을 관리 할 수 있습니다. 또한 팀원 모집글과 게스트 모집글을 작성 할 수 있습니다.
- 관리자는 농구장을 등록, 수정 할 수 있고 등록한 농구장을 이용해 공식경기를 등록 할 수 있습니다.
- 각각 목록들은 필터, 페이징, 검색을 할 수 있습니다.

### 프로젝트 진행한 목적
- 기존의 불편한 농구 매칭 과정을 간편하게
- 내 지역의 농구장 예약을 쉽고 빠르게
- 이용자가 팀을 만들고 팀관리를 편리하게
- 공식경기 시스템을 이용해 나와 수준이 비슷한 사람과 매칭

### 일정
- 24.04.01 ~ 24.05.10

### Team  
|<img src="https://avatars.githubusercontent.com/u/157499897?v=4" width="150" height="150"/>|<img src="https://avatars.githubusercontent.com/u/167273720?v=4" width="150" height="150"/>|<img src="https://avatars.githubusercontent.com/u/77182293?v=4" width="150" height="150"/>|<img src="https://avatars.githubusercontent.com/u/167273795?v=4" width="150" height="150"/>|<img src="https://avatars.githubusercontent.com/u/63435073?v=4" width="150" height="150"/>|
|:-:|:-:|:-:|:-:|:-:|
|[@apg021067](https://github.com/apg021067)|[@min0eda](https://github.com/min0eda)|[@eogns22222](https://github.com/eogns22222)|[@tmdals9781](https://github.com/tmdals9781)|[@woo677](https://github.com/woo677)|  

### 핵심 기능
1. 회원
    - 로그인
    - 회원가입
    - 회원목록
    - 회원수정
    - 회원제제
2. 경기
    - 공식 매치 등록
    - 공식 매치 수정
    - 게스트 매치 등록
    - 게스트 매치 수정
    - 게스트 매치 제재
    - 게스트 매치 비활성화
3. 경기장
    - 경기장 등록
    - 경기장 수정
    - 경기장 제재
    - 경기장 비활성화
4. 팀
    - 팀 만들기
    - 팀원 모집글 작성
    - 게스트 모집글 작성
    - 팀원 관리

### 부가 기능
1. 신고
    - 경기장 신고
    - 게스트 모집글 신고
    - 팀원 모집글 신고
2. 찜
    - 경기장 찜
3. 내역
    - 경기 내역
    - 포인트 내역
4. 프로필
    - 내 정보
    - 제재 내역
    - 보유 포인트

## ERD
![백코트](https://github.com/apg021067/backCourt/assets/157499897/c8e5dab3-7597-488d-855a-9d866159ed11)

## 개발 환경 및 기술
- OS : macOS Sonoma 14.4.1
- DB : mariaDB 11.3.2
- SERVER : Apache Tomcat 9.0, AWS EC2
- FRONTEND : JavaScript, HTML, CSS, JQuery, ajax
- BACKEND : JAVA, Spring Framework, MyBatis
- TOOL : SourceTree, STS3, DBeaver

## 접속
- 123.456.78.9
- 관리자 ID : admin PW : pass
- 사용자 ID : user1 PW : pass
