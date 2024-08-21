
package college.management.system;

import javax.swing.*;
import java.awt.*;


public class About extends JFrame{
    
    About(){
        setSize(700, 500);
        setLocation(400, 150);
        getContentPane(). setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/about.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(300,20,300,200);
        add(image);
        
        JLabel heading = new JLabel("<html>College<br/>Management System</html>");
        heading.setBounds(10,20,300,130);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(heading);
        
        JLabel name = new JLabel("Developed By:Group 14 SEIT");
        name.setBounds(10,220,550,40);
        name.setFont(new Font("Tahoma", Font.PLAIN , 20));
        add(name);
        
        JLabel rollno = new JLabel("Roll number:11,13,15,60");
        rollno.setBounds(10,280,550,40);
        rollno.setFont(new Font("Tahoma", Font.PLAIN , 20));
        add(rollno);
        
        
        setLayout(null);
        
        setVisible(true);
        
    }
    
    public static void main(String[] args) {
        new About ();
        
    }
    
}
