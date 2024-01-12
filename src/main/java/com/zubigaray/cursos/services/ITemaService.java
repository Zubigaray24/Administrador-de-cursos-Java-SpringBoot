package com.zubigaray.cursos.services;

import com.zubigaray.cursos.model.Tema;

public interface ITemaService {

    //Crear temas y asociar a un curso
    public void saveTopic(Tema tema);
    
    //Modificar los datos de un tema
    public void modifyTopic(Tema tema);

    public void deleteTopic(Long id_tema);
}
