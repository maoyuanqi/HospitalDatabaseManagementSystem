package Hospital;

/**
 * Created by maoyuanqi on 2017/12/4.
 */


import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FINANCE_UI extends JFrame implements ActionListener {


    JButton jb,jb1,jb6= null;
    JPanel jp,jp1= null;

    //构造函数
    public FINANCE_UI() {


        jb = new JButton("Get Employee Paycheck");
        jb1 = new JButton("Get Patient Payment");

        jb6=new JButton("Back to login");
        //设置监听
        jb.addActionListener(this);
        jb1.addActionListener(this);

        jb6.addActionListener(this);

        jp=new JPanel();
        jp1 = new JPanel();

        jp.add(jb);
        jp.add(jb1);

        jp1.add(jb6);


        this.add(jp);
        this.add(jp1);

        this.setLayout(new GridLayout(2, 3));
        this.setTitle("FINANCE Department");
        this.setSize(500, 400);
        this.setLocation(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


    }


    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand() == "Get Employee Paycheck") {

                dispose();
                FINANCE_PAYCHECK_UI f=new FINANCE_PAYCHECK_UI();





        }

        if(e.getActionCommand() == "Get Patient Payment"){
                dispose();
           FINANCE_PAYMENT_UI f=new FINANCE_PAYMENT_UI();


        }
        if (e.getActionCommand() == "Back to login") {


            dispose();
            Login l = new Login();



        }

    }
}
