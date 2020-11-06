package model.dao;

import java.util.List;

public abstract class Dao<T>
{
	protected String table;
	
	public abstract int insert(T pojo);
	public abstract void update(T pojo);
	public abstract T getById(int idPojo);
	public abstract List<T> getAll();
}
