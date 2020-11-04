package model.dao;

import java.util.List;

public abstract class Dao<T>
{
	protected String table;
	public abstract void insert(T pojo);
	public abstract List<?> getAll();
}
