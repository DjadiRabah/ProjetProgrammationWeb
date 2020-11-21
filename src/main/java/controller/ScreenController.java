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

import model.dao.DaoFactory;
import model.pojo.Pojo;
import model.pojo.Screen;

@Controller
public class ScreenController {
	
	@RequestMapping(value = "/screens", method = RequestMethod.GET)
	public @ResponseBody List<Screen> getAll(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, IOException {
		try {
				return DaoFactory.getInstance().getScreenDao().getAll();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

		return null;
	}
	@RequestMapping(value = "/screen", method = RequestMethod.GET)
	public @ResponseBody  Pojo getScreenById(HttpServletRequest request, HttpServletResponse response )
			throws UnsupportedEncodingException, IOException 
	{
		String idString = request.getParameter("id");
		if (idString == null)
			return null;
		int id = Integer.parseInt(idString);
		return DaoFactory.getInstance().getScreenDao().getById(id);
	}
}
