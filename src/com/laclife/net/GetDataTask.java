package com.laclife.net;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParserException;

import android.os.AsyncTask;

import com.laclife.parser.LifefitBaseParser;

public class GetDataTask extends AsyncTask<String, Void, Object> {

	private LifefitBaseParser mParser;
	private GetDataCallBack mDataCallBack;

	public GetDataTask(LifefitBaseParser parser, GetDataCallBack dataCallBack) {
		mParser = parser;
		mDataCallBack = dataCallBack;
	}

	@Override
	protected Object doInBackground(String... params) {
		String response = WebServiceHelper
				.executeHttpSOAP(params[0], params[1]);
		try {
			return mParser.parseResponse(response);
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	protected void onPostExecute(Object result) {
		mDataCallBack.done(result);
	}
}
