package com.pfizer.fragmin.http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;


/**
 * This class acts as a utility to make HTTP request.
 * AppValidator will be at the Application launch.
 * Must include {@link IHttpResponseCallback} Interface to get the response in Fragment file.
 * First String parameter is URL consumed by the doInbackGround method.
 * Last Parameter is the DataType you want to get in return as Http Response.
 *  Generally its a JSON String
 * 
 */
public class AppValidator extends AsyncTask<String, String, String>{
	
	IHttpResponseCallback httpcallback = null;	
	
	public AppValidator(Context context ,IHttpResponseCallback httpCallback) {
		// TODO Auto-generated constructor stub		
		this.httpcallback = httpCallback;
	}
	
	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
	}

    @Override
    protected String doInBackground(String... uri) {
        HttpClient httpclient = new DefaultHttpClient();
        HttpResponse response;
        HttpGet httpGet = new HttpGet(uri[0]);
        httpGet.setHeader("Accept", "application/json");
        String responseString = null;
        try {
            response = httpclient.execute(httpGet);
            StatusLine statusLine = response.getStatusLine();
            if(statusLine.getStatusCode() == HttpStatus.SC_OK){
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                response.getEntity().writeTo(out);
                out.close();
                responseString = out.toString();
            } else{
                //Closes the connection.
                response.getEntity().getContent().close();
                throw new IOException(statusLine.getReasonPhrase());
            }
        } catch (ClientProtocolException e) {
            //TODO Handle problems..
        } catch (IOException e) {
            //TODO Handle problems..
        }
        return responseString;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        
        if(httpcallback != null)
        {
        	httpcallback.postResult(result);
        }
        else
        {
        	Log.d("CallBack", "Please register for HTTP Callback");
        }
        //Do anything with response..
    }
}