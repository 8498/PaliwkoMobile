package com.example.mobilepaliwko;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	public EditText email;
	public EditText password;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);
	    
	    email = (EditText) findViewById(R.id.emailField);
		password = (EditText) findViewById(R.id.passwordField);
		
	}

	
	public void emailClear(View v){
		email.setText("");
	}
	
	public void passwordClear(View v){
		password.setText("");
	}
	
	public void login(View v){
		new SigninActivity(this).execute(email.getText().toString(),password.getText().toString());
	}
	
	public void goToRegister(View v){
		goToRegisterA();
	}
	
	public void goToDashboard(){
		Intent intent = new Intent(this, DashboardActivity.class);
		startActivity(intent);
	}
	
	public void goToRegisterA(){
		Intent intent = new Intent(this, RegisterActivity.class);
		startActivity(intent);
	}
	
}
