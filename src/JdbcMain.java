
import java.sql.*;

    public class JdbcMain {

        public static final String URL = "jdbc:mysql://localhost:3306/tarr4_db?serverTimezone=UTC";
        public static final String USER = "root";
        public static final String PASSWORD = "admin";
        public static final String SQL = "select * from user where name=?";

        public static void main(String[] args) {
            try {
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement statement = connection.prepareStatement(SQL);
                statement.setString(1,"XXX");
                ResultSet resultSet = statement.executeQuery();

                while(resultSet.next()){
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String phoneNo = resultSet.getString("phone_no");

                    System.out.println("Dane z bazy: \n \t name: "+ name + "\n\t email: "+ email + "\n\t phone no:" + phoneNo);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

