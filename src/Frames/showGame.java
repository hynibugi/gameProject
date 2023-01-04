package Frames;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import gameObject.Jelly;
import gameObject.Obstacle;

public class showGame extends JFrame {

   ClassLoader classLoader = getClass().getClassLoader();
   Toolkit kit = Toolkit.getDefaultToolkit();
   Image imC = kit.getImage(classLoader.getResource("original.png"));
   Image imbg = kit.getImage(classLoader.getResource("background.png"));
   Image jelly = kit.getImage(classLoader.getResource("jelly.png"));
   
   int whereX;
   int whereY;
   private JPanel contentPane;
   private JLabel characterIng;
   private Timer timer; // 배경 타이머
   private Timer timerJ; // 젤리 타이머
   private int x;
   
   private Jelly jellyS;
private int frameX;
   
   public int getWhereX() {
      return whereX;
   }
   public void setWhereX(int whereX) {
      this.whereX = whereX;
   }
   public int getWhereY() {
      return whereY;
   }
   public void setWhereY(int whereY) {
      this.whereY = whereY;
   }
   
   public showGame()  {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 701, 437);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      Obstacle ob = new Obstacle(100, 200, 100, 100);
      ob.setBounds(ob.getX(), ob.getY(), 100, 100);
      
      JLabel bgIng = new JLabel(""); //배경 
      bgIng.setIcon(new ImageIcon(imbg));
      bgIng.setBounds(0, 0, 100000, 400);
      x = 0;
      timer = new Timer(16, new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            x -= 10; 
            if (x <= -15700) {
               timer.stop();
               x = 0;
            } else {
               bgIng.setLocation(x, 0);
            }
         }
      });
      timer.start();
      
      
      jellyS = new Jelly(700, 300, jelly);
      JLabel jIng = new JLabel("");
      jIng.setIcon(new ImageIcon(jellyS.getImJelly()));
      jIng.setBounds(jellyS.getJellyX(), jellyS.getJellyY(), 50, 50);

      frameX = 670;
      timerJ = new Timer(1000, new ActionListener() {
    	  @Override
          public void actionPerformed(ActionEvent e) {
    		  frameX -= 10; 
             if (frameX <= -5000) {
            	 timerJ.stop();
            	 frameX = 0;
             } else {
            	 jIng.setLocation(frameX, 300);

             }
          }
       });
      timerJ.start();
      
      characterIng = new JLabel(""); //게임중인 캐릭터
      whereX = 50;
      whereY = 260;
      characterIng.setFocusable(true);
      characterIng.setBounds(whereX, whereY, 100, 100);
      characterIng.addKeyListener(new KeyListener() {         
         private int count = 0;
         @Override
         public void keyTyped(KeyEvent e) {
         }      
         @Override
         public void keyReleased(KeyEvent e) {      
         }
         @Override
         public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_UP) {
               whereY = 220;
               characterIng.setBounds(whereX, whereY, 100, 100);
               count ++;
               if(count == 1) {                  
                  System.out.println("1단점프");
                  System.out.println("(x, y) = " + getWhereX() + ", " + getWhereY());
               }
            
               if (count == 2) {
                  System.out.println("2단점프");
                  whereY = 180;
                  characterIng.setBounds(whereX, whereY, 100, 100);
                  System.out.println("(x, y) = " + getWhereX() + ", " + getWhereY());
                  count --;
               }
            } 
            if (key == KeyEvent.VK_DOWN) {
               System.out.println("슬라이드");
               count = 0;
               whereY = 280;
               characterIng.setBounds(whereX, whereY, 100, 100);
               System.out.println("(x, y) = " + getWhereX() + ", " + getWhereY());
            }
         }
      });
      characterIng.setIcon(new ImageIcon(imC));
      contentPane.add(jIng);
      contentPane.add(ob);
      contentPane.add(characterIng);
      contentPane.add(bgIng);
   }
}