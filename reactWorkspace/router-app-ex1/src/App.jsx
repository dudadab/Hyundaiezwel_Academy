import './App.css'
import { Link, Routes, Route } from 'react-router-dom'
import Home from './components/Home.jsx'
import Content from './components/Content.jsx'
import Book from './components/Book.jsx'

function App() {

  const books = [
    { id: '1', title: "햄릿", writer: "윌리엄 셰익스피어" },
    { id: '2', title: "오셀로", writer: "윌리엄 셰익스피어" },
    { id: '3', title: "맥베스", writer: "윌리엄 셰익스피어" },
    { id: '4', title: "리어왕", writer: "윌리엄 셰익스피어" }
];

  return (
      <div>
        <ul>
          <li>
            <Link to="/">Home</Link>
          </li>
          <li>
            <Link to="/content">전체 도서 정보 출력</Link>
          </li>
        </ul>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/content" element={<Content books={books} />} />
          <Route path="/book/:keyword" element={<Book books={books} />} />
        </Routes>
      </div>

  )
}

export default App
