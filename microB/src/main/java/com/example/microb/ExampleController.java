package com.example.microb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class ExampleController {

    @Value("${mensaje}")
    private String mensaje;

    @GetMapping("/saludo")
    public String obtenerSaludo(@RequestParam String nombre) {
        log.info(nombre);
        return mensaje + " para el nombre " + nombre;
    }

    @PostMapping("/procesa")
    public RespuestaDto procesaSaludo(@RequestBody DatoDto datoDto) {
        log.info("Recibi {}", datoDto);
        if(datoDto.nombre().equals("orlando")){
            throw new OrlandoException();
        }
        return new RespuestaDto("Gracias por enviar " + datoDto.nombre(), "001");
    }

    @GetMapping("/procesa-get/{nombre}")
    public RespuestaDto procesaSaludo(@PathVariable String nombre) {
        if(nombre.equals("orlando")){
            throw new OrlandoException();
        }
        return new RespuestaDto("Gracias por enviar " + nombre, "001");
    }

    @GetMapping("/materia/{nombre}")
    public RespuestaDto materia(@PathVariable MateriaEnum nombre) {

        return new RespuestaDto("Gracias por enviar " + nombre, "001");
    }
}
