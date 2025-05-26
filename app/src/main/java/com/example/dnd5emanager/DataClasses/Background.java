package com.example.dnd5emanager.DataClasses;

import static com.example.dnd5emanager.DataClasses.Constants.Backgrounds;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Background {
    private String Name;
        public void setName(String Name) {
            this.Name = Name;
        }
        public String getName() {
            return Name;
        }
//    private final ArrayList<Feature> Features;
    private final int Gold;
//    private final ArrayList<Equipment> Equipment;
//    private final ArrayList<String> Languages;

    public Background(String Name, /*ArrayList<Feature> Features,*/ int Gold/*, ArrayList<Equipment> Equipment, ArrayList<String> Languages*/){
        this.Name = Name;
//        this.Features = Features;
        this.Gold = Gold;
//        this.Equipment = Equipment;
//        this.Languages = Languages;
    }

    public static void parseBackgrounds(Context context, String dir, String s) {
        AssetManager AM;

        Log.d("Jason", "He was just born in Background.");
        AM = context.getAssets();
        char Letter = s.toLowerCase().charAt(0);
        try {
            String[] fileNames = AM.list(dir);
            if (fileNames != null) {
                int i = 0;
                for (String fileName : fileNames) {
                    if (Letter == fileName.toLowerCase().charAt(0) || Letter == ' ') {
                        String fullPath = dir + "/" + fileName;
                        InputStream inputStream = AM.open(fullPath);
                        int size = inputStream.available();
                        byte[] buffer = new byte[size];
                        inputStream.read(buffer);
                        inputStream.close();
                        String jsonString = new String(buffer, StandardCharsets.UTF_8);
                        JSONObject jsonObject = new JSONObject(jsonString);
                        String materialCost = "";
                        Backgrounds.put(jsonObject.getString("name"), new Background(
                                jsonObject.getString("name"),
                                jsonObject.getInt("goldPieces")
                        ));
                        Log.d("Background #" + i, jsonObject.getString("name"));
                        i++;
                    }
                }
            }
        }
        catch (IOException | JSONException e){
            Log.d("Jason?", "Shot dead in Background.");
            throw new RuntimeException(e);
        }
    }
}
