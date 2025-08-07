-- 테이블 생성
-- 동일DB(동일계정)에 동일명 테이블이 있으면 안됨
-- 기본키 제약조건
-- 1. 속성 설정 시 기본키 지정\
CREATE TABLE product2(
    prdNo VARCHAR2(10) NOT NULL PRIMARY KEY,
    prdName VARCHAR2(30) NOT NULL,
    prdPRICE NUMBER(8),
    prdCOMPANY VARCHAR2(30)
);

-- 2. 기본키 따로 설정 : primary key(기본키 필드명)
CREATE TABLE product(
    prdNo VARCHAR2(10) NOT NULL,
    prdName VARCHAR2(30) NOT NULL,
    prdPRICE NUMBER(8),
    prdCOMPANY VARCHAR2(30),
    PRIMARY KEY(prdNo)
);

-- 3. 제약 이름과 같이 설정 : 제약 변경이나 삭제 시 유용함 -> CONSTRAINT pk_product_prdNo PRIMARY KEY
CREATE TABLE product(
    prdNo VARCHAR2(10) NOT NULL CONSTRAINT PK_product_prdNo PRIMARY KEY,
    prdName VARCHAR2(30) NOT NULL,
    prdPRICE NUMBER(8),
    prdCOMPANY VARCHAR2(30)
);

-- 4. 따로 설정 제약명 추가
CREATE TABLE product(
    prdNo VARCHAR2(10) NOT NULL,
    prdName VARCHAR2(30) NOT NULL,
    prdPRICE NUMBER(8),
    prdCOMPANY VARCHAR2(30),
    CONSTRAINT pk_product_prdNo PRIMARY KEY(prdNo)
);

------------------------------------------------------------------------------
-- 출판사 테이블 먼저 생성하고 도서 테이블 생성(외래키 참조 필드)
-- 외래키 필드에 입력되는 값은 참조테이블의 기본키로서 값과 동일해야 함
-- 외래키 필드의 도메인과 참조테이블의 기본키 도메인은 동일해야 함
-- 테이블 삭제 시에는 생성과 반대로 참조하는 book을 먼저 삭제하고 참조되는 publisher를 삭제
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
기본값 체크 조건
*/
-- 외래키 필드는 참조테이블에서는 기본키여야 함
CREATE TABLE book(
    bookNO VARCHAR2(10) NOT NULL PRIMARY KEY,
    bookNAME VARCHAR2(30) NOT NULL,
    bookPRICE NUMBER(8) DEFAULT 10000 CHECK(bookPRICE > 1000),
    bookDATE DATE,
    pubNO VARCHAR2(10) NOT NULL,
    CONSTRAINT FK_book_publisher FOREIGN KEY (pubNO) REFERENCES publisher(pubno)
);



CREATE TABLE department (
    department_id NUMBER(10) PRIMARY KEY,
    department_name VARCHAR2(50) NOT NULL
);

INSERT INTO department (department_id, department_name) VALUES (101, '국어국문학과');
INSERT INTO department (department_id, department_name) VALUES (102, '사학과');
INSERT INTO department (department_id, department_name) VALUES (103, '철학과');

CREATE TABLE student (
    student_id VARCHAR2(10) PRIMARY KEY,
    student_name VARCHAR2(50) NOT NULL,
    grade NUMBER DEFAULT 4 CHECK (grade BETWEEN 1 AND 4),
    department_id NUMBER(10),
    FOREIGN KEY (department_id) REFERENCES department(department_id)
);

INSERT INTO student (student_id, student_name, grade, department_id) VALUES ('2025001', '홍길동', 2, 101);
INSERT INTO student (student_id, student_name, grade, department_id) VALUES ('2025002', '고길동', 3, 102);
INSERT INTO student (student_id, student_name, grade, department_id) VALUES ('2025003', '성춘향', 1, 103);

-- ALTER TABLE (ADD/DROP/MODIFY/RENAME)

-- ALTER TABLE ADD : 속성 추가
ALTER TABLE product ADD (prdUITPRICE NUMBER(8), prdSTOCK NUMBER(12));

-- 열의 데이터 형식 변경 : ALTER TABLE 테이블명 MODIFY 속성명 변경타입
ALTER TABLE product MODIFY prdUITPRICE NUMBER(4); -- 데이터가 저장된 상태에서 크기 변경 진행 시 범위를 벗어나는 데이터가 있다면 변환오류 발생

-- 열의 제약조건 NOT NULL -> NULL로 변경 MODIFY
ALTER TABLE product MODIFY PRDNAME VARCHAR2(30) NULL;

-- 열 이름 변경 ALTER TABLE 테이블 명 RENAME COLUMN 기존 컬럼명 to 새 컬럼명
ALTER TABLE PRODUCT RENAME COLUMN PRDUITPRICE TO PRDUPRICE;

-- 열 삭제
ALTER TABLE product 

-- 여러 열 삭제


---------------------------------------------------------------------------

--
--ALTER TABLE product ADD (prdStock NUMBER(8), prdDate DATE);
--
--ALTER TABLE product ADD prdCompany VARCHAR2(30);
--ALTER TABLE product MODIFY prdCompany VARCHAR2(30) NOT NULL;
--
--ALTER TABLE publisher ADD (pubPhone VARCHAR2(20), pubAddress VARCHAR2(30));
--
--ALTER TABLE publisher DROP COLUMN pubPhone;

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
    CONSTRAINT FK_SCORES_STUDENT FOREIGN KEY(STDNO) REFERENCES STUDENT (STDO),
    CONSTRAINT FK_SCORES_COURSE FOREIGN KEY(COURSEID) REFERENCES COURSE (COURSEID)
);
