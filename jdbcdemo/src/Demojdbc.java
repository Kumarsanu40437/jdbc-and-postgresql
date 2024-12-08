import java.sql.*;
public class Demojdbc {
     public static void main(String[] args) throws Exception{
           /*steps involed in connection with database
        import package
        load and register
        create connection
        execute statement
        process the results
        close
         */
          //if we have to take input from user
          int studentid= 101;
          String name="Animesh";
          int marks=48;
          String url= "jdbc:postgresql://localhost:5432/demo";
          String uname= "postgres";
          String pass="1234";

          //writing query for querying input from the user using PreparedStatement

         String sql="insert into Students values (?,?,?)";//We can not only use these for creating,we can use it for all crud operations just use ? where we have to use dynamic data

          //writing query for fetching data from table
          //String str="select name from Students where studentid = 1";
          //String sql="select * from students";
          //String sql="insert into Students values (5,'John',48)";//create
          //String sql="update Students set name='Max' where studentid=5";//update
          //String sql="delete from Students where studentid=5";//Delete
          Class.forName("org.postgresql.Driver"); //this is how you load the driver
          //create connection
          Connection con=DriverManager.getConnection(url,uname,pass);
          //System.out.println("connection established");

          //fetching information .For this we have to make an object of the connection which is an interface.
          //Statement st=con.createStatement();// connection interface has its own method known as .createStatement which is mainly used to change in the table or altering the table

          //for other purpose we use PreparedStatement
          PreparedStatement st=con.prepareStatement(sql);
          st.setInt(1,studentid);
          st.setString(2,name);
          st.setInt(3,marks);
          st.execute();
          //we get the result in the form of a set
          //ResultSet rs=st.executeQuery(sql);//executeQuery returns a string value
          //boolean status=st.execute(sql);//it returns a boolean value whether our query got executed

          //System.out.println(rs.next());
          //rs.next();
          //String name=rs.getString("name");//just give the entry of a single column in first r
          //rs.next():
          //This moves the cursor of the ResultSet to the next row.
          //When a query is executed (e.g., using Statement.executeQuery()), the cursor of the ResultSet is initially positioned before the first row.
          //Calling rs.next() moves the cursor to the first row (or subsequent rows when called repeatedly).
          //It returns: //true if there is a valid row to access.
          //false if there are no more rows.
          //rs.getString("name"):
          //The value is returned as a String.
          //How it Works Together:
          //rs.next() is called to move the cursor to the first row (or the next row in a loop).
          //After moving the cursor, rs.getString("name") retrieves the value from the column named name.
          //System.out.println("Name of student is" + name);

          //suppose we want to print all dataset means all rows
//          while(rs.next()){//till it is returning true value it will put pointer to the next row
//          System.out.print(rs.getInt(1) + "-");
//          System.out.print(rs.getString(2) + "-");
//          System.out.println(rs.getInt(3) + "-");
//
//          }
          //At above code we have completed the part of the read operation for crud operations,now what about creating,deleting the data;
          //first change the sql query

          con.close();
          System.out.println("connection closed");

     }
}
