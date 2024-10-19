package com.ejercicio.cursos.controller;

import com.ejercicio.cursos.model.Tema;
import com.ejercicio.cursos.service.TemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemaController {
    @Autowired
    private TemaService temServ;
    
    @PostMapping("/temas/crear")
    public String crearTema(@RequestBody Tema tem){
        temServ.saveTema(tem);
        return "El tema se ha creado con exito";
    }
    
    @PutMapping("/temas/editar")
    public Tema editarTema(@RequestBody Tema tem){
        temServ.editTema(tem);
        return temServ.findTema(tem.getId_tema());
    }
    
}
