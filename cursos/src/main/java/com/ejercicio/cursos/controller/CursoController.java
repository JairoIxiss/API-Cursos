package com.ejercicio.cursos.controller;

import com.ejercicio.cursos.dto.CursoTemaDTO;
import com.ejercicio.cursos.model.Curso;
import com.ejercicio.cursos.service.CursoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CursoController {
    @Autowired
    private CursoService curServ;
    
    @PostMapping("/cursos/crear")
    public String crearCurso(@RequestBody Curso cur){
        curServ.saveCurso(cur);
        return "El curso se ha creado con exito";
    }
    
    @GetMapping("/cursos/traer")
    public List<Curso> traerCursos(){
        return curServ.getCursos();
    }
    
    @PutMapping("/cursos/editar")
    public Curso editarCurso(@RequestBody Curso cur){
        curServ.saveCurso(cur);
        return curServ.findCurso(cur.getId_curso());
    }
    
    @GetMapping("/cursos/tema/{id_curso}")
    public CursoTemaDTO TemasdeCurso(@PathVariable Long id_curso){
        return curServ.temasDeCurso(id_curso);
    }
    
    @GetMapping("/cursos/java")
    public List<Curso> cursosJava (){
        return curServ.getCursosJava();
    }
    
}
