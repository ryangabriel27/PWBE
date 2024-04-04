package webapp.projeto_appescola.Model;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
public class Aluno implements Serializable {
    @Id
    private String usuario;

    private String nome_completo;
    private String senha;
    private String cpf;
    private int idade;
    private String email;
    private String celular;
    private String materia1;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNome_completo() {
        return nome_completo;
    }

    public void setNome_completo(String nome_completo) {
        this.nome_completo = nome_completo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getMateria1() {
        return materia1;
    }

    public void setMateria1(String materia1) {
        this.materia1 = materia1;
    }
    
}
