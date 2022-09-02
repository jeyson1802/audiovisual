package com.audiovisual.landing.dto;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

public class CampanaDto implements Serializable {
    private Integer idCampana;
    private String descripcion;
    private String linkCampana;
    private String linkCreativos;
    private String linkCanal;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private String idlistaProveedorEmailMarketing;
    private CursoDto curso;
    private TraficoDto trafico;
    private ListaLeadDto listaLead;
    private ProveedorEmailMarketingDto proveedorEmailMarketing;
    private String estado;
    private Instant fechaRegistro;
    private String usuarioRegistro;
    private Instant fechaModificacion;
    private String usuarioModificacion;

    public Integer getIdCampana() {
        return idCampana;
    }

    public void setIdCampana(Integer idCampana) {
        this.idCampana = idCampana;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLinkCampana() {
        return linkCampana;
    }

    public void setLinkCampana(String linkCampana) {
        this.linkCampana = linkCampana;
    }

    public String getLinkCreativos() {
        return linkCreativos;
    }

    public void setLinkCreativos(String linkCreativos) {
        this.linkCreativos = linkCreativos;
    }

    public String getLinkCanal() {
        return linkCanal;
    }

    public void setLinkCanal(String linkCanal) {
        this.linkCanal = linkCanal;
    }

    public LocalDate getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(LocalDate fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getIdlistaProveedorEmailMarketing() {
        return idlistaProveedorEmailMarketing;
    }

    public void setIdlistaProveedorEmailMarketing(String idlistaProveedorEmailMarketing) {
        this.idlistaProveedorEmailMarketing = idlistaProveedorEmailMarketing;
    }

    public CursoDto getCurso() {
        return curso;
    }

    public void setCurso(CursoDto curso) {
        this.curso = curso;
    }

    public TraficoDto getTrafico() {
        return trafico;
    }

    public void setTrafico(TraficoDto trafico) {
        this.trafico = trafico;
    }

    public ListaLeadDto getListaLead() {
        return listaLead;
    }

    public void setListaLead(ListaLeadDto listaLead) {
        this.listaLead = listaLead;
    }

    public ProveedorEmailMarketingDto getProveedorEmailMarketing() {
        return proveedorEmailMarketing;
    }

    public void setProveedorEmailMarketing(ProveedorEmailMarketingDto proveedorEmailMarketing) {
        this.proveedorEmailMarketing = proveedorEmailMarketing;
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
                "idCampana = " + idCampana + ", " +
                "descripcion = " + descripcion + ", " +
                "linkCampana = " + linkCampana + ", " +
                "linkCreativos = " + linkCreativos + ", " +
                "linkCanal = " + linkCanal + ", " +
                "fechaInicial = " + fechaInicial + ", " +
                "fechaFinal = " + fechaFinal + ", " +
                "idlistaProveedorEmailMarketing = " + idlistaProveedorEmailMarketing + ", " +
                "curso = " + curso + ", " +
                "trafico = " + trafico + ", " +
                "listaLead = " + listaLead + ", " +
                "proveedorEmailMarketing = " + proveedorEmailMarketing + ", " +
                "estado = " + estado + ", " +
                "fechaRegistro = " + fechaRegistro + ", " +
                "usuarioRegistro = " + usuarioRegistro + ", " +
                "fechaModificacion = " + fechaModificacion + ", " +
                "usuarioModificacion = " + usuarioModificacion + ")";
    }
}
