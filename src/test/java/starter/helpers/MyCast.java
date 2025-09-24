package starter.helpers;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowsingTheWeb;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyCast extends OnlineCast {

    @Managed
    static WebDriver driver;

    public static Actor user(){
        Actor actor=new Actor("ram");
        actor.can(BrowsingTheWeb.with(driver));
        return actor;
    }
}
