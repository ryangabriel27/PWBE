const express = require("express");
const mysql = require("mysql2");
const cors = require("cors");

const db = mysql.createPool({
    host:"localhost",
    user:"root",
    password:"",
    database:"produtoscrud"
});

const app = express();

app.use(cors());
app.use(express.json());

app.post("/cadastro", (req,res)=>{
    const { name } = req.body;
    const { cost } = req.body;
    const { category } = req.body;

    let sql = "INSERT INTO produtos( name,cost,category ) VALUES (?,?,?)"

    db.query(sql,[name, cost, category],(err,result) => {
        console.log(err);
    });
})

app.get("/getCards", (req,res)=>{
    
    let sql = "SELECT * FROM produtos";

    db.query(sql, (err,result)=>{
        if (err) console.log(err);
        else res.send(result);
    })
})

app.listen(3001, ()=>{
    console.log("Rodando o servidor");
});

app.put("/edit", (req,res) => {
    const { id } = req.body;
    const { name } = req.body;
    const { cost } = req.body;
    const { category } = req.body;

    let sql = "UPDATE produtos name = ?, cost = ?, category = ?, WHERE id = ?"

    db.query(sql, (err,result)=>{
        if (err) console.log(err);
        else res.send(result);
    })
})