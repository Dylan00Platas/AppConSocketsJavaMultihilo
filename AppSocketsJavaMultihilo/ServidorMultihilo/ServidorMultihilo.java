package ServidorMultihilo;

import java.io.IOException;
import java.net.ServerSocket;

public class ServidorMultihilo{
    public static void main(String[] args) {
        // Establece el puerto a utilizar
        int puerto = 8080;
        int contadorClientes = 0;
        // Crea un socket de servidor
        try(ServerSocket ss = new ServerSocket(puerto)){
            System.out.println("Servidor escuchando en el puerto: " + puerto + "...");
            
           
            while (true) {
                contadorClientes += 1;
              
                HiloHandler cliente = new HiloHandler(ss.accept(), contadorClientes);
                Thread h1 = new Thread(cliente);
                h1.start();
            }
        }catch(IOException ex){
            System.out.println(ex);
        }
    }
}
