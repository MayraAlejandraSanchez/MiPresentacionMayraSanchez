package miPresentacion;

// Mayra Alejandra Sanchez Salinas cod. 202040506

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class GUI_Presentacion extends JFrame /*Heredo de JFrame para GUI_presentacion*/{
    //Atributos

    private JButton miFoto, miHobby, misExpectativas;
    private JPanel panelBotones,panelDatos, fondo;
    private JLabel labelImagen;
    private Titulos titulo;
    private JTextArea textoExpectativa;
    private Escucha escucha;

    //Metodos

    /*Constructor*/
    public GUI_Presentacion(){
        initGUI();
        //Configuaracion base de la ventana
        this.setTitle("Mi presentación - Mayra Sanchez"); //Titulo
        this.setSize(600,540); //Tamaño
        this.setLocationRelativeTo(null); // Donde se va a ubicar
        this.setVisible(true); //Visible o no visible
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Finalizar la ejecucion del programa
    }

    private void initGUI() {
        //Definir Conteiner y Layout del Jframe
        //Crear objetos escuchar y Control

        escucha =new Escucha();


        //Configurar JComponent

        titulo = new Titulos("Hola Soy Mayra Sánchez, si quieres concer mas\n" +
                " de mi pues oprime los botones", Color.yellow);
        this.add(titulo, BorderLayout.PAGE_START);

        /*Botones*/
        panelDatos = new JPanel ();
        panelDatos.setBorder(BorderFactory.createTitledBorder(null,"Un poco mas de mi...",
                TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION,
                new Font(Font.SERIF, Font.BOLD+Font.PLAIN, 20),
                Color.RED));
        panelDatos.addMouseListener(escucha);
        panelDatos.addMouseListener(escucha);
        panelDatos.addKeyListener(escucha);
        panelDatos.setFocusable(true);

        this.add(panelDatos,BorderLayout.CENTER);

        miFoto = new JButton("Esta soy yo");
        miFoto.addMouseListener(escucha);
        miFoto.setBackground(Color.GREEN);
        miHobby = new JButton("Mis hobbies");
        miHobby.addMouseListener(escucha);
        miHobby.setBackground(Color.yellow);
        misExpectativas = new JButton("Expectativas");
        misExpectativas.addKeyListener(escucha);
        misExpectativas.setBackground(Color.RED);

        //Agrego los botones

        panelBotones = new JPanel();
        panelBotones.add(miFoto);
        panelBotones.add(miHobby);
        panelBotones.add(misExpectativas);

        // A la ventana ...
        this.add(panelBotones, BorderLayout.SOUTH);

        //Imagenes
        labelImagen =new JLabel();
        textoExpectativa = new JTextArea(10,12);
    }
    /*Metodo MAIN*/
    public static void main (String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                /*Crear objeto*/ GUI_Presentacion miGUI_Presentacion = new GUI_Presentacion();

            }
        });
    }

    private class Escucha implements MouseListener, KeyListener{
        private ImageIcon image;

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        public void keyReleased(KeyEvent e) {
            panelDatos.removeAll();
            if (e.getKeyChar() == 'm' ){
                textoExpectativa.append("Me gusta mucho la programación y me siento familiarizada con Java ya que\n" +
                        "el colegio donde sali me gradue por estudiar Java y hacer un proyecto de grado\n" +
                        "con base en Java, mis expectativas para este semestre son altas ya que quiero\n" +
                        "dar todo lo mejor de mi y sobresalir con el conocimiento que yo adquiera,\n" +
                        "tambien aspiero tener muy buena comunicación con mi futuro equipo de trabajo y \n" +
                        "que entre todos demos lo mejor de nosotros mismos para que cada mini proyecto\n" +
                        "sea mucho mejor que el anterior.\n" +
                        "\n" +
                        "Espero que este semestre sea mucho mejor mejor que el anterior, esa es mi\n" +
                        "mayor expectativa.");
                textoExpectativa.setBackground(Color.CYAN);
                textoExpectativa.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 12));
                panelDatos.add(textoExpectativa);
            }
            revalidate();
            repaint();
        }

        @Override
          public void mouseClicked(MouseEvent e) {
            panelDatos.removeAll();
            if (e.getSource()==miFoto & e.getClickCount()==1){
                image = new ImageIcon(getClass().getResource("/recursos/miFoto_opt.jpg"));
                labelImagen.setIcon(image);
                panelDatos.add(labelImagen);
            }else{
                if (e.getSource()==miHobby & e.getClickCount()==2){
                    image = new ImageIcon(getClass().getResource("/recursos/miH_opt.jpg"));
                    labelImagen.setIcon(image);
                    panelDatos.add(labelImagen);
                }
            }
            revalidate();
            repaint();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        public void mouseReleased(MouseEvent e) {
           
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
