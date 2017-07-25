package manhnv.unittestseminar.data.source;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import manhnv.unittestseminar.data.model.User;
import manhnv.unittestseminar.data.source.local.LocalLoginDataSource;
import manhnv.unittestseminar.data.source.remote.RemoteLoginDataSource;
import manhnv.unittestseminar.utils.RxScheduler;

/**
 * Created by root on 7/25/17.
 */

public class LoginRepository implements LoginDataSource {
    private LocalLoginDataSource local;
    private RemoteLoginDataSource remote;
    private static LoginRepository self;

    private LoginRepository() {
        local = new LocalLoginDataSource();
        remote = new RemoteLoginDataSource();
    }

    public static LoginRepository instance() {
        return self == null ? self = new LoginRepository() : self;
    }

    @Override
    public Observable<User> login(String userName, String password) {
        return remote.login(userName, password).compose(RxScheduler.<User>applyObservableAsync());
    }

    @Override
    public Observable<Boolean> save(User user) {
        return local.save(user).compose(RxScheduler.<Boolean>applyObservableAsync());
    }
}