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

public class FINANCE_PAYCHECK_UI extends JFrame implements ActionListener {

    //定义组件
    JLabel jl1= null;
    JTextField jtf = null;
    JButton jb,jb2,jb3,jb6= null;
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
    public FINANCE_PAYCHECK_UI() {
        //创建组件
        //展示，下方有案例。
        jl1 = new JLabel("Please enter employee #:");

        jtf = new JTextField(10);
        jb = new JButton("Get Employee Paycheck");

        jb2 = new JButton("Previous Paycheck");
        jb3 = new JButton("Next Paycheck");

        jb6=new JButton("Back to Finance department main menu");
        //设置监听
        jb.addActionListener(this);

        jb2.addActionListener(this);
        jb3.addActionListener(this);

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

        jp3.add(jb6);


        this.add(jp);
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.setLayout(new GridLayout(2, 3));
        this.setTitle("FINANCE Department");
        this.setSize(500, 400);
        this.setLocation(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


    }


    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand() == "Get Employee Paycheck") {
            //JOptionPane.showMessageDialog(null,"查询成功！","提示消息",JOptionPane.WARNING_MESSAGE);
            //创建火箭车

            GetSQL.ConnectSQL();
            Integer a=Integer.parseInt(jtf.getText());
            GetSQL.finance_query(a);
            count=0;
            jtable.setValueAt("pcNo:", 0, 0);
            jtable.setValueAt("name:", 1, 0);
            jtable.setValueAt("position:", 2, 0);
            jtable.setValueAt("eNo:", 3, 0);
            jtable.setValueAt("Salary:", 4, 0);
            jtable.setValueAt("Bonus:", 5, 0);
            jtable.setValueAt("PayDate:", 6, 0);

            jtable.setValueAt(GetSQL.pcno[count], 0, 1);
            jtable.setValueAt(GetSQL.name[count], 1, 1);
            jtable.setValueAt(GetSQL.position[count], 2, 1);
            jtable.setValueAt(GetSQL.eNo[count], 3, 1);
            jtable.setValueAt(GetSQL.Salary[count], 4, 1);
            jtable.setValueAt(GetSQL.Bonus[count], 5, 1);
            jtable.setValueAt(GetSQL.PayDate[count], 6, 1);



        }
        if (e.getActionCommand() == "Previous Paycheck") {
            //JOptionPane.showMessageDialog(null,"查询成功！","提示消息",JOptionPane.WARNING_MESSAGE);
            //创建火箭车

            GetSQL.ConnectSQL();
            Integer a=Integer.parseInt(jtf.getText());
            GetSQL.finance_query(a);
            jtable.setValueAt("pNo:", 0, 0);
            jtable.setValueAt("pcNo:", 0, 0);
            jtable.setValueAt("name:", 1, 0);
            jtable.setValueAt("position:", 2, 0);
            jtable.setValueAt("eNo:", 3, 0);
            jtable.setValueAt("Salary:", 4, 0);
            jtable.setValueAt("Bonus:", 5, 0);
            jtable.setValueAt("PayDate:", 6, 0);
            if (count>0) {
                count--;
                jtable.setValueAt(GetSQL.pcno[count], 0, 1);
                jtable.setValueAt(GetSQL.name[count], 1, 1);
                jtable.setValueAt(GetSQL.position[count], 2, 1);
                jtable.setValueAt(GetSQL.eNo[count], 3, 1);
                jtable.setValueAt(GetSQL.Salary[count], 4, 1);
                jtable.setValueAt(GetSQL.Bonus[count], 5, 1);
                jtable.setValueAt(GetSQL.PayDate[count], 6, 1);

            }     else{
                count=0;
                jtable.setValueAt(GetSQL.pcno[count], 0, 1);
                jtable.setValueAt(GetSQL.name[count], 1, 1);
                jtable.setValueAt(GetSQL.position[count], 2, 1);
                jtable.setValueAt(GetSQL.eNo[count], 3, 1);
                jtable.setValueAt(GetSQL.Salary[count], 4, 1);
                jtable.setValueAt(GetSQL.Bonus[count], 5, 1);
                jtable.setValueAt(GetSQL.PayDate[count], 6, 1);
                System.out.println(count);
            }


        }
        if (e.getActionCommand() == "Next Paycheck") {
            //JOptionPane.showMessageDialog(null,"查询成功！","提示消息",JOptionPane.WARNING_MESSAGE);
            //创建火箭车

            GetSQL.ConnectSQL();
            Integer a=Integer.parseInt(jtf.getText());
            GetSQL.finance_query(a);
            jtable.setValueAt("pcNo:", 0, 0);
            jtable.setValueAt("pNo:", 0, 0);
            jtable.setValueAt("pcNo:", 0, 0);
            jtable.setValueAt("name:", 1, 0);
            jtable.setValueAt("position:", 2, 0);
            jtable.setValueAt("eNo:", 3, 0);
            jtable.setValueAt("Salary:", 4, 0);
            jtable.setValueAt("Bonus:", 5, 0);
            jtable.setValueAt("PayDate:", 6, 0);

            if(count< GetSQL.paycheck_count-1)
            {
            count++;
            jtable.setValueAt(GetSQL.pcno[count], 0, 1);
            jtable.setValueAt(GetSQL.name[count], 1, 1);
            jtable.setValueAt(GetSQL.position[count], 2, 1);
            jtable.setValueAt(GetSQL.eNo[count], 3, 1);
            jtable.setValueAt(GetSQL.Salary[count], 4, 1);
            jtable.setValueAt(GetSQL.Bonus[count], 5, 1);
            jtable.setValueAt(GetSQL.PayDate[count], 6, 1);
            }else{
                count= GetSQL.paycheck_count-1;
                jtable.setValueAt(GetSQL.pcno[count], 0, 1);
                jtable.setValueAt(GetSQL.name[count], 1, 1);
                jtable.setValueAt(GetSQL.position[count], 2, 1);
                jtable.setValueAt(GetSQL.eNo[count], 3, 1);
                jtable.setValueAt(GetSQL.Salary[count], 4, 1);
                jtable.setValueAt(GetSQL.Bonus[count], 5, 1);
                jtable.setValueAt(GetSQL.PayDate[count], 6, 1);
                System.out.println(count+"  "+ GetSQL.payment_count);
            }





        }

        if (e.getActionCommand() == "Back to Finance department main menu") {
            //JOptionPane.showMessageDialog(null,"查询成功！","提示消息",JOptionPane.WARNING_MESSAGE);
            //创建火箭车

            dispose();
            FINANCE_UI f=new FINANCE_UI();



        }

    }
}
