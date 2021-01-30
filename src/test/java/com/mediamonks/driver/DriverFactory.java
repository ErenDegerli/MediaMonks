package com.mediamonks.driver;

import com.mediamonks.core.PropKey;
import com.mediamonks.core.PropertyReader;
import com.mediamonks.utils.Helper;
import com.mediamonks.utils.SystemPropertyHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import static com.mediamonks.utils.Helper.isRemote;

public class DriverFactory {

    public static PropertyReader prop;
    public static WebDriver driver = null;
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static WebDriver getDriver() throws IOException {
        if(driver == null) {

            if(isRemote()) {
                try {
                    driverThreadLocal.set(new RemoteWebDriver(new URL(Helper.getHubUrl()),
                            getBrowser().getBrowserCapabilities()));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }else {
                driverThreadLocal.set(getBrowser().getWebDriver());
            }
        }
        driverThreadLocal.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driverThreadLocal.get();
    }

    public static void quitDriver() {
        driverThreadLocal.get().quit();
    }

    private static BrowserType getBrowser() throws IOException {

        BrowserType browserType = SystemPropertyHelper.getBrowserFromSystemVariable();

        if(browserType!=null) {
            return browserType;
        }
        if(prop.getProperty(PropKey.BROWSER.getPropVal()).equalsIgnoreCase("CHROME")) {
            return BrowserType.CHROME;
        }else if(prop.getProperty(PropKey.BROWSER.getPropVal()).equalsIgnoreCase("FIREFOX")) {
            return BrowserType.FIREFOX;
        }else if(prop.getProperty(PropKey.BROWSER.getPropVal()).equalsIgnoreCase("IE")) {
            return BrowserType.IE;
        }else {
            return BrowserType.CHROME;
        }
    }
}