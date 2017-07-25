package manhnv.unittestseminar.utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

import static org.mockito.Mockito.verify;

/**
 * Created by root on 7/24/17.
 */

@RunWith(JUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ValidateHelperTest {
    @Before
    public void setup() {

    }

    @Test
    public void case_1_test_empty() throws Exception {
        Assert.assertFalse(ValidateHelper.isNotEmpty(null));
        Assert.assertFalse(ValidateHelper.isNotEmpty(""));
        Assert.assertTrue(ValidateHelper.isNotEmpty("abc"));
    }

    @Test
    public void case_2_test_email() throws Exception {
        Assert.assertFalse(ValidateHelper.isValidEmail(null));
        Assert.assertFalse(ValidateHelper.isValidEmail(""));
        Assert.assertFalse(ValidateHelper.isValidEmail("abc"));
        Assert.assertFalse(ValidateHelper.isValidEmail("abc@@gmail.com"));
        Assert.assertFalse(ValidateHelper.isValidEmail("abcgmail.@com"));
        Assert.assertFalse(ValidateHelper.isValidEmail("abcgmail@.com"));
        Assert.assertTrue(ValidateHelper.isValidEmail("abc@gmail.com"));
    }

    @Test
    public void case_3_test_password() {
        Assert.assertFalse(ValidateHelper.isValidPassword(null));
        Assert.assertFalse(ValidateHelper.isValidPassword(""));
        Assert.assertFalse(ValidateHelper.isValidPassword("abc"));
        Assert.assertFalse(ValidateHelper.isValidPassword("abcd"));
        Assert.assertFalse(ValidateHelper.isValidPassword("1dadsads"));
        Assert.assertFalse(ValidateHelper.isValidPassword("_1dadsads"));
        Assert.assertFalse(ValidateHelper.isValidPassword("@1dadsadsdasdsa"));
        Assert.assertTrue(ValidateHelper.isValidPassword("A@1dadsadsdasdsa"));
    }
}
