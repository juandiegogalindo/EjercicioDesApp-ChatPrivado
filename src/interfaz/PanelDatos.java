/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;

import Controlador.Controlador;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author jdgal
 */
public class PanelDatos extends JPanel {

    private Controlador ctrl;
    private JTextField textFieldMensaje, textFieldIP, textFieldNick;
    private JButton botonEnviar, botonConectar;
    private JLabel labelMensaje, labelNick, labelIP;
    private JTextArea textArea;

    public PanelDatos(Controlador ctrl) {
        this.ctrl = ctrl;
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK), BorderFactory.createTitledBorder("CHAT")));
        setLayout(null);

        String ipDestino = ctrl.getIpDestino();
        String nickUsuario = ctrl.getNick();

        // IP
        labelIP = new JLabel("Ingresa la IP: ");
        labelIP.setBounds(50, 10, 150, 50);
        add(labelIP);
        textFieldIP = new JTextField(ipDestino);
        textFieldIP.setBounds(130, 25, 120, 20);
        add(textFieldIP);
        // NICK
        labelNick = new JLabel("NICK: ");
        labelNick.setBounds(280, 10, 150, 50);
        add(labelNick);
        textFieldNick = new JTextField(20);
        textFieldNick.setBounds(315, 25, 120, 20);
        add(textFieldNick);
        // Boton concetar IP
        botonConectar = new JButton("Conectar");
        botonConectar.setBounds(462, 25, 86, 20);
        botonConectar.addActionListener(e -> conectar());
        add(botonConectar);
        // Chat
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(50, 75, 500, 450);
        add(scrollPane);
        // Mensaje
        labelMensaje = new JLabel("Mensaje: ");
        labelMensaje.setBounds(50, 533, 150, 50);
        add(labelMensaje);
        textFieldMensaje = new JTextField(80);
        textFieldMensaje.setBounds(110, 550, 355, 20);
        add(textFieldMensaje);
        // Boton
        botonEnviar = new JButton("Enviar");
        botonEnviar.setBounds(480, 550, 70, 20);
        botonEnviar.setEnabled(false);
        botonEnviar.addActionListener(e -> enviarMensaje());
        add(botonEnviar);
    }

    private void conectar() {
        String ipDestino = textFieldIP.getText().trim();
        String nickUsuario = textFieldNick.getText().trim();
        int puertoDestino = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el puerto del otro cliente:"));
        int puertoLocal = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el puerto en el que escucharás:"));

        if (!ipDestino.isEmpty() && !nickUsuario.isEmpty()) {
            ctrl.configurarConexion(ipDestino, puertoDestino, puertoLocal, nickUsuario);
            botonEnviar.setEnabled(true); // Habilitar el botón de enviar mensajes
            textFieldIP.setEditable(false);
            textFieldNick.setEditable(false);
            botonConectar.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(this, "Debes ingresar IP y Nick antes de conectar.");
        }
    }

    private void enviarMensaje() {
        String msg = textFieldMensaje.getText();
        if (!msg.isEmpty()) {
            ctrl.enviarMensaje(msg);
            textFieldMensaje.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Ingresa un mensaje.");
        }
    }

    public void agregarMensaje(String msg) {
        textArea.append(msg + "\n");
    }
}
