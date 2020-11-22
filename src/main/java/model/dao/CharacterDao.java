package model.dao;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.pojo.Character;

public class CharacterDao extends Dao<Character> {
	private static CharacterDao characterDao;

	public static synchronized CharacterDao getInstance() {
		if (characterDao == null)
			characterDao = new CharacterDao();
		return characterDao;
	}

//	@Override
//	public void update(Character pojo) 
//	{
//		try 
//		{
//			String sql =  "UPDATE " + this.table + " SET nameCharacter = ?, loreCharacter = ?,filenameCharacter = ?, hpCharacter = ?, attackCharacter = ?, defenseCharacter = ?, dodgeCharacter = ?"
//					+ " WHERE idCharacter = ?";
//			PreparedStatement statement = DaoConnection.getInstance().prepareStatement(sql);    
//			statement.setString(1, pojo.getName());
//			statement.setString(2, pojo.getLore());
//			statement.setString(3, pojo.getFilename());
//			statement.setInt(4, pojo.getHp());
//			statement.setInt(5, pojo.getAttack());
//			statement.setInt(6, pojo.getDefense());
//			statement.setDouble(7, pojo.getDefense());
//			statement.setInt(8, pojo.getId());
//		    statement.executeUpdate();
//		    statement.close();
//		}
//		catch (SQLException e) 
//		{
//			e.printStackTrace();
//		}
//	}

	@Override
	public Class<Character> getPojoClass() 
	{
		return Character.class;
	}

	@Override
	public String getTableName() 
	{
		return "characterprojet";
	}
	private List<Character> getPlayableCharacters(int playable)
	{
		try {
			List<Character> characters = new ArrayList<>();
			String sql = "select * from " + getTableName() + " where playableCharacter = " + playable;
			
			Statement statement = DaoConnection.getInstance().createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				Character character = new Character();
				for (Field attribute : getPojoClass().getDeclaredFields()) {
					String attributeName = attribute.getName().substring(0, 1).toUpperCase()
							+ attribute.getName().substring(1);
					Class<?> attributeClass = attribute.getType();
					String attributeClassName = attributeClass.getSimpleName().substring(0, 1).toUpperCase()
							+ attributeClass.getSimpleName().substring(1);
					Method methodPojo = getPojoClass().getMethod("set" + attributeName, attributeClass);
					Method methodResultSet = ResultSet.class.getMethod("get" + attributeClassName, String.class);
					methodPojo.invoke(character,
							methodResultSet.invoke(resultSet, attribute.getName() + getPojoClass().getSimpleName()));
				}
				characters.add(character);
			}

			resultSet.close();
			statement.close();

			return characters;
		}

		catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Character> getPlayableCharacters()
	{
		return getPlayableCharacters(1);
	}
	
	public List<Character> getUnplayableCharacters()
	{
		return getPlayableCharacters(0);
	}
	
}
