package manhnv.unittestseminar;

/**
 * Created by root on 7/25/17.
 */

import android.support.annotation.NonNull;
import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.TestScheduler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class TestSchedulerRule implements TestRule {
    //    private final Scheduler immediate = new Scheduler() {
    //        @Override
    //        public Worker createWorker() {
    //            return new ExecutorScheduler.ExecutorWorker(new ScheduledThreadPoolExecutor(1) {
    //                @Override
    //                public void execute(@NonNull Runnable runnable) {
    //                    runnable.run();
    //                }
    //            });
    //        }
    //    };

    Scheduler immediate = new Scheduler() {
        @Override
        public Disposable scheduleDirect(@NonNull Runnable run, long delay,
                @NonNull TimeUnit unit) {
            // this prevents StackOverflowErrors when scheduling with a delay
            return super.scheduleDirect(run, 0, unit);
        }

        @Override
        public Worker createWorker() {
            return new ExecutorScheduler.ExecutorWorker(new ScheduledThreadPoolExecutor(1) {
                @Override
                public void execute(Runnable command) {
                    command.run();
                }
            });
        }
    };

    private final TestScheduler testScheduler = new TestScheduler();

    public TestScheduler getTestScheduler() {
        return testScheduler;
    }

    @Override
    public Statement apply(final Statement base, Description d) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                RxJavaPlugins.setIoSchedulerHandler(new Function<Scheduler, Scheduler>() {
                    @Override
                    public Scheduler apply(@io.reactivex.annotations.NonNull Scheduler scheduler)
                            throws Exception {
                        return testScheduler;
                    }
                });

                RxJavaPlugins.setComputationSchedulerHandler(new Function<Scheduler, Scheduler>() {
                    @Override
                    public Scheduler apply(@io.reactivex.annotations.NonNull Scheduler scheduler)
                            throws Exception {
                        return testScheduler;
                    }
                });
                RxJavaPlugins.setNewThreadSchedulerHandler(new Function<Scheduler, Scheduler>() {
                    @Override
                    public Scheduler apply(@io.reactivex.annotations.NonNull Scheduler scheduler)
                            throws Exception {
                        return testScheduler;
                    }
                });
                RxAndroidPlugins.setMainThreadSchedulerHandler(
                        new Function<Scheduler, Scheduler>() {
                            @Override
                            public Scheduler apply(
                                    @io.reactivex.annotations.NonNull Scheduler scheduler)
                                    throws Exception {
                                return immediate;
                            }
                        });

                try {
                    base.evaluate();
                } finally {
                    RxJavaPlugins.reset();
                    RxAndroidPlugins.reset();
                }
            }
        };
    }
}
