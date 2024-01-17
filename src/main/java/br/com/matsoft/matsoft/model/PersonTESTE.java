package br.com.matsoft.matsoft.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "personTESTE")
public class PersonTESTE implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", nullable = false, length = 80)
    private String nome;
    @Column(name = "idade", nullable = false, length = 80)
    private Long idade;
    @Column(name = "cargo", nullable = false, length = 80)
    private String cargo;

    public PersonTESTE() {}

    public PersonTESTE(String nome, Long idade, String cargo) {
        this.nome = nome;
        this.idade = idade;
        this.cargo = cargo;
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

    public Long getIdade() {
        return idade;
    }

    public void setIdade(Long idade) {
        this.idade = idade;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonTESTE that = (PersonTESTE) o;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(idade, that.idade) && Objects.equals(cargo, that.cargo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, idade, cargo);
    }
}
