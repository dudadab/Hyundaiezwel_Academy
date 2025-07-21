import './App.css'
import Home from './components/Home.jsx'
import Topics from './components/Topics.jsx'
import Contact from './components/Contact.jsx'
import { Routes, Route, Link, NavLink } from 'react-router-dom'

let contents = [
    {id:1, title:'Politics', description:'Politics is...'},
    {id:2, title:'Economy', description:'Economy is...'},
    {id:3, title:'Society', description:'Society is...'},
  ];

function App() {

  return (
    <>
      <div className="App">
        <h1>Hello React Router Dom</h1>
        {/* 렌더링 진행될때마다 페이지 새로고침이 발생함
            기존에 추가한 컴포넌트들 모두 사라지고 다시 처음부터 렌더링을 진행함
            페이지 단위 리로드 하지 않으려면 동적으로 갖고 오는 코드나 데이터는 비동기 기술을 이용해서 페이지를 만들어야 함
            리액트가 제공하는 Link 컴포넌트를 활용
            애플리케이션 유지한 상태에서 페이지 주소만 변경 가능한 환경을 구성할 수 있음*/}
        {/* 리로드가 되는 코드 
        <ul>
          <li><a href="/">Home</a></li>
          <li><a href="/topics">Topics</a></li>
          <li><a href="/contact">Contact</a></li>
        </ul> */}

        {/* 리로드가 발생하지 않는 Link 컴포넌트 사용 로그*/}
          {/*<ul>
            <li><Link to="/">Home</Link></li>
            <li><Link to="/topics">Topics</Link></li>
            <li><Link to="/contact">Contact</Link></li>
          </ul>*/}
          <ul>
            <li><NavLink to="/">Home</NavLink></li>
            <li><NavLink to="/topics">Topics</NavLink></li>
            <li><NavLink to="/contact">Contact</NavLink></li>
          </ul>

        {/* url 요청 신호 받아서 url 매핑 후 연결 element 컴포넌트를 뷰에 렌더링 */}
        <Routes>
          {/* <Route path="/*" element={'Not Found'}/> 위에 작성해도 동일하게 작동 */}
          <Route path="/" element={<Home/>}/>
          {/* /topics/1과 같은 경우로 url 요청 되었을 경우 Tipics 컴포넌트  */}
          <Route path="/topics" element={<Topics contents={contents}/>}/>
          <Route path="/contact" element={<Contact/>}/>
          <Route path="/*" element={'Not Found'}/>
          {/*  /* url은 /뒤에 어떤 url도 처리 함 - url 매핑 순서는 상관없음 */}
        </Routes>  
      </div>
      
    </>
  )
}

export default App
