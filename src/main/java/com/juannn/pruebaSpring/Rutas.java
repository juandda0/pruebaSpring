package com.juannn.pruebaSpring;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/libros") // Ruta base para las solicitudes
public class Rutas {

    //Almacenar libros en memoria (Simula una base de datos)
    private Map<Integer, Libro> libros = new HashMap<>();


    public Rutas(){
        //El constructor se encarga de crear 2 libros iniciales
        libros.put(1, new Libro(1, "Libro 1", "Juan", "editorial Juan"));
        libros.put(2, new Libro(2, "Libro 2", "Juan", "editorial Juan"));
    }

    //Manejo de solicitdes GET para obtener todos los libros de la BD
    @GetMapping
    Map<Integer, Libro> obtener_libros(){
        return libros;
    }

    //Manejo de solicitdes GET para obtener un libro por id de la BD
    @GetMapping("/{id}")
    Libro libro_id(@PathVariable int id){
        return libros.get(id);
    }
    //Manejo de solicitudes POST para agregar un nuevo libro a la BD
    @PostMapping
    String agregar_libro(@RequestBody Libro libro){ //Se solicita un libro
        if(libros.containsKey(libro.getId())){
            return "El libro con el id: " + libro.getId() + ", ya existe.";
        }
        libros.put(libro.getId(), libro);
        return "El libro " + libro.getTitulo() + ", Fue agregado a la base de datos: ";
    }

    //Manejo de solicitudes PUT para actualizar un libro de la BD
    @PutMapping("/{id}")
    String actualizar_libro(@PathVariable int id, @RequestBody Libro libro){ //Solicitamos un id y un libro
        if(!libros.containsKey(id)){
            return "El libro con el id: " + id + ", no existe";
        }

        libro.setId(id);
        libros.put(id, libro);
        return "El libro: " + libro.getTitulo() + ", fue actualizado";
    }

    //Manejo de solicitudes DELETE para eliminar un libro de la BD
    @DeleteMapping("/{id}")
    String eliminar_libro(@PathVariable int id) {
        if (!libros.containsKey(id)) {
            return "El libro con el id: " + id + ", no existe";
        }
        libros.remove(id);
        return "El libro con el id: " + id + ", fue eliminado";
    }

}
