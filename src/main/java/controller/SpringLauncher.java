package controller;




import java.io.IOException;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import okhttp3.OkHttpClient;

@SpringBootApplication
public class SpringLauncher {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, IOException 
	{
		SpringApplication.run(SpringLauncher.class, args);
		OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
	}
}
