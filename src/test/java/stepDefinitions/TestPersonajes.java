package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pageObjects.BasePage;
import pageObjects.DetallePage;

public class TestPersonajes {
    public BasePage bp = new BasePage();
    public DetallePage dp = new DetallePage();

    @Given("El usuario abre la url")
    public void el_usuario_abre_la_url() {
        bp.abrirUrl();
    }

    @When("el usuario valida que esta en la pagina principal {string}")
    public void el_usuario_valida_que_esta_en_la_pagina_principal(String titulo) {

        Assertions.assertTrue(bp.confirmarPaginaPrincipal(titulo));
    }

    @Then("el usuario valida que los personajes tienen nombre y el boton ver detalle")
    public void el_usuario_valida_que_los_personajes_tienen_nombre_y_el_boton_ver_detalle() {

        Assertions.assertTrue(bp.confirmarInformacionDeLosPersonajes());
    }

    @When("el usuario va al detalle de informacion del personaje numero {string}")
    public void el_usuario_va_al_detalle_de_informacion_del_personaje_numero(String string) throws InterruptedException {
        bp.clickEnVerDetalle(string);
    }

    @Then("el usuario valida el {string} , la {string}, {string}, el {string} y la {string}")
    public void el_usario_valida_el_la_y_la(String string, String string1, String string2, String string3, String string4) {
        // Cambié Assert por Assertions
        Assertions.assertTrue(dp.validarinformacionPersonaje(string, string1, string2, string3, string4));
    }

    @Then("el usuario regresa a la pagina principal por medio de la opcion Home")
    public void el_usuario_regresa_a_la_pagina_principal_por_medio_de_la_opcion_Home() {
        bp.volverAHome();
    }

    @When("el usuario abre una nueva vista con el botton add")
    public void el_usuario_abre_una_nueva_vista_con_el_botton_add() {
        bp.navegarAFormulario();
    }

    @Then("el usuario vera un formulario")
    public void el_usuario_vera_un_formulario() {
        bp.validarContenidoDeLaNuevaPagina();
    }

    @When("el usuario hace scroll down")
    public void el_usuario_hace_scroll_down() throws InterruptedException {
        bp.scrollDown();
    }

    @Then("el usuario utiliza el boton top para volver hasta el inicio")
    public void el_usuario_utiliza_el_boton_top_para_volver_hasta_el_inicio() {
        bp.volverAlTop();
    }
}
