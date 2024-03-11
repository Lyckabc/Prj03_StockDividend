# README

[https://github.com/Lyckabc/Prj03_StockDividend](https://github.com/Lyckabc/Prj03_StockDividend)

# 📝 [Prj03_StockDividend](https://github.com/Lyckabc/Prj03_StockDividend)

## 🔮 과제 시나리오

[Chapter All_resize.pdf](README%4862/Chapter_All_resize.pdf)

## ⭐ 필수 준수사항

**1. 중요**

- [x]  ✅ 웹 페이지를 분석하고 스크래핑 기법을 활용하여 필요한 데이터를 추출/저장합니다.
- [x]  ✅ 사용자별 데이터를 관리하고 예상 배당금 액수를 계산할 수 있습니다.
- [x]  ✅ 서비스에서 캐시의 필요성을 이해하고 캐시 서버를 구성합니다.

**2. 기술스택**

- Spring Boot, Java, JPA, H2, Redis, Jsoup, Docker

**3. 최종 구현 API 리스트**

- 1) GET - finance/dividend/{companyName}
    - [x]  회사 이름을 인풋으로 받아서 해당 회사의 메타 정보와 배당금 정보를 반환
    - [x]  잘못된 회사명이 입력으로 들어온 경우 400 status 코드와 에러메시지 반환
    - error message
        
        ```c
        {
            "code": 400,
            "message": "존재하지 않는 회사명 입니다."
        }
        ```
        
- 2) GET - company/autocomplete
    - [x]  자동완성 기능을 위한 API
    - [x]  검색하고자 하는 prefix 를 입력으로 받고, 해당 prefix 로 검색되는 회사명 리스트 중 10개 반환
- 3) GET - company
    - [x]  서비스에서 관리하고 있는 모든 회사 목록을 반환
    - [x]  반환 결과는 Page 인터페이스 형태
- 4) POST - company
    - [x]  새로운 회사 정보 추가
    - [x]  추가하고자 하는 회사의 ticker 를 입력으로 받아 해당 회사의 정보를 스크래핑하고 저장
    - [x]  이미 보유하고 있는 회사의 정보일 경우 400 status 코드와 적절한 에러 메시지 반환
    - Error message
        
        ```c
        {
            "code": 400,
            "message": "이미 존재하는 회사명입니다."
        }
        ```
        
    - [ ]  존재하지 않는 회사 ticker 일 경우 400 status 코드와 적절한 에러 메시지 반환
- 5) DELETE - company/{ticker}
    - [x]  ticker 에 해당하는 회사 정보 삭제
    - [x]  삭제시 회사의 배당금 정보와 캐시도 모두 삭제되어야 함
- 6) POST - auth/signup
    - [x]  회원가입 API
    - [x]  중복 ID 는 허용하지 않음
    - [x]  패스워드는 암호화된 형태로 저장되어야함
- 7) POST - auth/signin
    - [x]  로그인 API
    - [x]  회원가입이 되어있고, 아이디/패스워드 정보가 옳은 경우 JWT 발급
- **4. 프로젝트 진행에 꼭 챙겨야하는 부분들!**
    - [x]  ✅ spring boot 로 프로젝트 세팅하기
    - [x]  ✅ h2 인메모리 데이터베이스 연동하기
    - [x]  ✅ yahoo 파이낸스 데이터 스크래핑하기
    - [x]  ✅ DB table 모델링 및 연관관계 매핑하기
    - [x]  ✅ 스크래핑한 데이터를 적절한 형태로 DB 에 저장하기
    - [x]  ✅ POST /company API 구현
    - [x]  ✅ GET /finance/dividend/{companyName} API 구현
    - [x]  ✅ GET /company/autocomplete API 구현
    - [x]  ✅ GET /company API 구현
    - [x]  ✅ DELETE /company/{ticker} API 구현
    - [x]  ✅ 레디스 서버 구성하기
    - [x]  ✅ 레디스에 데이터 캐싱/삭제하기
    - [x]  ✅ 적합한 로그레벨로 필요한 로그 남기기
    - [x]  ✅ ControllerAdvice 에서 에러 처리하기

## 🌟  추가 기능

- [x]  ✅ [README.md](http://README.md) 파일 추가
- [ ]  ✅ API DOC (SWEGER 추가)

## 📄 Reference
