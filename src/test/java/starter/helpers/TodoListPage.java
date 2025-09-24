package starter.helpers;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.annotations.DefaultUrl;
import static starter.helpers.PageConfigs.get;


@DefaultUrl("pages.myurl")
public class TodoListPage extends PageObject {
    public static Target ITEM_NAME_FIELD = Target.the("item name field").locatedBy("//textarea[@aria-label='Search']");

    public static Target ITEMS_LIST = Target.the(" item list").locatedBy("//textarea[@aria-label='Search']");
}