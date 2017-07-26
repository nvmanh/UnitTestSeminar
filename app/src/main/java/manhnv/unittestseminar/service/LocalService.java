package manhnv.unittestseminar.service;

/**
 * Created by root on 7/26/17.
 */

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import java.util.Random;

/**
 * {@link Service} that generates random numbers.
 * <p>
 * A seed for the random number generator can be set via the {@link Intent} passed to
 * {@link #onBind(Intent)}.
 */
public class LocalService extends Service {
    // Used as a key for the Intent.
    public static final String SEED_KEY = "SEED_KEY";

    // Binder given to clients
    private final IBinder mBinder = new LocalBinder();

    // Random number generator
    private Random mGenerator = new Random();

    private long mSeed;

    @Override
    public IBinder onBind(Intent intent) {
        // If the Intent comes with a seed for the number generator, apply it.
        if (intent.hasExtra(SEED_KEY)) {
            mSeed = intent.getLongExtra(SEED_KEY, 0);
            mGenerator.setSeed(mSeed);
        }
        return mBinder;
    }

    public class LocalBinder extends Binder {

        public LocalService getService() {
            // Return this instance of LocalService so clients can call public methods.
            return LocalService.this;
        }
    }

    /**
     * Returns a random integer in [0, 100).
     */
    public int getRandomInt() {
        return mGenerator.nextInt(100);
    }
}
