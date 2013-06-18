package com.laclife.net;

public abstract class LifefitBaseWS {

	public static final String TAG_LOGIN = "<fittype:Login>"
			+ "<fittype:UserId>mobapp</fittype:UserId>"
			+ "<fittype:Password>321357987</fittype:Password>"
			+ "</fittype:Login>";

	public static final String TAG_START = "<soap:Envelope "
			+ "xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" "
			+ "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" "
			+ "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" "
			+ "xmlns:fittype=\"LIFEfitData/types\"><soap:Body>";

	public static final String TAG_END = "</soap:Body></soap:Envelope>";

	public abstract void getDataInBackground(
			final GetDataCallBack getDataCallBack);

	public abstract String formatRequest();

}
