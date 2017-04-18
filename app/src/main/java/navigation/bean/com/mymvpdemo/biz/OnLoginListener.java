package navigation.bean.com.mymvpdemo.biz;

import navigation.bean.com.mymvpdemo.bean.UserBean;

/**
 * 作者 : bean on 2017/4/18/0018.
 * 注释 :
 */
public interface OnLoginListener {
  void   onSuccess(UserBean user);
  void   onFailed();
}
