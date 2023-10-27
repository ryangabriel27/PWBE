const express = require("express");
const dataBase = require("mysql");

const app = express();

app.listen(3001, ()=>{
    console.log("Rodando o servidor");
});

app.get('/', (req,res)=>{
    res.send("Hello World!")
});