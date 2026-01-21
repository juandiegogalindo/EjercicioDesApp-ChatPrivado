/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package interfaz;

import Controlador.Controlador;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class InterfazApp extends JFrame {

    private PanelDatos pnlDatos;
    private Controlador ctrl;

    public InterfazApp() {
        ctrl = new Controlador(); // Crea el Controlador sin PanelDatos
        pnlDatos = new PanelDatos(ctrl); // Luego crea PanelDatos
        ctrl.setPanelDatos(pnlDatos); // Asigna PanelDatos al Controlador

        pnlDatos.setBounds(40, 10, 600, 600);
        getContentPane().add(pnlDatos);

        getContentPane().setLayout(null);
        this.setTitle("CHAT PRIVADO");
        this.setSize(700, 700);
        this.setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        InterfazApp frmMain = new InterfazApp();
        frmMain.setVisible(true);
    }
}
