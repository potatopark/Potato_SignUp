package com.example.park.signup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.park.signup.helper.RegexHelper;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public static final int REQUEST_CODE=101;
    EditText editText1, editText2, editText3, editText4;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(this);
    }
    public void onButton(View v) {


        Intent myIntent = new Intent(getApplicationContext(), ManySite.class);
        startActivityForResult(myIntent,REQUEST_CODE);
    }
    @Override
    public void onClick(View v) {
        String name = editText1.getText().toString().trim();
        String email = editText2.getText().toString().trim();
        String address = editText3.getText().toString().trim();
        String tel = editText4.getText().toString().trim();

        String err_msg = null;

        if (err_msg == null && !RegexHelper.getInstance().isValue(name)) {//메세지가 없거나 이름이 null이면
            err_msg = "이름을 입력해 주세요.";
        }
//        if(err_msg == null && !RegexHelper.getInstance().isKor(name)){
//            err_msg = "이름을 한글로만 입력해 주세요.";
//        }
        if (err_msg == null && !RegexHelper.getInstance().isValue(email)) {//메세지가 없거나 이메일이 null이면
            err_msg = "이메일 주소를를 입력해 주세요.";
        }
        if (err_msg == null && !RegexHelper.getInstance().isEmail(email)) {
            err_msg = "이메일 주소가 형식에 맞지 않습니다.";
        }
        if (err_msg == null && !RegexHelper.getInstance().isValue(address)) {//메세지가 없거나 주소가 null이면
            err_msg = "주소을 입력해 주세요.";
        }
        if (err_msg == null && !RegexHelper.getInstance().isValue(tel)) {//메세지가 없거나 핸드폰이 null이면
            err_msg = "전화번호을 입력해 주세요.";
        }
        if (err_msg == null && !RegexHelper.getInstance().isCellPhone(tel)) {
            err_msg = "전화번호가 형식에 맞지 않습니다.";
        }
        if (err_msg != null) {
            Toast.makeText(this, err_msg, Toast.LENGTH_SHORT).show();
            return;
        }
        String result = String.format("이름: %s\n이메일: %s\n주소: %s\n전화번호: %s",
                name,email,address,tel);
        Toast.makeText(this,result,Toast.LENGTH_SHORT).show();
        onButton(button);



    }

}
