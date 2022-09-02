package com.audiovisual.landing.dto;

import java.io.Serializable;
import java.time.Instant;

public class ListaLeadDto implements Serializable {
    private Integer idListaLead;
    private String descripcion;
    private String estado;
    private Instant fechaRegistro;
    private String usuarioRegistro;
    private Instant fechaModificacion;
    private String usuarioModificacion;

    public Integer getIdListaLead() {
        return idListaLead;
    }

    public void setIdListaLead(Integer idListaLead) {
        this.idListaLead = idListaLead;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
                "idListaLead = " + idListaLead + ", " +
                "descripcion = " + descripcion + ", " +
                "estado = " + estado + ", " +
                "fechaRegistro = " + fechaRegistro + ", " +
                "usuarioRegistro = " + usuarioRegistro + ", " +
                "fechaModificacion = " + fechaModificacion + ", " +
                "usuarioModificacion = " + usuarioModificacion + ")";
    }
}
