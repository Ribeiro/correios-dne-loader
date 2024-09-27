package br.tec.gtech.correios_dne_loader.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.tec.gtech.correios_dne_loader.entity.Bairro;
import br.tec.gtech.correios_dne_loader.repository.BairroRepository;
import br.tec.gtech.correios_dne_loader.util.StringUtilities;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BairroService {

    private static final String SEPARADOR = "@";

    private BairroRepository repository;

    @Transactional
    public void carregarDados(BufferedReader br) throws IOException {
        repository.deleteAllBairros();
        
        List<Bairro> bairros = new ArrayList<>();
        String linha;
        while ((linha = br.readLine()) != null) {
            String[] campos = linha.split(SEPARADOR);
            
            if (campos.length >= 5) {
                Bairro bairro = new Bairro();
                bairro.setCodigo(Long.parseLong(campos[0]));
                bairro.setUf(campos[1]);
                bairro.setCodMunicipio(Integer.parseInt(campos[2]));
                bairro.setNomeBairro(StringUtilities.removerAcentos(campos[3]));
                bairro.setDescricaoBairro(StringUtilities.removerAcentos(campos[4]));
                
                bairros.add(bairro);
            }
        }

        repository.saveAll(bairros);
    }
}