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

public class FINANCE_PAYMENT_UI extends JFrame implements ActionListener {

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
    public FINANCE_PAYMENT_UI() {
        //创建组件
        //展示，下方有案例。
        jl1 = new JLabel("Please enter patient #:");

        jtf = new JTextField(10);
        jb = new JButton("Get Patient Payment");

        jb2 = new JButton("Previous Payment");
        jb3 = new JButton("Next Payment");

        jb6=new JButton("Back to Finance department main menu");
        //设置监听
        jb.addActionListener(this);

        jb2.addActionListener(this);
        jb3.addActionListener(this);

        jb6.addActionListener(this);
        //设置表格
        String[] columnNames = {"col1", "col2"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 7);
        //model.setColumnCount(0);
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


        if (e.getActionCommand() == "Get Patient Payment") {
            //JOptionPane.showMessageDialog(null,"查询成功！","提示消息",JOptionPane.WARNING_MESSAGE);
            //创建火箭车
            GetSQL.ConnectSQL();
            Integer a=Integer.parseInt(jtf.getText());
            GetSQL.finance_query2(a);
            count=0;
            jtable.setValueAt("InvoiceNo:", 0, 0);
            jtable.setValueAt("Name:", 1, 0);
            jtable.setValueAt("Amount:", 2, 0);
            jtable.setValueAt("Pay_Method:", 3, 0);
            jtable.setValueAt("Status:", 4, 0);
            jtable.setValueAt("pNo:", 5, 0);


            jtable.setValueAt(GetSQL.invoiceNo[count], 0, 1);
            jtable.setValueAt(GetSQL.payment_name[count], 1, 1);
            jtable.setValueAt(GetSQL.amount[count], 2, 1);
            jtable.setValueAt(GetSQL.pay_method[count], 3, 1);
            jtable.setValueAt(GetSQL.status[count], 4, 1);
            jtable.setValueAt(GetSQL.payment_pNo[count], 5, 1);
            System.out.println(count);



        }
        if ((e.getActionCommand() == "Previous Payment")) {
            //JOptionPane.showMessageDialog(null,"查询成功！","提示消息",JOptionPane.WARNING_MESSAGE);
            //创建火箭车

          //  GetSQL.ConnectSQL();
         //   GetSQL.finance_query2(jtf.getText());

            jtable.setValueAt("InvoiceNo:", 0, 0);
            jtable.setValueAt("Name:", 1, 0);
            jtable.setValueAt("Amount:", 2, 0);
            jtable.setValueAt("Pay_Method:", 3, 0);
            jtable.setValueAt("Status:", 4, 0);
            jtable.setValueAt("pNo:", 5, 0);
            if (count>0){
                count--;
                System.out.println(count);
                jtable.setValueAt(GetSQL.invoiceNo[count], 0, 1);
                jtable.setValueAt(GetSQL.payment_name[count], 1, 1);
                jtable.setValueAt(GetSQL.amount[count], 2, 1);
                jtable.setValueAt(GetSQL.pay_method[count], 3, 1);
                jtable.setValueAt(GetSQL.status[count], 4, 1);
                jtable.setValueAt(GetSQL.payment_pNo[count], 5, 1);}
            else{
                count=0;
                jtable.setValueAt(GetSQL.invoiceNo[count], 0, 1);
                jtable.setValueAt(GetSQL.payment_name[count], 1, 1);
                jtable.setValueAt(GetSQL.amount[count], 2, 1);
                jtable.setValueAt(GetSQL.pay_method[count], 3, 1);
                jtable.setValueAt(GetSQL.status[count], 4, 1);
                jtable.setValueAt(GetSQL.payment_pNo[count], 5, 1);
                System.out.println(count);
            }




        }
        if ((e.getActionCommand() == "Next Payment")) {
            //JOptionPane.showMessageDialog(null,"查询成功！","提示消息",JOptionPane.WARNING_MESSAGE);
            //创建火箭车

         //   GetSQL.ConnectSQL();
          //  GetSQL.finance_query2(jtf.getText());
            jtable.setValueAt("InvoiceNo:", 0, 0);
            jtable.setValueAt("Name:", 1, 0);
            jtable.setValueAt("Amount:", 2, 0);
            jtable.setValueAt("Pay_Method:", 3, 0);
            jtable.setValueAt("Status:", 4, 0);
            jtable.setValueAt("pNo:", 5, 0);
                if(count<GetSQL.payment_count-1) {
                    count++;
                    jtable.setValueAt(GetSQL.invoiceNo[count], 0, 1);
                    jtable.setValueAt(GetSQL.payment_name[count], 1, 1);
                    jtable.setValueAt(GetSQL.amount[count], 2, 1);
                    jtable.setValueAt(GetSQL.pay_method[count], 3, 1);
                    jtable.setValueAt(GetSQL.status[count], 4, 1);
                    jtable.setValueAt(GetSQL.payment_pNo[count], 5, 1);

                    System.out.println(count+"  "+GetSQL.payment_count);

                }else{
                    count=GetSQL.payment_count-1;
                    jtable.setValueAt(GetSQL.invoiceNo[count], 0, 1);
                    jtable.setValueAt(GetSQL.payment_name[count], 1, 1);
                    jtable.setValueAt(GetSQL.amount[count], 2, 1);
                    jtable.setValueAt(GetSQL.pay_method[count], 3, 1);
                    jtable.setValueAt(GetSQL.status[count], 4, 1);
                    jtable.setValueAt(GetSQL.payment_pNo[count], 5, 1);
                    System.out.println("++anomaly");
                }

        }

        if (e.getActionCommand() == "Back to Finance department main menu") {
            //JOptionPane.showMessageDialog(null,"查询成功！","提示消息",JOptionPane.WARNING_MESSAGE);
            //创建火箭车

            dispose();
            Hospital.FINANCE_UI f=new Hospital.FINANCE_UI();



        }

    }
}
