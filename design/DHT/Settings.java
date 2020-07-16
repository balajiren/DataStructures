package DHT;

public class Settings {
    private final static Settings instance = new Settings();
    public final String Version;
    public final String Prefix;
    public final int Modulo;

    public static Settings getInstance() {
        return instance;
    }

    private Settings() {
        Version = "SDHT_1.0";
        Prefix = "SDHT|";
        Modulo = 16;
    }
}