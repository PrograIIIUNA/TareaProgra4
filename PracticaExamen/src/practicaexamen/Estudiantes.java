package practicaexamen;

import java.awt.BorderLayout;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.control.CheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Carlos
 */
public class Estudiantes extends JFrame implements ActionListener{
        JTextField car, nom, cre, pag;
        JLabel nombre, carnet, creditos, pagar, aIngreso; 
        JButton consultar, cerrar;
        String texto, texto2;
        JComboBox n;
        JRadioButton nacional, extranjero;
        ButtonGroup t;
    
    public Estudiantes(){
        super("Consulta de pago");
        setSize(350,250);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        Container cont = getContentPane();
        cont.setLayout(new FlowLayout());
        JPanel panel1 = new JPanel(new GridLayout(5,1,0,0));
        JPanel panelCheck = new JPanel();
        JPanel panelBoton = new JPanel();
       
        t = new ButtonGroup();
        nacional = new JRadioButton("Nacional");
        extranjero = new JRadioButton("Extranjero");
        t.add(nacional);
        t.add(extranjero);
        panelCheck.add(nacional);
        panelCheck.add(extranjero);
        
        car = new JTextField(8);
        carnet = new JLabel("Carnet");
        panel1.add(carnet);
        panel1.add(car);
        
        nombre = new JLabel("Nombre  ");
        nom = new JTextField(8);
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
        
        creditos = new JLabel("Créditos");
        cre = new JTextField(8);
        cre.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if(!(Character.isDigit(c))){
                        getToolkit().beep();
                        e.consume();
                    }
                }
            });
        panel1.add(creditos);
        panel1.add(cre);
        
        String vect [] = {"2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016"};
        n = new JComboBox(vect);
        aIngreso = new JLabel("Año de ingreso");
        panel1.add(aIngreso);
        panel1.add(n);
        
        pagar = new JLabel("Pagar   ");
        pag = new JTextField(8);
        pag.setEnabled(false);
        panel1.add(pagar);
        panel1.add(pag);
        
        consultar = new JButton("Consultar");
        cerrar = new JButton("Cerrar");
        cerrar.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                       PracticaExamen n = new PracticaExamen();
                       n.setVisible(true);
                       setVisible(false);
                }
        });
        
        panelBoton.add(consultar);
        panelBoton.add(cerrar);

        cont.add(panel1, new BorderLayout().WEST);
        cont.add(panelCheck, new BorderLayout().CENTER);
        cont.add(panelBoton, new BorderLayout().SOUTH);
        consultar.addActionListener(this);

        paintComponents(getGraphics());
    }
    
    public void calcularPago(){
        int recargo = 5000;
        if(Integer.parseInt(cre.getText())>=12){
            pag.setText(Integer.toString(Integer.parseInt(cre.getText())*8000));
            if(n.getSelectedItem().equals("2016"))
                pag.setText(Integer.toString(Integer.parseInt(cre.getText())*8000));
        }
        else
            pag.setText(Integer.toString(Integer.parseInt(cre.getText())*9000));
        if(extranjero.isSelected())
                pag.setText(Integer.toString(Integer.parseInt(cre.getText())*9000+recargo)); 
    }
    
    public String nacionalidad(){
        String es;
        if(nacional.isSelected())
            es = "Nacional";
        else
            es = "Extranjero";
        return es;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        texto2 = "Hay espacios en blanco";
        if((car.getText().length()==0)||(nom.getText().length()==0)||(cre.getText().length()==0)|| (!(nacional.isSelected())&&!(extranjero.isSelected()))){
            JOptionPane.showMessageDialog(this, texto2, "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{ 
            this.calcularPago();
            texto = "Carnet: " +car.getText()+"\n"+
                "Nombre: "+ nom.getText()+"\n"+
                "Creditos: "+ cre.getText()+"\n"+
                "Año de ingreso: "+ n.getSelectedItem()+"\n"+
                "Nacionalidad: "+ this.nacionalidad()+"\n"+
                "Total a pagar: "+ pag.getText();
        JOptionPane.showMessageDialog(null,texto,"Información", JOptionPane.INFORMATION_MESSAGE);
        }         
    }
}