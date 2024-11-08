package com.example.microa;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "MICROB")
public interface MicroBFeign {

    //El no sabe en que puerto esta y mucho menos en que server esta

    @GetMapping("/saludo")
    String obtenerUnSaludoDeB(@RequestParam String nombre);

    @PostMapping("/procesa")
    RespuestaDto procesaSaludo(@RequestBody DatoDto datoDto);
}
