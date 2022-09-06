var hid_campana;
var txt_correo_inicial;
var txt_correo_final;
var btn_inicial;
var btn_final;
var form_lead_inicial;
var form_lead_final;
var div_landing;
var div_gracias;

var HttpCodes = {
    success  : 200,
    unprocessableentity : 422,
    error  : 500
};

var Boton = {
    PRIMARY	: "btn-primary",
    WARNING	: "btn-warning",
    INFO	: "btn-info",
    SUCCESS	: "btn-success",
    DANGER	: "btn-danger"
}

var mensajeGenericoError = "Ocurrió un error inesperado. Por favor intentar nuevamente.";

$(document).ready(function(){
    initVariables();
    initComponentes();
});

function initVariables() {
    hid_campana = $("#hid_campana");
    txt_correo_inicial = $("#txt_correo_inicial");
    txt_correo_final = $("#txt_correo_final");
    btn_inicial = $("#btn_inicial");
    btn_final = $("#btn_final");
    form_lead_inicial = $("#form_lead_inicial");
    form_lead_final = $("#form_lead_final")
    div_landing = $("#div_landing");
    div_gracias = $("#div_gracias");
}

function initComponentes() {

    validacionFormularios();

    btn_inicial.on("click", function(){

        form_lead_inicial.validate().then(function(status) {
            if(status === 'Valid') {
                registrarLead(txt_correo_inicial.val());
                registrarLeadEmailMarketing(txt_correo_inicial.val());
            }
        });
    });

    btn_final.on("click", function(){

        form_lead_final.validate().then(function(status) {
            if(status === 'Valid') {
                registrarLead(txt_correo_final.val());
                registrarLeadEmailMarketing(txt_correo_final.val());
            }
        });
    });

}

function validacionFormularios() {

    form_lead_inicial = FormValidation.formValidation(document.getElementById('form_lead_inicial'),
            {
                fields: {
                    txt_correo_inicial: {
                        validators: {
                            notEmpty: {
                                message: 'El correo es obligatorio.',
                            },
                            emailAddress: {
                                message: 'Debe ingresar un correo válido.',
                            },
                            stringLength: {
                                max: 200,
                                message: 'El correo no puede sobrepasar 200 caracteres.',
                            },
                        },
                    },
                },
                plugins: {
                    trigger: new FormValidation.plugins.Trigger(),
                    bootstrap5: new FormValidation.plugins.Bootstrap5(),
                    submitButton: new FormValidation.plugins.SubmitButton(),
                    icon: new FormValidation.plugins.Icon({
                        valid: 'fa fa-check',
                        invalid: 'fa fa-times',
                        validating: 'fa fa-refresh',
                    }),
                },
            }
        );

    form_lead_final = FormValidation.formValidation(document.getElementById('form_lead_final'),
        {
            fields: {
                txt_correo_final: {
                    validators: {
                        notEmpty: {
                            message: 'El correo es obligatorio.',
                        },
                        emailAddress: {
                            message: 'Debe ingresar un correo válido.',
                        },
                        stringLength: {
                            max: 200,
                            message: 'El correo no puede sobrepasar 200 caracteres.',
                        },
                    },
                },
            },
            plugins: {
                trigger: new FormValidation.plugins.Trigger(),
                bootstrap5: new FormValidation.plugins.Bootstrap5(),
                submitButton: new FormValidation.plugins.SubmitButton(),
                icon: new FormValidation.plugins.Icon({
                    valid: 'fa fa-check',
                    invalid: 'fa fa-times',
                    validating: 'fa fa-refresh',
                }),
            },
        }
    );
}

function registrarLead(correo) {

    var lead = {}
    lead["correo"] = correo;
    lead["idCampana"] = hid_campana.val();

    $.ajax({
        type: "POST",
        contentType: "application/json",
        accept: 'text/plain',
        url: '/registrarLead',
        data: JSON.stringify(lead),
        dataType: 'json',
        beforeSend: function (xhr) {
            loadding(true);
        },
        error: function (xhr, status, error) {
            loadding(false);

            if (xhr.status === HttpCodes.unprocessableentity) {
                mostrarAlertaAdvertencia(xhr.responseJSON.message);
            }

            if (xhr.status == HttpCodes.error) {

                mostrarAlertaError(mensajeGenericoError);
            }

        },
        success: function (result, textStatus, xhr) {

            loadding(false);

            if (xhr.status == HttpCodes.success) {

                div_landing.addClass("d-none");
                div_gracias.removeClass("d-none");

                fbq('track', 'Lead');

                $('body,html').animate({
                    scrollTop: 0
                }, 200);

            }
        }
    });

}

function registrarLeadEmailMarketing(correo) {

    var lead = {}
    lead["correo"] = correo;
    lead["idCampana"] = hid_campana.val();

    $.ajax({
        type: "POST",
        contentType: "application/json",
        accept: 'text/plain',
        url: '/agregarLeadEmailMarketing',
        data: JSON.stringify(lead),
        dataType: 'json',
        beforeSend: function (xhr) {
        },
        error: function (xhr, status, error) {

            if (xhr.status === HttpCodes.unprocessableentity) {
                console.log('registrarLeadEmailMarketing ==> ' + xhr.responseJSON.message);
            }

            if (xhr.status == HttpCodes.error) {

                console.log('registrarLeadEmailMarketing ==> ' + mensajeGenericoError);
            }

        },
        success: function (result, textStatus, xhr) {

            console.log('registrarLeadEmailMarketing ==> OK');
        }
    });

}

function loadding(onOff) {

    if (onOff) {
        var div="<div id='loadding' class='box'><div class='image'><img src='../images/loading.svg'></div></div>";
        jQuery.blockUI({
            message: div,
            css: {
                border: 'none',
                padding: '0px',
                backgroundColor: ''
            },
            overlayCSS: {
                backgroundColor: 'white',
                opacity: 0.5
            }
        });
    }
    else {
        jQuery.unblockUI();
    }
}

function mostrarAlertaError(mensaje){

    bootbox.dialog({
        message: "<img class=\"img-alert\" src=\"../images/error.png\" alt=\"\" /><p class=\"text-alert\">" + mensaje + "</p>",
        size: 'medium',
        centerVertical: true,
        closeButton: false,
        buttons: {
            cancel: {
                label: "Aceptar",
                className: Boton.DANGER
            }
        }
    });

}

function mostrarAlertaAdvertencia(mensaje){

    bootbox.dialog({
        message: "<img class=\"img-alert\" src=\"../images/warning.png\" alt=\"\" /><p class=\"text-alert\">" + mensaje + "</p>",
        size: 'medium',
        centerVertical: true,
        closeButton: false,
        buttons: {
            cancel: {
                label: "Aceptar",
                className: Boton.WARNING
            }
        }
    });

}

function mostrarAlertaOk(mensaje){

    bootbox.dialog({
        message: "<img class=\"img-alert\" src=\"../images/ok.png\" alt=\"\" /><p class=\"text-alert\">" + mensaje + "</p>",
        size: 'medium',
        centerVertical: true,
        closeButton: false,
        buttons: {
            cancel: {
                label: "Aceptar",
                className: Boton.SUCCESS
            }
        }
    });

}