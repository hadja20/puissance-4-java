package swing;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main extends JFrame {


    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawOval(150, 150, 100, 100);
    }



    public static void main(String[] args){

        JFrame f = new JFrame("Puissance 4");
        f.setSize(700,400);
        JPanel pannel = new JPanel();
        JLabel jLabel1 =new JLabel("Mon texte dans JLabel");

        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        pannel.add(jLabel1);

        ImageIcon icone = new ImageIcon("book.gif");
        JLabel jLabel2 =new JLabel(icone);
        pannel.add(jLabel2);



        JLabel jLabel3 =new JLabel("Mon texte",icone,SwingConstants.LEFT);
        pannel.add(jLabel3);


        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f.setLocation(dim.width/2 - f.getWidth()/2, dim.height/2 - f.getHeight()/2);
        f.getContentPane().add(pannel);
        f.setVisible(true);

        new Main();



    }
}
