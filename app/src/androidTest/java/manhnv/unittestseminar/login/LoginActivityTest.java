package manhnv.unittestseminar.login;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import manhnv.unittestseminar.R;
import manhnv.unittestseminar.data.model.User;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Created by root on 7/25/17.
 */
@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {
    private static final String USER_PASSWORD = "Aa@123456";
    private static final String USER_EMAIL = "manhdaica@gmail.com";
    @Rule
    public ActivityTestRule<LoginActivity> mActivityTestRule =
            new ActivityTestRule<LoginActivity>(LoginActivity.class);

    @Before
    public void setup() {

    }
    @Test
    public void test_1_login(){
        onView(withId(R.id.edtEmail)).perform(typeText(USER_EMAIL), closeSoftKeyboard());
        onView(withId(R.id.edtPassword)).perform(typeText(USER_PASSWORD), closeSoftKeyboard());

        onView(withId(R.id.btnLogin)).perform(click());

        onView(withId(R.id.tvSalutation)).check(matches(allOf(isDescendantOfA(withId(R.id.layoutMain)), isDisplayed())));
    }
}
