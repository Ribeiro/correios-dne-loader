package br.tec.gtech.correios_dne_loader.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "log_bairro")
@Data
public class Bairro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long codigo;
    private String uf;
    private Integer codMunicipio;
    private String nomeBairro;
    private String descricaoBairro;
}
