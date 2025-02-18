import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.*
import com.iub.lab7.R
import com.iub.lab7.TicketDetailFragment
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TicketDetailFragmentTest {

    @Test
    fun updatesTicketOnUserInput() {
        val scenario = launchFragmentInContainer<TicketDetailFragment>(themeResId = R.style.Theme_MaterialComponents_Light_NoActionBar)

        val inputText = "Test Ticket Title"

        // Enter text into EditText
        onView(withId(R.id.ticket_title))
            .perform(replaceText(inputText))

        // Click the CheckBox
        onView(withId(R.id.ticket_solved))
            .perform(click())

        // Verify Ticket values using onFragment
        scenario.onFragment { fragment ->
            assertEquals(inputText, fragment.ticket.title)
            assertEquals(true, fragment.ticket.isSolved)
        }
    }
}
