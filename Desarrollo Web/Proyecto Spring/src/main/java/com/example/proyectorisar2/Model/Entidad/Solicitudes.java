package com.example.proyectorisar2.Model.Entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "solicitudes")
public class Solicitudes implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "Nombre")
    @NotEmpty
    private String nombre;
    @Column(name = "DI")
    @NotEmpty
    private String di;
    @Column(name = "telefono")
    @NotNull
    private int telefono;
    @Column(name = "Asunto")
    @NotEmpty
    private String asunto;
    @Column(name = "Descripcion")
    @NotEmpty
    private String descripcion;
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * @return the di
     */
    public String getDi() {
        return di;
    }
    /**
     * @param di the di to set
     */
    public void setDi(String di) {
        this.di = di;
    }
    /**
     * @return the telefono
     */
    public int getTelefono() {
        return telefono;
    }
    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    /**
     * @return the asunto
     */
    public String getAsunto() {
        return asunto;
    }
    /**
     * @param asunto the asunto to set
     */
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }
    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }
    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    
    
}
