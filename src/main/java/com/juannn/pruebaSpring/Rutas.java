package com.juannn.pruebaSpring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Rutas {

    @GetMapping("/hola")
    String mi_primera_ruta(){
        return "hola mundo desde spring controller :)";
    }

    @GetMapping("/libro/{id}/editorial/{editorial}")
    String leer_libro(@PathVariable int id, @PathVariable String editorial){
        return "Leyendo el libro id: " + id +"\neditorial: " + editorial;
    }

}
