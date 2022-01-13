package gay.Aurum.smithingupgrades;

import com.google.gson.*;
import com.google.gson.stream.JsonWriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;

/**
 * uhm what the fuck is this config deserializer
 * seriously this is some weird ass shit
 */
public class SmithingConfigs {
    public static final Path CONFIG_FILE = FileSystems.getDefault().getPath("config","ToolSmithing.json");

    private static final Map<String,String> CONFIGKEYS = new HashMap<>();

    private boolean requiresCustomClient;
    SmithingConfigs(){
        this.requiresCustomClient = false;
    }

    SmithingConfigs(boolean requiresCustomClient){
        this.requiresCustomClient = requiresCustomClient;
    }

    public static void init(){
        CONFIGKEYS.put("requiresCustomClient","bool");
    }

    public boolean getRequiresCustomClient(){
        return this.requiresCustomClient;
    }

    public static void save(SmithingConfigs changes){
        JsonObject jsn = serialize(changes);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try(BufferedWriter config = Files.newBufferedWriter(CONFIG_FILE, StandardOpenOption.CREATE);) {
            JsonWriter writer = gson.newJsonWriter(config);
            gson.toJson(jsn,writer);
        } catch (IOException e) {
            SmithingUpgrades.logger(e.toString()+" Error saving config");
        }
    }

    public static SmithingConfigs load(){
        if(!Files.exists(CONFIG_FILE)){
            save(new SmithingConfigs());
            return new SmithingConfigs();
        }
        try {
            BufferedReader config = Files.newBufferedReader(CONFIG_FILE);
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(config);
            SmithingConfigs temp = deserialize(element);
            save(temp);
            return temp;
        } catch (IOException e) {
            SmithingUpgrades.logger(e.toString()+" Error loading config");
            return new SmithingConfigs();
        }
    }

    private static SmithingConfigs deserialize(JsonElement element){
        JsonObject obj = element.getAsJsonObject();
        JsonObject backupObj = serialize(new SmithingConfigs());
        Map<String,JsonElement> json = new HashMap<>();
        Map<String,JsonElement> backup = new HashMap<>();

        Map<String,Boolean> bools = new HashMap<>();
        Map<String,String> strs = new HashMap<>();
        Map<String,Integer> nums = new HashMap<>();
        for (Map.Entry<String,JsonElement> entry:obj.entrySet()) {
            json.put(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String,JsonElement> entry:backupObj.entrySet()) {
            backup.put(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String,String> entry:CONFIGKEYS.entrySet()) {
            JsonElement val;
            val = json.get(entry.getKey());
            if(val == null){
                val = backupObj.get(entry.getKey());
            }

            switch (entry.getValue()){
                case ("bool"):
                    try {
                        bools.put(entry.getKey(),val.getAsBoolean());
                    }catch (ClassCastException e){
                        SmithingUpgrades.logger(e.toString()+" Config entry '"+entry.getKey()+"' expected boolean");
                    }
                    break;
                case ("string"):
                    try {
                        strs.put(entry.getKey(),val.getAsString());
                    }catch (ClassCastException e){
                        SmithingUpgrades.logger(e.toString()+" Config entry '"+entry.getKey()+"' expected string");
                    }
                    break;
                case ("int"):
                    try {
                        nums.put(entry.getKey(),val.getAsInt());
                    }catch (ClassCastException e){
                        SmithingUpgrades.logger(e.toString()+" Config entry '"+entry.getKey()+ "'  expected int");
                    }
                    break;
                default:
            }
        }
        return new SmithingConfigs(bools.get("requiresCustomClient")
        );
    }

    private static JsonObject serialize(SmithingConfigs fig){
        JsonObject obj = new JsonObject();
        obj.addProperty("requiresCustomClient", fig.requiresCustomClient);
        return obj;
    }
}
