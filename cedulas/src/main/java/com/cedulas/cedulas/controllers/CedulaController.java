package com.cedulas.cedulas.controllers;

import com.cedulas.cedulas.entities.Cedula;
import com.cedulas.cedulas.services.CedulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cedula")
public class CedulaController {

    @Autowired
    private CedulaService cedulaService;

    @PostMapping
    public ResponseEntity<?> createCedula(@RequestBody Cedula cedula){
        return ResponseEntity.ok(cedulaService.createCedula(cedula));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCedula(@PathVariable Long id){
        return ResponseEntity.ok(cedulaService.getCedula(id));
    }

    @GetMapping("/ordenamiento/{id}")
    public ResponseEntity<?> getCedulasOrdenadas(@PathVariable Long id){
        return ResponseEntity.ok(cedulaService.getCedulasOrdenadas(id));
    }

    @GetMapping("/getnumero/{id}")
    public ResponseEntity<?> getNumero(@PathVariable Long id, @RequestBody int numero){
        return ResponseEntity.ok(cedulaService.findNumero(id, numero));
    }

    @GetMapping("getfaltantes/{id}")
    public ResponseEntity<?> getFaltantes(@PathVariable Long id, @RequestBody int numero){
        return ResponseEntity.ok(cedulaService.numerosRestantes(id, numero));
    }

}
