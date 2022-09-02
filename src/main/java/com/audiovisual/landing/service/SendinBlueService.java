package com.audiovisual.landing.service;

public interface SendinBlueService {

    void crearContacto(String email, String idLista, String apiKeyEmailMarketing) throws Exception;
}
