package com.example.mobilepaliwko;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;

public class SigninActivity extends AsyncTask<String,Void,String>{
	
	private MainActivity activity;
	
	public SigninActivity(MainActivity activity)
	{
		this.activity = activity;
	}
	@Override
	protected String doInBackground(String... arg0) {
		try{
	         String email = (String)arg0[0];
	         String password = (String)arg0[1];
	         String link = "http://10.0.2.2/android/login.php?email="+email+"&password="+password;
	         
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
	            return sb.toString();
	         }
	         
	         catch(Exception e){
	            return new String("Exception: " + e.getMessage());
	         }
	}
	@Override
   protected void onPostExecute(String result){
      System.out.println("result: " + result);
      if(!result.equals("error"))
      {
    	 activity.goToDashboard();
      }
      else
      {
    	  System.out.println("!!! error !!!");
      }
   }
}
