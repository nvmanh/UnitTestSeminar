package manhnv.unittestseminar.main;

import android.content.Context;
import android.content.Intent;
import com.google.gson.Gson;
import manhnv.unittestseminar.R;
import manhnv.unittestseminar.base.BaseBindingActivity;
import manhnv.unittestseminar.data.model.User;
import manhnv.unittestseminar.databinding.ActivityMainBinding;

/**
 * Created by root on 7/24/17.
 */

public class MainActivity extends BaseBindingActivity<ActivityMainBinding, MainPresenter>
        implements MainView {
    private static final String INTENT_USER = "intent_user";

    private User mUser;

    public static Intent newIntent(Context context, User user) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(INTENT_USER, user.toString());
        return intent;
    }

    @Override
    public void setPresenter(MainPresenter presenter) {
        binding.setPresenter(presenter);
    }

    @Override
    public Context context() {
        return this;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void init() {
        mUser = new Gson().fromJson(getIntent().getStringExtra(INTENT_USER), User.class);
        presenter = new MainPresenter(this, mUser);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
