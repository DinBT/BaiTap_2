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

import com.example.bean.TblArea;
import com.example.bean.TblCity;
import com.example.bean.TblOldPost;
import com.example.bean.TblPost;
import com.example.bean.TblPrefecture;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 * Class for common methods
 *
 * @author DinBT
 */
public class Common {
    /**
     * Convert jsonData from URL into a TblCity object
     *
     * @param jsonText
     * @return TblCity
     */
    public static TblCity dataToTblCity(String jsonText) {
        JSONObject jsonData = (JSONObject) JSONValue.parse(jsonText);
        TblCity tblCity = new TblCity(
                Integer.parseInt(jsonData.get("city_id").toString()),
                jsonData.get("code").toString(),
                jsonData.get("city_kana").toString(),
                jsonData.get("city").toString(),
                Integer.parseInt(jsonData.get("prefecture_id").toString()));
        return tblCity;
    }

    /**
     * Convert jsonData from URL into a TblArea object
     *
     * @param jsonText
     * @return TblArea
     */
    public static TblArea dataToTblArea(String jsonText) {
        JSONObject jsonData = (JSONObject) JSONValue.parse(jsonText);
        TblArea tblArea = new TblArea(
                Integer.parseInt(jsonData.get("area_id").toString()),
                jsonData.get("area_kana").toString(),
                jsonData.get("area").toString(),
                Integer.parseInt(jsonData.get("city_id").toString()),
                Integer.parseInt(jsonData.get("chome_area").toString()),
                Integer.parseInt(jsonData.get("koaza_area").toString()),
                Integer.parseInt(jsonData.get("multi_post_area").toString()),
                Integer.parseInt(jsonData.get("post_id").toString()),
                Integer.parseInt(jsonData.get("old_post_id").toString()));
        return tblArea;
    }

    /**
     * Convert jsonData from URL into a TblPost object
     *
     * @param jsonText
     * @return TblPost
     */
    public static TblPost dataToTblPost(String jsonText) {
        JSONObject jsonData = (JSONObject) JSONValue.parse(jsonText);
        TblPost tblPost = new TblPost(
                Integer.parseInt(jsonData.get("post_id").toString()),
                jsonData.get("post_code").toString(),
                Integer.parseInt(jsonData.get("update_show").toString()),
                Integer.parseInt(jsonData.get("change_reason").toString()),
                Integer.parseInt(jsonData.get("multi_area").toString()));
        return tblPost;
    }

    /**
     * Convert jsonData from URL into a TblOldPost object
     *
     * @param jsonText
     * @return TblOldPost
     */
    public static TblOldPost dataToTblOldPost(String jsonText) {
        JSONObject jsonData = (JSONObject) JSONValue.parse(jsonText);
        TblOldPost tblOldPost = new TblOldPost(
                Integer.parseInt(jsonData.get("old_post_id").toString()),
                jsonData.get("old_post_code").toString());
        return tblOldPost;
    }

    /**
     * Convert jsonData from URL into a TblPrefecture object
     *
     * @param jsonText
     * @return TblPrefecture
     */
    public static TblPrefecture dataToTblPrefecture(String jsonText) {
        JSONObject jsonData = (JSONObject) JSONValue.parse(jsonText);
        TblPrefecture tblCity = new TblPrefecture(
                Integer.parseInt(jsonData.get("prefecture_id").toString()),
                jsonData.get("prefecture_kana").toString(),
                jsonData.get("prefecture").toString(),
                jsonData.get("prefecture_code").toString());
        return tblCity;
    }
}
