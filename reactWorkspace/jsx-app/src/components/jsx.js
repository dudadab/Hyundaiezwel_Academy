import React from 'react';

const jsx = () => {
    //자바스크립트 코드
    const name = '홍길동'; //상수 name 선언 및 생성
    return(
        <div>
            <h1>JSX 입니다.</h1>
            <h2>name 안녕 !</h2> {/*문자열 name*/}
            <h2>{name} 안녕 !</h2> {/*변수 name*/}
        </div>
    );
};

export default jsx;