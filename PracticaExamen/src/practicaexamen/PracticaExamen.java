/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaexamen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Carlos
 */
public class PracticaExamen extends JFrame implements ActionListener{
    
    JLabel imagen, practica, estudiante;
    JButton cobro, informacion;
    
    PracticaExamen(){
        super("Bienvenido");
        setSize(280,260);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container cont = getContentPane();
        cont.setLayout(new FlowLayout());
        JPanel panel1 = new JPanel(new FlowLayout());
        JPanel panelBotones = new JPanel(new FlowLayout());
        JPanel panelImagen = new JPanel(new FlowLayout());
        
        estudiante = new JLabel("Estudiante: Carlos Bonilla Robles");
        practica = new JLabel("Práctica para examen 1");
        
        panel1.add(estudiante);
        Icon ico1 = new ImageIcon("LogoUna.gif");
        imagen = new JLabel(ico1);
        imagen.setToolTipText("Universidad Nacional de Costa Rica");
        panelImagen.add(imagen);
        
        cobro = new JButton("Cobro");
        informacion = new JButton("Información Personal");
        cobro.setToolTipText("Abrir pantalla de cobro");
        informacion.setToolTipText("Editar información personal");
        panelBotones.add(cobro);
        panelBotones.add(informacion);
        
        cobro.setActionCommand("Cobro");
        informacion.setActionCommand("Informacion");
        
        cobro.addActionListener(this);
        informacion.addActionListener(this);

        cont.add(panel1, new BorderLayout().CENTER);
        cont.add(panelImagen, new BorderLayout().CENTER);
        cont.add(panelBotones, new BorderLayout().CENTER);
        
        paintComponents(getGraphics());
    }
    
    
    public static void main(String[] args) {
        PracticaExamen e = new PracticaExamen();
     }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Cobro")){
            Estudiantes n = new Estudiantes();
            n.setLocationRelativeTo(null);
            n.setVisible(true);
            setVisible(false);
            n=null;
        }
        else if(e.getActionCommand().equals("Informacion")){
            Informacion i = new Informacion();
            i.setLocationRelativeTo(null);
            i.setVisible(true);
            setVisible(false);
            i=null;
        }
    }
}
