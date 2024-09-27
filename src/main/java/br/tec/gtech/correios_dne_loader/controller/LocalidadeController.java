package br.tec.gtech.correios_dne_loader.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.tec.gtech.correios_dne_loader.service.LocalidadeService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class LocalidadeController {

    private LocalidadeService service;

    @PostMapping("/carregar-localidades")
    public String carregarLocalidades(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "Arquivo vazio. Por favor, envie um arquivo válido.";
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream(), "Windows-1252"))) {
            service.carregarDados(br);
            return "Dados de localidades carregados com sucesso!";
        } catch (IOException e) {
            return "Erro ao carregar dados: " + e.getMessage();
        }
    }
}