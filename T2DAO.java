package pokemon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/** テーブルt2に対するDAO */
public class T2DAO {
	/** クラスの初期化時に一度だけ実行される */
	static {
		try {
			Class.forName("org.h2.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** テーブルt2のすべてのデータを返す */
	public List<Pokemon> findAll() {
		List<Pokemon> pokemonList = new ArrayList<Pokemon>();
		String url = "jdbc:h2:tcp://localhost/f:/h2/s1732126";
		try (Connection conn = DriverManager.getConnection(url, "user", "pass");) {
			String sql = "SELECT 番号,名前,攻撃力 FROM t2";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			int rows = 0;
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				rows++;
				int number = rs.getInt("番号");
				String name = rs.getString("名前");
				int attack = rs.getInt("攻撃力");
				Pokemon pokemon = new Pokemon();
				pokemon.setNumber(number);
				pokemon.setName(name);
				pokemon.setAttack(attack);
				pokemonList.add(pokemon);
			}
			System.out.println(rows + "件");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return pokemonList;
	}

	/** テーブルt2にデータを追加する．成功したらtrueを返す */
	public boolean create(int number, String name, int attack) {
		String url = "jdbc:h2:tcp://localhost/f:/h2/s1732126";
		try (Connection conn = DriverManager.getConnection(url, "user", "pass");) {
			String sql = "INSERT INTO T2(番号,名前,攻撃力) VALUES(?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, number);
			pStmt.setString(2, name);
			pStmt.setInt(3, attack);
			int result = pStmt.executeUpdate();
			if (result != 1)
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(int number) {
		String url = "jdbc:h2:tcp://localhost/f:/h2/s1732126";
		try (Connection conn = DriverManager.getConnection(url, "user", "pass");) {
			String sql = "DELETE FROM T2 WHERE 番号 = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, number);
			int result = pStmt.executeUpdate();
			if (result != 1)
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(String name, int attack,int number) {
		String url = "jdbc:h2:tcp://localhost/f:/h2/s1732126";
		try (Connection conn = DriverManager.getConnection(url, "user", "pass");) {
			if(number != 0 && name != "null" && attack != 0)
			{
			 String sql ="UPDATE T2 SET 名前=?,攻撃力=? WHERE 番号=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, name);
				pStmt.setInt(2, attack);
				pStmt.setInt(3, number);
				int result = pStmt.executeUpdate();
				if (result != 1)
					return false;
			}
			else if(number != 0 && name != "null")
			{
				 String sql ="UPDATE T2 SET 名前=? WHERE 番号=?";
					PreparedStatement pStmt = conn.prepareStatement(sql);
					pStmt.setString(1, name);
					pStmt.setInt(2, number);
					int result = pStmt.executeUpdate();
					if (result != 1)
						return false;
			}
			else if(number != 0 && attack != 0)
			{
				 String sql ="UPDATE T2 SET 攻撃力=? WHERE 番号=?";
					PreparedStatement pStmt = conn.prepareStatement(sql);
					pStmt.setInt(1, attack);
					pStmt.setInt(2, number);
				int result = pStmt.executeUpdate();
				if (result != 1)
					return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}