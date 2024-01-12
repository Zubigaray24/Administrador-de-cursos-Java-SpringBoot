package com.zubigaray.cursos.services;

import com.zubigaray.cursos.model.Tema;
import com.zubigaray.cursos.repository.ITemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemaService implements ITemaService{

    @Autowired
    private ITemaRepository temaRepo;
    
    @Override
    public void saveTopic(Tema tema) {
        temaRepo.save(tema);
    }

    @Override
    public void modifyTopic(Tema tema) {
        this.saveTopic(tema);
    }

    @Override
    public void deleteTopic(Long id_tema) {
        temaRepo.deleteById(id_tema);
    }
    
}
