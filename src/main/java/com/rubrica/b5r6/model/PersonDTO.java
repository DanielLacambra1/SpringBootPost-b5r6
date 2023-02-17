package com.rubrica.b5r6.model;

import java.math.BigDecimal;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

public class PersonDTO {
    private String nombre;
    private String apellido;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fnac;
    private String profesion;
    private BigDecimal salario;

    public PersonDTO() {
    }

    public PersonDTO(String nombre, String apellido, Date fnac, String profesion, BigDecimal salario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fnac = fnac;
        this.profesion = profesion;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public Date getFnac() {
        return fnac;
    }
    public void setFnac(Date fnac) {
        this.fnac = fnac;
    }
    public String getProfesion() {
        return profesion;
    }
    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }
    public BigDecimal getSalario() {
        return salario;
    }
    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

}
