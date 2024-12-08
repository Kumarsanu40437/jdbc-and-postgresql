import java.sql.*;
public class Main{
    public static void main(String[] args) throws Exception{
           /*
        import package
        load and register
        create connection
        execute statement
        process the results
        close
         */
        String url= "jdbc:postgresql://localhost:5432/demo";
        String uname= "postgres";
        String pass ="1234";
        Class.forName("org.postgresql.Driver"); //this is how you load the driver
        //create connection
        Connection con=DriverManager.getConnection(url,uname,pass);
        System.out.println("connection established");

    }
}