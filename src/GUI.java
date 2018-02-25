import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.*;

public class GUI extends JFrame {

     JTextField tf;
    public GUI(){
        tf = new JTextField(20);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(tf);
        setVisible(true);
    }



    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI();
            }
        });
    }

}
