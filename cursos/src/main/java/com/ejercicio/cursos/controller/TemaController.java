package com.ejercicio.cursos.controller;

import com.ejercicio.cursos.model.Tema;
import com.ejercicio.cursos.service.TemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/temas")
public class TemaController {
    @Autowired
    private TemaService temServ;
    
    @PostMapping("/crear")
    public String crearTema(@RequestBody Tema tem){
        temServ.saveTema(tem);
        return "El tema se ha creado con exito";
    }

    @GetMapping("/traer")
    public List<Tema> traerTemas(){
        return temServ.getTemas();
    }

    @GetMapping("/traer/{id}")
    public Tema traerTema(@PathVariable Long id){
        return temServ.findTema(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarTema(@PathVariable Long id){
        temServ.deleteTema(id);
        return "El tema se ha eliminado de forma correcta";
    }

    @PutMapping("/editar")
    public Tema editarTema(@RequestBody Tema tem){
        temServ.editTema(tem);
        return temServ.findTema(tem.getId_tema());
    }
    
}
