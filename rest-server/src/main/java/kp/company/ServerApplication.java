package kp.company;

import org.springframework.boot.SpringApplication;
/*-
 Spring MVC + Spring HATEOAS app with HAL representations of each resource
 
 HATEOAS - Hypermedia As The Engine Of Application State
 HAL - JSON Hypertext Application Language
 */
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The RESTful Web Service server application.
 *
 */
@SpringBootApplication
public class ServerApplication {

	/**
	 * The main method.
	 * 
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}
}
