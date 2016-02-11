/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaexamen;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javafx.scene.layout.Border;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Carlos
 */
public class Informacion extends JFrame implements ActionListener{

    JCheckBox videoJuegos, musica, ejercicio, leer, cocinar, cine, otros;
    JLabel nombre, edad, direccion, telefono, pais, pasatiempos, estadoC;
    JTextField nom, ed, dir, tele, otro;
    JButton enviar, cerrar;
    JComboBox p, es;
    String texto, texto2;
    //agregando nueva variable
    String prueba;

    public Informacion(){
        super("Información Personal");
        setSize(375,300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        Container cont = getContentPane();
        cont.setLayout(new FlowLayout());
        JPanel panel1 = new JPanel(new GridLayout(5,1,0,5));
        JPanel panel2 = new JPanel(new GridLayout(5,1));
        JPanel panelCheck = new JPanel(new GridLayout(3, 3));
        JPanel panelBotones = new JPanel(new FlowLayout());
        
        otro = new JTextField(10);
        otro.setVisible(false);
        
        //limitar tamaño
//        nombre = new JLabel("Nombre   ");
//        nom = new JTextField(10);
//        nom.addKeyListener(new KeyAdapter(){
//            public void keyTyped(KeyEvent e){
//                if (nom.getText().length()== 5)
//                    e.consume();
//        }
//        });
              
        nombre = new JLabel("Nombre   ");
        nom = new JTextField(10);
        nom.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if(!(Character.isLetter(c))) {
                        getToolkit().beep();
                        e.consume();
                    }
                }
            });
        panel1.add(nombre);
        panel1.add(nom);
        
        edad = new JLabel("Edad     ");
        ed = new JTextField(10);
        ed.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if(!(Character.isDigit(c))){
                        getToolkit().beep();
                        e.consume();
                    }
                }
            });
        panel1.add(edad);
        panel1.add(ed);
        
        direccion = new JLabel("Dirección");
        dir = new JTextField(10);
        panel1.add(direccion);
        panel1.add(dir);
        
        telefono = new JLabel("Teléfono ");
        tele = new JTextField(10);
        tele.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if(!(Character.isDigit(c))) {
                        getToolkit().beep();
                        e.consume();
                    }
                }
            });
        panel1.add(telefono);
        panel1.add(tele);
        
        estadoC = new JLabel("Est Civil");
        String vect2 [] = {" ","Soltero", "Casado", "Viudo", "Divorciado"};
        es = new JComboBox(vect2);
        panel1.add(estadoC);
        panel1.add(es);
        
        String vect [] = {" ", "Costa Rica", "Honduras", "El Salvador", "Guatemala", "Nicaragua"};
        p = new JComboBox(vect);
        pais = new JLabel("Pais");
        panel2.add(pais);
        panel2.add(p);
                
        pasatiempos = new JLabel("Pasatiempo");
        videoJuegos = new JCheckBox("Video Juegos");
        musica = new JCheckBox("Música");
        ejercicio = new JCheckBox("Ejercicio");
        leer = new JCheckBox("Leer");
        cocinar = new JCheckBox("Cocinar");
        cine = new JCheckBox("Cine");
        otros = new JCheckBox("Otros");
        panelCheck.add(pasatiempos);
        panelCheck.add(videoJuegos);
        panelCheck.add(musica);
        panelCheck.add(ejercicio);
        panelCheck.add(leer);
        panelCheck.add(cocinar);
        panelCheck.add(cine);
        panelCheck.add(otros);
        panelCheck.add(otro);
        otros.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
             if(otros.isSelected())
                otro.setVisible(true);
             else
                otro.setVisible(false);
            }
        });
        

        
        enviar = new JButton("Enviar");
        cerrar = new JButton("Cerrar");
        panelBotones.add(enviar);
        panelBotones.add(cerrar);
        enviar.addActionListener(this);
        cerrar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                       PracticaExamen n = new PracticaExamen();
                       n.setVisible(true);
                       setVisible(false);
                }
        });
        
        cont.add(panel1, new BorderLayout().WEST);
        cont.add(panel2, new BorderLayout().EAST);
        cont.add(panelCheck);
        cont.add(panelBotones);
        paintComponents(getGraphics());
    }
   
    public String pasatiempo(){
        String pasa = "";
        if(videoJuegos.isSelected()){
            if(pasa.length()!=0)
               pasa += ", "+"Video Juegos";
            else               
                pasa = "Video Juegos";
        }
        if(musica.isSelected()){
            if(pasa.length()!=0)
                pasa += ", "+"Música";
            else
                pasa = "Música";
        }
        if(ejercicio.isSelected()){
            if(pasa.length()!=0)
                pasa += ", "+"Ejercicio";
            else 
                pasa = "Ejercicio";
        }
        if(cocinar.isSelected()){
            if(pasa.length()!=0)
                pasa += ", "+"Cocinar";
            else
                pasa = "Cocinar";
        }
        if(cine.isSelected()){
            if(pasa.length()!=0)
                pasa += ", "+"Cine";
            else 
                pasa = "Cine";
        }
        if(leer.isSelected()){
            if(pasa.length()!=0)
                pasa += ", "+"Leer";
            else
                pasa = "Leer";
        }
        if(otros.isSelected()){
            if(pasa.length()!=0)
                pasa += ", "+otro.getText();
            else
                pasa = otro.getText();
        }
        return pasa;
    }
     
    public void numeros(JTextField x){
        x.addKeyListener(new KeyAdapter(){
            public void KeyTyped(KeyEvent e){
                char c=e.getKeyChar();
                if(Character.isDigit(c)){
                    getToolkit().beep();
                    e.consume();
                }
            }
        });
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        texto2 = "Hay espacios en blanco";
        if((nom.getText().length()==0)||(ed.getText().length()==0)||(dir.getText().length()==0)||(tele.getText().length()==0)
                || (es.getSelectedItem().equals(" ")) || (p.getSelectedItem().equals(" ")))
            JOptionPane.showMessageDialog(null, texto2, "Error", JOptionPane.ERROR_MESSAGE);
        else{
        texto = "Nombre: "+ nom.getText()+ "\n"+
                "Edad: "+ ed.getText()+ "\n"+
                "Dirección: "+ dir.getText()+"\n"+
                "Teléfono: "+ tele.getText()+"\n"+
                "Estado Civil: "+ es.getSelectedItem()+"\n"+
                "Pais: "+ p.getSelectedItem()+ "\n"+
                "Pasatiempo: "+ this.pasatiempo();
        JOptionPane.showMessageDialog(null,texto,"Información", JOptionPane.INFORMATION_MESSAGE);
    }
 } 
}