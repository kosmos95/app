package flutter.app;

import flutter.app.repository.memberRepository.MemberRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

//	@Bean
//	public TestDataInit testDataInit(MemberRepository memberRepository) {
//		return new TestDataInit(memberRepository);
//	}

}
