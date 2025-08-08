-- 1.product 테이블에 숫자 값을 갖는 prdStock과 제조일을 나타내는 prdDate 열 추가
ALTER TABLE product ADD (prdStock NUMBER(8), prdDate DATE);

-- 2.product 테이블의 prdCompany 열 기본 추가해서 을 NOT NULL로 변경
ALTER TABLE product ADD prdCompany VARCHAR2(20);
ALTER TABLE product MODIFY prdCompany VARCHAR2(20) NOT NULL;

-- 3.publisher 테이블에 pubPhone, pubAddress 열 추가
ALTER TABLE publisher ADD (pubPhone VARCHAR2(20), pubAddress VARCHAR2(30));

-- 4.publisher 테이블에서 pubPhone 열 삭제
ALTER TABLE publisher DROP COLUMN pubPhone;


-- INSERT 연습 문제
-- 1. 속성과 값을 모두 나열
INSERT INTO STUDENT (STDNO, STDNAME, STDYEAR, STDBIRTHDAY, DPTNO)
VALUES ('2016001', '홍길동', 4, '1997-01-01', 1);

INSERT INTO STUDENT (STDNO, STDNAME, STDYEAR, STDBIRTHDAY, DPTNO)
VALUES ('2015002', '성춘향', 3, '1996-12-10', 3);

INSERT INTO STUDENT (STDNO, STDNAME, STDYEAR, STDBIRTHDAY, DPTNO)
VALUES ('2014004', '이몽룡', 2, '1996-03-03', 2);

INSERT INTO STUDENT (STDNO, STDNAME, STDYEAR, STDBIRTHDAY, DPTNO)
VALUES ('2016002', '변학도', 4, '1995-05-07', 1);

INSERT INTO STUDENT (STDNO, STDNAME, STDYEAR, STDBIRTHDAY, DPTNO)
VALUES ('2015003', '손흥민', 3, '1997-11-11', 2);

-- 2. 값만 나열
INSERT INTO STUDENT
VALUES ('2016001', '홍길동', 4, '1997-01-01', 1);

INSERT INTO STUDENT
VALUES ('2015002', '성춘향', 3, '1996-12-10', 3);

INSERT INTO STUDENT
VALUES ('2014004', '이몽룡', 2, '1996-03-03', 2);

INSERT INTO STUDENT
VALUES ('2016002', '변학도', 4, '1995-05-07', 1);

INSERT INTO STUDENT
VALUES ('2015003', '손흥민', 3, '1997-11-11', 2);

-- 3. 전체를 한번에
INSERT INTO STUDENT (STDNO, STDNAME, STDYEAR, STDBIRTHDAY, DPTNO)
VALUES ('2016001', '홍길동', 4, '1997-01-01', 1),
       ('2015002', '성춘향', 3, '1996-12-10', 3),
       ('2014004', '이몽룡', 2, '1996-03-03', 2),
       ('2016002', '변학도', 4, '1995-05-07', 1),
       ('2015003', '손흥민', 3, '1997-11-11', 2);

SELECT *
FROM STUDENT;

--------------------------------------------------------------------------------

-- 1. book 테이블에 다음과 같이 행 삽입
INSERT INTO book (BOOKNO, BOOKNAME, BOOKPRICE, BOOKDATE, PUBNO)
VALUES (6, 'JAVA 프로그래밍', 30000, '2021-03-10', 1);
INSERT INTO book (BOOKNO, BOOKNAME, BOOKPRICE, BOOKDATE, PUBNO)
VALUES (7, '파이썬 데이터 과학', 24000, '2018-02-05', 2);

-- 2.  도서명이 '데이터베이스'인 행의 가격 변경
UPDATE book
SET BOOKPRICE = 22000
WHERE BOOKNAME = '데이터베이스';

-- 3. 발행일이 2018년도인 행 삭제
DELETE FROM book
WHERE BOOKDATE BETWEEN '2018-01-01' AND '2018-12-31';

--------------------------------------------------------------------------------

-- 종합 연습문제 
-- 1. cutomer 테이블 생성
CREATE TABLE customer(
    CUSTNO VARCHAR2(10) PRIMARY KEY,
    CUSTNAME VARCHAR2(50),
    CUSTPHONE VARCHAR2(20),
    CUSTADDRESS VARCHAR2(100),
    CUSTGENDER VARCHAR2(10),
    CUSTAGE NUMBER(3)
);

-- 2. orderProduct 테이블 생성
CREATE TABLE orderProduct(
    ORDERNO VARCHAR2(10) PRIMARY KEY,
    ORDERDATE DATE,
    ORDERQTY NUMBER,
    CUSTNO VARCHAR2(10) REFERENCES customer(CUSTNO),
    PRDNO VARCHAR2(10) REFERENCES PRODUCT7(PRDNO)
);

-- 3. 고객 테이블 CUSTPHONE 열 NOT NULL 변경
ALTER TABLE customer
MODIFY CUSTPHONE VARCHAR2(20) NOT NULL;

-- 4. 고객 테이블 CUSTGENDER, CUSTAHE 열 추가 (생성 시에 만들었음)
-- ALTER TABLE customer
-- ADD (CUSTGENDER VARCHAR2(10), CUSTAGE NUMBER(3));

-- 5. 고객, 주문 테이블에 데이터 삽입
INSERT ALL
    INTO customer (CUSTNO, CUSTNAME, CUSTPHONE, CUSTADDRESS, CUSTGENDER, CUSTAGE)
    VALUES ('1001', '홍길동', '010-1111-1111', '강원도 평창', '남', 22)
    INTO customer (CUSTNO, CUSTNAME, CUSTPHONE, CUSTADDRESS, CUSTGENDER, CUSTAGE)
    VALUES ('1002', '이몽룡', '010-2222-2222', '서울 종로구', '남', 23)
    INTo customer (CUSTNO, CUSTNAME, CUSTPHONE, CUSTADDRESS, CUSTGENDER, CUSTAGE)
    VALUES ('1003', '성춘향', '010-3333-3333', '서울시 강남구', '여', 22)
SELECT * FROM dual;

INSERT ALL
    INTO orderProduct (ORDERNO, ORDERDATE, ORDERQTY, CUSTNO, PRDNO)
    VALUES ('1', '2018-01-10', 3, '1003', '3') 
    INTO orderProduct (ORDERNO, ORDERDATE, ORDERQTY, CUSTNO, PRDNO)
    VALUES ('2', '2018-03-03', 1, '1001', '7')
    INTO orderProduct (ORDERNO, ORDERDATE, ORDERQTY, CUSTNO, PRDNO)
    VALUES ('3', '2018-04-05', 3, '1002', '2')
SELECT * FROM dual;

-- 6. 주문 테이블에서 ORDERNO 2인 행의 ORDERQTY를 3으로 수정
UPDATE orderProduct
SET ORDERQTY = 3
WHERE PRDNO = '2';

--------------------------------------------------------------------------------
       
-- 1.고객 테이블에서 고객명, 생년월일, 성별 출력
SELECT CLIENTNAME, CLIENTBIRTH, CLIENTGENDER
FROM CLIENT;

-- 2.고객 테이블에서 주소만 검색하여 출력 (중복되는 튜플은 한번만 출력)
SELECT DISTINCT CLIENTADDRESS
FROM CLIENT;

-- 3.고객 테이블에서 취미가 '축구'이거나 '등산'인 고객의 고객명, 취미 출력
SELECT DISTINCT CLIENTNAME, CLIENTHOBBY FROM CLIENT
WHERE CLIENTHOBBY IN ('축구', '등산');

-- 4.도서 테이블에서 저자의 두 번째 위치에 '길'이 들어 있는 저자명 출력 (중복되는 튜플은 한번만 출력)
SELECT DISTINCT BOOKAUTHOR FROM BOOK
WHERE BOOKAUTHOR LIKE '_길%';

-- 5.도서 테이블에서 발행일이 2018년인 도서의 도서명, 저자, 발행일 출력
SELECT BOOKNAME, BOOKAUTHOR, BOOKDATE FROM BOOK
WHERE BOOKDATE BETWEEN '2018-01-01' AND '2018-12-31';

-- 6.도서판매 테이블에서 고객번호1, 2를 제외한 모든 튜플 출력
SELECT * FROM BOOKSALE
WHERE CLIENTNO NOT IN ('1','2');

-- 7.고객 테이블에서 취미가 NULL이 아니면서 주소가 '서울'인 고객의 고객명, 주소, 취미 출력   
SELECT CLIENTNAME, CLIENTADDRESS, CLIENTHOBBY FROM CLIENT
WHERE CLIENTHOBBY IS NOT NULL AND CLIENTADDRESS = '서울'; 
