import React from 'react';

const reducer = (currentState, action) => {
    //currentState가 정의 되지 않은 경우 기본 state 값 반환 - state value count
    if(currentState === undefined){
        return {count:0}
    } //if문이 실행되면 currentState는 0

    //각 state의 불변성 유지하기 위해 state 복제해서 사용
    const newState = {...currentState}

    /////////////////////////////////////////
    // 여기서 state 값 변경
    if(action.type == 'PLUS'){
        newState.count++;
    }

    if(action.type === 'MiNUS'){
        if(newState.count>0){
            newState.count--;
        }
    }
    /////////////////////////////////////////
    //변화시킨 값을 반환
    return newState; //반환된 값이 새로운 state 값이 됨
};

export default reducer;