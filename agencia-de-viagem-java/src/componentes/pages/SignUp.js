import React from 'react';
import { Form, Button } from 'react-bootstrap'

function SignUp() {
  return (
      <div className='form__container'>
          <h1>CADASTRE-SE</h1>
          <Form>
            
            <Form.Group className="mb-3" controlId="formBasicName">
              <Form.Label>Nome</Form.Label>
              <Form.Control type="text" placeholder="Digite seu nome" />
            </Form.Group>   
            <Form.Group className="mb-3" controlId="formBasic">
              <Form.Label>CPF</Form.Label>
              <Form.Control type="text" placeholder="Digite seu CPF" />
            </Form.Group>
            <Form.Group className="mb-3" controlId="formBasicEmail">
              <Form.Label>E-mail</Form.Label>
              <Form.Control type="e-mail" placeholder="Digite seu e-mail" />
            </Form.Group>
            <Form.Group className="mb-3" controlId="formBasicAdress">
              <Form.Label>Endereço</Form.Label>
              <Form.Control type="text" placeholder="Digite seu endereço" />
            </Form.Group>


            <Button variant="primary" type="submit">
              Confirme
            </Button>
          </Form>
        </div>
  );
}

export default SignUp;
