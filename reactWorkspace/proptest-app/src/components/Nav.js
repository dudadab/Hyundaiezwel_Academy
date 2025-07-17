import React from 'react';

const Nav = (props) => {
    //props에 전달되는 객체는 topices라는 배열이 전달됨
    //props.topices -> 배열 
    //props.topices[0].id
    //각 원소의 title만 추출해서 목록을 구성
    const lis = []
    for(let i=0; i<props.topics.lengh; i++){
        let t = props.topics[i];
        lis.push(<li key={t.id}><a href={"/read/" + t.id}>{t.title}</a></li>);
    }
    return (
        <nav>
            <ol>
                {/* <li><a href="/read/1">html</a></li>
                <li><a href="/read/2">CSS</a></li>
                <li><a href="/read/3">JS</a></li> */}
                {/* 선택자 컴포넌트에서 전달된 데이터에 따라 목록 생성 */}
                {lis}
            </ol>
        </nav>
    );
};

export default Nav;