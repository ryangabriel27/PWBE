const express = require("express");
const mysql = require("mysql2");
const cors = require("cors");

const db = mysql.createPool({
    host:"localhost",
    user:"root",
    password:"root",
    database:"produtoscrud"
});

const app = express();

app.use(cors());
app.use(express.json());


app.listen(3001, ()=>{
    console.log("Rodando o servidor");
});

// app.get('/', (req,res)=>{
    
//     let sql = "INSERT INTO produtos( id,name,cost,category ) VALUES ( 1,'Racao Cachorro 10KG','80','Cachorro' )";

//     db.query(sql,(err,result)=>{
//         console.log(err);
//     });
// });