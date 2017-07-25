package manhnv.unittestseminar.login;

import android.content.Context;
import android.databinding.ObservableField;
import io.reactivex.Observable;
import manhnv.unittestseminar.TestSchedulerRule;
import manhnv.unittestseminar.data.model.User;
import manhnv.unittestseminar.data.source.LoginRepository;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by root on 7/24/17.
 */
@RunWith(MockitoJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginPresenterTest {
    private static final String EMAIL = "abc@gmail.com";
    private static final String EMAIL_INVALID = "abcgmail.com";
    private static final String PASSWORD = "Aa@123456";
    private static final String PASSWORD_INVALID = "_Aa@123456";
    private static final String USER_NAME = "Manh daica";
    private User mUser = new User(USER_NAME, EMAIL);

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Rule
    public TestSchedulerRule testSchedulerRule = new TestSchedulerRule();

    @Mock
    private Context mContext;

    @Mock
    private LoginView mView;

    @Mock
    private LoginRepository mLoginRepository;

    @Mock
    private ObservableField<String> email;

    @Mock
    private ObservableField<String> password;

    private LoginPresenter mPresenter;

    @Before
    public void setupLoginPresenter() throws Exception {
        MockitoAnnotations.initMocks(this);
        // neu dung singleton ->
        mPresenter = new LoginPresenter(mView, mLoginRepository);
    }

    @Test
    public void test_1_Init() {
        given(mView.context()).willReturn(mContext);
    }

    @Test
    public void test_2_onEmptyError() {
        mPresenter.onClickLogin();
        mView.onEmptyError();
    }

    @Test
    public void test_3_onEmailError() {
        mPresenter.email.set(EMAIL_INVALID);
        mPresenter.password.set(PASSWORD_INVALID);
        mPresenter.onClickLogin();
        verify(mView).onEmailError();
    }

    @Test
    public void test_4_onPasswordError() {
        mPresenter.email.set(EMAIL);
        mPresenter.password.set(PASSWORD_INVALID);
        mPresenter.onClickLogin();
        verify(mView).onPasswordError();
    }

    @Test
    public void test_5_onLoginError() throws Exception {
        ////case 1
        //        when(mLoginRepository.login(EMAIL, PASSWORD)).thenReturn(
        //                Observable.<User>error(new NullPointerException()));
        ////case 2
        //        doReturn(Observable.<User>error(new NullPointerException())).when(mLoginRepository)
        //                .login(EMAIL, PASSWORD);
        ////  case3
        given(mLoginRepository.login(EMAIL, PASSWORD)).willReturn(
                Observable.<User>error(new NullPointerException()));

        mPresenter.email.set(EMAIL);
        mPresenter.password.set(PASSWORD);
        mPresenter.onClickLogin();

        //        testSchedulerRule.getTestScheduler().advanceTimeBy(2, TimeUnit.SECONDS);

        verify(mView).showLoading();
        verify(mView).hideLoading();
        verify(mView).showError();
    }

    @Test
    public void test_6_onLoginSuccess() throws Exception {
        mPresenter.email.set(EMAIL);
        mPresenter.password.set(PASSWORD);
        when(mLoginRepository.login(EMAIL, PASSWORD)).thenReturn(Observable.just(mUser));
        //        testSchedulerRule.getTestScheduler().advanceTimeBy(2, TimeUnit.SECONDS);
        mPresenter.onClickLogin();
        verify(mView).showLoading();
        verify(mView).hideLoading();
        verify(mView).onLoginSuccess(mUser);
        verify(mLoginRepository).save(mUser);
    }
}