import React from 'react';
import { useDispatch } from 'react-redux';

const Right3 = () => {
    //store에 접근해서 state값을 변경 시키는 기능 수행 (action)
    //action은 useDispatch() 활용해서 store에 의견 전달 가능
    const dispatch = useDispatch();
    return (
        <div>
            <h3>Right3</h3>
            <button onClick ={
                //reducer에 action
                () => {dispatch({type: "MiNUS"})}
            }>-</button> &nbsp;
            <button onClick ={
                () => {dispatch({type: "PLUS"})}
            }>+</button>
        </div>
    );
};

export default Right3;