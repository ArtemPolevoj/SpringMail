package spring.mail;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MailApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MailApplication.class, args);
		//SpringApplication.run(MailApplication.class, args);
		EmailServiceImp emailServiceImp = context.getBean(EmailServiceImp.class);
		emailServiceImp.sendEmail("artempolevoj@yandex.ru","subject","message");
		emailServiceImp.print();

	}

}
