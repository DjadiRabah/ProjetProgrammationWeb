package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.pojo.Character;

public class CharacterDao extends Dao<Character> {
	private static CharacterDao characterDao;

	private CharacterDao() {
		this.table = "characterprojet";
	}

	public static synchronized CharacterDao getInstance() {
		if (characterDao == null)
			characterDao = new CharacterDao();
		return characterDao;
	}

	@Override
	public int insert(Character pojo) {
		try {
			String query = "INSERT INTO " + this.table
					+ "(idCharacter, nameCharacter, loreCharacter, filenameCharacter, hpCharacter, attackCharacter, defenseCharacter, dodgeCharacter) VALUES (?,?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement preparedStatement = DaoConnection.getInstance().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, pojo.getId());
			preparedStatement.setString(2, pojo.getName());
			preparedStatement.setString(3, pojo.getLore());
			preparedStatement.setString(4, pojo.getFilename());
			preparedStatement.setInt(5, pojo.getHpMax());
			preparedStatement.setInt(6, pojo.getAttack());
			preparedStatement.setInt(7, pojo.getDefense());
			preparedStatement.setDouble(8, pojo.getDodge());
			preparedStatement.executeUpdate();
			
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();
			int id =  resultSet.getInt(1);
			preparedStatement.close();
			resultSet.close();
			
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public List<Character> getAll() {
		try {
			List<Character> characters = new ArrayList<>();
			String sql = "select * from " + this.table;
			Statement statement = DaoConnection.getInstance().createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				int id = resultSet.getInt("idCharacter");
				String name = resultSet.getString("nameCharacter");
				String lore = resultSet.getString("loreCharacter");
				String fileName = resultSet.getString("filenameCharacter");
				int hp = resultSet.getInt("hpCharacter");
				int attack = resultSet.getInt("attackCharacter");
				int defense = resultSet.getInt("defenseCharacter");
				double dodge = resultSet.getDouble("dodgeCharacter");
				characters.add(new Character(id, name, lore, fileName, hp, attack, defense, dodge));
			}
			resultSet.close();
			statement.close();

			return characters;
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Character getById(int idPojo) {
		try {
			Character pojo = null;
			String sql = "select * from " + this.table + " WHERE idCharacter = ?";
			PreparedStatement statement = DaoConnection.getInstance().prepareStatement(sql);
			statement.setInt(1, idPojo);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("idCharacter");
				String name = resultSet.getString("nameCharacter");
				String lore = resultSet.getString("loreCharacter");
				String fileName = resultSet.getString("filenameCharacter");
				int hp = resultSet.getInt("hpCharacter");
				int attack = resultSet.getInt("attackCharacter");
				int defense = resultSet.getInt("defenseCharacter");
				double dodge = resultSet.getDouble("dodgeCharacter");
				pojo = new Character(id, name, lore, fileName, hp, attack, defense, dodge);
			}
			resultSet.close();
			statement.close();

			return pojo;
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(Character pojo) 
	{
		try 
		{
			String sql =  "UPDATE " + this.table + " SET nameCharacter = ?, loreCharacter = ?,filenameCharacter = ?, hpCharacter = ?, attackCharacter = ?, defenseCharacter = ?, dodgeCharacter = ?"
					+ " WHERE idCharacter = ?";
			PreparedStatement statement = DaoConnection.getInstance().prepareStatement(sql);    
			statement.setString(1, pojo.getName());
			statement.setString(2, pojo.getLore());
			statement.setString(3, pojo.getFilename());
			statement.setInt(4, pojo.getHpMax());
			statement.setInt(5, pojo.getAttack());
			statement.setInt(6, pojo.getDefense());
			statement.setDouble(7, pojo.getDefense());
			statement.setInt(8, pojo.getId());
		    statement.executeUpdate();
		    statement.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
