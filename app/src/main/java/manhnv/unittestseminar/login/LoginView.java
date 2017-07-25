package manhnv.unittestseminar.login;

import manhnv.unittestseminar.base.BaseView;
import manhnv.unittestseminar.data.model.User;

/**
 * Created by root on 7/24/17.
 */

public interface LoginView extends BaseView<LoginPresenter> {
    void onEmailError();

    void onPasswordError();

    void onLoginSuccess(User user);

    void onEmptyError();

    void clearError();

    void showLoading();

    void hideLoading();

    void showError();
}
