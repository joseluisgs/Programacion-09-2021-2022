package es.joseluisgs.dam.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import es.joseluisgs.dam.models.Persona;
import es.joseluisgs.dam.utils.LocalDateAdapter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.List;

public class BackupJSON implements IBackupJSON {
    private static BackupJSON instance;
    private final String APP_PATH = System.getProperty("user.dir");
    private final String DATA_DIR = APP_PATH + File.separator + "data";
    private final String BACKUP_FILE = DATA_DIR + File.separator + "personas.json";

    private BackupJSON() {
        File dataDir = new File(DATA_DIR);
        if (!dataDir.exists()) {
            dataDir.mkdir();
        }
    }


    public static BackupJSON getInstance() {
        if (instance == null) {
            instance = new BackupJSON();
        }
        return instance;
    }


    @Override
    public void backup(List<Persona> personas) throws IOException {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .setPrettyPrinting()
                .create();
        String json = gson.toJson(personas);
        Files.writeString(new File(BACKUP_FILE).toPath(), json);
    }


    @Override
    public List<Persona> restore() throws IOException {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();
        String json = "";
        json = Files.readString(new File(BACKUP_FILE).toPath());
        return gson.fromJson(json, new TypeToken<List<Persona>>() {
        }.getType());
    }
}
