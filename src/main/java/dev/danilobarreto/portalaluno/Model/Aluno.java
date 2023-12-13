package dev.danilobarreto.portalaluno.Model;

import dev.danilobarreto.portalaluno.Enum.Curso;
import dev.danilobarreto.portalaluno.Enum.Status;
import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Size(min = 5, max = 40, message = "O nome deve conter no mínimo 5 caracteres")
    @NotBlank(message = "O nome não pode ser vazio.")
    private String nome;

    @NotNull(message = "Clique no Botão Gerar!")
    private String matricula;
    @Enumerated(EnumType.STRING)
    @NotBlank(message = "O campo curso não pode ser nulo.")
    private Curso curso;

    @Enumerated(EnumType.STRING)
    @NotBlank(message = "O campo status não pode ser nulo.")
    private Status status;

    @Size(min = 4, message = "No mínimo 4 caracteres.")
    @NotBlank(message = "O turno não pode ser vazio.")
    private String turno;


    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public Curso getCurso() {
        return curso;
    }


    public String getTurno() {
        return turno;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
