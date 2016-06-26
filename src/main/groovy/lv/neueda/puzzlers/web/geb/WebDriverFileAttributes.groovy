package lv.neueda.puzzlers.web.geb


enum WebDriverFileAttributes {
    LINUX('chromedriver_linux64.zip', 'chromedriver'),
    WINDOWS('chromedriver_win32.zip', 'chromedriver.exe'),
    MAC('chromedriver_mac32.zip', 'chromedriver')

    final String chromeDriverArchive
    final String chromeDriverExecutable

    WebDriverFileAttributes(String chromeDriverArchive, String chromeDriverExecutable) {
        this.chromeDriverArchive = chromeDriverArchive
        this.chromeDriverExecutable = chromeDriverExecutable
    }
}
