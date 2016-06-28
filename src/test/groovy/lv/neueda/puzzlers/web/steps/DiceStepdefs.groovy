package lv.neueda.puzzlers.web.steps

import lv.neueda.puzzlers.web.pages.DicePage

import static cucumber.api.groovy.EN.*

Given(~/^a user is on dice page$/) { ->
    to DicePage
}

When(~/^a user toggles the switch "on"$/) { ->
    page.shuffleKnob.click()
}

Then(~/^dice start to shuffle$/) { ->
    page.isDiceStatusChanged()
}

When(~/^a user sees three "(.*)" dice in a row within (\d+) seconds$/) { String diceType, int seconds ->
    page.isSameSymbolOnAllDiceDisplayed(diceType, seconds)
}


