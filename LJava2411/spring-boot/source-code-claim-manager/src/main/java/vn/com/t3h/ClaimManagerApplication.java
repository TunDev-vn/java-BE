package vn.com.t3h;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "vn.com.t3h")
public class ClaimManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClaimManagerApplication.class, args);
	}

}
