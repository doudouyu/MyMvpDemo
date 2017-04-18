package navigation.bean.com.mymvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import navigation.bean.com.mymvpdemo.bean.UserBean;
import navigation.bean.com.mymvpdemo.presenter.Ipresenter;
import navigation.bean.com.mymvpdemo.view.IUserLoginView;

public class MainActivity extends AppCompatActivity implements IUserLoginView {

    private EditText etName;
    private EditText etPassword;
    private TextView tvLogin;
    private TextView tvClear;
    private ProgressBar mPbLoading;
    private Ipresenter ipresenter = new Ipresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        dealCommon();
    }

    private void dealCommon() {
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ipresenter.login();
            }
        });
        tvClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ipresenter.clear();
            }
        });
    }

    private void initView() {
        mPbLoading = (ProgressBar) findViewById(R.id.pb);
        etName = (EditText) findViewById(R.id.et_name);
        etPassword = (EditText) findViewById(R.id.et_password);
        tvLogin = (TextView) findViewById(R.id.tv_login);
        tvClear = (TextView) findViewById(R.id.tv_clear);
    }

    @Override
    public String getUserName() {
        return etName.getText().toString();
    }

    @Override
    public String getPassword() {
        return etPassword.getText().toString();
    }

    /**
     * 清空用户名
     */
    @Override
    public void clearUserName() {
        etName.setText("");
    }

    /**
     * 清除密码框
     */
    @Override
    public void clearPassword() {
        etPassword.setText("");
    }

    /**
     * 隐藏加载框
     */
    @Override
    public void hideLoading() {
        mPbLoading.setVisibility(View.GONE);
    }

    /**
     * 显示加载框
     */
    @Override
    public void showLoading() {
        mPbLoading.setVisibility(View.VISIBLE);

    }

    /**
     * 联网获取的数据，在该界面展示
     * @param user
     */
    @Override
    public void toMainActivity(UserBean user) {
        Toast.makeText(this,
                "login success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this,
                "login failed", Toast.LENGTH_SHORT).show();

    }
}
