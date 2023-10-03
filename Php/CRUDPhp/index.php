<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Página Inicial</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-
+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <link rel="stylesheet" href="css/styleIndex.css">
</head>
<body>
<div class="container d-flex justify-content-center py-5">
    <div class="all">
    <h1>Olá, seja bem-vindo(a)!!</h1>
    <form action="processaLogin.php" method="POST">
        <div class="col-4">
            <label for="email">E-mail:</label>
            <input type="email" name="email" id="email" class="form-control">
        </div>
        <div class="col-4">
            <label for="senha">Senha:</label>
            <input type="password" name="senha" id="senha" class="form-control">
        </div><br />
        <button type="submit" name="enviarDados" class="btn btn-outline-success">Entrar</button>
        <a href="cadastro.php" class="btn btn-outline-warning">Cadastrar-se</a>
    </form>
    </div>
    
</div>
</body>
</html>
