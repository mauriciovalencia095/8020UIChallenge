package hooks;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utilities.Driver;

import java.io.File;
import java.io.IOException;

public class Hooks {

    private WebDriver driver;

    public Hooks() {
        this.driver = Driver.get(); // Asegúrate de inicializar el driver correctamente
    }

    @AfterStep
    public void addScreenshotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {

                String screenshotPath = System.getProperty("user.dir") + "/resultsTests/" + scenario.getName() + ".png";
                File destinationFile = new File(screenshotPath);
                FileUtils.copyFile(screenshot, destinationFile);

                scenario.attach(FileUtils.readFileToByteArray(destinationFile), "image/png", "Screenshot");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}