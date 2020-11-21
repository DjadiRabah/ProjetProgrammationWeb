package model.dao;

import model.pojo.Screen;

public class ScreenDao extends Dao <Screen> {
	
	private static ScreenDao screenDao;

	public static synchronized ScreenDao getInstance() {
		if (screenDao == null)
			screenDao = new ScreenDao();
		return screenDao;
	}

	@Override
	public Class<Screen> getPojoClass() {
		// TODO Auto-generated method stub
		return Screen.class;
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "Screen";
	}
	
}
