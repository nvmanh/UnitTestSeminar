package manhnv.unittestseminar.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by root on 7/24/17.
 */

public abstract class BaseBindingActivity<V extends ViewDataBinding, P extends BasePresenter>
        extends AppCompatActivity {
    protected P presenter;
    protected V binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        init();
    }

    protected abstract int getLayoutId();

    public abstract void init();
}
