package com.jaliosLeaRahmoun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class TranslateServiceImpl implements TranslateServiceInterface {


    @SuppressWarnings("deprecation")
    @Override
    public String translate(String text, String sourceLang, String targetLang) throws IOException {
	String textToTranslate = text != null ? URLEncoder.encode(text, "UTF-8") : "";
	String urlStr = "https://translation.googleapis.com/language/translate/v2?key=AIzaSyAU141kb_mIY5fIJVABdkKNHAi_pHx1HV0"
		+ "&q=" + textToTranslate + "&target=" + targetLang + "&source=" + sourceLang;
	StringBuilder result = new StringBuilder();

	try {

	    URL url = new URL(urlStr);
	    HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
	    InputStream stream;

	    stream = conn.getResponseCode() == 200 ? conn.getInputStream() : conn.getErrorStream();
	    BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

	    String line;
	    while ((line = reader.readLine()) != null) {
		result.append(line);
	    }

	    JsonElement element = new JsonParser().parse(result.toString());

	    if (element.isJsonObject()) {
		JsonObject obj = element.getAsJsonObject();
		if (obj.get("error") == null) {
		    String translatedText = obj.get("data").getAsJsonObject().get("translations").getAsJsonArray()
			    .get(0).getAsJsonObject().get("translatedText").getAsString();
		    return translatedText;
		}
	    }

	} catch (IOException | JsonSyntaxException ex) {
	    System.err.println(ex.getMessage());
	}

	return "";
    }

}
