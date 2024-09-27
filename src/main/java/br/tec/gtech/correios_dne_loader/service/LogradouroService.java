package br.tec.gtech.correios_dne_loader.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.tec.gtech.correios_dne_loader.entity.Logradouro;
import br.tec.gtech.correios_dne_loader.repository.LogradouroRepository;
import br.tec.gtech.correios_dne_loader.util.StringUtilities;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LogradouroService {

    private static final String SEPARADOR = "@";

    private LogradouroRepository repository;

    @Transactional
    public void carregarDados(BufferedReader br) throws IOException {
        repository.deleteAllLogradouros();

        List<Logradouro> logradouros = new ArrayList<>();
        String linha;
        while ((linha = br.readLine()) != null) {
            String[] campos = linha.split(SEPARADOR);

            if (campos.length >= 10) {
                Logradouro logradouro = new Logradouro();
                logradouro.setCodigo(Long.parseLong(campos[0]));
                logradouro.setUf(campos[1]);
                logradouro.setCodMunicipio(Integer.parseInt(campos[2]));
                logradouro.setCodBairro(Integer.parseInt(campos[3]));
                logradouro.setNomeBairro(StringUtilities.removerAcentos(campos[4]));
                logradouro.setNomeLogradouro(StringUtilities.removerAcentos(campos[5]));
                logradouro.setCep(campos[6]);
                logradouro.setTipoLogradouro(campos[7]);
                logradouro.setStatus(campos[8]);
                logradouro.setDescricaoCompleta(StringUtilities.removerAcentos(campos[9]));

                logradouros.add(logradouro);
            }
        }

        repository.saveAll(logradouros);
    }
}