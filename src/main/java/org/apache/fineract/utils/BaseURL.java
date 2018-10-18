package org.apache.fineract.utils;

public class BaseURL {
	public static final String API_ENDPOINT = "www.orosbank.com";
    public static final String API_PATH = "/fineract-provider/api/v1/";
    public static final String PROTOCOL_HTTPS = "https://";

    private String url;

    public String getUrl() {
    	url = PROTOCOL_HTTPS + API_ENDPOINT + API_PATH;
    	
        if (url == null) {
            return PROTOCOL_HTTPS + API_ENDPOINT + API_PATH;
        }
        return url;
    }

}
