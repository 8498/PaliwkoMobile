package com.example.mobilepaliwko;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class StationsActivity extends Activity {
	
	private ListView list;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stations);
		
		System.out.println("okejka");
		
		Bundle extras = getIntent().getExtras();
		list = (ListView) findViewById(R.id.lista);
		
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,extras.getStringArrayList("lista"));
        
		list.setAdapter(arrayAdapter); 
	}
	
	public void backToDashboard(View v)
	{
		Intent intent = new Intent(this, DashboardActivity.class);
		startActivity(intent);
	}
}