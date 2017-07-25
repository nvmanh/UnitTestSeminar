package manhnv.unittestseminar.utils;

import java.util.regex.Pattern;

/**
 * Created by root on 7/24/17.
 */

public class ValidateHelper {
    private static final String PASSWORD_PATTERN =
            "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+])[A-Za-z\\d][A-Za-z\\d!@#$%^&*()_+]{7,17}$";
    private static final String VALID_EMAIL_ADDRESS_REGEX =
            "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    private static Pattern passwordPattern =
            Pattern.compile(PASSWORD_PATTERN, Pattern.CASE_INSENSITIVE);
    private static final Pattern emailPattern =
            Pattern.compile(VALID_EMAIL_ADDRESS_REGEX, Pattern.CASE_INSENSITIVE);

    public static boolean isNotEmpty(String source) {
        return source != null && source.trim().length() > 0;
    }

    public static boolean isValidPassword(String password) {
        return isNotEmpty(password) && passwordPattern.matcher(password).find();
    }

    public static boolean isValidEmail(String email) {
        return isNotEmpty(email) && emailPattern.matcher(email.trim()).find();
    }
}
