-- 테이블 생성
-- 동일DB(동일계정)에 동일명 테이블이 있으면 안됨
-- 기본키 제약조건
-- 1. 속성 설정 시 기본키 지정
CREATE TABLE product(
    prdNo VARCHAR2(10) NOT NULL PRIMARY KEY,
    prdNAME VARCHAR2(30) NOT NULL,
    prdPRICE NUMBER(8),
    prdCOMPANY VARCHAR2(30)
);

--2. 기본키 따로 설정 : primary key(기본키 필드명)
CREATE TABLE product(
    prdNo VARCHAR2(10) NOT NULL ,
    prdNAME VARCHAR2(30) NOT NULL,
    prdPRICE NUMBER(8),
    prdCOMPANY VARCHAR2(30),
    PRIMARY KEY(prdNo)
);

-- 3. 제약 이름과 같이 설정 : 제약 변경이나 삭제 시 유용함 ->CONSTRAINT PK_product_prdNo PRIMARY KEY
CREATE TABLE product(
    prdNo VARCHAR2(10) NOT NULL CONSTRAINT PK_product_prdNo PRIMARY KEY,
    prdNAME VARCHAR2(30) NOT NULL,
    prdPRICE NUMBER(8),
    prdCOMPANY VARCHAR2(30)
);

--4. 따로 설정 제약명 추가
CREATE TABLE product2(
    prdNo VARCHAR2(10) NOT NULL ,
    prdNAME VARCHAR2(30) NOT NULL,
    prdPRICE NUMBER(8),
    prdCOMPANY VARCHAR2(30),
    CONSTRAINT PK_product_prdNo PRIMARY KEY(prdNo)
);

-----------------------------------------------------------------------
-- 출판사 테이블 먼저 생성하고 도서 테이블 생성(외래키 참조필드)
-- 외래키 필드에 입력되는 값은 참조테이블의 기본키로서 값과 동일해야 함
-- 외래키 필드의 도메인과 참조테이블의 기본키 도메인은 동일해야 함
-- 테이블 삭제시에는 생성과 반대로 참조하는 book을 먼저 삭제하고 참조되는 publisher를 삭제
/* 출판사 테이블 생성(출판사 번호, 출판사명)
제약조건
- 기본키 not null
*/

CREATE TABLE publisher(
    pubNo VARCHAR2(10) NOT NULL PRIMARY KEY,
    pubName VARCHAR2(30) NOT NULL
);

/*
도서 테이블(도서번호, 도서명, 가격, 발행일, 출판사번호)
기본키
외래키
기본값 체크조건
*/
-- 외래키 필드는 참조테이블에서는 기본키여야 함
CREATE TABLE book(
    bookNO VARCHAR2(10) NOT NULL PRIMARY KEY,
    bookNAME VARCHAR2(30) NOT NULL,
    bookPRICE NUMBER(8) DEFAULT 10000 CHECK(bookPRICE > 1000),
    bookDATE DATE,
    pubNO VARCHAR2(10) NOT NULL,
    CONSTRAINT FK_book_publisher FOREIGN KEY (pubNO) REFERENCES publisher(pubNo)
);

-- 학과 테이블
create table department (
	dptNo varchar2(10) not null primary key,
    dptName varchar2(30) not null,
    dptTel varchar2(13) not null
);

-- 학생 테이블
create table student (
	stdNo varchar2(10) not null primary key,
    stdName varchar2(30) not null,
    stdYear int default 4 check (stdYear>=1 and stdYear<=4),
    stdAddress varchar2(30),
    stdBirth date,
    dptNo varchar2(10) not null,
    foreign key (dptNo) references department(dptNo)
);

-- 교수 테이블
create table professor (
	profNo varchar2(10) not null primary key,
    profName varchar2(30) not null,
    profPosition varchar2(30),
    profTel varchar2(13),
    dptNo varchar2(10) not null,
    foreign key (dptNo) references department(dptNo)
);

-- 과목 테이블
create table course (
	courseId varchar(10) not null primary key,
    courseName varchar(30) not null,
    courseCredit int,
    profNo varchar(10) not null,
    foreign key (profNo) references professor(profNo)
);

CREATE TABLE SCORES(
    STDNO VARCHAR2(10) NOT NULL,
    COURSEID VARCHAR2(10) NOT NULL,
    SCORE NUMBER(3),
    GRADE VARCHAR2(2),
    CONSTRAINT PK_SCORES_STDNO_COURSEID PRIMARY KEY(STDNO, COURSEID),
    CONSTRAINT FK_SCORES_STUDENT FOREIGN KEY(STDNO) REFERENCES STUDENT (STDNO),
    CONSTRAINT FK_SCORES_COURSE FOREIGN KEY(COURSEID) REFERENCES COURSE (COURSEID)
);


-- 기본키 삭제 : 기본키는 반드시 있어야 하는 건 아님 단, 릴레이션 논리적 특징 유지하려면 기본키는 설정해야 함
-- 학생테이블 교수 테이블이 참조하고 있음 - 외부테이블 참조 기본키는 참조 오류로 기본키제약조건 삭제 불가
ALTER TABLE department
DROP PRIMARY KEY;

-- 제약조건(참조제약) 무시 무조건 기본키 삭제 - CASCADE
ALTER TABLE department
DROP PRIMARY KEY CASCADE;

-- 외래키 제약조건 삭제 : DROP CONSTRAINT 제약조건명
ALTER TABLE student
DROP CONSTRAINT;

-- ALTER TABLE (ADD/DROP/MODIFY/RENAME)

-- ALTER TABLE ADD : 속성추가
ALTER TABLE product ADD (prdUITPRICE NUMBER(8), prdSTOCK NUMBER(12));

-- 열의 데이터 형식 변경 :  ALTER TABLE 테이블명 MODIFY 속성명 변경타입
ALTER TABLE product MODIFY prdUITPRICE NUMBER(4); -- 데이터가 저장된 상태에서 크기 변경 진행 시 범위를 벗어나는 데이터가 있을 시 변환오류 발생

-- 열의 제약조건 NOT NULL -> NULL로 변경 MODIFY
ALTER TABLE product MODIFY PRDNAME VARCHAR2(30) NULL;

-- 열 이름 변경 ALTER TABLE 테이블 병 RENAME COLUMN 기존컬럼명 to 새 컬럼명  
ALTER TABLE product RENAME COLUMN PRDUITPRICE TO PRDUPRICE;

-- 열 삭제
ALTER TABLE product DROP COLUMN prdSTOCK;

-- 여러 열 삭제
ALTER TABLE product DROP (PRDCOMPANY, PRDUPRICE);

-- 기본키 삭제 : 기본키는 반드시 있어야 하는 건 아님 단, 릴레이션 논리적 특징 유지하려면 기본키는 설정해야 함
-- 학생테이블 교수 테이블이 참조하고 있음 - 외부테이블 참조 기본키는 참조오류로 기본키제약조건 삭제 불가
ALTER TABLE department
DROP PRIMARY KEY;

-- 제약조건(참조제약) 무시 무조건 기본키 삭제 - CASCADE
-- 참조하는 외래키 제약조건 같이 삭제 됨
ALTER TABLE department
DROP PRIMARY KEY CASCADE;

-- 제약 조건 추가 : 기본 키 추가
ALTER TABLE department
ADD CONSTRAINT PK_department_dptNO
PRIMARY KEY(dptNO);

ALTER TABLE STUDENT
ADD CONSTRAINT FK_student_department
FOREIGN KEY(dptNo) REFERENCES department(dptNO);

-- 외래키 제약조건 삭제 : DROP CONSTRAINT 제약조건명
ALTER TABLE student
DROP CONSTRAINT FK_student_department;

-- 기본키 삭제 - 참조하고 있는 다른테이블이 없으면 바로 삭제됨
ALTER TABLE department
DROP PRIMARY KEY;

-- 기본키 삭제하려고 할 때 기본키 참조하는 테이블들에 대해 참조제약조건 삭제 후 기본키 제약조건 삭제 진행
-- casecade 이용하면 강제로 모든 참조 없앰

----------------------------------------------------------------------------------------
-- 테이블 제약조건 확인 쿼리
-- 일반유저 설정 제약조건은 USER_CONSTRAINTS 테이블에 정보가 저장되어 있음
-- 일반유저는 조회 권한을 갖고 있음
SELECT * FROM USER_CONSTRAINTS; -- 해당 USER 소유 테이블의 모든 제약조건 확인
SELECT * FROM USER_CONSTRAINTS
WHERE TABLE_NAME='STUDENT'; -- 해당 USER가 소유한 STUDENT테이블의 제약조건 확인

-- 제약조건 타입
-- C : Check on a table , Check, Not Null
-- P : Primary Key
-- R : Foreign Key
----------------------------------------------------------------------------------------
ALTER TABLE department
ADD CONSTRAINT PK_department_dptNO
PRIMARY KEY(dptNO);
-- 데이터가 삭제되는 경우 삭제되는 레코드가 다른 테이블에서 참조되고 있는 경우 데이터 삭제 제약 받음
-- on delete cascade : 참조하는 테이블의 데이터도 같이 삭제 시킴
ALTER TABLE student
ADD CONSTRAINT FK_STUDENT_DEPARTMENT
FOREIGN KEY(dptNO) REFERENCES department (dptNO)
on delete cascade;


------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------
-- 테이블 삭제 : 테이블 모든 구조와 모든 데이터 삭제
-- 데이터만 삭제 : DML의 DELETE 문
-- DROP TABLE 테이블명 [PURGE|CASCADE CONSTRAINTS]
-- PURGE : 복구가능한 임시 테이블 생성하지 않고 영구히 삭제
-- CASCADE CONSTRAINTS : 제약조건 무시하고 기준 테이블을 강제 삭제, 권장하지 않음

-- 외래 키에 의해 참조되는 고유/기본 키가 테이블에 있습니다. 삭제 불가
DROP TABLE department;

-- 참조 상관없이 무조건 테이블 삭제
DROP TABLE department cascade constraints;

-- 참조 제약조건 상관 없는 테이블
DROP TABLE product;











