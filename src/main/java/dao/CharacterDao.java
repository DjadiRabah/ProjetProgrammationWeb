package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojo.Character;

public class CharacterDao  extends Dao
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
		    	int hp = resultSet.getInt("hpCharacter");
		    	int attack = resultSet.getInt("attackCharacter");
		    	int defense = resultSet.getInt("defenseCharacter");
		    	double dodge = resultSet.getDouble("dodgeCharacter");
		    	characters.add(new Character(id, name, hp, attack, defense, dodge));
			}
		    
		    return characters;
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	    return null;
	}

}
