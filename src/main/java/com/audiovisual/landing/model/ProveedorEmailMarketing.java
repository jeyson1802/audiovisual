package com.audiovisual.landing.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "proveedor_email_marketing")
public class ProveedorEmailMarketing {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idproveedor_email_marketing", nullable = false)
    private Integer idProveedorEmailMarketing;

    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;

    @Column(name = "correo", nullable = false, length = 200)
    private String correo;

    @Column(name = "api", nullable = false, length = 200)
    private String api;

    @Column(name = "estado", nullable = false, length = 1)
    private String estado;

    @Column(name = "fecha_registro", nullable = false)
    private Instant fechaRegistro;

    @Column(name = "usuario_registro", nullable = false, length = 45)
    private String usuarioRegistro;

    @Column(name = "fecha_modificacion")
    private Instant fechaModificacion;

    @Column(name = "usuario_modificacion", length = 45)
    private String usuarioModificacion;

    public Integer getIdProveedorEmailMarketing() {
        return idProveedorEmailMarketing;
    }

    public void setIdProveedorEmailMarketing(Integer idProveedorEmailMarketing) {
        this.idProveedorEmailMarketing = idProveedorEmailMarketing;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Instant getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Instant fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(String usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }

    public Instant getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Instant fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

}