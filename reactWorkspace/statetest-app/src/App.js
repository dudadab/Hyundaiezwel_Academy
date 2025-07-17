import logo from './logo.svg';
import './App.css';
import {useState} from 'react'; //useState 기능 포함
function Header(props) {
  console.log('props', props.title)
  return (
    <header>
      <h1><a href="/" onClick={(event)=>{
        event.preventDefault();
        props.onChangeMode();
      }}>{props.title}</a></h1>
    </header>
  )
}
function Nav(props) {
  const lis = []
  for(let i=0; i<props.topics.length; i++) {
    let t = props.topics[i];
    lis.push(<li key={t.id}>
      <a id={t.id} href={'/read/'+t.id} onClick={event=>{
        event.preventDefault();
        props.onChangeMode(event.target.id);
      }}>{t.title}</a>
    </li>);
  }
  return (
    <nav>
      <ol>
        {lis}
      </ol>
    </nav>
  )
}
function Article(props) {
  return (
    <article>
      <h2>{props.title}</h2>
      {props.body}
    </article>
  )
}
function App() {

  const [mode, setMode] = useState('WELCOME');
  const topics = [
    {id:1, title:'html', body:'html is ...'},
    {id:2, title:'css', body:'css is ...'},
    {id:3, title:'javascript', body:'javascript is ...'}
  ]
  let content=null;
  if(mode === 'WELCOME') {
    content = <Article title="Welcome" body="Hello, Web"></Article>
  } else if(mode === 'html') {
    content = <Article title={topics[0].title} body={topics[0].body}></Article>;
  }
  else if(mode === 'css') {
    content = <Article title={topics[1].title} body={topics[1].body}></Article>;
  }
  else if(mode === 'javascript') {
    content = <Article title={topics[2].title} body={topics[2].body}></Article>;
  }
  return (
    <div className="App">
      <Header title="WEB" onChangeMode={()=>{
        setMode('WELCOME');
      }}></Header>
      <Nav topics={topics} onChangeMode={(id)=>{
        if(id === '1') {
          setMode('html');
        } else if(id === '2') {
          setMode('css');
        } else if(id === '3') {
          setMode('javascript');
        }
      }}></Nav>
      {content}
    </div>
  );
}
export default App;