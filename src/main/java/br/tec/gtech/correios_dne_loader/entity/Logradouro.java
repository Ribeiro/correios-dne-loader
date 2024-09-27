package br.tec.gtech.correios_dne_loader.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "log_logradouro")
@Data
public class Logradouro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long codigo;
    private String uf;
    private Integer codMunicipio;
    private Integer codBairro;
    private String nomeBairro;
    private String nomeLogradouro;
    private String cep;
    private String tipoLogradouro;
    private String status;
    private String descricaoCompleta;
}
