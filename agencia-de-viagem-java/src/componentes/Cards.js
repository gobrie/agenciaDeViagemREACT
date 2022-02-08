import React from 'react';
import CardItem from './CardItem';
import './Cards.css'

function Cards() {
  return (
    <div className='cards'>
        <h1>Confira estas promoções!</h1>
        <div className='cards__container'>
            <div className='cards__wrapper'>
                <ul className='cards__items'>
                <CardItem
              src='img/ponto1.jpg'
              text='Garanta já sua viagem com desconto!'
              label='Aventura'
              path='/SignUp'
            />
            <CardItem
              src='img/ponto2.jpg'
              text='Garanta já sua viagem com desconto!'
              label='Aventura'
              path='/SignUp'
            />
          </ul>
          <ul className='cards__items'>
            <CardItem
              src='img/ponto3.jpg'
              text='Garanta já sua viagem com desconto!'
              label='Aventura'
              path='/SignUp'
            />
            <CardItem
              src='img/ponto4.jpg'
              text='Garanta já sua viagem com desconto!'
              label='Aventura'
              path='/SignUp'
            />
                </ul>
            </div>
        </div>
    </div>
  );
}

export default Cards;
