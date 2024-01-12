package com.zubigaray.cursos.controller;

import com.zubigaray.cursos.model.Tema;
import com.zubigaray.cursos.services.ITemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemaController {
    
    @Autowired
    private ITemaService temaService;
    
    @PostMapping("/temas/crear")
    public void saveTopic(@RequestBody Tema tema){
        temaService.saveTopic(tema);
    }
    
    @PutMapping("/temas/editar")
    public void modifyTopic(@RequestBody Tema tema){
        temaService.modifyTopic(tema);
    }
    
    @DeleteMapping("/temas/borrar/{id_tema}")
    public void deleteCourse(@PathVariable Long id_tema){
        temaService.deleteTopic(id_tema);
    }
}
