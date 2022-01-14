package gay.Aurum.smithingupgrades;

import com.google.gson.*;
import com.google.gson.stream.JsonWriter;
import net.minecraft.util.JsonHelper;

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

    private boolean requiresCustomClient;
    SmithingConfigs(){
        this.requiresCustomClient = false;
    }

    SmithingConfigs(boolean requiresCustomClient){
        this.requiresCustomClient = requiresCustomClient;
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
        
        return new SmithingConfigs(JsonHelper.getBoolean(obj,"isItem",false) );
    }

    private static JsonObject serialize(SmithingConfigs fig){
        JsonObject obj = new JsonObject();
        obj.addProperty("requiresCustomClient", fig.requiresCustomClient);
        return obj;
    }
}
