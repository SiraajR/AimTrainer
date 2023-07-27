import java.util.*;
import java.util.Timer;


import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.sound.sampled.Line;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;



public class introPage extends JFrame{
    
    JLabel introLabel;
    static final int  panel_width = 1000;
    static final int  panel_height = (int)(panel_width*(0.5));
    static final Dimension screenSize = new Dimension(panel_width, panel_height); 
    JButton halfMin;
    JButton oneMin;
    JButton hardMode;
    ball Ball;
    Random random;
    Timer timer;
    JPanel introPanel;
    scoreBoard board;


    introPage(){
        board = new scoreBoard();
        
        
        
    
        introLabel = new JLabel("Welcome to aim Trainer");
        introLabel.setForeground(Color.white);
        this.setLayout(null);
        this.setSize(panel_width, panel_height);
        introPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Ball.draw(g);
            }
        };
        
        introPanel.setLayout(null);
        introPanel.setOpaque(false);
        introPanel.setBounds(0, 0, panel_width, panel_height);
        this.add(introPanel);
        introLabel.setBounds(200, 100, 600, 100);
        introLabel.setHorizontalAlignment(SwingConstants.CENTER);
        introLabel.setFont(introLabel.getFont().deriveFont(24.0f));
        introPanel.add(introLabel);
        halfMin = new JButton();
        halfMin.setText("30 sec");
        halfMin.setForeground(Color.white);
        halfMin.setBounds(250, 201, 150, 50);
        halfMin.setBorder(new LineBorder(Color.white));
        halfMin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JButton button = (JButton) e.getSource();
                JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(button);
                currentFrame.dispose();
                gameFrame frame = new gameFrame(30, board.getLastRunNumber());
                
               

            }
            
        });

        introPanel.add(halfMin);
        oneMin = new JButton();
        oneMin.setText("1 min");
        oneMin.setBounds(401, 201, 150, 50);
        oneMin.setForeground(Color.white);
        oneMin.setBorder(new LineBorder(Color.white));
        oneMin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                JButton button = (JButton) e.getSource();
                JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(button);
                currentFrame.dispose();
                gameFrame oneMinGame = new gameFrame(60 ,board.getLastRunNumber());
            }
            
        });
        introPanel.add(oneMin);

        hardMode = new JButton();
        hardMode.setText("<html> Hard Mode<br />Under Construction</html>");
        hardMode.setFont(hardMode.getFont().deriveFont(13.0f));
        hardMode.setBounds(552, 201, 150, 50);
        hardMode.setForeground(Color.white);
        hardMode.setBorder(new LineBorder(Color.white));
        hardMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

            }
            
        });
        introPanel.add(hardMode);
        newBall();
        javax.swing.Timer timer = new javax.swing.Timer(5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ball.move();
                checkCollision();
                introPanel.repaint();
            }
        });
        timer.start();
        
        this.getContentPane().setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        this.setLocationRelativeTo(null);
        this.setVisible(true);




    }
    public void newBall() {
		random = new Random();
		Ball = new ball((panel_width/2)-(10),random.nextInt(panel_height-20),20,20);
	}

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Ball.draw(g);
    }

    
    public void checkCollision(){
        if(Ball.y <=0) {
			Ball.setYDirection(-Ball.yVelocity);
		}
		if(Ball.y >= panel_height-35) {
			Ball.setYDirection(-Ball.yVelocity);
		}
        if(Ball.x <=0){
            Ball.setXDirection(-Ball.xVelocity);
        }
        if(Ball.x >= panel_width -20){
            Ball.setXDirection(-Ball.xVelocity);
        }
    }
   


    
}