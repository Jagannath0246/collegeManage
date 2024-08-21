
package college.management.system;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class StudentFeeForm extends JFrame implements ActionListener {
    
    Choice crollno;
    JComboBox cbcourse, cbbranch,cbsemester;
    JButton Update, pay,back;
    JLabel labeltotal;
   
 
    
    StudentFeeForm(){
        setSize(900,500);
        setLocation(300, 100);
        setLayout(null);
        
        getContentPane(). setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
        Image i2 = i1.getImage().getScaledInstance(380,280,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,500,300);
        add(image); 
        
        JLabel lblrollnumber =new JLabel("Select Roll NO");
        lblrollnumber.setBounds(40,60,150,20);
        lblrollnumber.setFont(new Font("TAHOMA",Font.BOLD, 16));
        add(lblrollnumber);
        
        crollno = new Choice();
        crollno.setBounds(200,60,150,20);
        add(crollno);
        
        try{
            Conn c = new Conn();
            ResultSet rs= c.s.executeQuery("select * from student");
            while(rs.next()){
                crollno.add(rs.getString("rollno"));          
            }
    
        }catch(Exception e){
            e.printStackTrace();
        }
        JLabel lblname =new JLabel("Name");
        lblname.setBounds(40,100,150,20);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblname);
        
        
        JLabel labelname =new JLabel();
        labelname.setBounds(200,100,150,20);
        labelname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelname);
        
        
        JLabel lblfname =new JLabel(" Father's Name");
        lblfname.setBounds(35,140,150,20);
        lblfname.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblfname);
        
        JLabel labelfname=new JLabel();
        labelfname.setBounds(200,140,150,20);
        lblfname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add( labelfname);
        
        try {
            Conn c = new Conn();
            String query ="select * from student where rollno='"+crollno.getSelectedItem()+"'";
            ResultSet rs= c.s.executeQuery(query);
            while(rs.next()){
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                
            }
        
        }catch (Exception e) {
           e.printStackTrace();
        }
        
        crollno.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                 try {
                      Conn c = new Conn();
                      String query ="select * from student where rollno='"+crollno.getSelectedItem()+"'";
                      ResultSet rs= c.s.executeQuery(query);
                      while(rs.next()){
                      labelname.setText(rs.getString("name"));
                      labelfname.setText(rs.getString("fname"));
                      
                      }
            }
            catch (Exception e) {
            e.printStackTrace();
        }
                
            }
         
     });
         JLabel lblcourse =new JLabel("Course");
        lblcourse.setBounds(35,180,150,20);
        lblcourse .setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblcourse);
        
        
        String course[] ={"BTech","Bsc","BCA","MTech","Msc","MCA"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(200,180,150,20);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse );
        
        JLabel lblbranch =new JLabel("Branch");
        lblbranch.setBounds(35,220,150,20);
        lblbranch .setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblbranch);
        
        
        
        String branch[] ={"Computer Science","Electronics","Mechanical","Civil","IT"};
        cbbranch= new JComboBox(branch);
        cbbranch.setBounds(200,220,150,30);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch );
       
        
        
          JLabel lblsemester =new JLabel("Select Semester");
        lblsemester.setBounds(40,260,150,20);
        lblsemester .setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblsemester);
        
        
        String semester[] ={"Semester1","Semester2","Semester3","Semester4","Semester5","Semester6","Semester7","Semester8"};
        cbsemester = new JComboBox(semester);
       cbsemester.setBounds(200,265,150,20);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);
        
        JLabel lbltotal =new JLabel("Total Payable");
        lbltotal.setBounds(40,300,150,20);
        lbltotal.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lbltotal);
        
        labeltotal = new JLabel();
        labeltotal.setBounds(200,300,150,20);
        labeltotal.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labeltotal);
        
        
         Update = new JButton("Update");
       Update.setBounds(30,380,100,25);
        Update.setBackground(Color.GREEN);
        Update.addActionListener(this);
       Update.setFont(new Font("Tahoma",Font.BOLD,15));
        add(Update);
        
       pay = new JButton("PAY");
         pay.setBounds(150,380,100,25);
         pay.setBackground(Color.BLUE);
         pay.setForeground(Color.WHITE);
         pay.addActionListener(this);
         pay.setFont(new Font("Tahoma",Font.BOLD,15));
        add( pay);
          
     back= new JButton("BACK");
          back.setBounds(270,380,100,25);
         back.setBackground(Color.RED);
        back.addActionListener(this);
         back.setFont(new Font("Tahoma",Font.BOLD,15));
        add(  back);
        
        
        
        setVisible(true);
        
      
        
    }
    
     public void  actionPerformed(ActionEvent ae){
       if (ae.getSource() == Update) {
        
      String course = (String)cbcourse.getSelectedItem();
         String semester = (String)cbsemester.getSelectedItem();
      try{
          Conn c=new Conn();
          ResultSet rs = c.s.executeQuery("select * from fee where course ='"+course+"'");
          while(rs.next()){
    labeltotal.setText(rs.getString(semester));
          }
      }catch(Exception e){
          e.printStackTrace();
      }
    }else if(ae.getSource() == pay){
       
        String rollno = crollno.getSelectedItem();
        String course = (String)cbcourse.getSelectedItem();
         String semester = (String)cbsemester.getSelectedItem();
         String branch = (String)cbbranch.getSelectedItem();
        String total = labeltotal.getText();
        
        try{
          Conn c=new Conn();
         
          String query = "insert into collegefee values('"+rollno+"','"+course+"','"+branch+"','"+semester+"','"+total+"') ";
          c.s.executeUpdate(query);
          new payment();
         // JOptionPane.showMessageDialog(null, "College Fee submitted Successfully");
          setVisible(false);
      }catch(Exception e){
          e.printStackTrace();
      }
        
    }else if(ae.getSource() == back){
       
           setVisible(false);
    }
    }        

    public static void main(String[] args){
        new StudentFeeForm();
    }
}
