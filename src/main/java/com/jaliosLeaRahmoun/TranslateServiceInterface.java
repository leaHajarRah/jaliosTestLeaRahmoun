package com.jaliosLeaRahmoun;

import java.io.IOException;

public interface TranslateServiceInterface {
    /**
     * Translates a text string from one language to another.
     *
     * @param text       Required. A string representing the text to translate. The
     *                   size of the text must not exceed 10000 characters.
     * @param sourceLang Optional. A string representing the language code of the
     *                   translation text. For example, <code>en</code> for English.
     * @param targetLang A string Required. representing the language code to
     *                   translate the text into.
     * @return A string representing the translated text.
     * @throws IOException
     */
    String translate(String text, String sourceLang, String targetLang) throws IOException;
}
