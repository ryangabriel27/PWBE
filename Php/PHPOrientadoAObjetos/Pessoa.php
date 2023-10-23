<?php

namespace PHPOrientadoAObjetos;

class Pessoa
{
    private float $altura;

    private string $nome;

    private string $sobrenome;

    private int $idade;

    private string $sexo;



    public function __construct(float $altura, string $nome, string $sobrenome, int $idade, string $sexo)
    {
        $this -> altura = $altura;
        $this -> nome = $nome;
        $this -> sobrenome = $sobrenome;
        $this -> idade = $idade;
        $this -> sexo = $sexo;
    }

    public function getAltura():float
    {
        return $this->altura;
    }

    public function setAltura(float $altura):void
    {
        $this->altura = $altura;
    }

    public function getNome():string
    {
        return $this->nome;
    }

    public function setNome(string $nome):void
    {
        $this->nome = $nome;
    }

    public function getSobrenome():string
    {
        return $this->sobrenome;
    }

    public function setSobrenome(string $sobrenome):void
    {
        $this->sobrenome = $sobrenome;
    }

    public function getIdade(): int
    {
        return $this->idade;
    }

    public function setIdade(int $idade): void
    {
        $this->idade = $idade;
    }

    public function getSexo(): string
    {
        return $this->sexo;
    }

    public function setSexo(string $sexo): void
    {
        $this->sexo = $sexo;
    }




}