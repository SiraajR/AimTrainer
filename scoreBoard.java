import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class scoreBoard{

    public void insertScore(int run , int score){
        try{
            String url = "jdbc:mysql://localhost:3306/";
            String dataBase = "scoreBoard";
            String userName = "root";
            String pass = "siraaj.rizvi";

            Connection conn = DriverManager.getConnection(url+dataBase, userName, pass);
            Statement st = conn.createStatement();
            String query = "INSERT into scoreBoard VALUES ("+run+","+score+")";
            st.execute(query);
            System.out.println("Run added successfully");
            conn.close();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void deleteAll(){
        try{
            String url = "jdbc:mysql://localhost:3306/";
            String dataBase = "scoreBoard";
            String userName = "root";
            String pass = "siraaj.rizvi";

            Connection conn = DriverManager.getConnection(url+dataBase, userName, pass);
            Statement st = conn.createStatement();
            String query = "TRUNCATE TABLE scoreBoard";
            st.execute(query);
            System.out.println("Truncated successfully");
            conn.close();

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
    public int getLastRunNumber() {
        int lastRunNumber = 0;
        try {
            String url = "jdbc:mysql://localhost:3306/scoreBoard";
            String username = "root";
            String password = "siraaj.rizvi";
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String query = "SELECT MAX(No) FROM scoreBoard";
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                lastRunNumber = resultSet.getInt(1);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lastRunNumber;
    }
}
 