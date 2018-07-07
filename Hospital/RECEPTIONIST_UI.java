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

public class RECEPTIONIST_UI extends JFrame implements ActionListener {

    //定义组件
    JLabel jl1, jl2 = null;
    JTextField jtf = null;
    JButton jb,jb1,jb2 = null;
    JPanel jp1, jp2 = null;
    JTable jtable = null;

    String name = null;
    String num = null;

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
    public RECEPTIONIST_UI() {
        //创建组件
        //展示，下方有案例。
        jl2 = new JLabel("Please enter patient #:");
        jtf = new JTextField(5);
        jb = new JButton("Get Information");
        jb1 = new JButton("Back to login");
        jb2= new JButton("Register");
  //      jb2= new JButton("All patients");
        //设置监听
        jb.addActionListener(this);
        jb1.addActionListener(this);
        jb2.addActionListener(this);
  //      jb2.addActionListener(this);
        //设置表格
        String[] columnNames = {"col1", "col2"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 7);
        jtable = new JTable(model);
        jtable.setSize(500,300);
        jsp2 = new JScrollPane(jtable);

        jp1 = new JPanel();
        jp2 = new JPanel();

        jp1.add(jl2);
        jp1.add(jtf);
        jp1.add(jb);
     //   jp1.add(jb2);
        jp2.add(jtable);
        jp2.add(jsp2);
        jp2.add(jb1);
        jp2.add(jb2);

        this.add(jp1);
        this.add(jp2);

        this.setLayout(new GridLayout(2, 3));
        this.setTitle("RECEPTIONISTS");
        this.setSize(500, 400);
        this.setLocation(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


    }


    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand() == "Get Information") {
            //JOptionPane.showMessageDialog(null,"查询成功！","提示消息",JOptionPane.WARNING_MESSAGE);
            //创建火箭车

            GetSQL.ConnectSQL();
            Integer a=Integer.parseInt(jtf.getText());
            GetSQL.Receptionist_query(a);
            jtable.setValueAt("pNo:", 0, 0);
            jtable.setValueAt("Money_Reserved:", 1, 0);
            jtable.setValueAt("Name:", 2, 0);
            jtable.setValueAt("Address:", 3, 0);
            jtable.setValueAt("Age:", 4, 0);
            jtable.setValueAt("Gender:", 5, 0);
            jtable.setValueAt("Phone:", 6, 0);

            jtable.setValueAt(GetSQL.pNo, 0, 1);
            jtable.setValueAt(GetSQL.Money_Reserved, 1, 1);
            jtable.setValueAt(GetSQL.patient_Name, 2, 1);
            jtable.setValueAt(GetSQL.patient_Address, 3, 1);
            jtable.setValueAt(GetSQL.patient_Age, 4, 1);
            jtable.setValueAt(GetSQL.Gender, 5, 1);
            jtable.setValueAt(GetSQL.Phone, 6, 1);



        }

        if (e.getActionCommand() == "Back to login") {
            //JOptionPane.showMessageDialog(null,"查询成功！","提示消息",JOptionPane.WARNING_MESSAGE);
            //创建火箭车

            dispose();
            Hospital.Login l = new Hospital.Login();



        }
        if (e.getActionCommand() == "Register") {
            //JOptionPane.showMessageDialog(null,"查询成功！","提示消息",JOptionPane.WARNING_MESSAGE);
            //创建火箭车

            dispose();
            Register_UI r=new Register_UI();



        }

    }
}
