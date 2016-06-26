package lv.neueda.puzzlers.web.steps

import lv.neueda.puzzlers.web.pages.MapMarkerPage

import static cucumber.api.groovy.EN.*

Given(~/^a user is on map marker page$/) { ->
    to MapMarkerPage
}

When(~/^a user enters "(.*)" in field "(.*)"$/) { String coordinateValue, String coordinateType ->
    page."${coordinateType}Input".value(coordinateValue)
}

When(~/^clicks the "Add marker" button$/) { ->
    page.addMarkerButton.click()
}

Then(~/^a map marker should appear$/) { ->
    assert page.mapMarker.displayed
}

When(~/^a user clicks on a map marker$/) { ->
    page.mapMarker.click()
}

Then(~/^a popup should appear$/) { ->
    assert page.mapMarkerPopup.displayed
}

Then(~/^a popup should contain text "(.*)"$/) { String text ->
    assert page.mapMarkerPopup.text().contains(text)
}



