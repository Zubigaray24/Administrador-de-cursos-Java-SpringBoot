package com.zubigaray.cursos.controller;

import com.zubigaray.cursos.dto.CursoTemaDTO;
import com.zubigaray.cursos.model.Curso;
import com.zubigaray.cursos.services.ICursoService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CursoController {
    
    @Autowired
    private ICursoService cursoService;
    
    @PostMapping("/cursos/crear")
    public void saveCourse(@RequestBody Curso curso){
        cursoService.saveCourse(curso);
    }
    
    @DeleteMapping("/cursos/borrar/{id_curso}")
    public void deleteCourse(@PathVariable Long id_curso){
        cursoService.deleteCourse(id_curso);
    }
    
    @GetMapping("/cursos/traer/{id_curso}")
    public Curso getCourse(@PathVariable Long id_curso){
        Curso curso = cursoService.getCourse(id_curso);
        return curso;
    }
    
    @GetMapping("/cursos/traerTodos")
    public List<Curso> getAllCourses(){
        List<Curso> resultado = new ArrayList<>();
        resultado = cursoService.getAllCourses();
        return resultado;
    }
    
    @GetMapping("/cursos/traerTemasDeUnCurso/{id_curso}")
    public CursoTemaDTO getAllTopicsOfACourse(@PathVariable Long id_curso){
        CursoTemaDTO CursoTemaDTO = cursoService.getAllTopicsOfACourse(id_curso);
        return CursoTemaDTO;
    }
    
    @GetMapping("/cursos/traerPorPalabra/{palabra}")
    public List<Curso> getAllTheCourseThatContain(@PathVariable String palabra){
        List<Curso> resultado = cursoService.getAllTheCourseThatContain(palabra);
        return resultado;
    }
    
    @PutMapping("/cursos/editar")
    public void modifyCourse(@RequestBody Curso curso){
        cursoService.modifyCourse(curso);
    }
}
