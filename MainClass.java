import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MainClass{



    public static void main(String[] args) {
        
        System.out.println("Running");
        JFrame frame = new JFrame("Chess");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        
        GameRunner chess = new GameRunner();
        frame.add(chess);
        frame.setVisible(true);
    }

}