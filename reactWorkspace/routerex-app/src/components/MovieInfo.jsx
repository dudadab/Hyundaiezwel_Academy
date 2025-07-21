import React from 'react';
import { Link } from 'react-router-dom';

const MovieInfo = (props) => {
    const movie = props.movie;

    return (
        <div>
            <hr/>
            <h2>영화 정보</h2>
            <table border="1">
             <tbody>
                    <tr>
                        <th>제목</th>
                        <th>감독</th>
                        <th>배우</th>
                        <th>개봉일</th>
                        <th>장르</th>
                    </tr>
                    <tr>
                        <td>
                            {/* 아래 링크에 대한 라우터는 app.jsx에서 구성되고 있음 */}
                            <Link to="/movieDetail/spider">스파이더맨 노 웨이 홈</Link>
                        </td>
                        <td>존 왓츠</td>
                        <td>톰 홀랜드</td>
                        <td>2021-12-15</td>
                        <td>액션</td>
                    </tr>
                    <tr>
                        <td>
                            <Link to="/movieDetail/king">킹스맨 : 퍼스트 에이전트</Link>
                        </td>
                        <td>매튜 본</td>
                        <td>팔프 파인즈</td>
                        <td>2021-12-22</td>
                        <td>액션</td>
                    </tr>
                    {
                        movie.map((movie_ar) => (
                            <tr>
                                <td><Link to={"/movie/"+movie_ar.id}>{movie_ar.title}</Link></td>
                                <td>{movie_ar.director}</td>
                                <td>{movie_ar.actor}</td>
                                <td>{movie_ar.year}</td>
                                <td>{movie_ar.genre}</td>
                            </tr>
                        ))

                    }
                </tbody>
            </table>
        </div>
    );
};

export default MovieInfo;