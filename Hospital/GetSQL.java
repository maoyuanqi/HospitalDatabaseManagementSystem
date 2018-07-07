package Hospital;

/**
 * Created by maoyuanqi on 2017/12/4.
 */
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by maoyuanqi on 2017/12/2.
 */
class GetSQL
{
    //user name and password
    static int userword;
    static String pwd;

    static Connection ct=null;
    static PreparedStatement ps=null;
    static ResultSet rs=null;

    //hr-use
    static int username;
    static String Department;
    static String Position;
    static String Address;
    static String Name;
    //medicine-use
    static int mno;
    static int inventory;
    static int Price;
    static String medicine_Name;
    static String Vendor;
    static String Specification;
    static String Type;
    //financeq1-use
    static int[] pcno=new int[100];
    static String[] name=new String[100];
    static String[] position=new String[100];
    static int[] eNo=new int[100];
    static double[] Salary=new double[100];
    static double[] Bonus=new double[100];
    static String[] PayDate=new String[100];
    static int paycheck_count=0;
    //financeq2-use
    static int[] invoiceNo=new int[100];
    static String[] payment_name=new String[100];
    static double[] amount=new double[100];
    static String[] pay_method=new String[100];
    static String[] status=new String[100];
    static int[] payment_pNo=new int[100];
    static int payment_count=0;
    //clinic-use
    static int[] prescriptNo=new int[100];
    static int[] employeeNo=new int[100];
    static int[] patientNo=new int[100];
    static String[] Description=new String[100];
    static int history_count=0;

    //receptionist-use
    static int pNo;
    static double Money_Reserved;
    static String patient_Name;
    static String patient_Address;
    static int patient_Age;
    static String Gender;
    static String Phone;

    //medicine query 3
    static int prescript_no;
    static String description;
    static int Inventory;

    // recept query-user
    static String pati_name;
    static String pati_address;
    static int pati_age;
    static String pati_gender;
    static String pati_phone;





    //database connection, canbe inherited through sub-class.
    public static void ConnectSQL()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            ct= DriverManager.getConnection("jdbc:mysql://localhost:3306/Hospital?","root","root");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    //login query
    public static void sqlquery(String s,int e_no)
    {
        //
        try {

            ps = ct.prepareStatement("select * from Employee where Department=? AND eNo=?");
            // ？should be filled with a value, this way is much safer.
            ps.setString(1, s);
            ps.setInt(2, e_no);
            //ResultSet
            rs=ps.executeQuery();
            //fetching by loop
            while(rs.next()){
                //pull out the username n password.
                userword=rs.getInt(1);
                pwd=rs.getString(6);
                System.out.println("Successfully Matched");
                System.out.println(userword+"\t"+pwd+"\t");
            }
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();               JOptionPane.showMessageDialog(null, "Execution failed！", "Warning", JOptionPane.WARNING_MESSAGE);                     JOptionPane.showMessageDialog(null, "Execution failed！", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void hr_query(int s)
    {
        //
        try {

            ps = ct.prepareStatement("select * from Employee where eNo=?");
            // ？should be filled with a value, this way is much safer.
            ps.setInt(1, s);


            //ResultSet
            rs=ps.executeQuery();
            //fetching by loop
            while(rs.next()){
                //pull out the username n password.

                username=rs.getInt(1);
                Department=rs.getString(2);
                Position=rs.getString(3);
                Address=rs.getString(4);
                Name=rs.getString(5);


            }
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();               JOptionPane.showMessageDialog(null, "Execution failed！", "Warning", JOptionPane.WARNING_MESSAGE);                     JOptionPane.showMessageDialog(null, "Execution failed！", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void medicine_query(int s)
    {
        //
        try {

            ps = ct.prepareStatement("select * from Medicine where mNo=?");
            // ？should be filled with a value, this way is much safer.
            ps.setInt(1, s);


            //ResultSet
            rs=ps.executeQuery();
            //fetching by loop
            while(rs.next()){
                //pull out the username n password.

                mno=rs.getInt(1);
                inventory=rs.getInt(2);
                Price=rs.getInt(3);
                medicine_Name=rs.getString(4);
                Vendor=rs.getString(5);
                Specification=rs.getString(6);
                Type=rs.getString(7);


            }
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();               JOptionPane.showMessageDialog(null, "Execution failed！", "Warning", JOptionPane.WARNING_MESSAGE);                     JOptionPane.showMessageDialog(null, "Execution failed！", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void finance_query(int s)
    {
        //

        try {

            ps = ct.prepareStatement("select * from Paycheck where eNo=?");
            // ？should be filled with a value, this way is much safer.
            ps.setInt(1, s);


            //ResultSet
            rs=ps.executeQuery();
            //fetching by loop
            paycheck_count=0;
            while(rs.next()){
                //pull out the username n password.

                pcno[paycheck_count]=rs.getInt(1);
                name[paycheck_count]=rs.getString(2);
                position[paycheck_count]=rs.getString(3);
                eNo[paycheck_count]=rs.getInt(4);
                Salary[paycheck_count]=rs.getDouble(5);
                Bonus[paycheck_count]=rs.getDouble(6);
                PayDate[paycheck_count]=rs.getString(7);
                paycheck_count++;
//                inventory=rs.getInt(2);
//                Price=rs.getInt(3);
//                medicine_Name=rs.getString(4);
//                Vendor=rs.getString(5);
//                Specification=rs.getString(6);
//                Type=rs.getString(7);


            }
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();               JOptionPane.showMessageDialog(null, "Execution failed！", "Warning", JOptionPane.WARNING_MESSAGE);                     JOptionPane.showMessageDialog(null, "Execution failed！", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void finance_query2(int s)
{
    //
    try {

        ps = ct.prepareStatement("select * from payment where pNo=?");
        // ？should be filled with a value, this way is much safer.
        ps.setInt(1, s);


        //ResultSet
        rs=ps.executeQuery();
        payment_count=0;
        //fetching by loop
        while(rs.next()){
            //pull out the username n password.

            invoiceNo[payment_count]=rs.getInt(1);
            payment_name[payment_count]=rs.getString(2);
            amount[payment_count]=rs.getDouble(3);
            pay_method[payment_count]=rs.getString(4);
            status[payment_count]=rs.getString(5);
            payment_pNo[payment_count]=rs.getInt(6);
            payment_count++;




        }
    } catch (Exception e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();               JOptionPane.showMessageDialog(null, "Execution failed！", "Warning", JOptionPane.WARNING_MESSAGE);                     JOptionPane.showMessageDialog(null, "Execution failed！", "Warning", JOptionPane.WARNING_MESSAGE);
    }
}
    public static void Receptionist_query(int s)
    {
        //
        try {

            ps = ct.prepareStatement("select * from patient where pNo=?");
            // ？should be filled with a value, this way is much safer.
            ps.setInt(1, s);


            //ResultSet
            rs=ps.executeQuery();
            //fetching by loop
            while(rs.next()){
                //pull out the username n password.

                pNo=rs.getInt(1);
                Money_Reserved=rs.getDouble(2);
                patient_Name=rs.getString(3);
                patient_Address=rs.getString(4);
                patient_Age=rs.getInt(5);
                Gender=rs.getString(6);
                Phone=rs.getString(7);


            }
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();               JOptionPane.showMessageDialog(null, "Execution failed！", "Warning", JOptionPane.WARNING_MESSAGE);                     JOptionPane.showMessageDialog(null, "Execution failed！", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
    public static void clinic_query(int s)
    {
        //
        try {

            ps = ct.prepareStatement("select * from Prescription where pNo=?");
            // ？should be filled with a value, this way is much safer.
            ps.setInt(1, s);


            //ResultSet
            rs=ps.executeQuery();
            history_count=0;
            //fetching by loop
            while(rs.next()){
                //pull out the username n password.

                prescriptNo[history_count]=rs.getInt(1);
                employeeNo[history_count]=rs.getInt(2);
                patientNo[history_count]=rs.getInt(3);
                Description[history_count]=rs.getString(4);
                history_count++;


            }
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();               JOptionPane.showMessageDialog(null, "Execution failed！", "Warning", JOptionPane.WARNING_MESSAGE);                     JOptionPane.showMessageDialog(null, "Execution failed！", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void clinic_query2(int empNo,int pNo,String description)
    {
        //
        try {

            ps = ct.prepareStatement("insert into Prescription(eNo,pNo,Description) values (?,?,?)");
            // ？should be filled with a value, this way is much safer.
           // ps.setInt(1, psNo);
            ps.setInt(1, empNo);
            ps.setInt(2, pNo);
            ps.setString(3, description);


            //ResultSet
            ps.execute();
            System.out.println("Successfully inserted");
            JOptionPane.showMessageDialog(null, "Insert Success！", "Warning", JOptionPane.WARNING_MESSAGE);


            //fetching by loop
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();               JOptionPane.showMessageDialog(null, "Execution failed！", "Warning", JOptionPane.WARNING_MESSAGE);                     JOptionPane.showMessageDialog(null, "Execution failed！", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void medicine_plus(int medicineNo,String quantity)
    {
        //
        try {
            int q = Integer.parseInt(quantity);
            ps = ct.prepareStatement("update Medicine set Inventory = Inventory + ? where mNo = ?");
            // ？should be filled with a value, this way is much safer.

            ps.setInt(1,q);
            ps.setInt(2, medicineNo);


            //ResultSet
            ps.execute();
            System.out.println("Successfully modified");
            JOptionPane.showMessageDialog(null, "Modification Success！", "Warning", JOptionPane.WARNING_MESSAGE);


            //fetching by loop
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();               JOptionPane.showMessageDialog(null, "Execution failed！", "Warning", JOptionPane.WARNING_MESSAGE);                     JOptionPane.showMessageDialog(null, "Execution failed！", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
    public static void medicine_minus(int medicineNo,String quantity)
    {
        //
        try {
            int q = Integer.parseInt(quantity);
            ps = ct.prepareStatement("update Medicine set Inventory = Inventory - ? where mNo = ?");
            // ？should be filled with a value, this way is much safer.

            ps.setInt(1,q);
            ps.setInt(2, medicineNo);


            //ResultSet
            ps.execute();
            System.out.println("Successfully modified");
            JOptionPane.showMessageDialog(null, "Modification Success！", "Warning", JOptionPane.WARNING_MESSAGE);




            //fetching by loop
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();               JOptionPane.showMessageDialog(null, "Execution failed！", "Warning", JOptionPane.WARNING_MESSAGE);                     JOptionPane.showMessageDialog(null, "Execution failed！", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void medicine_query3(int prescriptionNo)
    {
        //
        try {

            ps = ct.prepareStatement("select prescription_No, Description from Prescription where prescription_No = ? ");
            // ？should be filled with a value, this way is much safer.

            ps.setInt(1, prescriptionNo);



            //ResultSet
            rs=ps.executeQuery();
            while(rs.next()){
                //pull out the username n password.

                prescript_no=rs.getInt(1);
                description =  rs.getString(2);


            }

            //fetching by loop
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();               JOptionPane.showMessageDialog(null, "Execution failed！", "Warning", JOptionPane.WARNING_MESSAGE);                     JOptionPane.showMessageDialog(null, "Execution failed！", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void recept_query(String name, String address,int age, String gender, String phone)
    {
        //
        try {

            ps = ct.prepareStatement("insert into patient(Money_Reserved,Name,Address,Age,Gender,Phone) values (0,?,?,?,?,?)");
            // ？should be filled with a value, this way is much safer.
            // ps.setInt(1, psNo);
            ps.setString(1, name);
            ps.setString(2, address);
            ps.setInt(3, age);
            ps.setString(4, gender);
            ps.setString(5, phone);



            //ResultSet
            ps.execute();
            System.out.println("Successfully inserted");
            JOptionPane.showMessageDialog(null, "Insert Success！", "Warning", JOptionPane.WARNING_MESSAGE);


            //fetching by loop
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null, "Execution failed！", "Warning", JOptionPane.WARNING_MESSAGE);                     JOptionPane.showMessageDialog(null, "Execution failed！", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void hr_query1(String department, String position,String address,String name, String password)
    {
        //
        try {

            ps = ct.prepareStatement("insert into Employee(Department,Position,Address,Name,Password) values (?,?,?,?,?)");
            // ？should be filled with a value, this way is much safer.
            // ps.setInt(1, psNo);
            ps.setString(1, department);
            ps.setString(2, position);
            ps.setString(3, address);
            ps.setString(4, name);
            ps.setString(5, password);



            //ResultSet
            ps.execute();
            System.out.println("Successfully inserted");
            JOptionPane.showMessageDialog(null, "Insert Success！", "Warning", JOptionPane.WARNING_MESSAGE);


            //fetching by loop
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null, "Execution failed！", "Warning", JOptionPane.WARNING_MESSAGE);                     JOptionPane.showMessageDialog(null, "Execution failed！", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

}
