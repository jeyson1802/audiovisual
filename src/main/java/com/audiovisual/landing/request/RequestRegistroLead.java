package com.audiovisual.landing.request;

import java.io.Serializable;

public class RequestRegistroLead implements Serializable {

    private String correo;
    private String idCampana;

    public RequestRegistroLead() {
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getIdCampana() {
        return idCampana;
    }

    public void setIdCampana(String idCampana) {
        this.idCampana = idCampana;
    }

    @Override
    public String toString() {
        return "RequestRegistroLead{" +
                "correo='" + correo + '\'' +
                ", idCampana=" + idCampana +
                '}';
    }
}
