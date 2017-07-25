package manhnv.unittestseminar.data.source.remote;

import io.reactivex.Observable;
import manhnv.unittestseminar.data.model.User;
import manhnv.unittestseminar.data.source.LoginDataSource;

/**
 * Created by root on 7/25/17.
 */

public class RemoteLoginDataSource implements LoginDataSource {
    @Override
    public Observable<User> login(String userName, String password) {
        return Observable.just(new User("manh daica", "manhduongvtt@gmail.com"));
    }

    @Override
    public Observable<Boolean> save(User user) {
        return null;
    }
}