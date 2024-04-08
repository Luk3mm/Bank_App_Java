package dbobjects;

import java.math.BigDecimal;
import java.sql.*;

public class DbJDBC {
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/bankapp";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "3004";

    public static User validateLogin(String username, String password){
        try{
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            //sql query
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM users WHERE username = ? AND password = ?"
            );

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                int userId = resultSet.getInt("id");

                BigDecimal currentBalance = resultSet.getBigDecimal("current_balance");

                return new User(userId, username, password, currentBalance);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public static boolean register(String username, String password){
        try{
            if(!checkUser(username)){
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

                PreparedStatement preparedStatement = connection.prepareStatement(
                        "INSERT INTO users(username, password, current_balance)" + "VAlUES(?, ?, ?)"
                );

                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                preparedStatement.setBigDecimal(3, new BigDecimal(0));
                preparedStatement.executeUpdate();

                return true;
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    private static boolean checkUser(String username){
        try{
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM users WHERE username = ?"
            );
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(!resultSet.next()){
                return false;
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return true;
    }

    public static boolean addTransactionToDatabase(Transaction transaction){
        try{
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            PreparedStatement insertTransaction = connection.prepareStatement(
                "INSERT transactions(user_id, transaction_type, transaction_amount, transaction_date)" +
                        "VALUES(?, ? ,? NOW())"
            );

            insertTransaction.setInt(1, transaction.getUserId());
            insertTransaction.setString(2, transaction.getTransactionType());
            insertTransaction.setBigDecimal(3, transaction.getTransactionAmount());

            return true;
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    public static boolean updateCurrentBalance(User user){
        try{
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            PreparedStatement updateBalance = connection.prepareStatement(
                "UPDATE users SET current_balance = ? WHERE id = ?"
            );

            updateBalance.setBigDecimal(1, user.getCurrentBalance());
            updateBalance.setInt(2, user.getId());
            updateBalance.executeUpdate();

            return true;
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return false;
    }
}
