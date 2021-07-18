package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Web {
    public static final String AUTOMATE_USERNAME = "jhonatandasilvap_e5bVLM";
    public static final String AUTOMATE_ACCESS_KEY = "sJ4csvRyFVtpiKszP9vK";
    public static final String URLBrowserStack = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static WebDriver createChrome() {
        // Abrindo o Navegador
        System.setProperty("webdriver.chrome.driver","C:\\Users\\jhow_\\drivers\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        // Navegando para a pagina do Taskit
        navegador.get("http://www.juliodelima.com.br/taskit");

        return navegador;

    }
    public static WebDriver createBrowserStack() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1920x1080");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("os", "Windows");
        caps.setCapability("name", "BStack-[Java] Sample Test"); // test name
        caps.setCapability("build", "BStack Build Number 1"); // CI/CD job or build name

        WebDriver navegador = null;

        try {
            navegador = new RemoteWebDriver(new URL(URLBrowserStack), caps);
            navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


            // Navegando para a pagina do Taskit
            navegador.get("http://www.juliodelima.com.br/taskit");

        } catch (MalformedURLException e) {
           System.out.println("houveram problemas com a URL: " + e.getMessage());
        }
        return navegador;
    }
}
