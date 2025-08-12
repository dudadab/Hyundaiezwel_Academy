-- 1.도서 테이블에서 가격 순으로 내림차순 정렬하여, 도서명, 저자, 가격 출력 (가격이 같으면 저자 순으로 오름차순 정렬)
SELECT bookName, BookAuthor, bookPrice
FROM book
ORDER by  bookPrice DESC, bookPrice ASC;

-- 2.도서 테이블에서 저자에 '길동'이 들어가는 도서의 총 재고 수량 계산하여 출력
SELECT SUM(bookStock) as total_bookStock
FROM book
WHERE bookAuthor LIKE '%길동%';

-- 3.도서 테이블에서 ‘서울 출판사' 도서 중 최고가와 최저가 출력
SELECT MAX(bookPrice) as max_bookPrice, MIN(bookPrice) as min_bookPrice
FROM book
WHERE pubName = '서울 출판사';

-- 4.도서 테이블에서 출판사별로 총 재고수량과 평균 재고 수량 계산하여 출력 (‘총 재고 수량’으로 내림차순 정렬)
SELECT pubNo, SUM(bookStock) as "총 재고 수량", AVG(bookStock) as "평균 재고 수량"
FROM book
GROUP BY pubNo
ORDER BY SUM(bookStock) DESC;

-- 정수표현(반올림) - ROUND(대상, 소수점이하 자리수)
SELECT pubNo, SUM(bookStock) as "총 재고 수량", ROUND(AVG(bookStock)) as "평균 재고 수량"
FROM book
GROUP BY pubNo
ORDER BY "총 재고 수량" DESC;

-- 5.도서판매 테이블에서 고객별로 ‘총 주문 수량’과 ‘총 주문 건수’ 출력. 단 주문 건수가 2이상인 고객만 해당
SELECT clientNo, SUM(BSQTY) AS 총주문수량, COUNT(*) AS 총주문건수 
FROM BOOKSALE
GROUP BY clientNo
HAVING COUNT(*) >= 2;

--------------------------------------------------------------------------------

-- 1.모든 도서에 대하여 도서의 도서번호, 도서명, 출판사명 출력
SELECT B.bookNo, B.bookname, P.pubName
FROM book B
JOIN publisher P ON B.pubNo = p.pubNo;

-- 2.‘서울 출판사'에서 출간한 도서의 도서명, 저자명, 출판사명 출력 (출판사명 사용)
SELECT B.bookName, B.BookAuthor, P.pubName
FROM book B
JOIN publisher P ON B.pubNo = P.pubNo
WHERE P.pubName = '서울 출판사';

-- 3.＇정보출판사'에서 출간한 도서 중 판매된 도서의 도서명 출력 (중복된 경우 한 번만 출력) (출판사명 사용)
SELECT DISTINCT B.bookName
FROM book B
JOIN publisher P ON B.pubNo = P.pubNo
JOIN bookSale S ON B.bookNo = S.bookNo
WHERE P.pubName = '정보출판사';

-- 4.도서가격이 30,000원 이상인 도서를 주문한 고객의 고객명, 도서명, 도서가격, 주문수량 출력
SELECT C.clientName, B.bookName, B.bookPrice, S.bsQty
FROM client C
JOIN bookSale S ON C.clientNo = s.clientNo
JOIN book B ON S.bookNo = B.bookNo
WHERE B.bookPrice >= 30000;

-- 5.'안드로이드 프로그래밍' 도서를 구매한 고객에 대하여 도서명, 고객명, 성별, 주소 출력 (고객명으로 오름차순 정렬)
SELECT B.bookName, C.clientName, C.clientGender, C.clientAddress
FROM client C
JOIN bookSale S ON C.clientNo = S.clientNo
JOIN book B ON S.bookNo = B.bookNo
WHERE B.bookName = '안드로이드 프로그래밍'
ORDER BY C.clientName ASC;

-- 6.‘도서출판 강남'에서 출간된 도서 중 판매된 도서에 대하여 ‘총 매출액’ 출력
SELECT SUM(B.bookPrice * S.bsQty) AS "총 매출액"
FROM book B
JOIN publisher P ON B.pubNo = P.pubNo
JOIN bookSale S ON B.bookNo = S.bookNo
WHERE P.pubName = '도서출판 강남';

-- 7.‘서울 출판사'에서 출간된 도서에 대하여 판매일, 출판사명, 도서명, 도서가격, 주문수량, 주문액 출력
SELECT S.BSDATE, P.PUBNAME, B.BOOKNAME, B.BOOKPRICE, S.BSQTY, (B.BOOKPRICE * S.BSQTY) AS "주문액"
FROM bookSale S
JOIN book B ON S.bookNo = B.bookNo
JOIN publisher P ON B.pubNo = P.pubNo
WHERE P.pubName = '서울 출판사';

-- 8.판매된 도서에 대하여 도서별로 도서번호, 도서명, 총 주문 수량 출력
SELECT B.bookNo, B.bookName, SUM(S.bsQty) AS "총 주문 수량"
FROM book B
JOIN bookSale S ON B.bookNo = S.bookNo
GROUP BY B.bookNo, B.bookName;

-- 9.판매된 도서에 대하여 고객별로 고객명, 총구매액 출력 ( 총구매액이 100,000원 이상인 경우만 해당)
SELECT C.clientName, SUM(B.bookPrice * S.bsQty) AS "총 구매액"
FROM client C
JOIN booKSale S ON C.clientNo = S.clientNo
JOIN book B ON S.bookNo = B.bookNo
GROUP BY C.clientName
HAVING SUM(B.bookPrice * S.bsQty) >= 100000;

-- 10.판매된 도서 중 ＇도서출판 강남'에서 출간한 도서에 대하여 고객명, 주문일, 도서명, 주문수량, 출판사명 출력 (고객명으로 오름차순 정렬)
SELECT C.clientName, S.bsDate, B.bookName, S.bsQty, P.pubName
FROM client C
JOIN bookSale S ON C.clientNo = S.clientNo
JOIN book B ON S.bookNo = B.bookNo
JOIN publisher P ON B.pubNo = P.pubNo
WHERE P.pubName = '도서출판 강남'
ORDER BY C.clientName ASC;