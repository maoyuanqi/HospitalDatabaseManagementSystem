package Hospital;

/**
 * Created by maoyuanqi on 2017/12/4.
 */



import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

    //component define
    JButton jb1,jb2,jb3=null;
    JRadioButton jrb1,jrb2,jrb3,jrb4,jrb5=null;
    JPanel jp1,jp2,jp3,jp4=null;
    JTextField jtf=null;
    JLabel jlb1,jlb2,jlb3=null;
    JPasswordField jpf=null;
    ButtonGroup bg=null;

    //menu
    JMenuBar jmb=null;
    JMenu jm=null;
    JMenuItem jmi1,jmi2=null;


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Login ms=new Login();


    }
    //
    public Login()
    {
        //component
        jb1=new JButton("Login");
        jb2=new JButton("Reset");
        jb3=new JButton("Exit");
        //listener
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);

        jmb=new JMenuBar();
        jm=new JMenu("Please Login First");
        jmi1=new JMenuItem("Start");
        jmi2=new JMenuItem("Quit");
        jm.add(jmi1);
        jm.add(jmi2);
        jmb.add(jm);


        jrb1=new JRadioButton("HR",true);
        jrb2=new JRadioButton("FINANCE");
        jrb3=new JRadioButton("RECEPTIONIST");
        jrb4=new JRadioButton("CLINIC");
        jrb5=new JRadioButton("MEDICINE");
        bg=new ButtonGroup();
        bg.add(jrb1);
        bg.add(jrb2);
        bg.add(jrb3);
        bg.add(jrb4);
        bg.add(jrb5);


        jp1=new JPanel();
        jp2=new JPanel();
        jp3=new JPanel();
        jp4=new JPanel();

        jlb1=new JLabel("        id:");
        jlb2=new JLabel("  password:  ");
        jlb3=new JLabel("Department:  ");

        jtf=new JTextField(3);
        jpf=new JPasswordField(6);
        //join in JP
        jp1.add(jlb1);
        jp1.add(jtf);
        jp2.add(jlb2);
        jp2.add(jpf);

        jp3.add(jlb3);
        jp3.add(jrb1);
        jp3.add(jrb2);
        jp3.add(jrb3);
        jp3.add(jrb4);
        jp3.add(jrb5);

        jp4.add(jb1);
        jp4.add(jb2);
        jp4.add(jb3);

        //join in JF
        this.setJMenuBar(jmb);
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);

        //layout setting
        this.setLayout(new GridLayout(4,1));
        //title setting
        this.setTitle("Hospital Database Management System");
        //window size
        this.setSize(600,500);
        //initial positioning
        this.setLocation(200, 150);
        //Real-time closing
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set visible
        this.setVisible(true);
        this.setResizable(true);

    }

    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand()=="Exit")
        {
            System.exit(0);
        }else if(e.getActionCommand()=="Login")
        {
            //Connecting to sql
            GetSQL.ConnectSQL();
            //if HR is selected.
            if(jrb1.isSelected())
            {
                Integer a=Integer.parseInt(jtf.getText());
                GetSQL.sqlquery("HR", a);
                this.HRlogin();
            }else if(jrb2.isSelected()) //finance is selected.
            {
                Integer a=Integer.parseInt(jtf.getText());
                GetSQL.sqlquery("FINANCE", a);
                this.FINANCE_login();
            }else if (jrb3.isSelected()){
                Integer a=Integer.parseInt(jtf.getText());
                GetSQL.sqlquery("RECEPTIONIST", a);
                this.RECEPTIONIST_login();
            }
            else if (jrb4.isSelected()){
                Integer a=Integer.parseInt(jtf.getText());
                GetSQL.sqlquery("CLINIC", a);
                this.CLINIC_login();
            }
            else if (jrb5.isSelected()){
                Integer a=Integer.parseInt(jtf.getText());
                GetSQL.sqlquery("MEDICINE", a);
                this.MEDICINE_login();
            }

        }else if(e.getActionCommand()=="Reset")
        {
            this.clear();
        }

    }

    //
    public  void clear()
    {
        jtf.setText("");
        jpf.setText("");
    }
    //
    public void HRlogin()
    {
        System.out.println(jtf.getText()+"  "+jpf.getText());
        if (GetSQL.userword ==Integer.parseInt(jtf.getText()) && GetSQL.pwd.equals(jpf.getText()))
        {
//                  System.out.println("Login Succeed!");
            JOptionPane.showMessageDialog(null,"Login Succeed!！","Message",JOptionPane.WARNING_MESSAGE);
            this.clear();

            dispose();
           HR_UI ui=new HR_UI();
        }else if(jtf.getText().isEmpty()&&jpf.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Please enter username and password！","Message",JOptionPane.WARNING_MESSAGE);
        }else if(jtf.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Please enter username！","Message",JOptionPane.WARNING_MESSAGE);
        }else if(jpf.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Please enter password！","Message",JOptionPane.WARNING_MESSAGE);
        }else
        {
            JOptionPane.showMessageDialog(null,"username or password fails！\nplease enter again","Message",JOptionPane.ERROR_MESSAGE);
            //
            this.clear();
        }
    }
    //
    public void FINANCE_login()
    {
        System.out.println(jtf.getText()+"  "+jpf.getText());
        if (GetSQL.userword ==Integer.parseInt(jtf.getText()) && GetSQL.pwd.equals(jpf.getText()))
        {
//                  System.out.println("Login Succeed!");
            JOptionPane.showMessageDialog(null,"Login Succeed!！","Message",JOptionPane.WARNING_MESSAGE);
            this.clear();
            //
            dispose();
            //
            FINANCE_UI ui=new FINANCE_UI();
        }else if(jtf.getText().isEmpty()&&jpf.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Please enter username and password！","Message",JOptionPane.WARNING_MESSAGE);
        }else if(jtf.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Please enter username！","Message",JOptionPane.WARNING_MESSAGE);
        }else if(jpf.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Please enter password！","Message",JOptionPane.WARNING_MESSAGE);
        }else
        {
            JOptionPane.showMessageDialog(null,"username or password fails！\nplease enter again","Message",JOptionPane.ERROR_MESSAGE);
            //
            this.clear();
        }
    }
    //
    public void RECEPTIONIST_login()
    {
        System.out.println(jtf.getText()+"  "+jpf.getText());
        if (GetSQL.userword ==Integer.parseInt(jtf.getText()) && GetSQL.pwd.equals(jpf.getText()))
        {
//                  System.out.println("Login Succeed!");
            JOptionPane.showMessageDialog(null,"Login Succeed!！","Message",JOptionPane.WARNING_MESSAGE);
            this.clear();
            //
            dispose();
            //
            RECEPTIONIST_UI ui=new RECEPTIONIST_UI();
        }else if(jtf.getText().isEmpty()&&jpf.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Please enter username and password！","Message",JOptionPane.WARNING_MESSAGE);
        }else if(jtf.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Please enter username！","Message",JOptionPane.WARNING_MESSAGE);
        }else if(jpf.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Please enter password！","Message",JOptionPane.WARNING_MESSAGE);
        }else
        {
            JOptionPane.showMessageDialog(null,"username or password fails！\nplease enter again","Message",JOptionPane.ERROR_MESSAGE);
            //
            this.clear();
        }
    }
    public void CLINIC_login()
    {
        System.out.println(jtf.getText()+"  "+jpf.getText());
        if (GetSQL.userword ==Integer.parseInt(jtf.getText()) && GetSQL.pwd.equals(jpf.getText()))
        {
//                  System.out.println("Login Succeed!");
            JOptionPane.showMessageDialog(null,"Login Succeed!！","Message",JOptionPane.WARNING_MESSAGE);
            this.clear();
            //
            dispose();
            //
            CLINIC_UI ui=new CLINIC_UI();
        }else if(jtf.getText().isEmpty()&&jpf.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Please enter username and password！","Message",JOptionPane.WARNING_MESSAGE);
        }else if(jtf.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Please enter username！","Message",JOptionPane.WARNING_MESSAGE);
        }else if(jpf.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Please enter password！","Message",JOptionPane.WARNING_MESSAGE);
        }else
        {
            JOptionPane.showMessageDialog(null,"username or password fails！\nplease enter again","Message",JOptionPane.ERROR_MESSAGE);
            //
            this.clear();
        }
    }
    public void MEDICINE_login()
    {
        System.out.println(jtf.getText()+"  "+jpf.getText());
        if (GetSQL.userword ==Integer.parseInt(jtf.getText()) && GetSQL.pwd.equals(jpf.getText()))
        {
//                  System.out.println("Login Succeed!");
            JOptionPane.showMessageDialog(null,"Login Succeed!！","Message",JOptionPane.WARNING_MESSAGE);
            this.clear();
            //
            dispose();

            MEDICINE_UI ui=new MEDICINE_UI();
        }else if(jtf.getText().isEmpty()&&jpf.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Please enter username and password！","Message",JOptionPane.WARNING_MESSAGE);
        }else if(jtf.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Please enter username！","Message",JOptionPane.WARNING_MESSAGE);
        }else if(jpf.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Please enter password！","Message",JOptionPane.WARNING_MESSAGE);
        }else
        {
            JOptionPane.showMessageDialog(null,"username or password fails！\nplease enter again","Message",JOptionPane.ERROR_MESSAGE);
            //
            this.clear();
        }
    }




}
