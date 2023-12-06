import App from './App.tsx'
import './index.css'
import React from 'react'
import ReactDOM from 'react-dom/client'
import {FluentProvider, webDarkTheme} from "@fluentui/react-components";

ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    <FluentProvider theme={webDarkTheme} style={{height: "100vh", width: "100vw", overflow: "auto"}}>
      <App/>
    </FluentProvider>
  </React.StrictMode>,
)
