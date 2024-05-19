# BACK COURT
## 프로젝트 소개
- Spring Framework를 사용한 농구 매칭 웹 서비스

## 프로젝트 진행한 목적
- 기존의 불편한 농구 매칭 과정을 간편하게
- 내 지역의 농구장 예약을 쉽고 빠르게
- 이용자가 팀을 만들고 팀관리를 편리하게
- 공식경기 시스템을 이용해 나와 수준이 비슷한 사람과 매칭
  
## 일정
- 24.04.01 ~ 24.05.10
  
## Team  
|<img src="https://avatars.githubusercontent.com/u/157499897?v=4" width="150" height="150"/>|<img src="https://avatars.githubusercontent.com/u/167273720?v=4" width="150" height="150"/>|<img src="https://avatars.githubusercontent.com/u/77182293?v=4" width="150" height="150"/>|<img src="https://avatars.githubusercontent.com/u/167273795?v=4" width="150" height="150"/>|<img src="https://avatars.githubusercontent.com/u/63435073?v=4" width="150" height="150"/>|
|:-:|:-:|:-:|:-:|:-:|
|[@apg021067](https://github.com/apg021067)|[@min0eda](https://github.com/min0eda)|[@eogns22222](https://github.com/eogns22222)|[@tmdals9781](https://github.com/tmdals9781)|[@woo677](https://github.com/woo677)|  

## 주요 업무 및 성과
- 핵심 서비스 구현
  - 관리자가 농구장을 등록,수정 하고 농구장 목록에서 사용자가 예약,결제 할수 있는 기능 구현
  - 관리자가 공식 경기 등록, 수정 하고 경기 목록에서 사용자가 예약,결제 할 수 있는 기능 구현
- ajax 이용한 비동기 서비스 구현
  - 사용자가 실시간으로 데이터를 주고받을 수 있게 하여, 보다 직관적이고 빠른 인터페이스를 제공
- 리스트 기능 리펙토링
  - 기존 방식은 모든 데이터를 DB에서 받아와서 처리
  - MyBatis DynamicSQL 사용, 필터 기능과 검색 기능의 코드 중복 제거
  - 백엔드와 프론트엔드의 코드변경 주기를 고려, 최대한 정제된 데이터를 넘기는 방향으로 변경
- AWS EC2, Docker, Tomcat을 활용하여 서비스를 배포

## 개발 환경 및 기술
- OS : macOS Sonoma 14.4.1
- DB : mariaDB 11.3.2
- SERVER : Apache Tomcat 9.0, AWS EC2
- FRONTEND : JavaScript, HTML, CSS, JQuery, ajax
- BACKEND : JAVA, Spring Framework, MyBatis
- TOOL : SourceTree, STS3, DBeaver
