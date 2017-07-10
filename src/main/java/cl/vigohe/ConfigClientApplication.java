package cl.vigohe;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@SpringBootApplication
public class ConfigClientApplication {

	@Value("${example.raw}")
	private String exampleRaw;

	@Value("${example.encrypted}")
	private String exampleEncrypted;

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

	@GetMapping("/api/example/raw")
	public String getExampleRaw() {
		return exampleRaw;
	}

	@GetMapping("/api/example/encrypted")
	public String getExampleEncrypted() {
		return exampleEncrypted;
	}


}
