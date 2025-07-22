import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'
import { Provider } from 'react-redux'
import reducer from './components/Reducer.js'
import { configureStore } from '@reduxjs/toolkit'

//store 생성
const store = configureStore({reducer:reducer})

createRoot(document.getElementById('root')).render(
    <React.StrictMode>
      <Provider store={store}>
        <App />
      </Provider>
    </React.StrictMode>
)
