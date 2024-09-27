package br.tec.gtech.correios_dne_loader.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.tec.gtech.correios_dne_loader.entity.Bairro;

public interface BairroRepository extends JpaRepository<Bairro, Long> {

    @Modifying
    @Query("DELETE FROM Bairro")
    public void deleteAllBairros();
}
