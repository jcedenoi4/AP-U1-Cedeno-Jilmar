import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

public class coordinador {
    public static void  main(String[] args){
        Properties config = new Properties();
        try (FileInputStream archivo = new FileInputStream("config.properties")){
            config.load(archivo);
            int cupo = Integer.parseInt(config.getProperty("cupo"));
            String token = config.getProperty("token");
            String host = config.getProperty("host");
            int puerto = Integer.parseInt(config.getProperty("puerto"));

            System.out.println("   Turno  ");
            System.out.println("Token: " + token);
            System.out.println("Host: " + host);
            System.out.println("Cupo: " + cupo);
            System.out.println("Puerto: " + puerto);

            try(ServerSocket servidor = new ServerSocket(puerto)){
                System.out.println("Esperando Conexion");
                while (true){
                    Socket cliente = servidor.accept();
                    System.out.println("Nueva Conexion: " + cliente.getInetAddress());
                    cliente.close();

                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
