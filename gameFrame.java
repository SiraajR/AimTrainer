import java.awt.Color;
import java.awt.Cursor;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.*;

public class gameFrame extends JFrame{
    gamePanel targetArea;
    timerGUI timer;
    JButton scoreButton;
    int times;
    
    
    gameFrame(int time , int run){
        getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        this.times = run;
        timer = new timerGUI(time);
        timer.switchOn();
        targetArea = new gamePanel(timer , times);
        this.setLayout(new BorderLayout());
        this.add(targetArea , BorderLayout.CENTER);
        
        this.setTitle("Aim trainer");
        this.setResizable(true);
        this.setBackground(Color.black);
        this.add(timer, BorderLayout.NORTH);


        

        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
    }

    

    

}