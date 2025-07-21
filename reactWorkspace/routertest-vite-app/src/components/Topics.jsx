import React from 'react';
import { Routes,Route,NavLink, useParams } from 'react-router-dom';
import Topic from './Topic.jsx';

const Topics = (props) => {
    let params = useParams();
    console.log(params);
    let contents = props.contents
    let lis = [];
    for (let i=0; i<contents.length; i++){
        lis.push(
            <li key={contents[i].id}><NavLink to={"/topics/"+contents[i].id}>{contents[i].title}</NavLink></li>
        )
    }

    return (
        <div>
            <h2>Topics</h2>
            {/* 아래 목록은 정적태그임 반드시 3개 목록이 생성됨 데이터에 따라 다른 목록을 표현하려고 하면 동적 태그 구성 
            <ul>
                <li><NavLink to="/topics/1">Politics</NavLink></li>
                <li><NavLink to="/topics/2">Economy</NavLink></li>
                <li><NavLink to="/topics/3">Society</NavLink></li>
            </ul>*/}

            <ul>
                {lis}
            </ul>

            <Routes>
                {/* 이 라우터에서는 App에서 매핑된 /topics는 제외시키고 하위 url만 매핑하면 됨 
                <Route path="/1" element={"Politics is ..."} />
                <Route path="/2" element={"Economy is ..."} />
                <Route path="/3" element={"Society is ..."} />*/}
                <Route path="/:topic_id" element={<Topic contents={contents} />}/>
            </Routes>
        </div>
    );
};

export default Topics;