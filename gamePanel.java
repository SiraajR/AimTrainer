import javax.swing.JButton;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Timer;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.*;
import java.util.Random;
import java.awt.*;




public class gamePanel extends JPanel implements Runnable{ 
    
    Random random; 
    static final int  panel_width = 1000;
    static final int  panel_height = (int)(panel_width*(0.5));
    static final Dimension screenSize = new Dimension(panel_width, panel_height); 
    static final int target_size = 20;
    int time;
    
    
    Thread gameThread;
    JButton currentTarget;
    timerGUI timer;
    JPanel scorePanel;
    int times;
    JLabel scoreLabel;
    

    
    
    public gamePanel(timerGUI timer , int run){
        
        time = timer.counter;
        this.setLayout(null); //this is to set the  layout on which the button would be added.
        this.timer = timer;
        gameThread = new Thread(this);
        gameThread.start(); 
        this.setBackground(Color.black);
        this.setPreferredSize(screenSize); 
        this.setLayout(null);
        this.times = run;
        
        
        
    } 
    @Override
    public void run(){
        //game loop
        random = new Random();
        while (timer.timerRunning == true) {
            if (currentTarget == null) {
                addTarget();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        times++;
        removeTarget();
        showScorePanel();

    }

    public void addTarget(){
        JButton newTarget = new JButton();
        newTarget.setBounds(randomNumber(20, panel_width-20) , randomNumber(target_size, panel_height-target_size),target_size,target_size);
        newTarget.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e ){
                if(timer.timerRunning == true){
                    timer.setScore();
                    removeTarget();
                    addTarget();
                }
                
                
            }
            
        });

        
        currentTarget = newTarget;
        this.add(newTarget);
        this.revalidate();
        this.repaint();
    }

    public void removeTarget(){
        this.remove(currentTarget);
        this.revalidate();
        this.repaint();


    }

    public int randomNumber(int start , int end){
        random = new Random();
        return random.nextInt(end - start + 1 )+start;
    }

    private void showScorePanel() {
        scorePanel = new JPanel();
        scorePanel.setBounds(panel_width / 2 - 125, panel_height / 2 - 75, 250, 200);
        scorePanel.setBackground(Color.BLACK);
        scorePanel.setLayout(null);
        scorePanel.setOpaque(false);
        if(timer.score > time/ 2){
            scoreLabel = new JLabel("<html>Final Score: "+timer.score+"<br />   Good Job <html>");
        }else{
            scoreLabel = new JLabel("Final Score: " + timer.score);

        }

        
        

        scoreLabel.setBounds(25, 5, 200, 50);
        scoreLabel.setFont(scoreLabel.getFont().deriveFont(20.0f));
        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        scoreLabel.setForeground(Color.white);

        
        scorePanel.add(scoreLabel);

        JButton restart = new JButton("Restart");
        restart.setBounds(25, 70 , 100 , 25);
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(gamePanel.this);
                currentFrame.dispose();
                gameFrame frame = new gameFrame(time, times);

            }
        });

        JButton scoreList = new JButton("ScoreList");
        scoreList.setBounds(126 , 70 , 100 , 25);
        scoreList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                scoreBoard board = new scoreBoard();
                board.insertScore(times, timer.score);
                ScoreDisplayFrame dsiplayFrame = new ScoreDisplayFrame();
            }
            
        });

        JButton mainMenu = new JButton("Main Menu");
        mainMenu.setBounds(75, 100, 100, 25);
        mainMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(gamePanel.this);
                currentFrame.dispose();
                
                introPage page = new introPage();
            }
            
        });
        
        




        
        this.add(scorePanel);
        scorePanel.add(restart);
        scorePanel.add(scoreList);
        scorePanel.add(mainMenu);
        this.revalidate();
        this.repaint();


    }

    



}
    



    

    

    


    
