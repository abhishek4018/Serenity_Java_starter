package starter.stepdefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowsingTheWeb;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import starter.helpers.AddAnItem;
import starter.helpers.MyCast;
import starter.helpers.NavigateTo;
import starter.helpers.TodoListPage;

public class AddItemStepDefinitions {

    Actor actor=MyCast.user();
    @Given("Rama is looking at his TODO list")
    public void actor_is_looking_at_his_todo_list() {
        actor.wasAbleTo(NavigateTo.theTodoListPage());
    }
    @When("he adds {string} to the list")
    public void he_adds_to_the_list(String itemName) {
        actor.attemptsTo(AddAnItem.withName(itemName));
    }
    @Then("he sees {string} as an item in the TODO list")
    public void he_sees_as_an_item_in_the_todo_list(String expectedItemName) {
        actor.attemptsTo(Ensure.that(TodoListPage.ITEMS_LIST).hasText(expectedItemName));
    }

}