package lv.neueda.puzzlers.web.steps

import lv.neueda.puzzlers.web.pages.MapMarkerPage

import static cucumber.api.groovy.EN.*

MapMarkerPage mapMarkerPage

Given(~/^a user is on map marker page$/) { ->
    mapMarkerPage = to MapMarkerPage
}

When(~/^a user enters "(.*)" in field "(.*)"$/) { String coordinateValue, String coordinateType ->
    mapMarkerPage."${coordinateType}Input".value(coordinateValue)
}

When(~/^clicks the "Add marker" button$/) { ->
    mapMarkerPage.addMarkerButton.click()
}

Then(~/^a map marker should appear$/) { ->
    assert mapMarkerPage.mapMarker.displayed
}

When(~/^a user clicks on a map marker$/) { ->
    mapMarkerPage.mapMarker.click()
}

Then(~/^a popup should appear$/) { ->
    assert mapMarkerPage.mapMarkerPopup.displayed
}

Then(~/^a popup should contain text "(.*)"$/) { String text ->
    assert mapMarkerPage.mapMarkerPopup.text().contains(text)
}



