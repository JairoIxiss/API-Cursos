package com.ejercicio.cursos.service;

import com.ejercicio.cursos.dto.CursoTemaDTO;
import com.ejercicio.cursos.model.Curso;
import java.util.List;

public interface ICursoService {
    
    public void saveCurso(Curso curs);
    
    public List<Curso> getCursos();
    
    public Curso findCurso(Long id);
    
    public void editCurso(Long id, Curso nuevoCurso);
    
    public void deleteCurso(Long id);
    
    public List<Curso> getCursosJava();
    
    public CursoTemaDTO temasDeCurso(Long id_curso);
        
}
