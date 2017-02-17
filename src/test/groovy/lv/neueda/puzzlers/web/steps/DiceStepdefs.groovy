package lv.neueda.puzzlers.web.steps

import lv.neueda.puzzlers.web.pages.DicePage

import static cucumber.api.groovy.EN.Given
import static cucumber.api.groovy.EN.Then
import static cucumber.api.groovy.EN.When

DicePage dicePage

Given(~/^a user is on dice page$/) { ->
    dicePage = to DicePage
}

When(~/^a user toggles the switch "on"$/) { ->
    dicePage.shuffleKnob.click()
}

Then(~/^dice start to shuffle$/) { ->
    dicePage.isDiceStatusChanged()
}

When(~/^a user sees three "(.*)" dice in a row within (\d+) seconds$/) { String diceType, int seconds ->
    dicePage.isSameSymbolOnAllDiceDisplayed(diceType, seconds)
}


