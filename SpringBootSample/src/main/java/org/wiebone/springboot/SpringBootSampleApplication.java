package org.wiebone.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.wiebone.springboot.producer.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class SpringBootSampleApplication implements CommandLineRunner {
	
	public static void main(String[] args) {	
		SpringApplication.run(SpringBootSampleApplication.class, args);
	}
	
	@Autowired
    private Sender sender;
	
	@Override
    public void run(String... strings) throws Exception {
		System.out.println(sender);
		sender.send("Kafka Example");
    }
}
