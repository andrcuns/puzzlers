package lv.neueda.puzzlers.web.pages

import geb.Page

class DicePage extends Page {

    static url = "#/dice"

    static at = {
        driver.currentUrl == "http://puzzlers.neueda.lv/#/dice"
        expectBaseElementsDisplayed()
    }

    static content = {
        shuffleKnob(wait: true) { $(".knob") }
        dice(wait: true) { $("i", class: contains("square")) }
    }

    private expectBaseElementsDisplayed() {
        shuffleKnob.displayed
        dice*.displayed
    }

    def isDiceStatusChanged() {
        waitFor { dice*.filter(class: contains("color")).displayed }
    }

    def isSameSymbolOnAllDiceDisplayed(String diceType, int period) {
        Map selectors = ['+': 'plus-', '-': 'minus-', 'blank': '']
        waitFor(period, 0.5) {
            $(".fa-${selectors.get(diceType)}square").size() == 3
        }
    }
}
