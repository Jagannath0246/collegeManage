
package college.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
 
public class TeacherLeave extends JFrame implements ActionListener {
    
    
    Choice cEmpId,ctime;
    JDateChooser dcdate;
    JButton submit, cancel;
    
    
    TeacherLeave(){
        
        setSize(500,500);
        setLocation(350,100);
        setLayout(null);
        
        getContentPane() .setBackground(Color.WHITE);
        
        JLabel heading =new JLabel("Apply Leave (Teacher)");
        heading.setBounds(40,40,300,30);
        add(heading);
        
        JLabel lblrollno =new JLabel("Search by Employee ID");
        lblrollno.setBounds(60,100,200,20);
        lblrollno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblrollno);
        
        cEmpId= new Choice();
        cEmpId.setBounds(60,130,200,20);
        add(cEmpId);
        
        try{
            Conn c = new Conn();
            ResultSet rs=c.s.executeQuery("select * from teacher");
            while(rs.next()){
                cEmpId.add(rs.getString("empId"));          
            }
    
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel lbldate =new JLabel("Date");
        lbldate.setBounds(60,180,200,20);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lbldate);
        
        dcdate= new JDateChooser();
        dcdate.setBounds(60,210,200,25);
        add(dcdate);
        
        JLabel lbltime =new JLabel("Time Duration");
        lbltime.setBounds(60,260,200,20);
        lblrollno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lbltime);
        
        ctime= new Choice();
        ctime.setBounds(60,290,200,20);
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);
        
        
        submit = new JButton("SUBMIT");
        submit.setBounds(60,350,100,25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD,15));
        add(submit);
        
        cancel = new JButton("CANCEL");
        cancel.setBounds(200,350,100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        add(cancel);
        
           ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/colle9.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,20,900,700);
        add(image);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String rollno = cEmpId.getSelectedItem();
            String date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            String duration = ctime.getSelectedItem();
            
            
            String query = "insert into teacherleave values('"+rollno+"','"+date+"','"+duration+"')";
            
            try { 
                
                Conn c= new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Leave Confirmed");
                 setVisible(false);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
            else{
            setVisible(false);
        }
    }
    
    
    public static void main(String[] args) {
        new TeacherLeave();
        
    }
}


