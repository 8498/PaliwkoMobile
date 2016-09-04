package com.example.mobilepaliwko;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Stations extends AsyncTask<String, Void, String>
{	
	private DashboardActivity dashboardActivity;

	public Stations(DashboardActivity dashboardActivity) {
		this.dashboardActivity = dashboardActivity;
	}

	@Override
	protected String doInBackground(String... params) {
		try{
	         String link = "http://10.0.2.2/android/stations.php";
	         
	         URL url = new URL(link);
	         HttpClient client = new DefaultHttpClient();
	         HttpGet request = new HttpGet();
	         request.setURI(new URI(link));
	         HttpResponse response = client.execute(request);
	         
	         BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

	           StringBuffer sb = new StringBuffer("");
	           String line="";
	           
	           while ((line = in.readLine()) != null) {
	              sb.append(line);
	              break;
	            }
	            in.close();
	            System.out.println("result1: " + sb.toString());
	            return sb.toString();
	         }
	         
	         catch(Exception e){
	            return new String("Exception: " + e.getMessage());
	         }
	}
	
	@Override
	protected void onPostExecute(String result) {
		System.out.println("result2: " + result);
		try {
			//JSONObject json_data= new JSONObject(result);
			JSONArray arrJson = new JSONArray(result);
			//JSONObject json_data = new JSONObject(arrJson.getString(0));
			//System.out.println("result3: " + arrJson.getString(0));
			//System.out.println(json_data.get("name"));
			
			ArrayList<String> listdata = new ArrayList<String>();
			
			if (arrJson != null) { 
				   for (int i=0;i<arrJson.length();i++){ 
				    listdata.add(arrJson.get(i).toString());
				   } 
				} 
			
			System.out.println("ok");
			dashboardActivity.goToStations(listdata);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }

}