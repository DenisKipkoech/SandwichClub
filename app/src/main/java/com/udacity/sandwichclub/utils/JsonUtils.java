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
        Sandwich mSandwich = new Sandwich();
        try {
            Log.d("JSONUTILS", json);
            JSONObject sandwich = new JSONObject(json);
            JSONObject name = (JSONObject) sandwich.get("name");
            JSONArray alsoKnown = name.getJSONArray("alsoKnownAs");
            JSONArray mIngredients = sandwich.getJSONArray("ingredients");

            String mainName = name.getString("mainName");
            List<String> alsoKnownAs = new ArrayList<>();
            if (alsoKnown != null){
                int len = alsoKnown.length();
                for (int i = 0; i <= len; i++){
                    alsoKnownAs.add(alsoKnown.get(i).toString());
                }
            }
            String placeOfOrigin = sandwich.getString("placeOfOrigin");
            String description = sandwich.getString("description");
            String image = sandwich.getString("image");
            List<String> ingredients = new ArrayList<>();
            if (mIngredients != null){
                int len = mIngredients.length();
                for (int i = 0; i <= len; i++){
                    ingredients.add(mIngredients.get(i).toString());
                }
            }

            mSandwich = new Sandwich(mainName, alsoKnownAs, placeOfOrigin,
                    description, image, ingredients);

        } catch (JSONException e) {
            e.printStackTrace();
        }

       return mSandwich;
    }


}
