package model.dao;

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
	
}
