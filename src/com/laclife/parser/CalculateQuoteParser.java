package com.laclife.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import com.laclife.model.CalculateQuoteResponse;
import com.laclife.model.QuoteDataModel;

public class CalculateQuoteParser extends LifefitBaseParser {

	// We don't use namespaces
	private static final String ns = null;

	private static final String TAG_QUOTE_NO = "QuoteNo";
	private static final String TAG_QUOTE_DATA = "QuoteData";
	private static final String TAG_NAME = "Name";
	private static final String TAG_VALUE = "Value";

	@Override
	public Object parseResponse(String response) throws XmlPullParserException,
			IOException {

		CalculateQuoteResponse quoteResponse = new CalculateQuoteResponse();
		List<QuoteDataModel> quoteData = new ArrayList<QuoteDataModel>();

		String quoteNo = null;
		XmlPullParser parser = newPullParser(response);

		int eventType = parser.getEventType();
		while (eventType != XmlPullParser.END_DOCUMENT) {
			String tag = null;
			switch (eventType) {
			case XmlPullParser.START_DOCUMENT:
				break;
			case XmlPullParser.START_TAG:
				tag = parser.getName();
				if (tag.equals(TAG_QUOTE_NO)) {
					quoteNo = readQuoteNo(parser);
				} else if (tag.equals(TAG_QUOTE_DATA)) {
					quoteData.add(readQuoteData(parser));
				}
				break;
			case XmlPullParser.END_TAG:
				break;
			}
			eventType = parser.next();
		}

		quoteResponse.setQuoteNo(quoteNo);
		quoteResponse.setQuoteData(quoteData);
		return quoteResponse;
	}

	private QuoteDataModel readQuoteData(XmlPullParser parser)
			throws IOException, XmlPullParserException {

		QuoteDataModel quote = new QuoteDataModel();

		parser.require(XmlPullParser.START_TAG, ns, "QuoteData");

		while (parser.next() != XmlPullParser.END_TAG) {
			if (parser.getEventType() != XmlPullParser.START_TAG) {
				continue;
			}
			String tag = parser.getName();
			if (tag.equals(TAG_NAME)) {
				quote.setName(readName(parser));
			} else if (tag.equals(TAG_VALUE)) {
				quote.setValue(readValue(parser));
			} else {
				skip(parser);
			}
		}

		return quote;

	}

	// Processes title tags in the feed.
	private String readQuoteNo(XmlPullParser parser) throws IOException,
			XmlPullParserException {
		parser.require(XmlPullParser.START_TAG, ns, "QuoteNo");
		String title = readText(parser);
		parser.require(XmlPullParser.END_TAG, ns, "QuoteNo");
		return title;
	}

	// Processes title tags in the feed.
	private String readName(XmlPullParser parser) throws IOException,
			XmlPullParserException {
		parser.require(XmlPullParser.START_TAG, ns, "Name");
		String title = readText(parser);
		parser.require(XmlPullParser.END_TAG, ns, "Name");
		return title;
	}

	// Processes summary tags in the feed.
	private String readValue(XmlPullParser parser) throws IOException,
			XmlPullParserException {
		parser.require(XmlPullParser.START_TAG, ns, "Value");
		String summary = readText(parser);
		parser.require(XmlPullParser.END_TAG, ns, "Value");
		return summary;
	}

}
