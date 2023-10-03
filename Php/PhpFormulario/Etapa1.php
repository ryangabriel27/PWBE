
<html>
    <title>Desenvolvendo Website com PHP</title>
    <link rel="stylesheet" href="style.css">
<body>
    <p align="center" class="title"><big><big><strong>Cadastro - etapa 1 de 3</strong></big></big></p>

    <div class="formulario">
    <form method="POST" action="Etapa2.php">
        <div align="center">
            <p>Nome: <input type="text" name="nome" size="20"></p>
        </div>
        <div align="center">
            <p>E-mail: <input type="email" name="email" size="20"></p>
        </div>
        <div align="center">
            <p>Data de nascimento: <input type="text" name="datanascimento" size="20"></p>
        </div>
        <div align="center">
            <p> Sexo: <input type="radio" value="masculino" checked name="sexo">Masculino&nbsp;&nbsp;<input type="radio" name="sexo" value="feminino">Feminino</p>
        </div>
        <div align="center">
            <p>Profissão: <input type="text" name="profissao" size="20"></p>
        </div>
        <div align="center">
            <p><input type="submit" value="PROSSEGUIR &gt;&gt;" name="prosseguir" class="btnEnviar"></p>
        </div>
    </form>
    </div>
</body>
</html>
