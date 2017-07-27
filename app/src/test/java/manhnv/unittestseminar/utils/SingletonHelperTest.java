package manhnv.unittestseminar.utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static junit.framework.Assert.assertNotNull;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.eq;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.support.SuppressCode.suppressConstructor;

/**
 * Created by root on 7/27/17.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(SingletonHelper.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SingletonHelperTest {

    private static final String VAL_TEST = "test";

    private SingletonHelper clazz = SingletonHelper.instance();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        //suppressConstructor(SingletonHelper.class);
        //mockStatic(SingletonHelper.class);
        //when(SingletonHelper.instance()).thenReturn(clazz);
        //set expectation for getInstance()

        //clazz = createMock(SingletonHelper.class);
        //expect(SingletonHelper.instance()).andReturn(clazz).anyTimes();
    }

    @Test
    public void test_1() {
        //mockStatic(SingletonHelper.class);
        //clazz = createMock(SingletonHelper.class);
        //expect(SingletonHelper.instance()).andReturn(clazz).anyTimes();
        clazz.setValue(VAL_TEST);
        //assertThat(clazz.getValue(), is(eq(VAL_TEST)));
        assertNotNull(clazz.getValue());
    }
}