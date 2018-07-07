package Hospital;

/**
 * Created by maoyuanqi on 2017/12/4.
 */


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class CLINIC_UI extends JFrame implements ActionListener {

    //定义组件
    JLabel jl1= null;
    JTextField jtf = null;
    JButton jb,jb2,jb3,jb6 , jb4= null;
    JPanel jp,jp1, jp2 ,jp3= null;
    JTable jtable = null;



    static Connection ct = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    JScrollPane jsp, jsp2 = null;
    int count=0;

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
    public CLINIC_UI() {
        //创建组件
        //展示，下方有案例。
        jl1 = new JLabel("Please enter patient #:");

        jtf = new JTextField(10);
        jb = new JButton("Get History Prescription");

        jb2 = new JButton("Previous Record");
        jb3 = new JButton("Next Record");
        jb4 = new JButton("Add prescription");
        jb6=new JButton("Back to login");
        //设置监听
        jb.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        jb4.addActionListener(this);
        jb6.addActionListener(this);
        //设置表格
        String[] columnNames = {"col1", "col2"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 7);
        jtable = new JTable(model);
        jtable.setSize(500,300);
        jsp2 = new JScrollPane(jtable);
        jp=new JPanel();
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3=new JPanel();

        jp.add(jl1);
        jp.add(jtf);
        jp1.add(jb);

        jp2.add(jtable);
        jp2.add(jsp2);
        jp2.add(jb2);
        jp2.add(jb3);
        jp1.add(jb4);
        jp3.add(jb6);


        this.add(jp);
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.setLayout(new GridLayout(4, 5));
        this.setTitle("CLINIC Department");
        this.setSize(500, 400);
        this.setLocation(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


    }


    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand() == "Get History Prescription") {
            //JOptionPane.showMessageDialog(null,"查询成功！","提示消息",JOptionPane.WARNING_MESSAGE);
            //创建火箭车

            GetSQL.ConnectSQL();
            Integer a=Integer.parseInt(jtf.getText());
            GetSQL.clinic_query(a);
            count=0;
            jtable.setValueAt("prescriptNo:", 0, 0);
            jtable.setValueAt("doctorNo:", 1, 0);
            jtable.setValueAt("patientNo:", 2, 0);
            jtable.setValueAt("Description", 3, 0);


            jtable.setValueAt(GetSQL.prescriptNo[count], 0, 1);
            jtable.setValueAt(GetSQL.employeeNo[count], 1, 1);
            jtable.setValueAt(GetSQL.patientNo[count], 2, 1);
            jtable.setValueAt(GetSQL.Description[count], 3, 1);




        }
        if (e.getActionCommand() == "Add prescription") {
            dispose();
            PRESCRIPTION_UI p=new PRESCRIPTION_UI();




        }
        if (e.getActionCommand() == "Previous Record") {
            //JOptionPane.showMessageDialog(null,"查询成功！","提示消息",JOptionPane.WARNING_MESSAGE);
            //创建火箭车

            GetSQL.ConnectSQL();
            Integer a=Integer.parseInt(jtf.getText());
            GetSQL.clinic_query(a);
            jtable.setValueAt("prescriptNo:", 0, 0);
            jtable.setValueAt("doctorNo:", 1, 0);
            jtable.setValueAt("patientNo:", 2, 0);
            jtable.setValueAt("Description", 3, 0);
            if (count>0) {
                count--;
                jtable.setValueAt(GetSQL.prescriptNo[count], 0, 1);
                jtable.setValueAt(GetSQL.employeeNo[count], 1, 1);
                jtable.setValueAt(GetSQL.patientNo[count], 2, 1);
                jtable.setValueAt(GetSQL.Description[count], 3, 1);
            }     else{
                count=0;
                jtable.setValueAt(GetSQL.prescriptNo[count], 0, 1);
                jtable.setValueAt(GetSQL.employeeNo[count], 1, 1);
                jtable.setValueAt(GetSQL.patientNo[count], 2, 1);
                jtable.setValueAt(GetSQL.Description[count], 3, 1);                System.out.println(count);
            }


        }
        if (e.getActionCommand() == "Next Record") {
            //JOptionPane.showMessageDialog(null,"查询成功！","提示消息",JOptionPane.WARNING_MESSAGE);
            //创建火箭车

            GetSQL.ConnectSQL();
            Integer a=Integer.parseInt(jtf.getText());
            GetSQL.clinic_query(a);
            jtable.setValueAt("prescriptNo:", 0, 0);
            jtable.setValueAt("doctorNo:", 1, 0);
            jtable.setValueAt("patientNo:", 2, 0);
            jtable.setValueAt("Description", 3, 0);

            if(count< GetSQL.history_count-1)
            {
                count++;
                jtable.setValueAt(GetSQL.prescriptNo[count], 0, 1);
                jtable.setValueAt(GetSQL.employeeNo[count], 1, 1);
                jtable.setValueAt(GetSQL.patientNo[count], 2, 1);
                jtable.setValueAt(GetSQL.Description[count], 3, 1);            }else{
                count= GetSQL.history_count-1;
                jtable.setValueAt(GetSQL.prescriptNo[count], 0, 1);
                jtable.setValueAt(GetSQL.employeeNo[count], 1, 1);
                jtable.setValueAt(GetSQL.patientNo[count], 2, 1);
                jtable.setValueAt(GetSQL.Description[count], 3, 1);                System.out.println(count+"  "+ GetSQL.payment_count);
            }





        }

        if (e.getActionCommand() == "Back to login") {
            //JOptionPane.showMessageDialog(null,"查询成功！","提示消息",JOptionPane.WARNING_MESSAGE);
            //创建火箭车

            dispose();
            Login l=new Login();



        }

    }
}
