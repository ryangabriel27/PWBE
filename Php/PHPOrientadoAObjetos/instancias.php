<?php

require_once ('Pessoa.php');

$pessoa1 = new \PHPOrientadoAObjetos\Pessoa(1.80,"Ryan","Gabriel",17,"Masculino");

$pessoa1 -> setAltura(1.90);

var_dump("Nome: ".$pessoa1 -> getNome());
var_dump("Sobrenome: ".$pessoa1 -> getSobrenome());
var_dump("Altura: ".$pessoa1 -> getAltura());
var_dump("Idade: ".$pessoa1 -> getIdade());


