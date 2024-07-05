# WeatherPrj
## 날씨에 따른 옷매칭 애플리케이션
- 공공데이터 포탈 API와 OpenAI(ChatGPT)를 연동하여 API자료를 바탕으로 날씨에 적절한 옷을 매칭시켜주는 프로그램

## 1일차
- 깃허브 Organization 리포지토리 만들기
    1. 프로필 > Your orgnizations 클릭
    2. New organization 클릭
    3. Create a free organization 선택
    4. Organization name, Contact email 작성 

    <img src="https://github.com/Pknu-TeamPrj/WeatherPrj/blob/main/image/img001.png" width="730">

    5. My personal account > Next
    6. Add organization members에서 추가할 계정 입력 > Complete setup 클릭
    7. 조직 생성자가 개인 리포지토리와 동일하게 리포지포리 생성

- 깃허브 팀원 브랜치 생성
    1. 생성자가 먼저 리드미 작업후 커밋 및 푸시 진행
    2. 팀원이 Github Desktop에서 Current branch 탭에서 브런치 생성

    <img src="https://github.com/Pknu-TeamPrj/WeatherPrj/blob/main/image/img002.png" width="730">

    3. Publish your branch 클릭
    4. 팀원 브런치에서 작업 후 커밋 후 푸시
    5. 팀원이 Create Pull Request를 클릭 후 깃허브 사이트로 이동하여 Merge Request 요청 후 Confirm하면 Merge 완료

    <img src="https://github.com/Pknu-TeamPrj/WeatherPrj/blob/main/image/img004.png" width="730">


- 공공데이터포탈에서 API 받아서 연동하기
    - [공공데이터포털](https://www.data.go.kr/index.do) 에서 기상청_단기예보 ((구)_동네예보) 조회서비스 API 활용 신청

    <img src="https://github.com/Pknu-TeamPrj/WeatherPrj/blob/main/image/img003.png" width="730">

    - 샘플코드를 활용하여 API 값 받아오기
    - /controller/WeatherController.java 생성 후 GetMapping 메서드 작성
    - /templates/weather.html에 샘플 javascript 함수작성 후 버튼으로 값이 들어오는 지 테스트

    <img src="https://github.com/Pknu-TeamPrj/WeatherPrj/blob/main/image/img005.png" width="730">

## 2일차
- 회원기능 및 로그인 기능 추가
    - Member entity, Repository, Controller 파일 추가
    - MemberController에 로그인과 회원가입 GetMapping와 PostMapping메서드 작성
    - 데이터를 보내기 위해서 UserDto를 생성
    - 회원가입과 로그인 HTML파일(join.html, login.html) 생성

    <img src="https://github.com/Pknu-TeamPrj/WeatherPrj/blob/main/image/loginJoinImg001.png" width="730">

    - CSS파일을 추가하여 꾸미기

    <img src="https://github.com/Pknu-TeamPrj/WeatherPrj/blob/main/image/loginJoinImg002.gif" width="730">


- 게시판 및 게시글 작성 추가
    - Board Controller 파일추가
    - board.html, write.html 파일추가

    <img src="https://github.com/Pknu-TeamPrj/WeatherPrj/blob/main/image/boardImg001.png" width="730">
