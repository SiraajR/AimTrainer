
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.*;

import java.awt.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.BreakIterator;
import java.awt.BorderLayout;

public class timerGUI extends JPanel{
    private JLabel timerLabel;
    private Timer timer;
    int counter;
    
    JLabel scoreLabel;
    public int score = 0;
    boolean timerRunning = true;
    JPanel resultPanel;

    JButton addHighest;
    JButton restartButton;
    
    public timerGUI(int helper){
        this.setLayout(new BorderLayout());
        this.setBackground(Color.black);
        counter = helper;
        timerLabel = new JLabel("00:"+String.valueOf(counter));

        scoreLabel = new JLabel("SCORE: "+ score);
        timerLabel.setForeground(Color.white);
        scoreLabel.setForeground(Color.white);
        
        timerLabel.setFont(timerLabel.getFont().deriveFont(20.0f));
        timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scoreLabel.setFont(scoreLabel.getFont().deriveFont(20.0f));
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        add(timerLabel , BorderLayout.CENTER);
        add(scoreLabel, BorderLayout.WEST);
        
        timer = new Timer(1000, e -> {
            
            counter--;
            timerLabel.setText("00:"+String.valueOf(counter));
            if (counter == 0) {
                timerLabel.setText("00:0"+String.valueOf(counter));
                timerRunning = false;
                
                timer.stop();
                

                
                
                
                
                
            }else if (counter <10){
                timerLabel.setText("00:0"+String.valueOf(counter));
            }
              
        });
    }

    public void switchOn(){
        timer.start();
    }

    public void setScore(){
        this.score++;
        scoreLabel.setText("SCORE: "+ this.score);
    }


    

    

    

   

}

    






