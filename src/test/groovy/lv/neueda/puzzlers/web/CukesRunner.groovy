package lv.neueda.puzzlers.web

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

@RunWith(Cucumber)
@CucumberOptions(
        tags = '@all',
        strict = true,
        plugin = ['html:build/cucumber', 'pretty'])
class CukesRunner {
}
