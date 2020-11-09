package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import model.dao.Dao;

public abstract class AbstractController<T>
{
	protected static final String TABLE = "";
	
	protected abstract Dao<T> getDao();

	@RequestMapping(value = "/" + TABLE + "s", method = RequestMethod.GET)
	public abstract @ResponseBody List<T> getAll(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, IOException;
}
