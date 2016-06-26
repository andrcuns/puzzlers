import static lv.neueda.puzzlers.web.geb.GebConfigUtils.getChromeDriver

baseUrl = 'http://puzzlers.neueda.lv'

driver = { chromeDriver }

waiting {
    timeout = 5
}
