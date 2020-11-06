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
import model.pojo.Character;

@Controller
public class CharacterController
{
	@RequestMapping(value = "/formCharacter", method = RequestMethod.POST)
	public void insertCharacter(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, IOException 
	{
		System.out.println("LOL");
	}
	
	@RequestMapping(value = "/character", method = RequestMethod.GET)
	public @ResponseBody Character getCharacterById(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, IOException 
	{
		String idString = request.getParameter("id");
		if (idString == null)
			return null;
		int id = Integer.parseInt(idString);
		return DaoFactory.getInstance().getCharacterDao().getById(id);
	}

	
	@RequestMapping(value = "/characters", method = RequestMethod.GET)
	public @ResponseBody List<Character> getCharacters(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, IOException 
	{
		return DaoFactory.getInstance().getCharacterDao().getAll();
	}
	
	@RequestMapping(value = "/updateCharacter", method = RequestMethod.GET)
	public @ResponseBody void updateCharacter(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, IOException 
	{
		String json = request.getParameter("json");
		System.out.println(json);
	}

}
