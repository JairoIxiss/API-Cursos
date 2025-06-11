
package com.ejercicio.cursos.service;

import com.ejercicio.cursos.repository.ITemaRepository;
import com.ejercicio.cursos.model.Tema;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemaService implements ITemaService{
    @Autowired
    private ITemaRepository temaRepo;

    @Override
    public void saveTema(Tema tem) {
        temaRepo.save(tem);
    }

    @Override
    public void editTema(Long id, Tema temaNuevo) {
        Tema temaEditar = this.findTema(id);

        temaEditar.setNombre(temaNuevo.getNombre());
        temaEditar.setDescripcion(temaNuevo.getDescripcion());

        this.saveTema(temaEditar);
    }

    @Override
    public Tema findTema(Long id) {
        return temaRepo.findById(id).orElse(null);
    }

    @Override
    public List<Tema> getTemas() {
        return temaRepo.findAll();
    }

    @Override
    public void deleteTema(Long id) {
        temaRepo.deleteById(id);
    }


}
