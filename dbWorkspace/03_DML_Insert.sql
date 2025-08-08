-- 데이터 조작어(DML)
-- 데이터 입력/삭제/수정/검색
-- INSERT : 테이블의 데이터(튜플)을 저장하는 조작을 진행
-- INSERT INTO 테이블명(열이름 리스트) VALUES(값 리스트) : 부분열만 저장 가능 - NULL 허용하는 열의 값은 생략해도 됨
-- INSERT INTO 테이블명 VALUES(값 리스트) : 값 리스트에 모든 열의 값이 순서에 맞춰서 존재해야 함

-- STUDENT 테이블에 행 삽입 -- 열 이름 리스트 나열하면 열 순서 상관없음, 값 순서는 나열한 열 순서와 동일 해야함
INSERT INTO STUDENT(stdNo, stdGrade, stdName, dptNo)
values('2016005', 3, '홍길동', 2); 
-- 값 문자열일때는 ' ' 표시

-- 열 나열 없이 실제 값만 나열 : 단, 모든 필드의 값이 다 나열되어야 함
INSERT INTO STUDENT
VALUES('2016006', 4, '홍길동', 서울, '2020-01-01',1);


-- 1. PUBNO: 101, PUBNAME: '한빛미디어', PUBADDRESS: '서울시 마포구'
INSERT INTO C##SQL_USER1.PUBLISHER (PUBNO, PUBNAME, PUBADDRESS)
VALUES (1, '한빛미디어', '서울시 마포구');

-- 2. PUBNO: 102, PUBNAME: '길벗', PUBADDRESS: '서울시 종로구'
INSERT INTO C##SQL_USER1.PUBLISHER (PUBNO, PUBNAME, PUBADDRESS)
VALUES (2, '길벗', '서울시 종로구');

-- 3. PUBNO: 103, PUBNAME: '프리렉', PUBADDRESS: NULL
INSERT INTO C##SQL_USER1.PUBLISHER (PUBNO, PUBNAME, PUBADDRESS)
VALUES (3, '프리렉', NULL);


-- BOOK 테이블에 데이터 저장



-- SELECT EX
SELECT BOOKNAME FROM BOOK WHERE BOOKNO='1';

-- 여러개의 DATA(튜플)를 저장 : INSERT ALL INTO 테이블명 () VALUES () INTO 테이블명...

INSERT ALL
    INTO BOOK VALUES('6','데이터베이스',35000,'2021-05-12','2')
    INTO BOOK VALUES('7','알고리즘',35000,'2021-05-12','1')
SELECT * 
FROM DUAL;

-- 시퀀스
-- 오라클 데이터베이스 객체로 유일한 값의 일련번호 생성
-- 지정한 수치로 증가하거나 감소
-- 기본키에 자동증가값을 사용할 때 유용
-- 최대 15개 가지 생성 가능
-- 테이블과 독립적으로 저장 생성
-- 하나의 시퀀스 여러 테이블에서 사용 가능

-- 시퀀스 생성 : create sequence 시퀀스명 옵션
CREATE SEQUENCE NO_SEQ
    START WITH 1
    INCREMENT BY 1
    MAXVALUE 10000
    MINVALUE 1
    NOCYCLE;
    
CREATE TABLE  board(
    bNo NUMBER PRIMARY KEY,
    bSubject VARCHAR2(30) NOT NULL,
    bname   VARCHAR2(20) NOT NULL
    );
    
-- 데이터 추가
INSERT INTO BOARD VALUES(NO_SEQ.NEXTVAL, '추석','홍길동');
INSERT INTO BOARD VALUES(NO_SEQ.NEXTVAL, '미세먼지', '홍길동');
INSERT INTO BOARD VALUES(NO_SEQ.NEXTVAL, '휴가', '홍길동');

SELECT * FROM BOARD;

-- 시퀀스 값 검색
SELECT NO_SEQ.CURRVAL FROM DUAL;

-- 시퀀스 수정
ALTER SEQUENCE NO_SEQ
    MAXVALUE 1000;
    
-- 수정 결과 검색 : 구조에 대한 검색, 시퀀스 정보 저장 테이블 USER_SEQUENCES
SELECT SEQUENCE_NAME, MAX_VALUE
FROM USER_SEQUENCES;

-- 시퀀스 삭제 : DROP SEQUENCE 시퀀스명
DROP SEQUENCE NO_SEQ;

-- 삭제 확인
SELECT SEQUENCE_NAME FROM USER_SEQUENCES; -- 삭제해서 빈 테이블 반환

-- DUAL 테이블
-- 오라클 자체에서 제공되는 테이블
-- 1개의 행과 1개의 열만 있는 더미테이블
-- SYS 소유지만 모든 사용자가 사용 가능
-- 간단한 함수 계산결과값 확인할 때 테이블 생성 없이 결과값 확인(리턴받을 수 있음)
SELECT CURRENT_DATE FROM DUAL;

--------------------------------------------------------------------------------
-- 데이터 임포트
-- 텍스트 파일을 읽어서 테이블 생성 및 데이터 구성 PRODEUCT7

-- 데이터 임포트 후 제약조건 추가
ALTER TABLE PRODUCT7
    ADD CONSTRAINT PK_PRODUCT_PRDNO1
    PRIMARY KEY(PRDNO);
