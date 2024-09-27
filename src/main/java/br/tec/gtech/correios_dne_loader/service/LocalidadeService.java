package br.tec.gtech.correios_dne_loader.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.tec.gtech.correios_dne_loader.entity.Localidade;
import br.tec.gtech.correios_dne_loader.repository.LocalidadeRepository;
import br.tec.gtech.correios_dne_loader.util.StringUtilities;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LocalidadeService {

    private static final String SEPARADOR = "@";

    private LocalidadeRepository repository;

    @Transactional
    public void carregarDados(BufferedReader br) throws IOException {
        repository.deleteAllLocalidades();

        List<Localidade> localidades = new ArrayList<>();
        String linha;
        while ((linha = br.readLine()) != null) {
            String[] campos = linha.split(SEPARADOR);

            if (campos.length >= 8) {
                Localidade localidade = new Localidade();
                localidade.setCodigo(Long.parseLong(campos[0]));
                localidade.setUf(campos[1]);
                localidade.setNomeLocalidade(StringUtilities.removerAcentos(campos[2]));
                localidade.setCep(campos[3]);
                localidade.setIndicadorDados(Integer.parseInt(campos[4]));
                localidade.setTipoLocalidade(StringUtilities.removerAcentos(campos[5]));
                localidade.setCodSubordinacao(campos[6].isEmpty() ? null : Integer.parseInt(campos[6]));
                localidade.setNomeAbreviado(StringUtilities.removerAcentos(campos[7]));

                localidades.add(localidade);
            }
        }

        repository.saveAll(localidades);
    }


}