import React from 'react';
import { Form, Button } from 'react-bootstrap'
import './Forms.css'

function Forms() {
    return (
      <div className='form__container'>
          <h1>FAÇA SUA RESERVA!</h1>
          <Form>
            
            <Form.Group className="mb-3" controlId="formBasicEmail">
              <Form.Label>País</Form.Label>
              <Form.Control type="email" placeholder="Digite o país" />
            </Form.Group>
    
            <Form.Group className="mb-3" controlId="cidade">
              <Form.Label>Cidade</Form.Label>
              <Form.Control type="text" placeholder="Digite a cidade" />
            </Form.Group>
            <Form.Group className="mb-3" controlId="dataIda">
              <Form.Label>Data de ida</Form.Label>
              <Form.Control type="Date" placeholder="Data" />
            </Form.Group>
            <Form.Group className="mb-3" controlId="dataVolta">
              <Form.Label>Data de volta</Form.Label>
              <Form.Control type="Date" placeholder="Data" />
            </Form.Group>
            <Form.Group className="mb-3" controlId="qtdPassageiros">
              <Form.Label>Quantidade de Passageiros</Form.Label>
              <Form.Control type="number" placeholder="" />
            </Form.Group>

            <Button variant="primary" type="submit">
              Confirme
            </Button>
          </Form>
        </div>
    
    
      );
}

export default Forms;
