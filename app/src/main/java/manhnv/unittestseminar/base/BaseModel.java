package manhnv.unittestseminar.base;

import com.google.gson.Gson;
import java.io.Serializable;

/**
 * Created by root on 7/25/17.
 */

public class BaseModel implements Serializable {
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
