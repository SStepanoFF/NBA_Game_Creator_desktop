package gamecreator.framework;


import java.sql.*;
import javax.swing.JOptionPane;

public class DataBase {
    private static Connection conn;
    private static Statement statement;
    private static ResultSet resultSets;

    public DataBase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");//Регистрируем драйвер
            conn = DriverManager.getConnection("jdbc:mysql://mysql-kstest2.t1.tenet:3306/nba_t1_ssstest_com_PRR_3227",
                    "member", "1234");//Установка соединения с БД
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog (null, "Can't connect to DataBase!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog (null, "Can't connect to DataBase!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String getGameID(String gameID){
        String result="Err";
        gameID=Integer.toString(Integer.parseInt(gameID) + 1);
        try{
            statement = conn.createStatement();//Готовим запрос
            while (!result.contains("0")) {
                resultSets = statement.executeQuery("SELECT count(*) as C FROM GAMES WHERE EXTERNAL_ID=" + gameID);
                while (resultSets.next()) {
                    result = resultSets.getString("C");
                }
                if(!result.contains("0")) gameID=Integer.toString(Integer.parseInt(gameID) + 1);
            }
            return gameID;
        } catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog (null, "Problen with finding GameID in DB!", "Error", JOptionPane.ERROR_MESSAGE); 
            return result;
        }
        finally{
            try {
                resultSets.close();
                statement.close();
                //conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
