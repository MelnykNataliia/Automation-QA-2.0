package testsuites;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import tests.Task24;

@RunWith(JUnitPlatform.class)
@SelectClasses({
		Task24.class
})
@ExcludeTags("TicketPage")

public class ContactPageSuite {

}
