package net.meetsky.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Driver {

    private Driver() {
    }

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    public static WebDriver getDriver() {

        if (driverPool.get() == null) {
            /*
            If the browser type is defined as a system property in test phase of maven's default life cycle, use the value
            of that system property.
            If the browser type is NOT defined as a system property in test phase, read the value of the key "browser" from
            configuration/properties file.
             */
            String browserType = (System.getProperty("browser") != null) ? System.getProperty("browser")
                    : ConfigurationReader.getProperty("browser");

            switch (browserType.toLowerCase()) {
                case "chrome":
                    driverPool.set(new ChromeDriver());
                    break;
                case "firefox":
                    driverPool.set(new FirefoxDriver());
                    break;
                case "remote-chrome":
                    try { // to permanently handle checked exception cause by URL instance
                        // Step 1 - Create an instance of the URL class and provide the IP of the hub at the remote server
                        String ipAddress = "54.172.98.158"; /** Make sure to change the IP address with yours */
                        URL url = new URL("http://" + ipAddress + ":4444/wd/hub");
                        // Step 2 - Create an instance of the DesiredCapabilities class to choose browser type, platform etc. at the remote server
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("chrome");
                        // Step 3 - Create an instance of the RemoteChromeDriver and pass url and desiredCapabilities as a parameter
                        driverPool.set(new RemoteWebDriver(url, desiredCapabilities));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
            }
            driverPool.get().manage().window().maximize();
            driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driverPool.get();
    }

    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}
