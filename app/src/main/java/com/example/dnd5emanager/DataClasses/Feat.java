package com.example.dnd5emanager.DataClasses;

import static com.example.dnd5emanager.DataClasses.Constants.Feats;

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
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Feat {
    private String Name;
        public void setName(String Name){this.Name = Name;}
        public String getName(){return Name;}

    private Map<Integer, String> Description;
    public String getDescription(int Level) {
        return Description.get(Level);
    }

    private int Level;
        public void setLevel(int Level){this.Level = Level;}
        public int getLevel(){return Level;}

    private String Notes;
        public void setNotes(String Notes){this.Notes = Notes;}
        public String getNotes(){return Notes;}

    public Feat(String Name, Map<Integer, String> Description, int Level){
        this.Name = Name;
        this.Description = Description;
        this.Level = Level;
    }

    public static void parseFeats(Context context, String dir, String s) {
        AssetManager AM;

        Log.d("Jason", "He was just born in Feat.");
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

                        for (int i = 0; i < jsonObject.getJSONArray("descriptionModels").length(); i++) {
                            DescModels.put(jsonObject.getJSONArray("descriptionModels").getJSONObject(i).getInt("level"), jsonObject.getJSONArray("descriptionModels").getString(i));
                        }

                        Feats.put(jsonObject.getString("name"), new Feat(
                                jsonObject.getString("name"),
                                DescModels,
                                jsonObject.getInt("level")
                        ));

                        Log.d("Feat #" + j, jsonObject.getString("name"));
                        j++;
                    }
                }
            }
        }
        catch (IOException | JSONException e){
            Log.d("Jason?", "Shot dead in Background.");
            throw new RuntimeException(e);
        }
    }

    public static void initializeFeats(Context context){
        Handler mainHandler = new Handler(Looper.getMainLooper());
        ExecutorService executorService = Executors.newFixedThreadPool(26);
        executorService.execute(new Runnable(){@Override public void run(){parseFeats(context, "feats", "A");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeats(context, "feats", "B");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeats(context, "feats", "C");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeats(context, "feats", "D");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeats(context, "feats", "E");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeats(context, "feats", "F");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeats(context, "feats", "G");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeats(context, "feats", "H");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeats(context, "feats", "I");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeats(context, "feats", "J");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeats(context, "feats", "K");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeats(context, "feats", "L");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeats(context, "feats", "M");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeats(context, "feats", "N");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeats(context, "feats", "O");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeats(context, "feats", "P");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeats(context, "feats", "Q");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeats(context, "feats", "R");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeats(context, "feats", "S");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeats(context, "feats", "T");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeats(context, "feats", "U");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeats(context, "feats", "V");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeats(context, "feats", "W");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeats(context, "feats", "X");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeats(context, "feats", "Y");}});
        executorService.execute(new Runnable(){@Override public void run(){parseFeats(context, "feats", "Z");}});
    }
}