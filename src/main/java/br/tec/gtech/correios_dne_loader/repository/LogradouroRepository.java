package br.tec.gtech.correios_dne_loader.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import br.tec.gtech.correios_dne_loader.entity.Logradouro;

public interface LogradouroRepository extends JpaRepository<Logradouro, Long> {

    @Modifying
    @Query("DELETE FROM Logradouro")
    public void deleteAllLogradouros();
}

