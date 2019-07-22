package pokemon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectPokemonSample {
public static void main(String args[]) {
 try {
 Class.forName("org.h2.Driver");
 } catch (Exception e) {
 e.printStackTrace();
 }
 String url = "jdbc:h2:tcp://localhost/f:/h2/s1732126";
 try (Connection conn = DriverManager.getConnection(url, "user", "pass");) {
 String sql = "SELECT 番号,名前,攻撃力,防御力,体力 FROM pokemon";
 PreparedStatement pStmt = conn.prepareStatement(sql);
 ResultSet rs = pStmt.executeQuery();
 while (rs.next()) {
 int number = rs.getInt("番号");
 String name = rs.getString("名前");
 int attack = rs.getInt("攻撃力");
 int defence = rs.getInt("防御力");
 int stamina = rs.getInt("体力");
 System.out.printf("%3d [%3d %3d %3d] %s\n",
 number, attack, defence, stamina, name);
 }
 } catch (SQLException e) {
 e.printStackTrace();
 }
 }
}
