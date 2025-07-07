package edu.wgu.d387_sample_code.rest;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicReference;

import static java.util.concurrent.Executors.newFixedThreadPool;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class MessageMapping {

    @RequestMapping(path ="/welcomeMesssage", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String[] showWelcome(){
        String[] messages = new String[2];

        //String fromThread1;
        //String fromThread2;
        ExecutorService messageExecutor = newFixedThreadPool(10);
        Properties stuff=new Properties();
        messageExecutor.execute(()-> {
            try{
                InputStream stream = new ClassPathResource("welcome_en_US.properties").getInputStream();
                stuff.load(stream);
                System.out.println(stuff.getProperty("welcome"));
                messages[0] = stuff.getProperty("welcome");
            }
            catch (Exception e){
                e.printStackTrace();
            }
        });

        messageExecutor.execute(()-> {
            try{
                InputStream stream = new ClassPathResource("welcome_fr_CA.properties").getInputStream();
                stuff.load(stream);
                System.out.println(stuff.getProperty("welcome"));
                messages[1] = stuff.getProperty("welcome");
            }
            catch (Exception e){
                e.printStackTrace();
            }
        });

        return messages;


    }

    @RequestMapping(path ="/presentation", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String showPresentation(){
        String finalMessage= "Join us for a live online presentation";
        return finalMessage;
    }

    @RequestMapping(path ="/timeZones", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String showTimeZones(){ //list of strings or array of strings
        ZoneId zEastern=ZoneId.of("America/New_York");
        ZoneId zMountain=ZoneId.of("America/Denver");
        ZoneId zUTC=ZoneId.of("UTC");
        ZoneId zoneId=ZoneId.systemDefault();

        String ET;
        String MT;
        String UTC;
        String all;

        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println("local time " + localDateTime.toString());
        ZonedDateTime zonedDateTime=localDateTime.atZone(zoneId);
        ZonedDateTime zonedDateTimeEastern=zonedDateTime.withZoneSameInstant(zEastern);
        LocalDateTime localDateTimeEastern=zonedDateTimeEastern.toLocalDateTime();
        ET = "Eastern time " + localDateTimeEastern.toString();
        ZonedDateTime zonedDateTimeMountain=zonedDateTime.withZoneSameInstant(zMountain);
        LocalDateTime localDateTimeMountain=zonedDateTimeMountain.toLocalDateTime();
        MT = "Mountain time " + localDateTimeMountain.toString();
        ZonedDateTime zonedDateTimeUTC=zonedDateTime.withZoneSameInstant(zUTC);
        LocalDateTime localDateTimeUTC=zonedDateTimeUTC.toLocalDateTime();
        UTC = "UTC time " + localDateTimeUTC.toString();

        all = (ET + "\n" + MT + "\n" + UTC + "\n");

        return all;

    }

}
