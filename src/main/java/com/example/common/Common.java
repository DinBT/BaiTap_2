/*
 * Copyright 2015-2016 Classmethod, Inc.
 * All Rights Reserved.
 *
 * NOTICE:  All source code, documentation and other information
 * contained herein is, and remains the property of Classmethod, Inc.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Classmethod, Inc.
 */
package com.example.common;


/**
 * Class for common methods
 *
 * @author DinBT
 */
public class Common {

    public static final String KANJI = "^[一-龥]+$";

    public static final String POST_CODE = "^(?=.{7}$).*[0-9]+-[0-9]{1,2}+$";

    /**
     * Check text is katakana
     *
     * @param text : String to check
     * @return true: All is Katakana
     */
    public static boolean checkKatakana(String text) {
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.UnicodeBlock.of(c) != Character.UnicodeBlock.KATAKANA) {
                return false;
            }
        }
        return true;
    }
}
