package domino.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.Border;

public class Testeo extends JFrame implements ActionListener {

    private JMenuBar menuBar;
    private JMenu menuConfiguracio, subMenuJugadors;
    private JMenuItem menuItemEstablirDosJugador, menuItemEstablirTresJugadors,
            menuItemEstablirQuatreJugadors, menuItemCanviarColor;
    private JLabel labelJugador1, labelJugador2, labelJugador3, labelJugador4, labelAux;
    private JButton x1, x2, x3, x4, x5, x6, x7, x8, x9;
    private JPanel panelTablero, panelFichasJ1, panelFichasJ2, panelFichasJ3, panelFichasJ4;
    private Border borde;

    public Testeo() throws HeadlessException {
        configuracio();
        this.pack();
        this.setVisible(true);
    }

    public void configuracio() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(300, 70);
        this.setPreferredSize(new Dimension(1000, 700));
        
        //Listener para seleccionar jugadores
        menuItemEstablirDosJugador = new JMenuItem("2 Jugadors");
        menuItemEstablirDosJugador.addActionListener(this);

        menuItemEstablirTresJugadors = new JMenuItem("3 Jugadors");
        menuItemEstablirTresJugadors.addActionListener(this);

        menuItemEstablirQuatreJugadors = new JMenuItem("4 Jugadors");
        menuItemEstablirQuatreJugadors.addActionListener(this);

        menuConfiguracio = new JMenu("Configuracio");
        subMenuJugadors = new JMenu("Nombre de jugadors");

        menuConfiguracio.add(subMenuJugadors);
        subMenuJugadors.add(menuItemEstablirDosJugador);
        subMenuJugadors.add(menuItemEstablirTresJugadors);
        subMenuJugadors.add(menuItemEstablirQuatreJugadors);

        menuBar = new JMenuBar();
        menuBar.add(menuConfiguracio);        
        this.getContentPane().setLayout(new BorderLayout());
        
        //Declaracion de los paneles
        panelFichasJ1 = new JPanel();
        panelFichasJ2 = new JPanel();
        panelFichasJ3 = new JPanel();
        panelFichasJ4 = new JPanel();
        panelTablero = new JPanel();
        
        //Ordenacion de los paneles en norte, sur, este, oeste y centro
        this.getContentPane().add(this.panelFichasJ1, BorderLayout.SOUTH);
        this.getContentPane().add(this.panelFichasJ2, BorderLayout.WEST);
        this.getContentPane().add(this.panelFichasJ3, BorderLayout.NORTH);
        this.getContentPane().add(this.panelFichasJ4, BorderLayout.EAST);
        this.getContentPane().add(this.panelTablero, BorderLayout.CENTER);
        
        //Redimension de los paneles para ajustarlos al tamaño deseado
        panelFichasJ1.setPreferredSize(new Dimension(150,80));
        panelFichasJ2.setPreferredSize(new Dimension(80,150));
        panelFichasJ3.setPreferredSize(new Dimension(150,80));
        panelFichasJ4.setPreferredSize(new Dimension(80,150));
        
        //Declaracion de los bordes de cada uno de nuestros paneles
        borde = BorderFactory.createLineBorder(Color.black);        
        panelFichasJ1.setBorder(borde);
        panelFichasJ2.setBorder(borde);
        panelFichasJ3.setBorder(borde);
        panelFichasJ4.setBorder(borde);
        panelTablero.setBorder(borde);
           
        this.setJMenuBar(menuBar);
    }
    
    //Panels donde iran la fichas con sus respectivos BoxLayout
    public void construccionPanelNorth(){
        panelFichasJ1 = new JPanel();
        x1=new JButton();
        ImageIcon img1 = new ImageIcon("00.png");
        x1.setIcon(img1);
        add(x1);
        panelFichasJ1.setLayout(new BoxLayout(panelFichasJ1, BoxLayout.X_AXIS));
        add(panelFichasJ1, BorderLayout.NORTH);
    }
    
    public void construccionPanelEast(){
        panelFichasJ2 = new JPanel();
        panelFichasJ2.setLayout(new BoxLayout(panelFichasJ2, BoxLayout.Y_AXIS));
        add(panelFichasJ2, BorderLayout.EAST);
    }
    
    public void construccionPanelSouth(){
        panelFichasJ3 = new JPanel();
        panelFichasJ3.setLayout(new BoxLayout(panelFichasJ3, BoxLayout.X_AXIS));
        add(panelFichasJ3, BorderLayout.SOUTH);
    }
    
    public void construccionPanelWest(){
        panelFichasJ4 = new JPanel();
        panelFichasJ4.setLayout(new BoxLayout(panelFichasJ4, BoxLayout.Y_AXIS));
        add(panelFichasJ4, BorderLayout.WEST);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        
        switch (action) {
            case "2 Jugadors":
                trabajandoEnEllo();
                break;
            case "3 Jugadors":
                trabajandoEnEllo();
                break;
            case "4 Jugadors":
                introducirNombres();
                break;
            case "Canviar color":
                break;
        }
    }

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //new GridLayoutExemple();
                new Testeo();
            }
        });
    }
    /*
    public void carregarImatge() {
        JFileChooser fc = new JFileChooser();
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            ImageIcon imagen;
            try {
                imagen = new ImageIcon(fc.getSelectedFile().getCanonicalPath());
                imagen = new ImageIcon(imagen.getImage().getScaledInstance(-1, -1, Image.SCALE_AREA_AVERAGING));
                labelImatge.setIcon(imagen);
            } catch (IOException ex) {
                Logger.getLogger(ExempleMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }*/
    
    public String introducirNombres(){
        String nom = JOptionPane.showInputDialog(null, "Introdueix el nom del jugador", "Nom Jugador", 1);
        return nom;
    }
    
    public void trabajandoEnEllo(){
        JOptionPane.showMessageDialog(null, "Trabajando en ello. Intenta con 4 jugadores");
    }
}
