package com.leo.biblioteca.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leo.biblioteca.entity.TituloEntity;
import com.leo.biblioteca.service.TituloService;

@RestController
@RequestMapping("api/titulo")
public class TituloControler {
    @Autowired
    private TituloService service;

    @GetMapping
    public ResponseEntity<List<TituloEntity>> listarTitulos() {
        return ResponseEntity.ok(service.listarTitulos());
    }

    @PostMapping("/cadastrarTitulo")
    public ResponseEntity<TituloEntity> cadastrarTitulo(@RequestBody TituloEntity titulo) {
        return ResponseEntity.ok(service.cadastrarTitulo(titulo));
    }
}
