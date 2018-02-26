import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.*;

public class GUI extends JFrame {



    public GUI(){

        JFrame window = new JFrame("test");

        JPanel panel = new JPanel();

        window.setSize(400,300);
        window.setLocation(200,200);




        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append("----------\n");
        }


        
        JLabel label = new JLabel(sb.toString());

        panel.add(label);
        window.add(panel);

//        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
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
