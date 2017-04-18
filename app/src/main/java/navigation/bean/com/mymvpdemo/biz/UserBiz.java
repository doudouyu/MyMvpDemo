package navigation.bean.com.mymvpdemo.biz;

import navigation.bean.com.mymvpdemo.bean.UserBean;

/**
 * 作者 : bean on 2017/4/18/0018.
 * 注释 :网络请求写在这里
 */
public class UserBiz implements IUserBiz {

    @Override
    public void login(final String userName, final String password, final OnLoginListener onLoginListener) {
        new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(2000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                //模拟登录成功
                if ("ydd".equals(userName) && "123".equals(password))
                {
                    UserBean user = new UserBean();
                    user.setName(userName);
                    user.setPassword(password);
                    onLoginListener.onSuccess(user);

                }else {
                    onLoginListener.onFailed();

                }
            }
        }.start();

    }
}
