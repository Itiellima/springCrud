package demo.springcrud.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "dt_nascimento")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dt_nascimento;

    public Pessoa() {
    }

    public Pessoa(Long id, String nome, Date dt_nascimento) {
        this.id = id;
        this.nome = nome;
        this.dt_nascimento = dt_nascimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(Date dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }


}
