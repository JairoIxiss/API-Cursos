package com.ejercicio.cursos.controller;

import com.ejercicio.cursos.dto.CursoTemaDTO;
import com.ejercicio.cursos.model.Curso;
import com.ejercicio.cursos.service.CursoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
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

    @GetMapping("/cursos/traer/{id}")
    public Curso traerCurso(@PathVariable Long id){
        return curServ.findCurso(id);
    }

    @PutMapping("/cursos/editar/{id}")
    public Curso editarCurso(@PathVariable Long id, @RequestBody Curso cur){
        curServ.editCurso(id, cur);
        return curServ.findCurso(id);
    }
    
    @GetMapping("/cursos/tema/{id_curso}")
    public CursoTemaDTO TemasdeCurso(@PathVariable Long id_curso){
        return curServ.temasDeCurso(id_curso);
    }
    
    @GetMapping("/cursos/java")
    public List<Curso> cursosJava (){
        return curServ.getCursosJava();
    }

    @DeleteMapping("/cursos/eliminar/{id}")
    public String eliminarCurso (@PathVariable Long id){
        curServ.deleteCurso(id);
        return "Curso Eliminado";
    }
}
