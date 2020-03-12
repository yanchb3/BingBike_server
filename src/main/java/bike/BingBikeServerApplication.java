package bike;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
//@MapperScan("bike.mapper") //设置mapper接口的扫描包
@SpringBootApplication
public class BingBikeServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BingBikeServerApplication.class, args);
	}

}
