import React, { useState, useEffect } from 'react';
import './App.css';
import Axios from "axios";
import Card from './components/cards/card.js';

function App() {
  const [values, setValues] = useState();
  const [listProducts, setListProducts] = useState([]);

  console.log(listProducts);

  const handleAddValues = (value) => {
    setValues((prevValue) => ({
      ...prevValue, [value.target.name]: value.target.value,
    }));
  }

  const handleRegisterButton = () => {
    Axios.post("http://localhost:3001/cadastro", {
      name: values.name,
      cost: values.cost,
      category: values.category,
    }).then((response) => {
      console.log(response);
    });
    document.location.reload();
  }

  useEffect(() => {
    Axios.get("http://localhost:3001/getCards").then((response) => {
      setListProducts(response.data)
    })
  }, []);

  return (
    <div className='app-container'>
      <div className='register-container'>
        <h1 className='register-title'>Pet&Repet</h1>

        <input className='register-input' type='text' name='name' placeholder='Nome do produto' onChange={handleAddValues}></input>

        <input className='register-input' type='text' name='cost' placeholder='Preço do produto' onChange={handleAddValues}></input>

        <input className='register-input' type='text' name='category' placeholder='Categoria' onChange={handleAddValues}></input>

        <button onClick={handleRegisterButton} className="register-button">
          Cadastrar
        </button>
      </div>

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
