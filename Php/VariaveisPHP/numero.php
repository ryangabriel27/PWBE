<?php

echo "Insira um número: ";$num1=readline().PHP_EOL;
echo "Insira outro número: ";$num2=readline().PHP_EOL;

echo "Selecione a operação desejada: \n1- Soma\n2- Subtração\n3- Multiplicação\n4- Divisão\n5- Potência\n ";$operacao= readline().PHP_EOL;

switch ($operacao) {
    case 1 :
        $soma = $num1+$num2;
        echo "Somando esses dois números temos: ".$soma.PHP_EOL;
        break;
    case 2 :
        $subtracao = $num1-$num2;
        echo "Subtraindo esses dois números temos: ".$subtracao.PHP_EOL;
        break;
    case 3 :
        $mult = $num1*$num2;
        echo "Multiplicando esses dois números temos: ".$mult.PHP_EOL;
        break;
    case 4 :
        if ($num2 == 0){
            echo "Não é possivel dividir um número por 0, tente novamente";
        } else {
            $divisao = $num1/$num2;
            echo "A dividindo esses dois números temos: ".$divisao.PHP_EOL;
        }
        break;
    case 5 :
        $potencia = $num1**$num2;
        echo "O número 1 elevado ao número 2 é igual a : ".$potencia.PHP_EOL;
        break;
    default :
        echo "Número inválido , tente novamente!";
        break;

}





