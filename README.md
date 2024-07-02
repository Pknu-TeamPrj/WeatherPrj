# WeatherPrj
## 날씨에 따른 옷매칭 애플리케이션
- 공공데이터 포탈 API와 OpenAI(ChatGPT)를 연동하여 API자료를 바탕으로 날씨에 적절한 옷을 매칭시켜주는 프로그램

## 1일차
- 깃허브 Organization 리포지토리 만들기
    1. 프로필 > Your orgnizations 클릭
    2. New organization 클릭
    3. Create a free organization 선택
    4. Organization name, Contact email 작성 

    <img src="https://github.com/Pknu-TeamPrj/WeatherPrj/blob/main/image/img001.png">

    5. My personal account > Next
    6. Add organization members에서 추가할 계정 입력 > Complete setup 클릭
    7. 조직 생성자가 개인 리포지토리와 동일하게 리포지포리 생성

- 깃허브 팀원 브랜치 생성
    1. 생성자가 먼저 리드미 작업후 커밋 및 푸시 진행
    2. 팀원이 Github Desktop에서 Current branch 탭에서 브런치 생성

    <img src="https://github.com/Pknu-TeamPrj/WeatherPrj/blob/main/image/img002.png">

    3. Publish your branch 클릭
    4. 팀원 브런치에서 작업 후 커밋 후 푸시
    5. 팀원이 Create Pull Request를 클릭 후 깃허브 사이트로 이동하여 Merge Request 요청 후 Confirm하면 Merge 완료

    <img src="https://github.com/Pknu-TeamPrj/WeatherPrj/blob/main/image/img004.png">


- 공공데이터포탈에서 API 받아서 연동하기
    - [공공데이터포털](https://www.data.go.kr/index.do) 에서 기상청_단기예보 ((구)_동네예보) 조회서비스 API 활용 신청

    <img src="https://github.com/Pknu-TeamPrj/WeatherPrj/blob/main/image/img003.png">

    - 샘플코드를 활용하여 API 값 받아오기
    - /controller/WeatherController.java 생성 후 GetMapping 메서드 작성
    - /service/WeatherprjApplication.java 생성 후 테스트용 실행 메서드 작성
    - /templates/weather.html에 샘플 javascript 함수작성 후 버튼으로 값이 들어오는 지 테스트

    <img src="https://github.com/Pknu-TeamPrj/WeatherPrj/blob/main/image/img005.png">



