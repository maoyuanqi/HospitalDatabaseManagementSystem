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

public class PRESCRIPTION_UI extends JFrame implements ActionListener {

    //定义组件
    JLabel  jl2, jl3, jl4 = null;
    JTextField jtf1,jtf2,jtf3 = null;
    JButton jb,jb1= null;
    JPanel jp1, jp2,jp3,jp4 ,jp5= null;




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
    public PRESCRIPTION_UI() {
        //创建组件
        //展示，下方有案例。
       // jl1=new JLabel("Please enter prescription #:");
        jl2 = new JLabel("Please enter doctor #:");
        jl3 = new JLabel("Please enter patient #:");
        jl4 = new JLabel("Please enter description:");
      //  jtf = new JTextField(10);
        jtf1 = new JTextField(10);
        jtf2 = new JTextField(10);
        jtf3 = new JTextField(10);

        jb = new JButton("Insert");
        jb1 =new JButton("Back to clinic main menu");
        //设置监听
        jb.addActionListener(this);
        jb1.addActionListener(this);
        //设置表格


        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();


     //   jp1.add(jl1);
      //  jp1.add(jtf);
        jp2.add(jl2);
        jp2.add(jtf1);
        jp3.add(jl3);
        jp3.add(jtf2);
        jp4.add(jl4);
        jp4.add(jtf3);
        jp5.add(jb);
        jp5.add(jb1);


        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);
        this.add(jp5);


        this.setLayout(new GridLayout(2, 2));
        this.setTitle("CLINIC Department");
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
            Integer b=Integer.parseInt(jtf1.getText());
            Integer c=Integer.parseInt(jtf2.getText());
            GetSQL.clinic_query2(b,c,jtf3.getText());
            //JOptionPane.showMessageDialog(null,"Successfully Inserted！","Info",JOptionPane.WARNING_MESSAGE);




        }
        if (e.getActionCommand() == "Back to clinic main menu") {
            //创建火箭车

            dispose();
            CLINIC_UI c = new CLINIC_UI();



        }

    }
}
