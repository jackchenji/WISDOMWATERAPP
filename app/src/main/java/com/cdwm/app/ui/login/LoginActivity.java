package com.cdwm.app.ui.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import okhttp3.Response;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cdwm.app.model.UserModel;
import com.cdwm.app.po.FormLogin;
import com.cdwm.app.ui.tab.TabActivity;
import com.cdwm.app.util.Constants;
import com.cdwm.app.R;
import com.cdwm.app.util.CurrentLoginUser;
import com.cdwm.app.util.GsonUtil;
import com.cdwm.app.util.HttpReturnListener;
import com.cdwm.app.util.HttpUtil;
import com.cdwm.app.util.SoftKeyBoardUtil;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private FormLogin formLogin;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.formLogin = new FormLogin();
        final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);
        final Button loginButton = findViewById(R.id.login);
        final TextView txtConfig=findViewById(R.id.txtConfig);
        usernameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.d(Constants.EWIDSOM_APP_DEBUG, "用户名发生了变更:" + editable.toString());
            }
        });
        passwordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                Log.d(Constants.EWIDSOM_APP_DEBUG, "密码发生了变更:" + editable.toString());
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkFields();
            }
        });

        txtConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showConfigView();
            }
        });
    }

    private void showConfigView(){
        Intent intent = new Intent(LoginActivity.this, ServiceConfigActivity.class);
        //intent.putExtra("userName", userName);//传值
        startActivity(intent);
    }

    /**
     * 检查表单
     */
    private void checkFields() {
        final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);

        String userName = usernameEditText.getText().toString();
        String passWord = passwordEditText.getText().toString();

        if (userName.equals("")) {
            Toast.makeText(this, getResources().getString(R.string.empty_username), Toast.LENGTH_LONG).show();
            return;
        }

        if (passWord.equals("")) {
            Toast.makeText(this, getResources().getString(R.string.empty_password), Toast.LENGTH_LONG).show();
            ;
            return;
        }

        if (passWord.length() < 5) {
            Toast.makeText(this, getResources().getString(R.string.invalid_password), Toast.LENGTH_LONG).show();
            ;
            return;
        }

        formLogin.setUserName(userName);
        formLogin.setPassWord(passWord);

        SoftKeyBoardUtil.hideSoftKeyboard(this);
        networkPost();
    }

    public void networkPost() {
        /*参数*/
        Map<String, String> params = new HashMap<>();
        params.put("uid", this.formLogin.getUserName());
        params.put("password", this.formLogin.getPassWord());
        CurrentLoginUser.user.setUid(this.formLogin.getUserName());
        CurrentLoginUser.user.setPassword(this.formLogin.getPassWord());
        HttpUtil.asyncPost(Constants.LOGIN_SERVICE,
                params,
                new HttpReturnListener() {
                    @Override
                    public void onFinish(Response response, String responseString) {
                        Map returnMap = GsonUtil.getBeanfromString(responseString, Map.class);
                        if (returnMap != null) {
                            Map headMap = (Map) returnMap.get("head");
                            String result = String.valueOf(headMap.get("result"));
                            String msg = String.valueOf(headMap.get("msg"));
                            if ("true".equalsIgnoreCase(result)) {
                                //登陆成功
                                Map<String, Map> bodyMap = (Map) returnMap.get("body");
                                String userName = String.valueOf(bodyMap.get("operinfo").get("realname"));
                                CurrentLoginUser.user.setUserName(userName);
                                Toast.makeText(LoginActivity.this, "登录成功，欢迎:" + userName, Toast.LENGTH_LONG).show();
                                //跳转并传参
                                Intent intent = new Intent(LoginActivity.this, TabActivity.class);
                                intent.putExtra("userName", userName);//传值
                                startActivity(intent);

                            } else {
                                Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                    @Override
                    public void onErr(Exception e) {
                       // e.printStackTrace();
                        Toast.makeText(LoginActivity.this, "服务器异常，请稍后再试", Toast.LENGTH_LONG).show();
                        //一般进这里是因为网络情况不好。
                    }
                }
        );
    }
}
