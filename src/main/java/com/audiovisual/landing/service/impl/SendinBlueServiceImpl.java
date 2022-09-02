package com.audiovisual.landing.service.impl;

import com.audiovisual.landing.service.SendinBlueService;
import com.audiovisual.landing.util.StringUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import sendinblue.ApiClient;
import sendinblue.Configuration;
import sendinblue.auth.ApiKeyAuth;
import sibApi.ContactsApi;
import sibModel.CreateContact;
import sibModel.CreateUpdateContactModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Service
public class SendinBlueServiceImpl implements SendinBlueService {

    private static final Logger logger = LogManager.getLogger(SendinBlueServiceImpl.class);

    @Override
    public void crearContacto(String email, String idLista, String apiKeyEmailMarketing) throws Exception {

        logger.info("Inicio crearContacto");

        ApiClient defaultClient = Configuration.getDefaultApiClient();
        ApiKeyAuth apiKey = (ApiKeyAuth) defaultClient.getAuthentication("api-key");
        apiKey.setApiKey(apiKeyEmailMarketing);

        ContactsApi api = new ContactsApi();

        CreateContact createContact = new CreateContact();
        createContact.setEmail(email);

        List<Long> listIds = new ArrayList<Long>();
        listIds.add(StringUtil.toLong(idLista));
        createContact.setListIds(listIds);

        createContact.setEmailBlacklisted(false);
        createContact.setSmsBlacklisted(false);
        createContact.setUpdateEnabled(false);

        CreateUpdateContactModel response = api.createContact(createContact);
        logger.info("Response Create Contact SendinBlue ==> " + response);

        logger.info("Fin crearContacto");
    }
}
