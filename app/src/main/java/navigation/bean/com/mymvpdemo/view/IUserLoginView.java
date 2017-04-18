package navigation.bean.com.mymvpdemo.view;

import navigation.bean.com.mymvpdemo.bean.UserBean;

/**
 * 作者 : bean on 2017/4/18/0018.
 * 注释 :
 */
public interface IUserLoginView {

    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(UserBean user);

    void showFailedError();
}
