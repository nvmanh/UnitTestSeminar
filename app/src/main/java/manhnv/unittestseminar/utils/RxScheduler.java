package manhnv.unittestseminar.utils;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;
import org.reactivestreams.Publisher;

/**
 * Created by root on 7/25/17.
 */

public class RxScheduler {

    /**
     * Create a transformer to compose an Observable to subscribe on separate thread and observe it
     * in UI thread
     *
     * @param <T> Rule of Observable object
     */
    public static <T> ObservableTransformer<T, T> applyObservableAsync() {
        return new ObservableTransformer<T, T>() {

            @Override
            public ObservableSource<T> apply(@NonNull io.reactivex.Observable<T> observable) {
                return observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /**
     * Create a transformer to compose an Observable to subscribe on current thread and observe it
     * in this thread
     * Using in synchronous API request
     *
     * @param <T> Rule of Observable object
     */
    public static <T> ObservableTransformer<T, T> applyObservableCompute() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(@NonNull io.reactivex.Observable<T> observable) {
                return observable.subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /**
     * Create a transformer to compose an Observable to subscribe on current thread and observe it
     * in main thread
     * Using in synchronous API request
     *
     * @param <T> Rule of Observable object
     */
    public static <T> ObservableTransformer<T, T> applyObservableMainThread() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(@NonNull io.reactivex.Observable<T> observable) {
                return observable.observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public static <T> FlowableTransformer<T, T> applyFlowableMainThread() {
        return new FlowableTransformer<T, T>() {
            @Override
            public Publisher<T> apply(@NonNull Flowable<T> flowable) {
                return flowable.observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public static <T> FlowableTransformer<T, T> applyFlowableAsysnc() {
        return new FlowableTransformer<T, T>() {
            @Override
            public Publisher<T> apply(@NonNull Flowable<T> flowable) {
                return flowable.observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public static <T> FlowableTransformer<T, T> applyFlowableCompute() {
        return new FlowableTransformer<T, T>() {
            @Override
            public Publisher<T> apply(@NonNull Flowable<T> flowable) {
                return flowable.observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
