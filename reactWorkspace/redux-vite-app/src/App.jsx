import './App.css'
import Left1 from './components/Left1.jsx'
import Right1 from './components/Right1.jsx'

function App() {


  return (
      <div className="App">
        <h3>Root</h3>
        <div id="container">
          <Left1 />
          <Right1 />
        </div>
      </div>
  )
}

export default App
