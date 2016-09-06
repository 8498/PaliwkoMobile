package com.example.mobilepaliwko;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;

public class StationsRequest extends AsyncTask<String, Void, String>
{	
	private DashboardActivity dashboardActivity;

	public StationsRequest(DashboardActivity dashboardActivity) {
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
			JSONArray arrJson = new JSONArray(result);
			
			ArrayList<JSONObject> listdata = new ArrayList<JSONObject>();
			
			if (arrJson != null) { 
				   for (int i=0;i<arrJson.length();i++){ 
				    listdata.add(arrJson.getJSONObject(i));
				   } 
				} 
			
			ArrayList<String> listdata2 = new ArrayList<String>();
			if (listdata != null) { 
				   for (int i=0;i<listdata.size();i++){ 
				    listdata2.add(arrJson.getJSONObject(i).getString("name") + "\n" + 
				    arrJson.getJSONObject(i).getString("created_at") + "\n" + 
				    "LPG: " + arrJson.getJSONObject(i).getString("LPG") + " | " + 
				    "ON: " + arrJson.getJSONObject(i).getString("ON") + " | " + 
				    "PB95: " + arrJson.getJSONObject(i).getString("PB95") + " | " + 
				    "PB98: " + arrJson.getJSONObject(i).getString("PB98"));
				   } 
				} 
			
			
			System.out.println("ok");
			dashboardActivity.goToStations(listdata2);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }

}