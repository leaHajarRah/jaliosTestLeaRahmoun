package com.jaliosLeaRahmoun;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.IOException;

import org.junit.Test;


public class TranslateServiceImplTest {

    @Test
    public void testTranslate() throws IOException {
	TranslateServiceInterface translate = new TranslateServiceImpl();
	TranslateServiceInterface translateReverse = new TranslateReverseServiceImpl();
	assertEquals(translate.translate("bonjour", "FR", "EN"), "hello");
	assertNotEquals(translate.translate("bonjour", "FR", "ES"), "hello");
	assertEquals(translate.translate("", "", ""), "");
	assertEquals(translateReverse.translate("Ceci est un Test", "FR", "EN"), "FR EN iceC tse nu tseT");
	assertNotEquals(translateReverse.translate("Ceci est un Test", "EN", "FR"), "FR EN iceC tse nu tseT");
	assertNotEquals(translateReverse.translate("", "FR", "ES"), "FR EN iceC tse nu tseT");
	assertNotEquals(translateReverse.translate("Ceci est un Test", "", ""), "FR EN iceC tse nu tseT");
    }


}
