package webapp.projeto_appescola.Model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class NotasFaltas implements Serializable{

    @Id
    private Long id;

    private double notas;
    private int faltas;
    private Long idAluno;

    public NotasFaltas(double notas, int faltas, Long idAluno) {
        this.notas = notas;
        this.faltas = faltas;
        this.idAluno = idAluno;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public double getNotas() {
        return notas;
    }
    public void setNotas(double notas) {
        this.notas = notas;
    }
    public int getFaltas() {
        return faltas;
    }
    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }
    public Long getIdAluno() {
        return idAluno;
    }
    public void setIdAluno(Long idAluno) {
        this.idAluno = idAluno;
    }
    

    

}
