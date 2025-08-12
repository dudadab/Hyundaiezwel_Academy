-- 조인
-- 여러개의 테이블을 결합하여 조건에 맞는 행 검색
-- ex. 홍길동 학생의 소속과명
-- 조인종류
-- 1. inner join / outter join 
-- 1. iner join : 두 테이블에 공통되는 열이 있을 때
-- 2. outer join : 두 테이블에 공통되는 열이 없을 때도 표현

-- 고객 / 주문 테이블
-- 상품을 주문한 고객을 조회 : inner join
-- 상품을 주문한 고객과 주문하지 않은 고객도 주문내역과 같이 조회 : outer join

-- 형식
/*  SELECT 열리스트
    FROM 테이블명 1
        iner join 테이블명 2
        on 조인조건(기본키 = 외래키); 
        
    SELECT 열리스트
    FROM 테이블명 1, 테이블명 2
    WHERE 조인조건(기본키 = 외래키);
    
    SELECT 테이블명.속성명, 테이블명.속성명
    FROM 테이블명 1, 테이블명 2
    WHERE 조인조건(기본키 = 외래키);*/
        
        
-- 주문한 적이 있는 고객의 번호 이름
-- 고객테이블에서 고객 번호와 이름이 있지만 주문여부는 확인 불가능
-- 주문테이블에서는 주문여부 확인이 가능하지만 고객번호와 고객이름은 확인 불가

-- 주문한 적이 있는 고객의 모든 정보
-- 가장 많이 사용되는 방법
SELECT client.clientno ,clientname
FROM client
    inner join booksale
    on client.clientno = booksale.clientno;
    
SELECT client.clientnom, clientname
FROM client, booksale -- 결합하고자 하는 테이블 나열
WHERE client.clientno = booksale.clientno;
    
-- 결과는 clientno를 제외하고는 테이블명 포함시키지 않아도 동일함
-- 오라클 서버 입장에서는 속성의 소속을 명확히 하게되므로 위치를 정확히 알려줄 수 있어 성능 향상
SELECT client.clientno, client.clientname, booksale.bsqty
FROM client, booksale -- 결합하고자 하는 테이블 나열
WHERE client.clientno = booksale.clientno;

-- 테이블에 별칭 사용
SELECT A.clientno, A.clientname, B.bsqty
FROM client A, booksale B
WHERE  A.clientno = B.clientno;

-- 주문한적이 있는 고객의 모든 정보 - join(inner join의 약어)
SELECT client.clientno, clientname
FROM client
     join booksale
     on client.clientno = booksale.clientno;
     
-- 주문한적이 있는 고객의 정보 
-- 중복을 제거해서 조회
-- 고객번호를 기준으로 정렬

SELECT UNIQUE C.clientno, C.clientname
FROM client C 
     join booksale BS
     on C.clientno = BS.clientno
ORDER BY C.clientno;

-- 소장 도서에 대한 도서명과 출판사명
SELECT bookName, pubName
FROM book B
     inner join publisher P
     on B.pubno = P.pubno;
     
--------------------------------------------------------------------------------

-- 주문된 도서의 도서번호와 고객번호
SELECT bookNo, clientNo
FROM bookSale;

-- 주문(bookSale)된 도서의 도서명(book)과 고객명(client)을 확인
-- 3개의 테이블 조인 진행 : select ~ from ~ inner join ~ on ~ inner join ~ on ~

SELECT C.clientName, B.bookName
FROM bookSale BS
     inner join client C on C.clientNo = BS.clientNo
     inner join book B on B.bookNo = BS.bookNo;
     
-- 도서를 주문한 고객의 고객 정보, 주문정보, 도서정보 조회
-- SELECT C.clientName, B.bookName, BS.bsDate, BS.bsQty
-- SELECT *
SELECT C.clientName, B.bookName, BS.bsDate, BS.bsQty
FROM bookSale BS
     inner join client C on C.clientNo = BS.clientNo
     inner join book B on B.bookNo = BS.bookNo;

-- 고객별로 총 주문 수량 계산
-- 주문수량 기준 내림차순 정렬

SELECT SUM(bsQty) as "총주문수량"
FROM bookSale
GROUP BY clientNo
ORDER BY "총주문수량" DESC;

-- 고객별로 총 주문 수량 계산
-- 주문수량 기준 내림차순 정렬
-- 고객명을 표현할 것

-- 고객별로 그룹 생성 시 동일한 이름의 서로 다른 고객이 있을 수 있으므로 고객명이 필요하다고 해서 고객 이름만으로 그룹을 진행하면 안됨
SELECT C.clientNo, C.clientName,SUM(BS.bsQty) as "총주문수량"
FROM bookSale BS
     inner join client C on C.clientNo = BS.clientNo
GROUP BY C.clientNo, C.clientName
ORDER BY "총주문수량" DESC;

-- GROUP BY 다음에 없는 열 이름이 SELECT 절에 올 수 없음

-- 주문된 도서의 주문일, 고객명, 도서명, 도서가격, 주문수량, 주문액(계산 가능 : 주문수량 * 단가)을 조회
SELECT BS.bsDate, C.clientName, B.bookName, B.bookPrice, BS.bsQty,
       BS.bsQty * B.bookPrice as "주문액"
FROM bookSale BS
        inner join client C on C.clientNo = BS.clientNo
        inner join book B on B.bookNo = BS.bookNo
ORDER BY "주문액" DESC;

-- 조인된 결과를 활용한 가공필드 생성
SELECT BS.bsDate, C.clientName, B.bookName, B.bookPrice, BS.bsQty,
       BS.bsQty * B.bookPrice as "주문액"
FROM bookSale BS
        inner join client C on C.clientNo = BS.clientNo
        inner join book B on B.bookNo = BS.bookNo
WHERE (BS.bsQty * B.bookPrice) >= 100000 -- 별칭 사용 불가(별칭 구성 전에 진행됨)
ORDER BY "주문액" DESC; -- 별칭 사용 가능(가장 마지막 단계여서 별칭 사용 가능)

-- 2018년 부터 현재까지 판매된 도서의 주문일, 고객명, 도서명, 도서가격, 주문수량, 주문액 계산해서 조회
SELECT BS.bsDate, C.clientName, B.bookName, B.bookPrice, Bs.bsQty,
       BS.bsQty * B.bookPrice as "주문액"
FROM bookSale BS
        inner join client C on C.clientNo = BS.clientNo
        inner join book B on B.bookNo = BS.bookNo
WHERE BS.bsDate >= '2018-01-01'
ORDER BY BS.bsDate;

--------------------------------------------------------------------------------

-- client 테이블과 bookSale 테이블 활용 outer join 예시
-- 왼쪽(LEFT) 기준
-- 고객의 주문정보 확인(단, 주문한적이 없는 고객에 대한 정보 조회)
SELECT *
FROM client C
    LEFT OUTER JOIN bookSale BS
    ON C.clientNo = BS.clientNo
ORDER BY C.clientNo;
-- 조회결과 clientNo_1 컬럼에 NULL이라고 표현되는 튜플은 주문한적이 없는 고객에 대한 정보를 주문정보 없이 표현

-- 오른쪽(RIGHT) 기준 : INNER JOIN과 동일한 결과
-- 서점의 고객 중 주문하지 않은 고객은 존재 가능 단, 주문한 고객 중 서점의 회원이 아닌 고객은 없음
SELECT *
FROM client C
    RIGHT OUTER JOIN bookSale BS
    ON C.clientNo = BS.clientNo
ORDER BY C.clientNo;

-- 완전(FUll) OUTER JOIN
-- CLIENT가 아니면 주문 불가 제약조건 존재 : LEFT OUTER JOIN과 동일
SELECT *
FROM client C
    FULL OUTER JOIN BOOKSALE BS
    ON C.CLIENTNO = BS.CLIENTNO
ORDER BY C.CLIENTNO;

-- 오라클 OUTER 조인
-- (+)연산자로 조인시킬 값이 없는 조인측에 위치
-- 고객의 주문정보 확인하되 주문이 없는 고객의 정보 확인
SELECT *
FROM CLIENT C, BOOKSALE BS
WHERE C.CLIENTNO = BS.CLIENTNO (+)
ORDER BY C.CLIENTNO;

SELECT *
FROM CLIENT C, BOOKSALE BS
WHERE C.CLIENTNO (+) = BS.CLIENTNO 
ORDER BY C.CLIENTNO;

/*
SELECT *
FROM CLIENT C, BOOKSALE BS
WHERE C.CLIENTNO (+) = BS.CLIENTNO (+) -- ORA-01468: outer-join된 테이블은 1개만 지정할 수 있습니다
ORDER BY C.CLIENTNO;
*/



