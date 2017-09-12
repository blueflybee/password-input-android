package com.blueflybee.passwordinput;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.Toast;

import com.blueflybee.library.PasswordInputView;

public class MainActivity extends AppCompatActivity implements PasswordInputView.OnFinishListener {

  private PasswordInputView passwordView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initView();
  }

  private void initView() {
    passwordView = (PasswordInputView)findViewById(R.id.password_view);
    initListener();
  }

  private void initListener() {
    passwordView.setOnFinishListener(this);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  @Override
  public void setOnPasswordFinished() {
    // TODO Auto-generated method stub
    if (passwordView.getOriginText().length() == passwordView.getMaxPasswordLength()) {
      Toast.makeText(this, "密码为" + passwordView.getOriginText(), Toast.LENGTH_LONG).show();
    }
  }

}