package com.audiovisual.landing.model;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "campana")
public class Campana {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idcampana", nullable = false)
    private Integer idCampana;

    @Column(name = "descripcion", nullable = false, length = 200)
    private String descripcion;

    @Column(name = "link_campana", nullable = false, length = 200)
    private String linkCampana;

    @Column(name = "link_creativos", length = 200)
    private String linkCreativos;

    @Column(name = "link_canal", length = 200)
    private String linkCanal;

    @Column(name = "fecha_inicial")
    private LocalDate fechaInicial;

    @Column(name = "fecha_final")
    private LocalDate fechaFinal;

    @Column(name = "idlista_proveedor_email_marketing", nullable = false, length = 100)
    private String idlistaProveedorEmailMarketing;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idcurso", nullable = false)
    private Curso curso;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idtrafico", nullable = false)
    private Trafico trafico;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idlista_lead", nullable = false)
    private ListaLead listaLead;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idproveedor_email_marketing", nullable = false)
    private ProveedorEmailMarketing proveedorEmailMarketing;

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

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Trafico getTrafico() {
        return trafico;
    }

    public void setTrafico(Trafico trafico) {
        this.trafico = trafico;
    }

    public ListaLead getListaLead() {
        return listaLead;
    }

    public void setListaLead(ListaLead listaLead) {
        this.listaLead = listaLead;
    }

    public ProveedorEmailMarketing getProveedorEmailMarketing() {
        return proveedorEmailMarketing;
    }

    public void setProveedorEmailMarketing(ProveedorEmailMarketing proveedorEmailMarketing) {
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

}