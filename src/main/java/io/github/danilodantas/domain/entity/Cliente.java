package io.github.danilodantas.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "cliente" )
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome", length = 100)
    @NotEmpty(message = "Campo Nome � obrigat�rio")
    private String nome;

    @Column(name = "cpf", length = 11)
    private String cpf;

    @JsonIgnore
    @OneToMany( mappedBy = "cliente" , fetch = FetchType.LAZY )
    private Set<Pedido> pedidos;

   public Cliente(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

}
