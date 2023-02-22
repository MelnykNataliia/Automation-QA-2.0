package testsuites;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import tests.Task25;

@RunWith(JUnitPlatform.class)
@SelectClasses({
		Task25.class
})
@ExcludeTags({"ManagersPage", "ContactsPage"})

public class CategoriesPageSuite {

}
