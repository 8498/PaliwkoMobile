package com.example.mobilepaliwko;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
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
}