package manhnv.unittestseminar.login;

import android.os.SystemClock;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import manhnv.unittestseminar.R;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
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

    private String getString(int id) {
        return mActivityTestRule.getActivity().getString(id);
    }

    @Test
    public void test_1_login() {
        // TODO: 8/3/17 check hint email, password
        onView(withId(R.id.edtEmail)).check(matches(withHint(getString(R.string.hint_email))));
        onView(withId(R.id.edtPassword)).check(
                matches(withHint(getString(R.string.hint_password))));
        // TODO: 8/3/17 case 1: check valid email
        //input invalid email
        onView(withId(R.id.edtEmail)).perform(typeText("dkm"), closeSoftKeyboard());
        //input valid password
        onView(withId(R.id.edtPassword)).perform(typeText(USER_PASSWORD), closeSoftKeyboard());
        //perform login action
        onView(withId(R.id.btnLogin)).perform(click());

        //expected
        //show correct error message on edit text email
        onView(withId(R.id.edtEmail)).check(matches(hasErrorText(getString(R.string.email_error))));
        //delay test some 1 second to view on device
        SystemClock.sleep(1000);

        // TODO: 8/3/17 case 2: check valid password
        onView(withId(R.id.edtEmail)).perform(clearText());
        onView(withId(R.id.edtPassword)).perform(clearText());
        //.......... implemented
        onView(withId(R.id.edtEmail)).perform(typeText(USER_EMAIL), closeSoftKeyboard());
        onView(withId(R.id.edtPassword)).perform(typeText("__12121212"), closeSoftKeyboard());
        onView(withId(R.id.btnLogin)).perform(click());
        onView(withId(R.id.edtPassword)).check(
                matches(hasErrorText(getString(R.string.password_error))));

        //delay test some 1 second to view on device
        SystemClock.sleep(1000);

        // TODO: 8/3/17 case 3: check login success
        onView(withId(R.id.edtEmail)).perform(clearText());
        onView(withId(R.id.edtPassword)).perform(clearText());
        //--------------
        onView(withId(R.id.edtEmail)).perform(typeText(USER_EMAIL), closeSoftKeyboard());
        onView(withId(R.id.edtPassword)).perform(typeText(USER_PASSWORD), closeSoftKeyboard());

        onView(withId(R.id.btnLogin)).perform(click());

        onView(withId(R.id.tvSalutation)).check(
                matches(allOf(isDescendantOfA(withId(R.id.layoutMain)), isDisplayed())));
        //delay test some 1 second to view on device
        SystemClock.sleep(1000);
    }

    @Test public void test_2_mockStatic(){

    }
}
