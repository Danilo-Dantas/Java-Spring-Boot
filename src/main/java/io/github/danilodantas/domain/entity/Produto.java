package io.github.danilodantas.domain.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "descricao")
    @NotEmpty(message = "Campo Descri��o � obrigat�rio.")
    private String descricao;

    @Column(name = "preco_unitario")
    @NotNull(message = "O campo pre�o � obrigat�rio.")
    private BigDecimal preco;

}
