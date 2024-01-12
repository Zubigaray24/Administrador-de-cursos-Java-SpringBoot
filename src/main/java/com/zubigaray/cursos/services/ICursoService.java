package com.zubigaray.cursos.services;

import com.zubigaray.cursos.dto.CursoTemaDTO;
import com.zubigaray.cursos.model.Curso;
import java.util.List;

public interface ICursoService {
    
    //Crear un nuevo curso - ALTA
    public void saveCourse(Curso curso);
    
    //Borrar un curso - BAJA
    public void deleteCourse(Long id_curso);
    
    //Traer un solo curso
    public Curso getCourse(Long id_curso);
    
    //Obtener todos los cursos -LECTURA
    public List<Curso> getAllCourses();
    
    //Obtener todos los temas de un curso - LECTURA
    public CursoTemaDTO getAllTopicsOfACourse(Long id_curso);
    
    //Obtener todos los temas de un curso que tengo incluida una palabra en especifico - LECTURA
    public List<Curso> getAllTheCourseThatContain(String palabra);
    
    //Modificar los datos de un curso - MODIFICACION
    public void modifyCourse(Curso curso);
}
