// Importação de bibliotecas necessárias
const express = require("express");
const mysql = require("mysql2");
const cors = require("cors");

// Criação de uma conexão com o banco de dados MySQL
const db = mysql.createPool({
    host: "localhost",
    user: "root",
    password: "",
    database: "produtoscrud"
});

// Inicialização de um servidor Express
const app = express();

// Habilita o uso do middleware CORS para lidar com solicitações de diferentes origens
app.use(cors());

// Habilita o middleware para análise de JSON no corpo das solicitações
app.use(express.json());

// Endpoint para lidar com solicitações POST de cadastro de produtos
app.post("/cadastro", (req, res) => {
    const { name } = req.body;
    const { cost } = req.body;
    const { category } = req.body;

    // Cria uma consulta SQL de inserção
    let sql = "INSERT INTO produtos(name, cost, category) VALUES (?,?,?)";

    // Executa a consulta SQL com os valores fornecidos no corpo da solicitação
    db.query(sql, [name, cost, category], (err, result) => {
        if (err) {
            console.log(err);
        }
    });
});

// Endpoint para lidar com solicitações GET para buscar todos os produtos
app.get("/getCards", (req, res) => {
    // Cria uma consulta SQL para selecionar todos os registros da tabela 'produtos'
    let sql = "SELECT * FROM produtos";

    // Executa a consulta SQL e envia os resultados como resposta
    db.query(sql, (err, result) => {
        if (err) {
            console.log(err);
        } else {
            res.send(result);
        }
    });
});

// Inicia o servidor na porta 3001
app.listen(3001, () => {
    console.log("Rodando o servidor");
});

// Endpoint para lidar com solicitações PUT de edição de produtos
app.put("/edit", (req, res) => {
    const { id } = req.body;
    const { name } = req.body;
    const { cost } = req.body;
    const { category } = req.body;

    // Cria uma consulta SQL de atualização com base no ID fornecido
    let sql = "UPDATE produtos SET name = ?, cost = ?, category = ? WHERE id = ?";

    // Executa a consulta SQL com os valores fornecidos no corpo da solicitação
    db.query(sql, [name, cost, category, id], (err, result) => {
        if (err) {
            console.log(err);
        } else {
            res.send(result);
        }
    });
});