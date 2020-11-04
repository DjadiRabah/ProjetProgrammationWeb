package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.pojo.Character;

public class CharacterDao  extends Dao<Character>
{
	private static CharacterDao characterDao; 
	
	private CharacterDao() 
	{
		this.table = "characterprojet";
	}
	
	public static synchronized CharacterDao getInstance()
	{
		if (characterDao == null)
			characterDao = new CharacterDao();
		return characterDao;
	}
	
	@Override
	public void insert(Character pojo) 
	{
		try 
		{
			String query =  "INSERT INTO " + this.table + "(idCharacter, nameCharacter, loreCharacter, hpCharacter, attackCharacter, defenseCharacter, dodgeCharacter) VALUES (?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement preparedStatement = DaoConnection.getInstance().prepareStatement(query);
			preparedStatement.setInt(1, pojo.getId());
			preparedStatement.setString (2, pojo.getName());
			preparedStatement.setString (3, pojo.getLore());
			preparedStatement.setInt(4, pojo.getHpMax());
			preparedStatement.setInt(5, pojo.getAttack());
			preparedStatement.setInt(6, pojo.getDefense());
			preparedStatement.setDouble(7, pojo.getDodge());
			
			preparedStatement.execute();
			preparedStatement.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Character> getAll() 
	{
		try 
		{
			List<Character> characters = new ArrayList<>();
			String sql =  "select * from " + this.table;
			Statement statement = DaoConnection.getInstance().createStatement();
		    ResultSet resultSet = statement.executeQuery(sql);
		    while (resultSet.next()) 
		    {
		    	int id = resultSet.getInt("idCharacter");
		    	String name = resultSet.getString("nameCharacter");
		    	String lore = resultSet.getString("loreCharacter");
		    	int hp = resultSet.getInt("hpCharacter");
		    	int attack = resultSet.getInt("attackCharacter");
		    	int defense = resultSet.getInt("defenseCharacter");
		    	double dodge = resultSet.getDouble("dodgeCharacter");
		    	characters.add(new Character(id, name, lore, hp, attack, defense, dodge));
			}
		    resultSet.close();
		    statement.close();
		    
		    return characters;
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	    return null;
	}
}
