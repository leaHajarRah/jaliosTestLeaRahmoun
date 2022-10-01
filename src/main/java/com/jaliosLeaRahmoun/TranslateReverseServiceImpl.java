package com.jaliosLeaRahmoun;

import java.util.regex.Pattern;

public class TranslateReverseServiceImpl implements TranslateServiceInterface {

    @Override
    public String translate(String text, String sourceLang, String targetLang) {
	Pattern pattern = Pattern.compile("\\s");
	String[] temp = text != null ? pattern.split(text) : null;
	String result = "";

	if (temp != null) {
	    for (int i = 0; i < temp.length; i++) {
		StringBuilder sb = new StringBuilder();
		sb.append(temp[i]);
		sb = sb.reverse();
		if (i == temp.length - 1)
		    result = result + " " + sb;
		else
		    result = result + " " + sb;
	    }
	}

	return String.join(" ", sourceLang, targetLang, result.toString().replaceFirst(" ", ""));
    }

}
