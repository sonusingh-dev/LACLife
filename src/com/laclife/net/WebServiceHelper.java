package com.laclife.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.AndroidHttpTransport;

public class WebServiceHelper {

	private static final String NAMESPACE = "LIFEfitData";
	private static final String SOAP_ACTION = "http://tempuri.org/IVoetBallService/";
	private static final String URL = "http://www.webqa.fitltd.com/lwyapp/lifefit/soap";

	/** The Constant CONNECTION_TIMEOUT. */
	public static final int CONNECTION_TIMEOUT = 10 * 1000;

	/** The Constant WAIT_RESPONSE_TIMEOUT. */
	public static final int WAIT_RESPONSE_TIMEOUT = 20 * 1000;

	public static SoapObject getSOAPRequest(String METHOD_NAME) {
		return new SoapObject(NAMESPACE, METHOD_NAME);
	}

	public static Object getSOAPResponse(SoapObject request, String METHOD_NAME)
			throws Exception {

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.dotNet = true;
		envelope.setOutputSoapObject(request);

		AndroidHttpTransport transport = new AndroidHttpTransport(URL);
		transport.debug = true;

		transport.call(SOAP_ACTION + METHOD_NAME, envelope);

		return envelope.getResponse();
	}

	public static String executeHttpSOAP(String soapAction, String request) {

		InputStream inputStream = null;
		HttpClient httpClient = null;
		HttpPost httpPost = null;
		HttpEntity entity = null;
		HttpResponse httpResponse = null;
		String strResponse = null;

		try {
			httpClient = getThreadSafeHttpClient();
			httpPost = new HttpPost(URL);
			// add headers
			httpPost.setHeader("SOAPAction", soapAction);
			httpPost.setHeader("Content-Type", "text/xml; charset=utf-8");
			// the entity holds the request
			entity = new StringEntity(request);
			httpPost.setEntity(entity);
			httpResponse = httpClient.execute(httpPost);
			inputStream = httpResponse.getEntity().getContent();

			strResponse = convertStreamToString(inputStream);
		} catch (Exception e) {
			// TODO: handle exception
			// Log.e("Error in executing HttpGet");
			// Log.e(e);
			// com.menuslate.utils.Log.e(e);
		} finally {

			/*
			 * The entity needs to be consumed completely in order to re-use the
			 * connection with keep-alive.
			 */
			if (httpResponse != null) {
				try {
					httpResponse.getEntity().consumeContent();
					// Log.i("***** HTTP RESPONSE ENTITY CONSUMED *****");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					// Log.e("***** ERROR CONSUMING HTTP RESPONSE ENTITY *****");
					// Log.e(e);
					// com.menuslate.utils.Log.e(e);
				}
			}

			/*
			 * Shut down HttpClient
			 */
			if (httpClient != null) {
				httpClient.getConnectionManager().shutdown();
				// Log.i("***** HTTP CONNECTION SHUTDOWN *****");
			}

			/*
			 * Close input stream
			 */
			if (inputStream != null) {
				try {
					inputStream.close();
					// Log.i("***** INPUTSTREAM CLOSED *****");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					// Log.e("ERROR CLOSING INPUTSTREAM");
					// Log.e(e);
					// com.menuslate.utils.Log.e(e);
				}
			}
		}

		return strResponse;
	}

	/**
	 * Convert stream to string.
	 * 
	 * @param streamToConvert
	 *            the InputStream to convert
	 * @return the string or null
	 */
	public static String convertStreamToString(InputStream streamToConvert) {
		try {
			return new Scanner(streamToConvert).useDelimiter("\\A").next();
		} catch (NoSuchElementException e) {
			// com.menuslate.utils.Log.e(e);
			return null;
		}
	}

	/**
	 * Gets the thread safe HttpClient.
	 * 
	 * @return the thread safe HttpClient
	 */
	private static HttpClient getThreadSafeHttpClient() {

		HttpClient client = new DefaultHttpClient();

		ClientConnectionManager mgr = client.getConnectionManager();

		HttpParams params = client.getParams();
		HttpConnectionParams.setConnectionTimeout(params, CONNECTION_TIMEOUT);
		HttpConnectionParams.setSoTimeout(params, WAIT_RESPONSE_TIMEOUT);
		HttpConnectionParams.setTcpNoDelay(params, true);

		client = new DefaultHttpClient(new ThreadSafeClientConnManager(params,
				mgr.getSchemeRegistry()), params);

		return client;
	}

	/**
	 * Gets the input stream from URL.
	 * 
	 * @param url
	 *            the URL
	 * @return the input stream from URL
	 * @throws IllegalStateException
	 *             the illegal state exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws URISyntaxException
	 *             the uRI syntax exception
	 */
	public static InputStream getInputStreamFromUrl(String url)
			throws IllegalStateException, IOException, URISyntaxException {

		InputStream content = null;

		HttpClient httpclient = getThreadSafeHttpClient();

		HttpGet httpGet = new HttpGet(new URI(url));
		HttpResponse response = httpclient.execute(httpGet);

		content = response.getEntity().getContent();

		response.getEntity().consumeContent();
		httpclient.getConnectionManager().shutdown();

		return content;
	}
}