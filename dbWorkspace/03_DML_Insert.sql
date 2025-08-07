-- 데이터 조작어
-- 데이터 입력/삭제/수정/검색
-- INSERT문 : 테이블에 데이터(튜플)을 저장하는 조작
-- INSERT INTO 테이블명(열이름 리스트) VALUES(값 리스트) : 부분열만 저장 가능 - NULL 허용하는 열의 값은 생략해도 됨
-- INSERT INTO 테이블명 VALUES(값 리스트) : 값 리스트에 모든열의 값이 테이블 생성 시 순서에 맞춰 나열되어야 함

-- STUDENT 테이블에 행 삽입
INSERT INTO STUDENT (STDNO, STDNAME, STDYEAR, DPTNO)
VALUES('2016005', '변학도', 4, '1');
-- 값 문자열일때는 ' ' 표시

-- 출판사 테이블 생성(앞에서 삭제함)
CREATE TABLE publisher (
 pubNo VARCHAR(10) NOT NULL PRIMARY KEY,
   pubName VARCHAR(30) NOT NULL
 );
-- INSERT 문
-- publisher 테이블에 데이터 입력
INSERT INTO publisher (pubNo, pubName) VALUES('1', '서울 출판사');
INSERT INTO publisher (pubNo, pubName) VALUES('2', '강남 출판사');
INSERT INTO publisher (pubNo, pubName) VALUES('3', '종로 출판사');
-- publisher 테이블 내용 조회
SELECT * FROM publisher;
-- * : ALL : 모든 열 (pubNo, pubName)