package lv.neueda.puzzlers.web.geb

import com.google.common.base.Preconditions
import org.openqa.selenium.Platform
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

class GebConfigUtils {

    private static final String CHROME_DRIVER_VERSION = '2.22'

    static WebDriver getChromeDriver() {
        def fileAttributes = currentOSFileAttributes

        def chromeDriverDownloadFullPath = "http://chromedriver.storage.googleapis.com/$CHROME_DRIVER_VERSION/${fileAttributes.chromeDriverArchive}"
        def chromeDriverLocalFile = downloadDriver(chromeDriverDownloadFullPath, fileAttributes.chromeDriverExecutable, fileAttributes.chromeDriverArchive)

        System.setProperty('webdriver.chrome.driver', chromeDriverLocalFile.absolutePath)

        def driver = new ChromeDriver()
        driver.manage().window().maximize()
        driver
    }

    private static WebDriverFileAttributes getCurrentOSFileAttributes() {
        def fileAttributes = WebDriverFileAttributes.find { "$it" == "${Platform.current.family()}" }
        Preconditions.checkNotNull(fileAttributes, "OS type is not supported")
        fileAttributes
    }

    private static File downloadDriver(String driverDownloadFullPath, String executableFile, String archiveFile) {
        File destinationDirectory = new File("build/drivers")
        if (!destinationDirectory.exists()) {
            destinationDirectory.mkdirs()
        }
        File driverFile = new File("${destinationDirectory.absolutePath}/${executableFile}")
        String localArchivePath = "build/${archiveFile}"

        if (!driverFile.exists()) {
            def ant = new AntBuilder()
            ant.get(src: driverDownloadFullPath, dest: localArchivePath)
            ant.unzip(src: localArchivePath, dest: destinationDirectory) {
                patternset {
                    include(name: "**/*$executableFile")
                }
                mapper(type: 'flatten')
            }
            ant.delete(file: localArchivePath)
            ant.chmod(file: driverFile, perm: '700')
        }
        driverFile
    }
}
