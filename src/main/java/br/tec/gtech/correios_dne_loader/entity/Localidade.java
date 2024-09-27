package br.tec.gtech.correios_dne_loader.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "log_localidade")
@Data
public class Localidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long codigo;
    private String uf;
    private String nomeLocalidade;
    private String cep;
    private Integer indicadorDados;
    private String tipoLocalidade;
    private Integer codSubordinacao;
    private String nomeAbreviado;
}

