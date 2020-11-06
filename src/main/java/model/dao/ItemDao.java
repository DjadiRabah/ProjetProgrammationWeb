package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.pojo.Item;

public class ItemDao extends Dao<Item>
{
	private static ItemDao itemDao;
	
	private ItemDao() 
	{
		this.table = "Item";
	}
	
	@Override
	public int insert(Item pojo) {
		return 0;
		// TODO Auto-generated method stub
		
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
		    	double dodge = resultSet.getDouble("dodgeItem");
		    	items.add(new Item(id, name, hp, attack, defense, dodge));
			}
		    
		    return items;
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	    return null;
	}

	@Override
	public Item getById(int idPojo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Item pojo) {
		// TODO Auto-generated method stub
		
	}
}
