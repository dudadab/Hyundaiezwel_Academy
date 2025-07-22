import ReactButton from './components/ReactButton.jsx'
import StyledButton from './components/StyledButton.jsx'
import {SimpleButton, LargeButton}from './components/CreateButton.jsx';
import { ReactLargeButton } from './components/ReactExpand.jsx';
import { PrimaryButton } from './components/DynamicsStyle.jsx';
import './App.css'

function App() {


  return (
    <div className="App">
      <ReactButton children={"ReactButton"}/>
      <StyledButton children={"StyledButton"}/>
      <SimpleButton children={"SimpleButton"}/>
      <LargeButton children={"LargeButton"}/>
      <ReactLargeButton children={"ReactLargeButton"}/>
      <PrimaryButton children={"PrimaryButton"}/>
      <PrimaryButton children={"PrimaryButton"} primary='true'/>
    </div>
  
  );
}

export default App
