package com.ejercicio.cursos.dto;

import com.ejercicio.cursos.model.Curso;
import com.ejercicio.cursos.model.Tema;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CursoTemaDTO {

    private String cursNom;
    private List<Tema> listaTemas;

    public CursoTemaDTO() {
    }

    public CursoTemaDTO(String cursNom, List<Tema> listaTemas) {
        this.cursNom = cursNom;
        this.listaTemas = listaTemas;
    }

}
