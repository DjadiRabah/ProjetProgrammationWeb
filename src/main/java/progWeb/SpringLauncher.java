package progWeb;



import java.sql.SQLException;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import model.dao.DaoConnection;
import model.dao.DaoFactory;
import model.pojo.Character;
import model.pojo.Item;

@SpringBootApplication
public class SpringLauncher {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		SpringApplication.run(SpringLauncher.class, args);
	}
}
