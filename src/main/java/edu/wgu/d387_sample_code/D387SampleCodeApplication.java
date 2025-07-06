package edu.wgu.d387_sample_code;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.concurrent.ExecutorService;


import java.io.InputStream;
import java.util.Properties;


import static java.util.concurrent.Executors.newFixedThreadPool;

@SpringBootApplication
public class D387SampleCodeApplication {
	public static String fromThread1;
	public static String fromThread2;
	static ExecutorService messageExecutor = newFixedThreadPool(10);
	public static void main(String[] args) {
		SpringApplication.run(D387SampleCodeApplication.class, args);
		Properties properties=new Properties();
		messageExecutor.execute(()-> {
			try{
				InputStream stream = new ClassPathResource("welcome_en_US.properties").getInputStream();
				properties.load(stream);
				System.out.println(properties.getProperty("welcome"));
				fromThread1 = properties.getProperty("welcome");
			}
			catch (Exception e){
				e.printStackTrace();
			}
		});

		messageExecutor.execute(()-> {
			try{
				InputStream stream = new ClassPathResource("welcome_fr_CA.properties").getInputStream();
				properties.load(stream);
				System.out.println(properties.getProperty("welcome"));
				fromThread2 = properties.getProperty("welcome");
			}
			catch (Exception e){
				e.printStackTrace();
			}
		});

		ZoneId zEastern=ZoneId.of("America/New_York");
		ZoneId zMountain=ZoneId.of("America/Denver");
		ZoneId zUTC=ZoneId.of("UTC");
		ZoneId zoneId=ZoneId.systemDefault();

		LocalDateTime localDateTime=LocalDateTime.now();
		System.out.println("local time " + localDateTime.toString());
		ZonedDateTime zonedDateTime=localDateTime.atZone(zoneId);
		ZonedDateTime zonedDateTimeEastern=zonedDateTime.withZoneSameInstant(zEastern);
		LocalDateTime localDateTimeEastern=zonedDateTimeEastern.toLocalDateTime();
		System.out.println("Eastern time " + localDateTimeEastern.toString());
		ZonedDateTime zonedDateTimeMountain=zonedDateTime.withZoneSameInstant(zMountain);
		LocalDateTime localDateTimeMountain=zonedDateTimeMountain.toLocalDateTime();
		System.out.println("Mountain time " + localDateTimeMountain.toString());
		ZonedDateTime zonedDateTimeUTC=zonedDateTime.withZoneSameInstant(zUTC);
		LocalDateTime localDateTimeUTC=zonedDateTimeUTC.toLocalDateTime();
		System.out.println("UTC time " + localDateTimeUTC.toString());





		//System.out.println(fromThread1);
		//System.out.println(fromThread2);

	}

}
