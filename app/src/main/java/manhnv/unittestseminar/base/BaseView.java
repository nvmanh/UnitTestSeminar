package manhnv.unittestseminar.base;

import android.content.Context;

/**
 * Created by root on 7/24/17.
 */

public interface BaseView<P extends BasePresenter> {
    void setPresenter(P presenter);
    Context context();
}
