package br.tec.gtech.correios_dne_loader.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import br.tec.gtech.correios_dne_loader.entity.Localidade;

public interface LocalidadeRepository extends JpaRepository<Localidade, Long> {

    @Modifying
    @Query("DELETE FROM Localidade")
    public void deleteAllLocalidades();
}

