package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatorio")
    private String nome;

    @NotBlank(message = "O tipo é obrigatorio")
    private String tipo;

    @Positive (message = "A idade deve ser um número")
    private Integer idade;

    private String raca;

    @NotBlank(message = "O status da adoção é obrigatório")
    private String statusAdocao;

    @Size(max = 500, message = "A descrição tem que ter no máximo 500 caracteres")
    private String descricao;

    private String imgUrl;

}
