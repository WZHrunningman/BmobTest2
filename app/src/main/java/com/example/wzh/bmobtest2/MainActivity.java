package com.example.wzh.bmobtest2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.wzh.bmobtest2.bean.UserBean;
import com.example.wzh.bmobtest2.util.ToastUtils;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

import static com.example.wzh.bmobtest2.R.id.btn_register;

public class MainActivity extends Activity implements OnClickListener {

    // Bmob应用创建建时获取的Application id,根据自己创建的应用来写入
    private static final String BMOB_APPLICATION_ID = "812b06a63357a00af19cfb0d5afbe1e0";
    Button btn_register, btn_login;
    EditText et_login_name, et_password;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 初始化 Bmob SDK
        // 使用时请将第二个参数Application ID替换成你在Bmob服务器端创建的Application ID
        Bmob.initialize(this, BMOB_APPLICATION_ID);
        initView();
    }

    /**
     *
     * 初始化控件
     */
    private void initView() {
        btn_register = (Button) this.findViewById(R.id.btn_register);
        btn_login = (Button) this.findViewById(R.id.btn_login);
        et_login_name = (EditText) this.findViewById(R.id.et_login_name);
        et_password = (EditText) this.findViewById(R.id.et_password);

        btn_register.setOnClickListener(this);
        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_register:
                register();
                break;
            case R.id.btn_login:
                login();
                break;
        }
    }

    private void register() {

        String loginId = et_login_name.getText().toString();
        String password = et_password.getText().toString();
        if (loginId.isEmpty() || password.isEmpty()) {
            ToastUtils.toast(this, "密码或账号不为空!");
            return;
        }

        final UserBean us = new UserBean();
        us.setLoginId(loginId);
        us.setPassword(password);
        us.setUserName("Bmob");
        /**
         * 保存数据到Bmob服务器
         */
        us.save(new SaveListener<String>() {
            @Override
            public void done(String objectId, BmobException e) {
                if(e==null){
                    ToastUtils.toast(MainActivity.this, us.toString()
                            + " 注册成功");
                }else{
                    int arg0 = 0;
                    String arg1 = null;
                    ToastUtils.toast(MainActivity.this, arg0 + "," + arg1 + " 注册失败");
                }
            }
        });

    }


    private void login() {

        String loginId = et_login_name.getText().toString();
        String password = et_password.getText().toString();
        if (loginId.isEmpty() || password.isEmpty()) {
            ToastUtils.toast(this, "密码或账号不为空!");
            return;
        }

        BmobQuery<UserBean> userQuery = new BmobQuery<UserBean>();

        // 查询条件
        userQuery.addWhereEqualTo("loginId", loginId);
        userQuery.addWhereEqualTo("password", password);

        userQuery.findObjects(new FindListener<UserBean>() {

            @Override
            public void done(List<UserBean> list, BmobException e) {
                if (list != null && list.size() > 0)
                    ToastUtils.toast(MainActivity.this, " 登陆成功");
                else {
                    int arg0 = 0;
                    String arg1 = null;
                    ToastUtils.toast(MainActivity.this, arg0 + "," + arg1 + " 登陆失败");
                }
            }
        });

    }

}
