package manhnv.unittestseminar.data.source.local;

import io.reactivex.Observable;
import manhnv.unittestseminar.data.model.User;
import manhnv.unittestseminar.data.source.LoginDataSource;

/**
 * Created by root on 7/25/17.
 */

public class LocalLoginDataSource implements LoginDataSource {
    @Override
    public Observable<User> login(String userName, String password) {
        return null;
    }

    @Override
    public Observable<Boolean> save(User user) {
        return Observable.just(true);
    }
}