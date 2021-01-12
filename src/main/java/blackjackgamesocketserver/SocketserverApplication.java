package blackjackgamesocketserver;

import blackjackgamesocketserver.logic.blackjackGameService;
import blackjackgamesocketserver.logic.roundService;
import blackjackgamesocketserver.models.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SocketserverApplication {

	public static void main(String[] args) {

		SpringApplication.run(SocketserverApplication.class, args);
	}



}
