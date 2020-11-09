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

import com.google.gson.Gson;

import model.dao.Dao;
import model.dao.DaoFactory;
import model.pojo.Character;
import model.pojo.Story;

@Controller
public class StoryController
{
	protected Dao<Story> getDao() {
		return DaoFactory.getInstance().getStoryDao();
	}
	
	@RequestMapping(value = "/story", method = RequestMethod.GET)
	public @ResponseBody Story getStoryById(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, IOException 
	{
		String idString = request.getParameter("id");
		if (idString == null)
			return null;
		int id = Integer.parseInt(idString);
		return getDao().getById(id);
	}

	@RequestMapping(value = "/storys", method = RequestMethod.GET)
	public @ResponseBody List<Story> getAll(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, IOException {
		return getDao().getAll();
	}
	
	@RequestMapping(value = "/insertStory", method = RequestMethod.GET)
	public @ResponseBody String insertStory(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException, IOException 
	{
		String json = request.getParameter("json");
		Story pojo = new Gson().fromJson(json, Story.class);
		int id = getDao().insert(pojo);
		return "/formStory.html?id="+id;
	}
}
