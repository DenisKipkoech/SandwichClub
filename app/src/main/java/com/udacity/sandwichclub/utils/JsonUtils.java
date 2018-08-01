package com.udacity.sandwichclub.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.udacity.sandwichclub.R;
import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        try {

            JSONObject sandwich = new JSONObject(json);
            JSONObject name = (JSONObject) sandwich.get("name");
            JSONArray alsoKnownAs = name.getJSONArray("alsoKnownAs");
            JSONArray mIngredients = sandwich.getJSONArray("ingredients");

            String mainName = name.getString("mainName");

            List<String> alsoKnownAsList = new ArrayList<>();
            getItemFromArray(alsoKnownAsList, alsoKnownAs);


            String placeOfOrigin = sandwich.getString("placeOfOrigin");
            String description = sandwich.getString("description");
            String image = sandwich.getString("image");
            List<String> ingredients = new ArrayList<>();
            getItemFromArray(ingredients, mIngredients);


            return new Sandwich(mainName, alsoKnownAsList, placeOfOrigin,
                    description, image, ingredients);


        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
    private static void getItemFromArray(List<String> listItem, JSONArray jsonArray){
        int loop = 0;
        while(loop < jsonArray.length()){
            try {
                listItem.add(jsonArray.getString(loop));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            loop += 1;
        }

    }

}
