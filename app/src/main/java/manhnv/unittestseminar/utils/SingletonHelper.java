package manhnv.unittestseminar.utils;

/**
 * Created by root on 7/27/17.
 */

public class SingletonHelper {
    private static SingletonHelper self;

    private String value;

    private SingletonHelper() {
        super();
    }

    public static SingletonHelper instance() {
        return self == null ? self = new SingletonHelper() : self;
    }

    public void setValue(String val) {
        this.value = val;
    }

    public String getValue() {
        return value;
    }
}
