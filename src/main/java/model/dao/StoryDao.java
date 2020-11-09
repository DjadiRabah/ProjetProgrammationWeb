package model.dao;

import model.pojo.Story;

public class StoryDao extends Dao<Story>
{
	private static StoryDao dao;

	public static synchronized StoryDao getInstance() {
		if (dao == null)
			dao = new StoryDao();
		return dao;
	}

	@Override
	public Class<Story> getPojoClass() 
	{
		return Story.class;
	}

	@Override
	public String getTableName() 
	{
		return "story";
	}

}
