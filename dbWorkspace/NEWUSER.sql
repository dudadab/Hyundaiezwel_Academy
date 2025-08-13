-- 계정에 할당된 QUOTA 확인
SELECT * FROM USER_TS_QUOTAS; -- 할당량 MAX_BYTES 값이 -1이면 무제한 의미

-- 계정 조회
SELECT * FROM USER_USERS; -- 현재 계정에 대한 정보 조회

-- 