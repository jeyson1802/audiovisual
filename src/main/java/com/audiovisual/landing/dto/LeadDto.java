package com.audiovisual.landing.dto;

import java.io.Serializable;
import java.time.Instant;

public class LeadDto implements Serializable {
    private Integer idLead;
    private String correo;
    private String nombres;
    private String ubicacion;
    private ListaLeadDto listaLead;
    private CampanaDto campana;
    private String estado;
    private Instant fechaRegistro;
    private String usuarioRegistro;
    private Instant fechaModificacion;
    private String usuarioModificacion;

    public Integer getIdLead() {
        return idLead;
    }

    public void setIdLead(Integer idLead) {
        this.idLead = idLead;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public ListaLeadDto getListaLead() {
        return listaLead;
    }

    public void setListaLead(ListaLeadDto listaLead) {
        this.listaLead = listaLead;
    }

    public CampanaDto getCampana() {
        return campana;
    }

    public void setCampana(CampanaDto campana) {
        this.campana = campana;
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
                "idLead = " + idLead + ", " +
                "correo = " + correo + ", " +
                "nombres = " + nombres + ", " +
                "ubicacion = " + ubicacion + ", " +
                "listaLead = " + listaLead + ", " +
                "campana = " + campana + ", " +
                "estado = " + estado + ", " +
                "fechaRegistro = " + fechaRegistro + ", " +
                "usuarioRegistro = " + usuarioRegistro + ", " +
                "fechaModificacion = " + fechaModificacion + ", " +
                "usuarioModificacion = " + usuarioModificacion + ")";
    }
}
