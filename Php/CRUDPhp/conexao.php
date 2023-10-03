<?php
// endereco
// nome do BD
// usuario
// senha
$endereco = 'localhost';
$banco = 'crudSimples';
$usuario = 'root';
$senha = '';
try {
// sgbd:host;port;dbname
// usuario
// senha
// errmode
    $pdo = new PDO("mysql:host=$endereco;dbname=$banco", $usuario, $senha);
        $pdo->setAttribute(PDO::ATTR_ERRMODE,PDO::ERRMODE_EXCEPTION);
    // echo "Conectado no banco de dados!!!";
} catch (PDOException $e) {
    echo "Falha ao conectar ao banco de dados. <br/>";
    die($e->getMessage());
}
?>
