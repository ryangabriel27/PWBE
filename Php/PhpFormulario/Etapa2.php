
<html>
    <title>Desenvolvendo Websites com PHP</title>
    <link rel="stylesheet" href="style.css">
    <body>
        <p align="center"><big><big><strong>Cadastro - Etapa 2 de 3</strong></big></big></p>
        <div class="formulario">
        <form method="POST" action="Etapa3.php">
            <input type="hidden" name="nome" value="<?php echo $_POST['nome'];?>">
            <input type="hidden" name="email" value="<?php echo $_POST['email'];?>">
            <input type="hidden" name="datanascimento" value="<?php echo $_POST['datanascimento'];?>">
            <input type="hidden" name="sexo" value="<?php echo $_POST['sexo'];?>">
            <input type="hidden" name="profissao" value="<?php echo $_POST['profissao'];?>">

            <div align="center">
                <p>Telefone: <input type="text" name="telefone" size="20"></p>
            </div>
            <div align="center">
                <p>Endereço: <input type="text" name="endereco" size="20"></p>
            </div>
            <div align="center">
                <p>Cidade: <input type="text" name="cidade" size="20">&nbsp;&nbsp;&nbsp;Estado:<input type="text" name="estado" size="2"></p>
            </div>
            <div align="center">
                <p>CEP: <input type="text" name="cep" size="9"></p>
            </div>
            <div align="center">
                <p><input type="submit" value="PROSSEGUIR &gt;&gt;" name="prosseguir" class="btnEnviar"></p>
            </div>
        </form>
        </div>
    </body>
</html>
