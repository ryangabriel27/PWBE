package webapp.projeto_appescola.Model;

import java.io.Serializable;

import jakarta.persistence.*;


@Entity
public class Administradores implements Serializable {

    @Id // Isso indica que o campo é uma chave primária
    private String cpf;
    
    private String nome;
    private String email;
    private String senha;

    // Getters e Setters

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
