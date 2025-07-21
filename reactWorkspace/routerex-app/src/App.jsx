import Home from './components/Home.jsx'
import About from './components/About.jsx'
import MovieInfo from './components/MovieInfo.jsx'
import MovieDetail from './components/MovieDetail.jsx'
import './App.css'
import {Link, Routes, Route } from 'react-router-dom'

const movie =[
  {id:1, title:'스파이더맨 노 웨이 홈', director:'존 왓츠',actor: '톰 홀랜드', year:'2021-12-15', genre:'액션' },
  {id:2, title:'킹스맨 : 퍼스트 에이전트', director:'매튜 본',actor: '팔프 파인즈', year:'2021-12-22', genre:'액션' }
]

function App() {

  return (
      <div className="wrap">
        <ul className="menu">
          <li><Link to="/">홈 화면 보기</Link></li>
          <li><Link to="/about">About 화면 보기</Link></li>
          <li><Link to="/movieInfo">영화정보 보기</Link></li>
          {/* <li><Link to="/movieDetail/king">킹스맨 : 퍼스트 에이전트</Link></li>
          <li><Link to="/movieDetail/spider">스파이더맨 노 웨이 홈</Link></li>
          <li><Link to="/movieDetail/squid">오징어게임</Link></li> */}
          <li><a href="https://movie.naver.com" target="_blank" rel="noreferrer noopener">네이버 영화</a></li>
        </ul>
        <Routes>
          <Route path="/" element={<Home/>}/>
          <Route path="/about" element={<About/>}/>
          <Route path="/movieInfo" element={<MovieInfo movie={movie}/>}/>
          <Route path="/movieDetail/:keyword" element={<MovieDetail movie={movie}/>}/>
        </Routes>
      </div>
      

  )
}

export default App
