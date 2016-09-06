package com.example.mobilepaliwko;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RegisterActivity extends Activity {

	public EditText name;
	public EditText email;
	public EditText password;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		name = (EditText) findViewById(R.id.nameField);
		email = (EditText) findViewById(R.id.emailField);
		password = (EditText) findViewById(R.id.passwordField);
	}
	
	public void nameClear(View v){
		name.setText("");
	}
	
	public void emailClear(View v){
		email.setText("");
	}
	
	public void passwordClear(View v){
		password.setText("");
	}
	
	public void register(View v)
	{
		new SignupAcitivity(this).execute(name.getText().toString(), email.getText().toString(), password.getText().toString());
	}
	
	public void backToLogin(View v){
		backToLoginA();
	}
	
	public void backToLoginA(){
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}
}
