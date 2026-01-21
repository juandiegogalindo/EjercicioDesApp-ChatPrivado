package mundo;

import Controlador.Controlador;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

public class HelloSocket implements Runnable {
    private String ipClienteDestino;
    private int puertoClienteDestino;
    private int puertoLocal;
    private Controlador controlador;

    public HelloSocket(String ipClienteDestino, int puertoClienteDestino, int puertoLocal, Controlador controlador) {
        this.ipClienteDestino = ipClienteDestino;
        this.puertoClienteDestino = puertoClienteDestino;
        this.puertoLocal = puertoLocal;
        this.controlador = controlador;

        new Thread(this).start(); // Iniciar servidor en un hilo aparte
    }

    public void enviarMensaje(String msg) {
        try (Socket client = new Socket(ipClienteDestino, puertoClienteDestino);
             DataOutputStream outBuffer = new DataOutputStream(client.getOutputStream())) {
            outBuffer.writeUTF(msg);
            outBuffer.flush();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al enviar mensaje: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(puertoLocal)) {
            System.out.println("Escuchando en el puerto " + puertoLocal);

            while (true) {
                try (Socket socket = serverSocket.accept();
                     DataInputStream inDataBuffer = new DataInputStream(socket.getInputStream())) {

                    String msg = inDataBuffer.readUTF();
                    controlador.manejarMensajeRecibido(msg);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al escuchar mensajes: " + e.getMessage());
        }
    }
}