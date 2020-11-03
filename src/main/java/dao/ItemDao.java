package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Pojo.Item;

public class ItemDao extends Dao
{
	private static ItemDao itemDao;
	
	private ItemDao() 
	{
		this.table = "Item";
	}
	
	public static synchronized ItemDao getInstance()
	{
		if (itemDao == null)
			itemDao = new ItemDao();
		return itemDao;
	}

	@Override
	public List<Item> getAll() 
	{
		try 
		{
			List<Item> items = new ArrayList<>();
			String sql =  "select * from " + this.table;
			Statement statement = DaoConnection.getInstance().createStatement();
		    ResultSet resultSet = statement.executeQuery(sql);
		    while (resultSet.next()) 
		    {
		    	int id = resultSet.getInt("idItem");
		    	String name = resultSet.getString("nameItem");
		    	int hp = resultSet.getInt("hpItem");
		    	int attack = resultSet.getInt("attackItem");
		    	int defense = resultSet.getInt("defenseItem");
		    	int dodge = resultSet.getInt("dodgeItem");
		    	items.add(new Item(id, name, hp, attack, defense, dodge));
		    	System.out.println(new Item(id, name, hp, attack, defense, dodge));
			}
		    
		    return items;
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	    return null;
	}
}
