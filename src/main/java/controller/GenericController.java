package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import model.dao.Dao;
import model.dao.DaoFactory;
import model.pojo.Pojo;

public abstract class GenericController {
	public DaoFactory getDaoFactory() {
		return DaoFactory.getInstance();
	}
	
	public abstract Dao<?> getDao();

	@RequestMapping(value = "/{pojo}s", method = RequestMethod.GET)
	public @ResponseBody List<?> getAll(@PathVariable("pojo") String pojo,
			HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, IOException {
		try {
				return getDao().getAll();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	@RequestMapping(value = "/character/{id}", method = RequestMethod.GET)
	public @ResponseBody  Pojo getCharacterById( @PathVariable("id") int id)
			throws UnsupportedEncodingException, IOException 
	{
//		String idString = request.getParameter("id");
//		if (idString == null)
//			return null;
//		int id = Integer.parseInt(idString);
		return getDao().getById(id);
	}
}
