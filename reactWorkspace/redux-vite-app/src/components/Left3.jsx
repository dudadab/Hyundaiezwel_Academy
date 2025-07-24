import React from 'react';
import { useSelector } from 'react-redux';

const Left3 = () => {
    //store에 접근해서 state value인 count 값을 출력
    //useSelector를 사용해 store의 state에 접근 가능
    //아래 코드가 최초 실행되는 시점은 currentState가 undefined임, 
    //reducer의 if문이 실행되면 0이 반환 currentstate는 0으로 셋팅
    //두번째 실행 시점부터는 currentState가 0으로 전달되기 때문에 if문이 실행되지 않음
    const count = useSelector((state) => state.count);
    return (
        <div>
            <h3>Left3</h3>
            Count: {count}
        </div>
    );
};

export default Left3;