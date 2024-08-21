/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package college.management.system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class payment extends JFrame implements ActionListener{
    
    
    JTextField cvv,No,Name;
    JLabel payment,wallet; 
    JButton b,   cancel;
     Long random;
    
      payment(){
        
            
            
            JPanel p1 = new JPanel();
                p1.setBounds(250,30,900,650);
                p1.setBackground(new Color(204,204,204));
                p1.setLayout(null);
                add(p1); 
                
                setLayout(null);
                
               
                  Random ran = new Random();
         random = Math.abs((ran.nextLong()%90L)+100000000L);
                
                
           payment = new JLabel("Payment method ");
        payment.setFont(new Font("Raleway", Font.BOLD,38));
        payment.setBounds(300,20,600,41);
        p1.add(payment);
        
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/paypal3.png"));
                JLabel Image1 = new JLabel(i1);
         Image1.setBounds(100,100,190,100);
             
               p1.add(Image1); 
               
               ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("icons/gpay2.png"));
                JLabel Image2 = new JLabel(i2);
         Image2.setBounds(100,200,190,100);
         p1.add(Image2); 
         
         ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icons/wallet2.png"));
                JLabel Image3 = new JLabel(i3);
         Image3.setBounds(300,100,190,100);
         p1.add(Image3); 
         
           wallet = new JLabel("Net Banking ");
        wallet.setFont(new Font("Raleway", Font.BOLD,30));
        wallet.setBounds(450,100,190,100);
        p1.add(wallet);
         
          ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/creditcard2.png"));
                JLabel Image4 = new JLabel(i4);
         Image4.setBounds(300,200,190,100);
         p1.add(Image4); 
         
           JLabel  Ccard = new JLabel("Credit / Debit card");
        Ccard.setFont(new Font("Raleway", Font.BOLD,30));
        Ccard.setBounds(450,200,290,100);
        p1.add(Ccard);
       
         JLabel  Card = new JLabel("Credit / Debit card Details ");
        Card.setFont(new Font("Raleway", Font.BOLD,38));
        Card.setBounds(250,350,600,41);
        p1.add(Card);
        
         JLabel  Cardno = new JLabel("Credit Number");
        Cardno.setFont(new Font("Raleway", Font.BOLD,31));
        Cardno.setBounds(100,420,600,40);
        p1.add(Cardno);
        
              No= new JTextField();
        No.setFont(new Font("Raleway", Font.BOLD,22));
        No.setBounds(100,470,300,40);
        p1.add(No);
        
         
        
        
         JLabel  Cardna = new JLabel("Name of the card");
        Cardna.setFont(new Font("Raleway", Font.BOLD,31));
        Cardna.setBounds(500,420,600,40);
        p1.add(Cardna);
        
         Name= new JTextField();
        Name.setFont(new Font("Raleway", Font.BOLD,22));
        Name.setBounds(500,470,300,40);
        p1.add(Name);
        
        JLabel  Cvv = new JLabel("Cvv");
        Cvv.setFont(new Font("Raleway", Font.BOLD,31));
        Cvv.setBounds(100,520,600,40);
        p1.add(Cvv);
        
         cvv= new JTextField();
        cvv.setFont(new Font("Raleway", Font.BOLD,22));
        cvv.setBounds(100,570,300,40);
        p1.add(cvv);
        
        
                    b=new JButton("Pay Now");
             b.setBounds(500, 570, 300, 40);
             b.addActionListener(this);
             p1.add(b);
           
        
      
       
                
                
       //setSize(1920,1080);
        this.setExtendedState(MAXIMIZED_BOTH);
        setLocation(-10,0);
        setVisible(true);
        }
        
        @Override
        public void actionPerformed(ActionEvent ae) {
        
        String cnumber = No.getText();
        String CV = cvv.getText();
        String name = Name.getText();
        String r=Long.toString(random);
        
        try{
            
            
        if(ae.getSource()==b){
            
            
         if(cnumber.equals("")){
             JOptionPane.showMessageDialog(null, "Credit card number cannot be empty");
             return;
         }
         
         if(CV.equals("")){
             JOptionPane.showMessageDialog(null, "CVV cannot be empty");
             return;
         }
         if(name.equals("")){
             JOptionPane.showMessageDialog(null, "Enter Name of the card");
             return;
         }
         if(CV.length()!=4){
              JOptionPane.showMessageDialog(null, "Invalid CVV");
            
         } else{
         
             boolean isDigits = CV.chars().allMatch(Character::isDigit); 
               boolean isDigitss = cnumber.chars().allMatch(Character::isDigit); 
               
         if(isDigits && isDigitss){
         

             
        JOptionPane.showMessageDialog(null, "payment is Successful");
        JOptionPane.showMessageDialog(null, "Admission Confirmed");
        JOptionPane.showMessageDialog(null,"Transaction ID is "+r);
        
         setVisible(false);
         } else{JOptionPane.showMessageDialog(null, "Invalid CVV and Card Number");}
        
        
    }
        
       
        }
        }catch(Exception e){
            e.printStackTrace();
        
        }
       /*   
                }*/
        
    }
        
    
    public static void main(String[] args){
        new payment();
    }

    
    
}
