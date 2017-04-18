package navigation.bean.com.mymvpdemo.presenter;

import android.os.Handler;

import navigation.bean.com.mymvpdemo.bean.UserBean;
import navigation.bean.com.mymvpdemo.biz.OnLoginListener;
import navigation.bean.com.mymvpdemo.biz.UserBiz;
import navigation.bean.com.mymvpdemo.view.IUserLoginView;

/**
 * 作者 : bean on 2017/4/18/0018.
 * 注释 :这个类就是真正解决问题的类
 */
public class Ipresenter {
    private IUserLoginView userLoginView;
    private UserBiz userBiz;
    private Handler mHandler = new Handler();

    public Ipresenter(IUserLoginView userLoginView) {
        this.userLoginView = userLoginView;
        this.userBiz = new UserBiz();
    }

    public void login() {
        userLoginView.showLoading();
        userBiz.login(userLoginView.getUserName(), userLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void onSuccess(final UserBean user) {
                //需要在UI线程执行
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.toMainActivity(user);
                userLoginView.hideLoading();
            }
        });


            }

            @Override
            public void onFailed() {
                //需要在UI线程执行
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.showFailedError();
                        userLoginView.hideLoading();
                    }
                });


            }
        });
    }

    public void clear() {
        userLoginView.clearUserName();
        userLoginView.clearPassword();

    }

}
