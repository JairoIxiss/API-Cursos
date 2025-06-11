package com.ejercicio.cursos.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Curso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_curso;
    private String nombre;
    private String modalidad;
    private LocalDate fecha_finalizacion;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "curso_id")
    private List <Tema> listaDeTemas;
    
    public Curso() {
    }

    public Curso(Long id_curso, String nombre, String modalidad, LocalDate fecha_finalizacion, List<Tema> listaDeTemas) {
        this.id_curso = id_curso;
        this.nombre = nombre;
        this.modalidad = modalidad;
        this.fecha_finalizacion = fecha_finalizacion;
        this.listaDeTemas = listaDeTemas;
    }


 
}
