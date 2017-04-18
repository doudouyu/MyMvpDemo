package navigation.bean.com.mymvpdemo.biz;

/**
 * 作者 : bean on 2017/4/18/0018.
 * 注释 :
 */
public interface IUserBiz {
    void login(String userName, String password, OnLoginListener onLoginListener);
}
