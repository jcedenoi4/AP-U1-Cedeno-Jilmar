import java.io.*;
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

                    try(Socket cliente = servidor.accept()){

                        System.out.println("Nueva Conexion: " + cliente.getInetAddress());
                        BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                        PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);

                        String mensaje = entrada.readLine();
                        if (mensaje == null || mensaje.isBlank()){
                            salida.println("Formato_Invalido");
                        }else{
                            String[] partes = mensaje.trim().split("\\s+");
                            if (partes.length != 2){
                                salida.println("Formato_Invalido");
                            }else{
                                System.out.println("Comando: " + partes[0]);
                                System.out.println("Token Recibido: " + partes[1]);


                                if (!"TURNO".equalsIgnoreCase(partes[0])){
                                    salida.println("Comando Invalido");
                                } else if (!token.equals(partes[1])){
                                    salida.println("Token Invalido");
                                }else{
                                    salida.println("Recibido");
                                }
                            }
                        }
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
