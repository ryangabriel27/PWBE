<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="cadastro">
    <form action="recebe_dados.php" method="POST">
    <div align="center">
        <label for="cUsername">Username:</label> <input type="text" name="cUsername" size="20" placeholder="Seu username">&nbsp;&nbsp;
        <label for="cSenha">Senha:</label>
        <input type="password" name="cSenha" size="20" placeholder="Sua senha">
    </div>
    <br>
    <div align="center">
        <label for="cNome"> Nome:</label>
        <input type="text" name="cNome" size="20" placeholder="Seu nome">
        <label for="cCPF"> CPF:</label>
        <input type="text" name="cCPF" maxlength="12" placeholder="Seu CPF">
    </div>
    <br>
    <div align="center">
        <label for="cEmail">Email:</label>
        <input type="email" name="cEmail" id="" size="20" placeholder="Seu e-mail">
    </div>
<br>
    <div align="center">
        <label for="cCidade">Cidade:</label>
        <input type="text" name="cCidade" size="20" placeholder="Cidade...">&nbsp;&nbsp;
        <label for="cEstado">Estado: </label>
        <input type="text" name="cEstado" size="2" maxlength="2" placeholder="XX">
    </div>
        <br>
        <div align="center">
            <label for="cBairro">Bairro:</label>
            <input type="text" name="cBairro" size="20" placeholder="Seu bairro">
        </div>
    <br>
    <div align="center">
        <button type="submit">Cadastrar</button>
    </div>
</form>
</div>
</body>
</html>