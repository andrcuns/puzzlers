package lv.neueda.puzzlers.web.pages

import geb.Page

class MapMarkerPage extends Page {

    static url = "#/map-marker"

    static at = {
        driver.currentUrl == "http://puzzlers.neueda.lv/#/map-marker"
        expectBaseElementsDisplayed()
    }

    static content = {
        longitudeInput(wait: true) { $(".control-label", text: "Lng").siblings().children() }
        latitudeInput(wait: true) { $(".control-label", text: "Lat").siblings().children() }
        addMarkerButton(wait: true) { $(".btn.btn-primary") }
        mapMarker(wait: true) { $(".leaflet-marker-icon") }
        mapMarkerPopup(wait: true) { $(".leaflet-popup-content-wrapper") }
    }
    
    private def expectBaseElementsDisplayed() {
        longitudeInput.displayed
        latitudeInput.displayed
        addMarkerButton.displayed
    }
}
