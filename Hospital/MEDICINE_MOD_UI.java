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

public class MEDICINE_MOD_UI extends JFrame implements ActionListener {

    //定义组件
    JLabel jl1, jl2 ,jl3= null;
    JTextField jtf,jtf1,jtf2 = null;
    JButton jb_, jb,jb1,jb2= null;
    JPanel jp1, jp2,jp3,jp4 ,jp5,jp6= null;
    JTable jtable =null;



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
    public MEDICINE_MOD_UI() {
        //创建组件
        //展示，下方有案例。
        jl1=new JLabel("Please enter medicine #:");
        jl2 = new JLabel("Please enter modified quantity:");
        jl3 = new JLabel("Please enter prescription #:");
      //  jl4 = new JLabel("Please enter description:");
        jtf = new JTextField(10);
        jtf1 = new JTextField(10);
        jtf2 = new JTextField(10);
//        jtf3 = new JTextField(10);

        jb = new JButton("Execute +");
        jb_ = new JButton("Execute -");
        jb1 =new JButton("Back to medicine main");
        jb2=new JButton("Query for prescription");
        //设置监听
        jb.addActionListener(this);
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb_.addActionListener(this);
        //设置表格
        String[] columnNames = {"col1", "col2"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 2);
        jtable = new JTable(model);
        jtable.setSize(500,300);
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();
        jp6=new JPanel();

        jp3.add(jl1);
        jp3.add(jtf);

        jp4.add(jl2);
        jp4.add(jtf1);

        jp1.add(jl3);
        jp1.add(jtf2);

        jp2.add(jtable);

        jp6.add(jb);
        jp5.add(jb1);
        jp6.add(jb_);
        jp5.add(jb2);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);
        this.add(jp5);
        this.add(jp6);


        this.setLayout(new GridLayout(3, 2));
        this.setTitle("MEDICINE Department");
        this.setSize(500, 400);
        this.setLocation(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


    }


    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand() == "Execute +") {
            //JOptionPane.showMessageDialog(null,"查询成功！","提示消息",JOptionPane.WARNING_MESSAGE);
            //创建火箭车

            GetSQL.ConnectSQL();
            Integer a=Integer.parseInt(jtf.getText());
            GetSQL.medicine_plus(a, jtf1.getText());
            //JOptionPane.showMessageDialog(null,"Successfully Inserted！","Info",JOptionPane.WARNING_MESSAGE);




        }
        if (e.getActionCommand() == "Execute -") {
            //JOptionPane.showMessageDialog(null,"查询成功！","提示消息",JOptionPane.WARNING_MESSAGE);
            //创建火箭车

            GetSQL.ConnectSQL();
            Integer a=Integer.parseInt(jtf.getText());
            GetSQL.medicine_minus(a, jtf1.getText());
            //JOptionPane.showMessageDialog(null,"Successfully Inserted！","Info",JOptionPane.WARNING_MESSAGE);




        }
        if (e.getActionCommand() == "Back to medicine main") {
            //创建火箭车

            dispose();
            MEDICINE_UI c = new MEDICINE_UI();



        }
        if (e.getActionCommand() == "Query for prescription") {
            //JOptionPane.showMessageDialog(null,"查询成功！","提示消息",JOptionPane.WARNING_MESSAGE);
            //创建火箭车

            Hospital.GetSQL.ConnectSQL();
            Integer a=Integer.parseInt(jtf2.getText());
            GetSQL.medicine_query3(a);
            jtable.setValueAt("prescriptionNo", 0, 0);
            jtable.setValueAt("Description:", 1, 0);


            jtable.setValueAt(GetSQL.prescript_no, 0, 1);
            jtable.setValueAt(GetSQL.description, 1, 1);




        }

    }
}
