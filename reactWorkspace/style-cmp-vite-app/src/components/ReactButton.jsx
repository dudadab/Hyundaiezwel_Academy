import React from 'react';

const ReactButton = (props) => {
    console.log('props', props);
    const style = { // 사용자 정의 객체로 css 속성 값 구성
        color:"white",
        background:"purple"
    }
    return (
        <div>
            <button style={style}>{props.children}</button>
        </div>
    );
};

export default ReactButton;