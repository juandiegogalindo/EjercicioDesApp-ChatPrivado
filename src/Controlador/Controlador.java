/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import interfaz.PanelDatos;
import mundo.HelloSocket;

public class Controlador {

    private HelloSocket helloSocket;
    private PanelDatos pnlDatos;
    private String nick;
    private String ipDestino;
    private int puertoDestino;
    private int puertoLocal;

    public Controlador(PanelDatos pnlDatos) {
        this.pnlDatos = pnlDatos;
    }

    public Controlador() {
    }

    public void configurarConexion(String ipDestino, int puertoDestino, int puertoLocal, String nick) {
        this.ipDestino = ipDestino;
        this.puertoDestino = puertoDestino;
        this.puertoLocal = puertoLocal;
        this.nick = nick;

        helloSocket = new HelloSocket(ipDestino, puertoDestino, puertoLocal, this);
    }

    public void enviarMensaje(String msg) {
        if (helloSocket != null) {
            String mensajeCompleto = nick + ": " + msg;
            helloSocket.enviarMensaje(mensajeCompleto);
            pnlDatos.agregarMensaje("Yo: " + msg);
        }
    }

    public void manejarMensajeRecibido(String msg) {
        pnlDatos.agregarMensaje(msg);
    }

    public String getNick() {
        return nick;
    }

    public String getIpDestino() {
        return ipDestino;
    }

    public void setPanelDatos(PanelDatos pnlDatos) {
        this.pnlDatos = pnlDatos;
    }
}
