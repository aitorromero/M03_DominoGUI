package domino.vista;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class InterficieGrafica extends JFrame implements ActionListener {

    private JMenuBar menuBar;
    private JMenu menuConfiguracio, subMenuJugadors;
    private JMenuItem menuItemEstablirDosJugador, menuItemEstablirTresJugadors, 
            menuItemEstablirQuatreJugadors, menuItemCanviarColor;
    
    public InterficieGrafica() throws HeadlessException{
        configuracio();
        this.pack();
        this.setVisible(true);
    }
    
    public void configuracio(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(300, 70);
        this.setPreferredSize(new Dimension(1000, 700));
        
        menuItemEstablirDosJugador = new JMenuItem("2 Jugadors");
        menuItemEstablirDosJugador.addActionListener(this);
        
        menuItemEstablirTresJugadors = new JMenuItem("3 Jugadors");
        menuItemEstablirTresJugadors.addActionListener(this);
        
        menuItemEstablirQuatreJugadors = new JMenuItem("4 Jugadors");
        menuItemEstablirQuatreJugadors.addActionListener(this);
        
        menuItemCanviarColor = new JMenuItem("Canviar color");
        menuItemCanviarColor.addActionListener(this);

        menuConfiguracio = new JMenu("Configuracio");
        subMenuJugadors = new JMenu("Nombre de jugadors");
        menuConfiguracio.add(subMenuJugadors);
        subMenuJugadors.add(menuItemEstablirDosJugador);
        subMenuJugadors.add(menuItemEstablirTresJugadors);
        subMenuJugadors.add(menuItemEstablirQuatreJugadors);
        

        menuBar = new JMenuBar();
        menuBar.add(menuConfiguracio);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
