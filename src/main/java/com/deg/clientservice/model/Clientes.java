package com.deg.clientservice.model;

import java.time.LocalDate;
import java.time.Period;



import javax.persistence.*;


@Entity
@Table(name = "cliente")
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;

  @Column(name ="fecha_nacimiento",nullable = false)
    private LocalDate fecha_nacimiento;
   @Transient
   private Integer edad;
 public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Integer getEdad() {
        return Period.between(fecha_nacimiento,LocalDate.now()).getYears();
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
}

 


