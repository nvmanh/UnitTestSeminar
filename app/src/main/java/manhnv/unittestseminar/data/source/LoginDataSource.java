package manhnv.unittestseminar.data.source;

import io.reactivex.Observable;
import manhnv.unittestseminar.data.model.User;

/**
 * Created by root on 7/25/17.
 */

public interface LoginDataSource {
    Observable<User> login(String userName, String password);

    Observable<Boolean> save(User user);
}
