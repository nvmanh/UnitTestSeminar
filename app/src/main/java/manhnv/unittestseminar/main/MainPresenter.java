package manhnv.unittestseminar.main;

import android.databinding.ObservableField;
import manhnv.unittestseminar.base.BasePresenter;
import manhnv.unittestseminar.data.model.User;

/**
 * Created by root on 7/24/17.
 */

public class MainPresenter implements BasePresenter {
    private MainView mView;
    public ObservableField<String> salutation = new ObservableField<>();

    public MainPresenter(MainView mainView, User user) {
        this.mView = mainView;
        mView.setPresenter(this);
        salutation.set(String.format("Welcome %s", user.getUserName()));
    }

    @Override
    public void subscribe() {
        // TODO: 7/25/17  
    }

    @Override
    public void unSubscribe() {
        // TODO: 7/25/17  
    }
}