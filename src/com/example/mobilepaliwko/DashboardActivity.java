package com.example.mobilepaliwko;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DashboardActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashboard);

	}
	
	public void showMap(View v)
	{
		Intent intent = new Intent(this, WebActivity.class);
		startActivity(intent);
	}
	
	public void showStations(View v)
	{
		/*Intent intent = new Intent(this, StationsActivity.class);
		startActivity(intent);*/
		new Stations(this).execute();
		System.out.println("click");
	}
	
	public void goToStations(ArrayList<String> lista)
	{
		Intent intent = new Intent(this, StationsActivity.class);
		intent.putStringArrayListExtra("lista", lista);
		startActivity(intent);
	}
}
