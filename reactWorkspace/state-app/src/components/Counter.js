import React, { useState } from 'react';

const Counter = () => {
        const [num, setNum] = useState(0);

        const onClickPlus = () => setNum(num + 1);

    return (
        <div>
            <hr/>
            <h3>{num}</h3>
            <button onClick={onClickPlus}>+</button> &nbsp;
            <button onClick={() => {setNum(num - 1)}}>-</button>
        </div>
    )

}
export default Counter;