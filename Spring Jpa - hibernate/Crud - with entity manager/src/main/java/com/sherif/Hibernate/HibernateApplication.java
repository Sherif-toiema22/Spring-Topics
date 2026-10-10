package com.sherif.Hibernate;

import com.sherif.Hibernate.entity.Client;
import com.sherif.Hibernate.service.ClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateApplication.class, args);}

		@Bean
		public CommandLineRunner runner(ClientService clientService){
		return runner -> {
			createClient(clientService);

			readClient(clientService );
		};


		}

	private void readClient(ClientService clientService) {
		List<Client> clients=clientService.findAll();
		for (Client client:clients)
			System.out.println(client);
	}


	public Client createClient(ClientService clientService){
		Client client= new Client("Ali","khalid21","Aly@gmail.com");
		return clientService.create(client);

	}

}
