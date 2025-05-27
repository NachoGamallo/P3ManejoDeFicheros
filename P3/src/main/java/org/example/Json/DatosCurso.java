package org.example.Json;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString

public class DatosCurso {

    private String curso;
    private String instituto;
    private List <String> listaAlumnos;

    public DatosCurso(){}

    public DatosCurso(String curso, String instituto , List<String> listaAlumnos){

        this.curso = curso;
        this.instituto = instituto;
        this.listaAlumnos = new ArrayList<>(listaAlumnos);

    }
}
