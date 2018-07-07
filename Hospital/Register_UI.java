package Hospital;

/**
 * Created by maoyuanqi on 2017/12/4.
 */



import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Register_UI extends JFrame implements ActionListener {

    //定义组件
    JLabel  jl1,jl2, jl3, jl4,jl5 = null;
    JTextField jtf1,jtf2,jtf3,jtf4,jtf5 = null;
    JButton jb,jb1= null;
    JPanel jp1, jp2,jp3,jp4 ,jp5,jp6= null;




    static Connection ct = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    JScrollPane jsp, jsp2 = null;

//  public static void main(String[] args) {
//      // TODO Auto-generated method stub
//      Teacher t=new Teacher();
//
//      try {
//          Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//          ct=DriverManager.getConnection("jdbc:odbc:ywq");
//      } catch (Exception e) {
//
//          e.printStackTrace();
//      }
//
//  }


    //构造函数
    public Register_UI() {
        //创建组件
        //展示，下方有案例。
        jl1 = new JLabel("Please enter name:");
        jl2 = new JLabel("Please enter address:");
        jl3 = new JLabel("Please enter age:");
        jl4=new JLabel("Please enter gender:");
        jl5=new JLabel("Please enter phone:");
        //  jtf = new JTextField(10);
        jtf1 = new JTextField(10);
        jtf2 = new JTextField(10);
        jtf3 = new JTextField(10);
        jtf4 = new JTextField(10);
        jtf5 = new JTextField(10);


        jb = new JButton("Insert");
        jb1 =new JButton("Back to receptionist");
        //设置监听
        jb.addActionListener(this);
        jb1.addActionListener(this);
        //设置表格


        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();
        jp6 = new JPanel();


        jp1.add(jl1);
        jp1.add(jtf1);
        jp2.add(jl2);
        jp2.add(jtf2);
        jp3.add(jl3);
        jp3.add(jtf3);
        jp4.add(jl4);
        jp4.add(jtf4);
        jp5.add(jl5);
        jp5.add(jtf5);

        jp6.add(jb);
        jp6.add(jb1);


        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);
        this.add(jp5);
        this.add(jp6);


        this.setLayout(new GridLayout(2, 2));
        this.setTitle("RECEPTIONISTS");
        this.setSize(500, 400);
        this.setLocation(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


    }


    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand() == "Insert") {
            //JOptionPane.showMessageDialog(null,"查询成功！","提示消息",JOptionPane.WARNING_MESSAGE);
            //创建火箭车

            GetSQL.ConnectSQL();
            // Integer a=Integer.parseInt(jtf.getText());

            GetSQL.recept_query(jtf1.getText(), jtf2.getText(),Integer.parseInt(jtf3.getText()),jtf4.getText(),jtf5.getText());
            //JOptionPane.showMessageDialog(null,"Successfully Inserted！","Info",JOptionPane.WARNING_MESSAGE);




        }
        if (e.getActionCommand() == "Back to receptionist") {
            //创建火箭车

            dispose();
            RECEPTIONIST_UI c = new RECEPTIONIST_UI();



        }

    }
}
