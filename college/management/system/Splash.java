

package college.management.system;
import javax.swing.*;
import java.awt.*;


public class Splash extends JFrame implements Runnable{
    Thread t;
    Splash(){
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/famt202.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        setVisible(true);
        int x=1;
        for(int i=2;i<=600;i+=4,x+=1){
            
      t = new Thread(this);
      t.start();
        setLocation(300,50);
        setSize(700,500);
        try{
            Thread.sleep(10);
        }catch (Exception e){}
       break;
        }
                            
    }
    public void run(){
        try{
            Thread.sleep(7000);
            setVisible(false);
         
            new Login();
            
          
        }catch (Exception e){}
    }
    
     public static void main(String[] args){
         new Splash();
         
         
     }
}
