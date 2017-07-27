package manhnv.unittestseminar;

/**
 * Created by root on 7/26/17.
 */

import manhnv.unittestseminar.login.LoginPresenterTest;
import manhnv.unittestseminar.utils.ValidateHelperTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

// Runs all unit tests.
@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginPresenterTest.class, ValidateHelperTest.class
})
public class TestCoverage {
}
