import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.phantomjs.PhantomJSDriver

baseUrl = 'http://puzzlers.neueda.lv'

waiting {
    timeout = 5
}

Closure getWebDriver = { Class<WebDriver> webDriver ->
    WebDriverManager.getInstance(webDriver).setup()
    def driver = webDriver.newInstance()
    driver.manage().window().maximize()
    driver
}

//Default driver to be used
driver = {
    getWebDriver(ChromeDriver)
}

environments {
    chrome {
        driver = { getWebDriver(ChromeDriver) }
    }
    firefox {
        driver = { getWebDriver(FirefoxDriver) }
    }
    phantomjs {
        driver = { getWebDriver(PhantomJSDriver) }
    }
}