package com.example.dnd5emanager.DataClasses;

import static com.example.dnd5emanager.DataClasses.Constants.Features;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Feature {
    private final String Name;

    public String getName() {
        return Name;
    }

    private final Map<Integer, String> Description;

    public String getDescription(int Level) {
        return Description.get(Level);
    }

    public ArrayList<CharacterClass> SupportedClasses;

    public Feature(String Name, Map<Integer, String> Description) {
        this.Name = Name;
        this.Description = Description;
    }

    public static void parseFeatures(Context context, String dir, String s) {
        AssetManager AM;

        Log.d("Jason", "He was just born in Feature.");
        AM = context.getAssets();
        char Letter = s.toLowerCase().charAt(0);
        try {
            String[] fileNames = AM.list(dir);
            if (fileNames != null) {
                int j = 0;
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
                        Map<Integer, String> DescModels = new HashMap<>();

                        for(int i = 0; i < jsonObject.getJSONArray("descriptionModels").length(); i++){
                            DescModels.put(jsonObject.getJSONArray("descriptionModels").getJSONObject(i).getInt("level"), jsonObject.getJSONArray("descriptionModels").getString(i));
                        }

                        Features.put(jsonObject.getString("name"), new Feature(
                                jsonObject.getString("name"),
                                DescModels
                        ));

                        Log.d("Feature #" + j, jsonObject.getString("name"));
                        j++;
                    }
                }
            }
        }
        catch (IOException | JSONException e){
            Log.d("Jason?", "Shot dead in Feature.");
            throw new RuntimeException(e);
        }
    }

    public static void initializeFeatures(Context context){
        Handler mainHandler = new Handler(Looper.getMainLooper());
        ExecutorService executorService = Executors.newFixedThreadPool(26);
        executorService.execute(new Runnable(){@Override public void run(){parseFeatures(context, "features", "A");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeatures(context, "features", "B");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeatures(context, "features", "C");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeatures(context, "features", "D");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeatures(context, "features", "E");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeatures(context, "features", "F");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeatures(context, "features", "G");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeatures(context, "features", "H");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeatures(context, "features", "I");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeatures(context, "features", "J");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeatures(context, "features", "K");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeatures(context, "features", "L");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeatures(context, "features", "M");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeatures(context, "features", "N");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeatures(context, "features", "O");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeatures(context, "features", "P");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeatures(context, "features", "Q");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeatures(context, "features", "R");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeatures(context, "features", "S");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeatures(context, "features", "T");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeatures(context, "features", "U");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeatures(context, "features", "V");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeatures(context, "features", "W");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeatures(context, "features", "X");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeatures(context, "features", "Y");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeatures(context, "features", "Z");}});
    }
}