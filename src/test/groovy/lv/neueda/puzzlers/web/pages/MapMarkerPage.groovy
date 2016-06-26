package lv.neueda.puzzlers.web.pages

import geb.Page

class MapMarkerPage extends Page {

    static url = "#/map-marker"

    static at = {
        driver.currentUrl == "http://puzzlers.neueda.lv/#/map-marker"
        expectBaseElementsDisplayed()
    }

    static content = {
        longitudeInput(wait: true) { $(".form-control.ng-pristine.ng-untouched.ng-valid", placeholder: "Longitude") }
        latitudeInput(wait: true) { $(".form-control.ng-pristine.ng-untouched.ng-valid", placeholder: "Latitude") }
        addMarkerButton(wait: true) { $(".btn.btn-primary") }
        mapMarker(wait: true) { $(".leaflet-marker-icon.leaflet-zoom-animated.leaflet-clickable") }
        mapMarkerPopup(wait: true) { $(".leaflet-popup-content-wrapper") }
    }
    
    private def expectBaseElementsDisplayed() {
        longitudeInput.displayed
        latitudeInput.displayed
        addMarkerButton.displayed
    }
}
