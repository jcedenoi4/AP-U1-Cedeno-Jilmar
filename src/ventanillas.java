import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Properties;

public class ventanillas {
    public static void  main(String[] args) {
        Properties config = new Properties();
        try (FileInputStream archivo = new FileInputStream("config.properties")) {
            config.load(archivo);
            String host = config.getProperty("host");
            int puerto = Integer.parseInt(config.getProperty("puerto"));

            try(Socket conexion = new Socket(host, puerto)){
                System.out.println("   Ventanilla  ");
                System.out.println("Conexion Establecida");
                System.out.println("Coordinador: " + host);
                System.out.println("Puerto: " + puerto);
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error de conexion: " + e.getMessage());
        }
    }
}
