package manhnv.unittestseminar.login;

import android.content.Context;
import manhnv.unittestseminar.R;
import manhnv.unittestseminar.base.BaseBindingActivity;
import manhnv.unittestseminar.data.model.User;
import manhnv.unittestseminar.data.source.LoginRepository;
import manhnv.unittestseminar.databinding.ActivityLoginBinding;
import manhnv.unittestseminar.main.MainActivity;

/**
 * Created by root on 7/24/17.
 */

public class LoginActivity extends BaseBindingActivity<ActivityLoginBinding, LoginPresenter>
        implements LoginView {

    @Override
    public void setPresenter(LoginPresenter presenter) {
        binding.setPresenter(presenter);
    }

    @Override
    public Context context() {
        return this;
    }

    @Override
    public void onEmailError() {
        binding.edtEmail.requestFocus();
        binding.edtEmail.setError(getString(R.string.email_error));
    }

    @Override
    public void onPasswordError() {
        binding.edtPassword.requestFocus();
        binding.edtPassword.setError(getString(R.string.password_error));
    }

    @Override
    public void onEmptyError() {
        binding.edtEmail.requestFocus();
        binding.edtEmail.setError(getString(R.string.requirement_error));
        binding.edtPassword.setError(getString(R.string.requirement_error));
    }

    @Override
    public void clearError() {
        binding.edtEmail.setError(null);
        binding.edtPassword.setError(null);
    }

    @Override
    public void showLoading() {
        // TODO: 7/25/17  
    }

    @Override
    public void hideLoading() {
        // TODO: 7/25/17  
    }

    @Override
    public void showError() {
        // TODO: 7/25/17
    }

    @Override
    public void onLoginSuccess(User user) {
        startActivity(MainActivity.newIntent(this, user));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void init() {
        presenter = new LoginPresenter(this, LoginRepository.instance());
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
