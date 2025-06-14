package com.ejercicio.cursos.service;

import com.ejercicio.cursos.model.Tema;
import java.util.List;

public interface ITemaService {
    
    public void saveTema(Tema tem);
    
    public Tema findTema(Long id);
    
    public List<Tema> getTemas();
    
    public void editTema(Long id, Tema nuevoTema);
    
    public void deleteTema(Long id);        
    
}
