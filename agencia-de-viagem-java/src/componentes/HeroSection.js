import React from 'react';
import { Button } from './Button';
import './HeroSection.css';
import '../App.css';

function HeroSection() {
  return (
      <div className="hero-container">
          <video src='/videos/video-3.mp4' autoPlay loop muted />
          <h1>Venha sobrevoar os horizontes</h1>
          <p>Não perca tempo</p>
          <div className='hero-btns'>
              <Button 
              className='btns' 
              buttonStyle='btn--outline'
              buttonSize='btn--large'
              >
                  VAMOS COMEÇAR
              </Button>
          </div>


      </div>
  )
}

export default HeroSection;
