import './App.css';
import React from 'react';
import Navbar from './componentes/Navbar'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from './componentes/pages/Home';
import Promotion from './componentes/pages/Promotion';
import Schedule from './componentes/pages/Schedule'
import SignUp from './componentes/pages/SignUp'



function App() {
  return (
    <>
      <Router>
        <Navbar />     
        <Routes>
        <Route path='/' element={<Home />} />
        <Route path='/Promotion' element={<Promotion />} />
        <Route path='/Schedule' element={<Schedule />} />
        <Route path='/SignUp' element={<SignUp />} />
        </Routes>
      </Router>
    </>
  );
}

export default App;
