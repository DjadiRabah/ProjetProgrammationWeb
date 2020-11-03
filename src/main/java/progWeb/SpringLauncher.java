package progWeb;



import java.sql.SQLException;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dao.DaoFactory;
import model.Universe;
import pojo.Item;
import pojo.Character;

@SpringBootApplication
public class SpringLauncher {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		SpringApplication.run(SpringLauncher.class, args);
		Universe.creation();
		DaoFactory daoFactory = DaoFactory.getInstance();
		
		List<Character> characters = daoFactory.getCharacterDao().getAll();
		List<Item> items = daoFactory.getItemDao().getAll();
		
		for(Character character : characters)
			System.out.println(character);
		
		for(Item item : items)
			System.out.println(item);
		
	}
}
