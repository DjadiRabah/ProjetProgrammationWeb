package model.dao;

import model.pojo.Item;

public class ItemDao extends Dao<Item> {
	private static ItemDao itemDao;

	public static synchronized ItemDao getInstance() {
		if (itemDao == null)
			itemDao = new ItemDao();
		return itemDao;
	}

	@Override
	public Class<Item> getPojoClass() 
	{
		return Item.class;
	}

	@Override
	public String getTableName() 
	{
		return "item";
	}
}
