package manhnv.unittestseminar.login;

import android.databinding.ObservableField;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import manhnv.unittestseminar.base.BasePresenter;
import manhnv.unittestseminar.data.model.User;
import manhnv.unittestseminar.data.source.LoginRepository;
import manhnv.unittestseminar.utils.ValidateHelper;

/**
 * Created by root on 7/24/17.
 */

public class LoginPresenter implements BasePresenter {
    private LoginView mView;
    public ObservableField<String> email = new ObservableField<>();
    public ObservableField<String> password = new ObservableField<>();
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    private LoginRepository mLoginRepository;

    public LoginPresenter(LoginView loginView, LoginRepository loginRepository) {
        this.mView = loginView;
        this.mLoginRepository = loginRepository;
        mView.setPresenter(this);
    }

    public void onClickLogin() {
        mView.clearError();
        if (!isNotEmpty(email.get()) || !isNotEmpty(password.get())) {
            mView.onEmptyError();
        } else if (!isValidEmail(email.get())) {
            mView.onEmailError();
        } else if (!isValidPassword(password.get())) {
            mView.onPasswordError();
        } else {
            mView.showLoading();
            mCompositeDisposable.add(mLoginRepository.login(email.get(), password.get())
                    .subscribe(new Consumer<User>() {
                        @Override
                        public void accept(@NonNull User user) throws Exception {
                            mView.hideLoading();
                            mLoginRepository.save(user);
                            mView.onLoginSuccess(user);
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(@NonNull Throwable throwable) throws Exception {
                            mView.hideLoading();
                            mView.showError();
                        }
                    }));
        }
    }

    private boolean isNotEmpty(String source) {
        return ValidateHelper.isNotEmpty(source);
    }

    private boolean isValidPassword(String password) {
        return ValidateHelper.isValidPassword(password);
    }

    private boolean isValidEmail(String email) {
        return ValidateHelper.isValidEmail(email);
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unSubscribe() {
        mCompositeDisposable.dispose();
        mCompositeDisposable.clear();
    }
}