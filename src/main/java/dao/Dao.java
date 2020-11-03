package dao;

import java.util.List;

public abstract class Dao 
{
	protected String table;
	public abstract List<?> getAll();
}
