<html>
    <title>Desenvolvendo Websites com PHP</title>
    <body>
        <p align="center"><big><big><strong>Cadastro - Etapa 3 de 3</strong></big></big></p>
        <form method="POST" action="cadastra.php">
            <input type="hidden" name="nome" value="<?php echo $_POST['nome'];?>">
            <input type="hidden" name="email" value="<?php echo $_POST['email'];?>">
            <input type="hidden" name="datanascimento" value="<?php echo $_POST['datanascimento'];?>">
            <input type="hidden" name="sexo" value="<?php echo $_POST['sexo'];?>">
            <input type="hidden" name="profissao" value="<?php echo $_POST['profissao'];?>">
        </form>
    </body>

</html>
