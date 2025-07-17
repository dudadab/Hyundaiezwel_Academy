import './App.css';
import Subject from './components/Subject';
import Nav2 from './components/Nav';
import Student from './components/Student';
import imgBlack from './image/black.png';


function Header(props){ //컴포넌트에 매개변수 설정하면 컴포넌트를 사용하는 곳에서 속성으로 전달된 객체를 받을 수 있음
  console.log(props);
  console.log(props.title)
  return(
    <header>
        <h1><a href="/">props.title</a></h1>
        <h1><a href="/">{props.title}</a></h1>
    </header>
  )
}

function Nav(){
  return(
    <nav>
        <ol>
          <li><a href="">html</a></li>
          <li><a href="">css</a></li>
          <li><a href="">js</a></li>
        </ol>
      </nav>
  )
}

function Article(){
  return(
      <article>
        <h2>welcome</h2>
        Hello, Web
      </article>
  )
}

function App() {
  const title ="props연습";
  let content = "내용"
  const topics = [
    {id:1, title:"html", body:'html is...'},
    {id:2, title:"css", body:'css is...'},
    {id3:3, title:"js", body:'js is...'}
  ]

  const topics2 = {
    res:[{id:1, title:"html", body:'html is...'},
        {id:2, title:"css", body:'css is...'}, 
        {id:3, title:"jss", body:'js is...'}]
  }

  const name="홍길동", age=20, year=4, address="서울";
  return (
    <div className="App">
      <Header title='리액트'/> {/* 사용자 정의 태그 속성에 값을 준다면?*/}
      <Nav/>
      <Article/>
      {/* 속성=값 속성=값 형태로 여러개의 값 전달 가능 */}
      <Subject title={title} sub="부제목" content={content}/>
      {/* 속성 전달 없음 */}
      <Subject/>
      <Nav2 topics={topics}/>
      <Student name={name} age={age} year={year} address={address}/>
      {/* 이미지 경로 import해서 사용 */}
      <img src={imgBlack} alt="black" width="100" height="100"/>
      {/*  */}
      <img src='/assets/apple.png' alt="apple" width="100" height="100"/>
    </div>
  );
}

export default App;
