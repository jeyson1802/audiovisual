package com.audiovisual.landing.service;

public interface SendinBlueService {

    void crearContacto(String email, String apellidos, String nombres, String numero, String idLista, String apiKeyEmailMarketing) throws Exception;
}
