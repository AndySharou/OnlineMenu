package com.example.andrew.ufafarfor13;

/**
 * Created by Andrew on 12.09.2016.
 */

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class XMLParser {
    //HttpURLConnection urlConnection = null;

    public XMLParser() {

    }

    // Retrive XML from URL
    public String getXmlFromUrl(String url) {
        String xml = null;

        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet httpget = new HttpGet(url);

            HttpResponse httpResponse = httpClient.execute(httpget);
            HttpEntity httpEntity = httpResponse.getEntity();
            xml = EntityUtils.toString(httpEntity);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return xml;
    }

    /*// Retrive DOM element
    public Document getDomElement(String xml) {
        Document doc = null;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {

            DocumentBuilder db = dbf.newDocumentBuilder();

            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(xml));
            doc = db.parse(is);

        } catch (ParserConfigurationException e) {
            Log.e("Error: ", e.getMessage());
            return null;
        } catch (SAXException e) {
            Log.e("Error: ", e.getMessage());
            return null;
        } catch (IOException e) {
            Log.e("Error: ", e.getMessage());
            return null;
        }

        return doc;
    }

    // Retrieve Node element
    public final String getElementValue(Node elem) {
        Node child;
        if (elem != null) {
            if (elem.hasChildNodes()) {
                for (child = elem.getFirstChild(); child != null; child = child
                        .getNextSibling()) {
                    if (child.getNodeType() == Node.TEXT_NODE) {
                        return child.getNodeValue();
                    }
                }
            }
        }
        return "";
    }

    // Retrive Node Value
    public String getValue(Element item, String str) {
        NodeList n = item.getElementsByTagName(str);
        return this.getElementValue(n.item(0));
    }*/
}