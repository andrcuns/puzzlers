package lv.neueda.puzzlers.web.steps

import geb.Browser
import geb.binding.BindingUpdater

import static cucumber.api.groovy.Hooks.After
import static cucumber.api.groovy.Hooks.Before

def bindingUpdater = new BindingUpdater(binding, new Browser())

Before {
    bindingUpdater.initialize()
}

After {
    bindingUpdater.remove()
}


