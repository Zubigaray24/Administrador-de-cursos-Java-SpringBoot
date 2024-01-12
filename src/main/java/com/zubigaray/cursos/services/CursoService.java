package com.zubigaray.cursos.services;

import com.zubigaray.cursos.dto.CursoTemaDTO;
import com.zubigaray.cursos.model.Curso;
import com.zubigaray.cursos.repository.ICursoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService implements ICursoService{
    
    @Autowired
    private ICursoRepository cursoRepo;

    @Override
    public void saveCourse(Curso curso) {
        cursoRepo.save(curso);
    }

    @Override
    public void deleteCourse(Long id_curso) {
        cursoRepo.deleteById(id_curso);
    }

    @Override
    public Curso getCourse(Long id_curso) {
        Curso cursoResultado = cursoRepo.findById(id_curso).orElse(null);
        return cursoResultado;
    }

    @Override
    public List<Curso> getAllCourses() {
        List<Curso> resultado = new ArrayList<>();
        resultado = cursoRepo.findAll();
        return resultado;
    }

    @Override
    public CursoTemaDTO getAllTopicsOfACourse(Long id_curso) {
        CursoTemaDTO cursoTemaDTO = new CursoTemaDTO ();
        Curso curso = this.getCourse(id_curso);
        cursoTemaDTO.setNombreCurso(curso.getNombre());
        cursoTemaDTO.setListaTemas(curso.getListaTemas());
        
        return cursoTemaDTO;
    }

    @Override
    public List<Curso> getAllTheCourseThatContain(String palabra) {
        List<Curso> todosLosCursos = new ArrayList<>();
        todosLosCursos = this.getAllCourses();
        
        List<Curso> resultado = new ArrayList<>();
        
        for(Curso curso : todosLosCursos){
            if(curso.getNombre().contains(palabra)){
                resultado.add(curso);
            }
        }
        
        return resultado;
    }

    @Override
    public void modifyCourse(Curso curso) {
        this.saveCourse(curso);
    }
    
}
