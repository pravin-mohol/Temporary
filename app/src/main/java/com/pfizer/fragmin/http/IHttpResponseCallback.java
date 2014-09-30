package com.pfizer.fragmin.http;


/**
 * This is a callback interface for HTTP.
 * AppValidator Class will fire a HTTP Get call.
 * When the result is received, postResult is called
 * {@link AppValidator}
 * 
 */
public interface IHttpResponseCallback {
	
	public void postResult(String httpResponse);

}
