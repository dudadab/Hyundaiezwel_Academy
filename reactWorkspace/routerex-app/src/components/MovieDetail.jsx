import React from 'react';
import {useParams} from 'react-router-dom';

const data = {
    spider: {
        title: "스파이더맨 노 웨이 홈",
        director: "존 왓츠",
        actor: "톰 홀랜드",
        date: "2021-12-15",
        genre: "액션",
    },
    king: {
        title: "킹스맨 : 퍼스트 에이전트",
        director: "메튜 본",
        actor: "랄프 파인즈",
        date: "2021-12-22",
        genre: "액션",
    },
};

const MovieDetail = (props) => {
    const params = useParams(); //영화 정보의 id값이 리턴됨
    const movie_ar = props.movie;
    console.log(movie_ar);
    console.log(params);
    //params에서 전달된 keyword가 data내에 존재하면 data 반환, 없으면 undefined로 반환 됨
    //keyword는 1부터 증가되는 값, 배열의 idx로 사용하려면 -1
    const movie = movie_ar[Number(params.keyword)-1];
    if(!movie){
        return <div> <hr/>영화 정보가 없습니다.</div>
    }
    return (
        <div>
            <hr/>
            <h3>{params.keyword} : {movie.title}</h3>
            <p>감독 : {movie.director}</p>
            <p>출연 : {movie.actor}</p>
            <p>개봉일 : {movie.date}</p>
            <p>장르 : {movie.genre}</p>
        </div>
         
    );
};

export default MovieDetail;