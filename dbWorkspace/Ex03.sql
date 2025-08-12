-- 1.호날두(고객명)가 주문한 도서의 총 구매량 출력
SELECT SUM(BSQTY) AS "총 구매량"
FROM BOOKSALE
WHERE CLIENTNO = (  SELECT CLIENTNO
                    FROM CLIENT
                    WHERE CLIENTNAME = '호날두');

-- 2.‘정보출판사’에서 출간한 도서를 구매한 적이 있는 고객명 출력
SELECT CLIENTNAME
FROM CLIENT
WHERE CLIENTNO IN ( SELECT DISTINCT CLIENTNO 
                    FROM BOOKSALE 
                    WHERE BOOKNO IN (   SELECT BOOKNO 
                                        FROM BOOK 
                                        WHERE PUBNO = ( SELECT PUBNO 
                                                        FROM PUBLISHER 
                                                        WHERE PUBNAME = '정보출판사')));

-- 3.베컴이 주문한 도서의 최고 주문수량 보다 더 많은 도서를 구매한 고객명 출력
SELECT DISTINCT C.CLIENTNAME
FROM CLIENT C
JOIN BOOKSALE S ON C.CLIENTNO = S.CLIENTNO
WHERE S.BSQTY > (SELECT MAX(BSQTY) 
                 FROM BOOKSALE 
                 WHERE CLIENTNO = (SELECT CLIENTNO 
                                   FROM CLIENT 
                                   WHERE CLIENTNAME = '베컴'));

-- 4.천안에 거주하는 고객에게 판매한 도서의 총 판매량 출력
SELECT SUM(BSQTY) AS "총 판매량"
FROM BOOKSALE
WHERE CLIENTNO IN (SELECT CLIENTNO 
                   FROM CLIENT 
                   WHERE CLIENTADDRESS LIKE '%천안%');

--------------------------------------------------------------------------------

-- 1
SELECT BOOKAUTHOR
FROM BOOK
WHERE SUBSTR(BOOKAUTHOR,1,1) = '손';

SELECT SUBSTR(BOOKAUTHOR,1,1) AS "성", COUNT(*) AS "인원 수"
FROM BOOK
GROUP BY SUBSTR(BOOKAUTHOR,1,1);

-- 2
CREATE TABLE sales (
    prdName VARCHAR2(20),
    salesDate VARCHAR2(10),
    prdCompany VARCHAR2(10),
    salesAmount NUMBER(8)
);

INSERT INTO sales VALUES ('노트북', '2021.01', '삼성', 10000);
INSERT INTO sales VALUES ('노트북', '2021.03', '삼성', 20000);
INSERT INTO sales VALUES ('냉장고', '2021.01', 'LG', 12000);
INSERT INTO sales VALUES ('냉장고', '2021.03', 'LG', 20000);
INSERT INTO sales VALUES ('프린터', '2021.01', 'HP', 3000);
INSERT INTO sales VALUES ('프린터', '2021.03', 'HP', 1000);

SELECT * FROM SALES;

-- 순서에 따라 계층적인 소계와 총계를 계산
SELECT prdCompany, prdName, SUM(salesAmount) AS "합계"
FROM sales
GROUP BY ROLLUP(prdCompany, prdName);

-- 가능한 모든 조합에 대한 소계와 총계를 계산
SELECT prdCompany, prdName, SUM(salesAmount) AS "합계"
FROM sales
GROUP BY CUBE(prdCompany, prdName);

-- 특정 항목에 대한 소계 산출
SELECT prdCompany, prdName, SUM(salesAmount) AS "합계"
FROM sales
GROUP BY GROUPING SETS((prdCompany), (prdName));

-- 3
SELECT bsDate AS "주문일", bsDate + 7 AS "배송일"
FROM booksale;

SELECT bookName AS "도서명", EXTRACT(YEAR FROM BOOKDATE) AS "출판연도"
FROM book;