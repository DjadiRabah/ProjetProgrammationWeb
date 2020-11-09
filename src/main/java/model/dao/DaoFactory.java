package model.dao;

public class DaoFactory 
{
	private static DaoFactory daoFactory;

	private DaoFactory() 
	{
	}
	
	public static synchronized DaoFactory getInstance()
	{
		if (daoFactory == null)
			daoFactory = new DaoFactory();
		return daoFactory;
	}
	
	public CharacterDao getCharacterDao()
	{
		return CharacterDao.getInstance();
	}
	
	public ItemDao getItemDao()
	{
		return ItemDao.getInstance();
	}
	
	public StoryDao getStoryDao()
	{
		return StoryDao.getInstance();
	}

}
