
package college.management.system;


import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class TeacherDetails extends JFrame implements ActionListener{
    
    Choice cempId;
    JTable table;
    JButton search,print,update,add,cancel;
    
    TeacherDetails(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading =new JLabel("Search by Employee ID");
        heading.setBounds(20,20,150,20);
        add(heading);
        
        cempId = new Choice();
        cempId.setBounds(180,20,150,20);
        add(cempId);
        
        try{
            Conn c = new Conn();
            ResultSet rs=c.s.executeQuery("select * from teacher");
            while(rs.next()){
                cempId.add(rs.getString("empId"));          
            }
    
        }catch(Exception e){
            e.printStackTrace();
        }
        
        table = new JTable();
        
        try{
            Conn c = new Conn();
            ResultSet rs=c.s.executeQuery("select * from teacher");
            table.setModel(DbUtils.resultSetToTableModel(rs));
    
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);
        
        search =new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);
        
        print=new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);
        
         update=new JButton("Update");
        update.setBounds(220,70,80,20);
        update.addActionListener(this);
        add(update);
        
         add=new JButton("Add");
        add.setBounds(320,70,80,20);
        add.addActionListener(this);
        add(add);
        
        cancel =new JButton("Cancel");
        cancel.setBounds(420,70,80,20);
        cancel.addActionListener(this);
        add(cancel);
        
        
        setSize(900,600);
        setLocation(180,25);
        
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/colle8.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,20,900,700);
        add(image);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            String query = "select * from teacher where empId ='"+cempId.getSelectedItem()+"'";
            try{
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()== print){
            
            try{
                table.print();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()== add){
            setVisible(false);
            new AddTeacher();
        }else if(ae.getSource()== update){
            setVisible(false);
          new UpdateTeacher();
        }else{
            setVisible(false);
        }
        
    }
    
    public static void main(String[] args){
        new TeacherDetails();
    }
    
}
