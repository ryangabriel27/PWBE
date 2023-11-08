import React, { useState, useEffect } from 'react';
import './App.css';
import Axios from "axios";
import Card from './components/cards/card.js';

function App() {
  // Estado para armazenar os valores inseridos pelo usuário
  const [values, setValues] = useState();

  // Estado para armazenar a lista de produtos recuperada do servidor
  const [listProducts, setListProducts] = useState([]);

  console.log(listProducts);

  // Função para atualizar o estado 'values' conforme o usuário digita nos campos
  const handleAddValues = (value) => {
    setValues((prevValue) => ({
      ...prevValue, [value.target.name]: value.target.value,
    }));
  }

  // Função para enviar os dados inseridos pelo usuário para o servidor
  const handleRegisterButton = () => {
    Axios.post("http://localhost:3001/cadastro", {
      name: values.name,
      cost: values.cost,
      category: values.category,
    }).then((response) => {
      console.log(response);
    });
    // Recarrega a página após o cadastro
    document.location.reload();
  }

  // Efeito de carregamento inicial para buscar a lista de produtos do servidor
  useEffect(() => {
    Axios.get("http://localhost:3001/getCards").then((response) => {
      setListProducts(response.data);
    })
  }, []);

  return (
    <div className='app-container'>
      <div className='register-container'>
        <h1 className='register-title'>Pet&Repet</h1>

        {/* Inputs para o usuário inserir os dados do produto */}
        <input className='register-input' type='text' name='name' placeholder='Nome do produto' onChange={handleAddValues}></input>
        <input className='register-input' type='text' name='cost' placeholder='Preço do produto' onChange={handleAddValues}></input>
        <input className='register-input' type='text' name='category' placeholder='Categoria' onChange={handleAddValues}></input>

        {/* Botão para registrar o produto no banco de dados */}
        <button onClick={handleRegisterButton} className="register-button">
          Cadastrar
        </button>
      </div>

      {/* Mapeia a lista de produtos e exibe cada um como um componente 'Card' */}
      {listProducts.map((value) => {
        return <Card
          key={value.id}
          listProducts={listProducts}
          setListProducts={setListProducts}
          id={value.id}
          name={value.name}
          cost={value.cost}
          category={value.category}
        ></Card>
      })}

    </div>
  );
}

export default App;
