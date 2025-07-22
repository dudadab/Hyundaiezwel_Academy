import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.jsx'
import MainApp from './MainApp.jsx'
import reporWebVitals from './reportWebVitals.js'
import HookThemeButton from './HookThemeButton.jsx'
import MyThemeProvider from './components/MyThemeProvider.jsx'

createRoot(document.getElementById('root')).render(
    <MyThemeProvider>
      <HookThemeButton />
    </MyThemeProvider>

)
