package progWeb;



import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.datetime.DateTimeFormatAnnotationFormatterFactory;

import dao.Dao;
import dao.DaoFactory;
import model.Universe;




@SpringBootApplication
public class SpringLauncher {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		SpringApplication.run(SpringLauncher.class, args);
		Universe.creation();
		DaoFactory daoFactory = DaoFactory.getInstance();
		daoFactory.getItemDao().getAll();
	}
}
