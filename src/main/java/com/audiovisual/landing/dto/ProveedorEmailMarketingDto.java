package com.audiovisual.landing.dto;

import java.io.Serializable;
import java.time.Instant;

public class ProveedorEmailMarketingDto implements Serializable {
    private Integer idProveedorEmailMarketing;
    private String nombre;
    private String correo;
    private String api;
    private String estado;
    private Instant fechaRegistro;
    private String usuarioRegistro;
    private Instant fechaModificacion;
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

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "idProveedorEmailMarketing = " + idProveedorEmailMarketing + ", " +
                "nombre = " + nombre + ", " +
                "correo = " + correo + ", " +
                "api = " + api + ", " +
                "estado = " + estado + ", " +
                "fechaRegistro = " + fechaRegistro + ", " +
                "usuarioRegistro = " + usuarioRegistro + ", " +
                "fechaModificacion = " + fechaModificacion + ", " +
                "usuarioModificacion = " + usuarioModificacion + ")";
    }
}
