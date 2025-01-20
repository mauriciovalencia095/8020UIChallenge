package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import utilities.Config;
import utilities.Driver;
import utilities.Waits;

import java.util.List;
import java.util.NoSuchElementException;

import static utilities.Driver.driver;

public class BasePage {
    public BasePage (){
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(xpath = "//button")
    WebElement botonIniciar;

    @FindBy(xpath = "//h1")
    WebElement tituloPrincipal;

    @FindBy(xpath = "//footer/a[1]")
    WebElement Home;

    @FindBy(xpath = "//figure")
    List<WebElement> numeroDePersonajes;

    @FindBy(xpath = "//div[@class='relative rounded-lg overflow-hidden pt-80'][1]//figure/following-sibling::div/span")
    WebElement primerPersonaje;

    @FindBy(xpath = "//div[@class='relative rounded-lg overflow-hidden pt-80'][20]//figure/following-sibling::div/span")
    WebElement ultimoPersonaje;

    @FindBy(xpath = "//footer/a[2]")
    WebElement Add;

    @FindBy(xpath = "//footer/button")
    WebElement Top;






    String url = Config.getProperty("url");

    public void abrirUrl(){
        Driver.get().get(url);
        Waits.explicitWaitExpectedConditionsVisibility(Driver.get(),botonIniciar);
        botonIniciar.click();
    }

    public boolean confirmarPaginaPrincipal(String titulo){
        Waits.explicitWaitExpectedConditionsVisibility(Driver.get(),tituloPrincipal);
        return titulo.equals(tituloPrincipal.getText());

    }

    public boolean confirmarInformacionDeLosPersonajes(){
        Waits.explicitWaitExpectedConditionsVisibility(Driver.get(),primerPersonaje);
        boolean flag = false;
        int conteo=0;
        for(int i =1; i<=numeroDePersonajes.size();i++){
            String nombrePersonaje = Driver.get().findElement(By.xpath("//div[@class='relative rounded-lg overflow-hidden pt-80']['"+ i +"']//figure/following-sibling::div/span")).getText();
            String verDetalle = Driver.get().findElement(By.xpath("//div[@class='relative rounded-lg overflow-hidden pt-80']['"+ i +"']//figure/following-sibling::div/a")).getText();
            if(!nombrePersonaje.isEmpty()&&verDetalle.equals("Ver detalle")){
                conteo = conteo+1;
            }

        }

        if(conteo == numeroDePersonajes.size()){
            flag =true;
        }
        return flag;
    }

    public void clickEnVerDetalle(String numeroPersonaje)  {
        Waits.explicitWaitExpectedConditionsVisibility(Driver.get(),tituloPrincipal);
        Waits.explicitWaitExpectedConditionsVisibility(Driver.get(),primerPersonaje);
        Waits.explicitWaitExpectedConditionsVisibility(Driver.get(),ultimoPersonaje);
        WebElement verDetalles = Driver.get().findElement(By.xpath("//div[contains(@class, 'relative') and contains(@class, 'rounded-lg') and contains(@class, 'overflow-hidden') and contains(@class, 'pt-80')]["+numeroPersonaje+"]//figure/following-sibling::div/a"));
        JavascriptExecutor executor = (JavascriptExecutor)Driver.get();
        executor.executeScript("arguments[0].click();", verDetalles);

    }

    public void volverAHome(){
        Home.click();
        Waits.explicitWaitExpectedConditionsVisibility(Driver.get(),tituloPrincipal);
    }

    public void navegarAFormulario(){
        Waits.explicitWaitExpectedConditionsVisibility(Driver.get(),Add);
        Add.click();
    }

    public void validarContenidoDeLaNuevaPagina(){
        String pageSource = Driver.get().getPageSource();
        if (pageSource.trim().isEmpty()) {
            System.out.println("La página está en blanco: No se encontró contenido.");
            return;
        }
        try {
            WebElement form = driver.findElement(By.tagName("form"));
            System.out.println("Formulario encontrado con éxito.");
        } catch (NoSuchElementException e) {
            System.out.println("No se encontró un formulario en la página.");
        }

    }

    public void scrollDown() throws InterruptedException {
        Thread.sleep(5000);
        Waits.explicitWaitExpectedConditionsVisibility(Driver.get(),tituloPrincipal);
        JavascriptExecutor js = (JavascriptExecutor) Driver.get();
        js.executeScript("window.scrollBy(0,250)", "");

    }

    public void volverAlTop(){
        JavascriptExecutor js = (JavascriptExecutor) Driver.get();
        Waits.explicitWaitExpectedConditionsVisibility(Driver.get(),Top);
        Double scrollPosAbajo = (Double) js.executeScript("return window.pageYOffset;");
        if (scrollPosAbajo == 0) {
            throw new AssertionError("El scroll no se desplazó hacia abajo.");
        }
        Top.click();
        Long scrollPosArriba = (Long) js.executeScript("return window.pageYOffset;");
        if (scrollPosArriba != 0) {
            throw new AssertionError("El botón Top no llevó la página al inicio.");
        } else {
            System.out.println("El botón Top funcionó correctamente.");
        }
    }







    public void cerrarNavegador(){
        Driver.get().close();
    }

}
