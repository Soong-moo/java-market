# java-market

상품 조회, 상품 입력 및 삭제 등 마트 프로그래밍

1. 상품 조회, 입력, 삭제

2. HashMap -> ArrayList 변경, 경고 표시 생성 #상품 조회 시 상품이 없으면 경고 표시 작성 필요

3. 경고 표시 완료, ProductList 추가, 상품 등록 수정

4-1. ProductManagement 생성 (addProduct, showProduct .. 등 옮김), 가격 음수 확인 메소드 추가

4-2. reviseProduct 추가

5. File I/O 사용한 ProductFile 생성, 기존 코드 수정

6-1. DB Package 추가 및 연동(MySQL)

6-2. 상품 조회, 입력, 삭제, 수정, 가격 찾기 DB 연동한 SQL문 코드 작성 완료

7. 전체 코드 수정, ArrayList인 productList 삭제, 이름 중복 검증 메소드 Product의 compareName() => Product의 compare(), DBManagement의 compare() 수정

기능 추가 예정
