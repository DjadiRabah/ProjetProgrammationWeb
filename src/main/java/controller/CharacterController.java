package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import model.dao.CharacterDao;
import model.dao.DaoFactory;
import model.pojo.Character;
import model.pojo.Pojo;

@Controller
public class CharacterController
{	
	@RequestMapping(value = "/updateCharacter", method = RequestMethod.GET)
	public @ResponseBody void updateCharacter(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, IOException 
	{
		String json = request.getParameter("json");
		Character pojo = new Gson().fromJson(json, Character.class);
		DaoFactory.getInstance().getCharacterDao().update(pojo);
	}
	
	@RequestMapping(value = "/insertCharacter", method = RequestMethod.GET)
	public @ResponseBody String insertCharacter(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, IOException 
	{
		String json = request.getParameter("json");
		Character pojo = new Gson().fromJson(json, Character.class);
		int id = DaoFactory.getInstance().getCharacterDao().insert(pojo);
		return "/formCharacter.html?id="+id;
	}

	public CharacterDao getDao() 
	{
		return DaoFactory.getInstance().getCharacterDao();
	}
	
	@RequestMapping(value = "/characters", method = RequestMethod.GET)
	public @ResponseBody List<Character> getAll(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, IOException {
		try {
				return getDao().getAll();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	@RequestMapping(value = "/character", method = RequestMethod.GET)
	public @ResponseBody  Pojo getCharacterById( HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, IOException 
	{
		String idString = request.getParameter("id");
		if (idString == null)
			return null;
		int id = Integer.parseInt(idString);
		return getDao().getById(id);
	}
	
	
}
