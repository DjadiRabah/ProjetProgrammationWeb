package model.dao;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.pojo.Pojo;

public abstract class Dao<T extends Pojo> {
	public abstract Class<T> getPojoClass();

	public abstract String getTableName();

	public int insert(T pojo) {
		try {
			String query = "INSERT INTO " + getTableName() + "(";
			String queryValues = " VALUES (";

			Field[] fields = getPojoClass().getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				if (i != 0) {
					query += ",";
					queryValues += ",";
				}

				String attributeName = fields[i].getName();
				query += attributeName + getPojoClass().getSimpleName();
				queryValues += "?";
			}
			queryValues += ")";
			query += ")" + queryValues;
			PreparedStatement preparedStatement = DaoConnection.getInstance().prepareStatement(query,
					Statement.RETURN_GENERATED_KEYS);

			for (int i = 0; i < fields.length; i++) {
				Field attribute = fields[i];
				String attributeName = attribute.getName().substring(0, 1).toUpperCase()
						+ attribute.getName().substring(1);
				Class<?> attributeType = attribute.getType();
				String attributeTypeName = attributeType.getSimpleName().substring(0, 1).toUpperCase()
						+ attributeType.getSimpleName().substring(1);
				Method methodPojo = getPojoClass().getMethod("get" + attributeName);
				Method methodPreparedStatement = PreparedStatement.class.getMethod("set" + attributeTypeName, int.class,
						attributeType);
				methodPreparedStatement.invoke(preparedStatement, (i + 1), methodPojo.invoke(pojo));

			}
			preparedStatement.executeUpdate();
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();
			int id = resultSet.getInt(1);
			preparedStatement.close();
			resultSet.close();

			return id;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	public void update(T pojo) {

	}

	public T getById(int idPojo) {
		try {
			T pojo = (T) getPojoClass().getConstructor().newInstance();
			String sql = "select * from " + getTableName() + " WHERE id" + getPojoClass().getSimpleName() + " = ?";
			PreparedStatement statement = DaoConnection.getInstance().prepareStatement(sql);
			statement.setInt(1, idPojo);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				for (Field attribute : getPojoClass().getDeclaredFields()) {
					String attributeName = attribute.getName().substring(0, 1).toUpperCase()
							+ attribute.getName().substring(1);
					Class<?> attributeClass = attribute.getType();
					String attributeClassName = attributeClass.getSimpleName().substring(0, 1).toUpperCase()
							+ attributeClass.getSimpleName().substring(1);
					Method methodPojo = getPojoClass().getMethod("set" + attributeName, attributeClass);
					Method methodResultSet = ResultSet.class.getMethod("get" + attributeClassName, String.class);
					methodPojo.invoke(pojo,
							methodResultSet.invoke(resultSet, attribute.getName() + getPojoClass().getSimpleName()));
				}
			}
			resultSet.close();
			statement.close();

			return pojo;
		}

		catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<T> getAll() {
		try {
			List<T> pojos = new ArrayList<>();
			String sql = "select * from " + getTableName();
			Statement statement = DaoConnection.getInstance().createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				T pojo = (T) getPojoClass().getConstructor().newInstance();
				for (Field attribute : getPojoClass().getDeclaredFields()) {
					String attributeName = attribute.getName().substring(0, 1).toUpperCase()
							+ attribute.getName().substring(1);
					Class<?> attributeClass = attribute.getType();
					String attributeClassName = attributeClass.getSimpleName().substring(0, 1).toUpperCase()
							+ attributeClass.getSimpleName().substring(1);
					Method methodPojo = getPojoClass().getMethod("set" + attributeName, attributeClass);
					Method methodResultSet = ResultSet.class.getMethod("get" + attributeClassName, String.class);
					methodPojo.invoke(pojo,
							methodResultSet.invoke(resultSet, attribute.getName() + getPojoClass().getSimpleName()));
				}
				pojos.add(pojo);
			}

			resultSet.close();
			statement.close();

			return pojos;
		}

		catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
