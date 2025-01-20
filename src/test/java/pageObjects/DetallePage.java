package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.Waits;

public class DetallePage extends BasePage{
        public DetallePage (){
            PageFactory.initElements(Driver.get(), this);
        }

    @FindBy(xpath = "//b[text()='Specie:']")
    WebElement SpecieLabel;

    @FindBy(xpath = "//section/h1")
    WebElement nombrePersonaje;

    @FindBy(xpath = "//b[text()='Gender:']/parent::p")
    WebElement generoPersonaje;

    @FindBy(xpath = "//b[text()='Specie:']/parent::p")
    WebElement EspeciePersonaje;

    @FindBy(xpath = "//b[text()='Status:']/parent::p")
    WebElement EstatusPersonaje;



    public boolean validarinformacionPersonaje(String nombre, String especie, String status,  String genero, String url){
        Waits.explicitWaitExpectedConditionsVisibility(Driver.get(),nombrePersonaje);
        Waits.explicitWaitExpectedConditionsVisibility(Driver.get(),SpecieLabel);
        String urlActual = Driver.get().getCurrentUrl();
        String nombreActual = nombrePersonaje.getText();
        String especieActual = EspeciePersonaje.getText();
        String estatusActual = EstatusPersonaje.getText();
        String generoActual = generoPersonaje.getText();
        return nombreActual.contains(nombre) && especieActual.contains(especie) && estatusActual.contains(status)&&generoActual.contains(genero)&& url.equals(urlActual);

    }


}
