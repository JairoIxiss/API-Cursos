package com.ejercicio.cursos.service;

import com.ejercicio.cursos.dto.CursoTemaDTO;
import com.ejercicio.cursos.service.ICursoService;
import com.ejercicio.cursos.model.Curso;
import com.ejercicio.cursos.repository.ICursoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService implements ICursoService{
    @Autowired
    private ICursoRepository cursRepo;
    
    @Override
    public void saveCurso(Curso curs) {
        cursRepo.save(curs);
    }

    @Override
    public List<Curso> getCursos() {
        return cursRepo.findAll();
    }

    @Override
    public void editCurso(Long id, Curso nuevoCurso) {
        Curso curso = this.findCurso(id);

        curso.setNombre(nuevoCurso.getNombre());
        curso.setFecha_finalizacion(nuevoCurso.getFecha_finalizacion());
        curso.setModalidad(nuevoCurso.getModalidad());
        curso.setListaDeTemas(nuevoCurso.getListaDeTemas());

        this.saveCurso(curso);
    }

    @Override
    public Curso findCurso(Long id) {
        return cursRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteCurso(Long id) {
        cursRepo.deleteById(id);
    }

    @Override
    public List<Curso> getCursosJava() {

        String clave = "Java";
        String comparacion;
        
        List<Curso> listaCursos= this.getCursos();
        List<Curso> listaJava= new ArrayList<Curso>();
        
        for (Curso curso :listaCursos) {
            comparacion = curso.getNombre();
            boolean esJava = comparacion.contains(clave);
            if (esJava ==true){
                listaJava.add(curso);
            }
        }
        return listaJava;
    }

    @Override
    public CursoTemaDTO temasDeCurso(Long id_curso) {

            CursoTemaDTO temsCur = new CursoTemaDTO();
            Curso cur = this.findCurso(id_curso);
            
            temsCur.setCursNom(cur.getNombre());
            temsCur.setListaTemas(cur.getListaDeTemas());
            
            return temsCur;

    }

    
}
