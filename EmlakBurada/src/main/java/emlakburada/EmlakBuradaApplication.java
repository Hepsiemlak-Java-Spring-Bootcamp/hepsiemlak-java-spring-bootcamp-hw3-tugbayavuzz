package emlakburada;

import emlakburada.repository.AdvertRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class EmlakBuradaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmlakBuradaApplication.class, args);

		/*
		Singleton singleton = Singleton.getSingletonInstance();
		
		System.out.println(singleton.toString());
		
		
		Singleton singleton1 = Singleton.getSingletonInstance();
		
		System.out.println(singleton1.toString());

		 */

        //AdvertRepository advertRepository = new AdvertRepository();

    }

//	@Bean
//	public IlanService ilanService() {
//		return new IlanService();
//	}
//
//	@Bean
//	public IlanRepository ilanRespository() {
//		return new IlanRepository();
//	}

}

/*

kullanıcı
 - controller
 - service
   - client kps(feign)

kps
 - controller
 - service
   - kullanıcı doğrulama

 */
