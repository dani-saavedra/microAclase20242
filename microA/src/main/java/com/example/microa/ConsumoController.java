package com.example.microa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumoController {

    private MicroBFeign feignB;

    public ConsumoController(MicroBFeign feignB) {
        this.feignB = feignB;
    }

    @GetMapping("/busca-saludo/{unnombre}")
    public String obtenerSaludo(@PathVariable String unnombre) {
        return "Buscando respuest del server" + feignB.obtenerUnSaludoDeB(unnombre);
    }

    @GetMapping("/procesa/{nombre}")
    public String procesa(@PathVariable String nombre) {
        return "Procesando " + feignB.procesaSaludo(new DatoDto(nombre, 33));
    }
}
