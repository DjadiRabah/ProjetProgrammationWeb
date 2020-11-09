package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import model.dao.DaoFactory;
import model.pojo.Item;

@Controller
public class ItemController
{	
	@RequestMapping(value = "/item", method = RequestMethod.GET)
	public @ResponseBody Item getItemById(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, IOException 
	{
		String idString = request.getParameter("id");
		if (idString == null)
			return null;
		int id = Integer.parseInt(idString);
		return DaoFactory.getInstance().getItemDao().getById(id);
	}

	@RequestMapping(value = "/items", method = RequestMethod.GET)
	public @ResponseBody List<Item> getItems(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, IOException 
	{
		return DaoFactory.getInstance().getItemDao().getAll();
	}
}
