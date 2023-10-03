<?php
    $username = $_POST["cUsername"];
    $senha = $_POST["cSenha"];
    $nome = $_POST["cNome"];
    $email = $_POST["cEmail"];
    $cidade = $_POST["cCidade"];
    $estado = $_POST["cEstado"];
    $bairro = $_POST["cBairro"];
    $cpf = $_POST["cCPF"];

    $erro =0;

    if (strlen($senha)<5){
        echo "A senha deve possuir no mínimo 5 caracteres. <br>"; $erro=1;
    } else if ($username == $senha){
         echo "O username e senha devem ser diferentes. <br>"; $erro=1;
    } else if (strlen($username)<5){
        echo "O username deve possuir no mínimo 5 caracteres. <br>"; $erro=1;
    } else if (empty($nome) OR strstr($nome,' ')==false){
        echo "Favor digite seu nome corretamente.<br>"; $erro=1;
    } else if (strlen($email)<8 || strstr($email,'@')==false){
        echo "Favor digite seu email corretamente.<br>"; $erro=1;
    } else if (empty($cidade)){
        echo "Favor digitar sua cidade corretamente.<br>"; $erro=1;
    } else if (strlen($estado)!=2){
        echo "Favor digitar seu esado corretamente.<br>"; $erro=1;
    } else if (strlen($cpf)!=12){
        echo "Favor digitar o cpf corretamente.<br>"; $erro=1;
    } else if (empty($bairro)){
        echo "Favor digitar o bairro corretamente.<br>"; $erro=1;
    }

    if ($erro == 0){
        echo "<script language='javascript' type='text/javascript'> 
            alert('Todos os dados foram digitados corretamente!!'); window.location.href='index.php';</script>";
    }
    ?>

