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
import java.time.format.DateTimeFormatter;




@RestController
@CrossOrigin
@RequestMapping("/api")
public class MessageMapping {

    @RequestMapping(path ="/welcomeMesssage", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String[] showWelcome(){
        String[] messages = new String[2];

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
    public String showTimeZones(){

        ZoneId zEastern = ZoneId.of("America/New_York");
        ZoneId zoneId = ZoneId.systemDefault();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a");

        String ET;
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("local time " + localDateTime.format(formatter));

        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);

        ZonedDateTime zonedDateTimeEastern = zonedDateTime.withZoneSameInstant(zEastern);
        ET = "Eastern time " + zonedDateTimeEastern.format(formatter);

        String all = (ET + "\n");
        return all;
    }
    @RequestMapping(path ="/timeZonesMT", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String showTimeZonesMT() {

        ZoneId zMountain = ZoneId.of("America/Denver");
        ZoneId zoneId = ZoneId.systemDefault();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a");
        String MT;

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("local time " + localDateTime.format(formatter));

        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);

        ZonedDateTime zonedDateTimeMountain = zonedDateTime.withZoneSameInstant(zMountain);
        MT = " Mountain  time  " + zonedDateTimeMountain.format(formatter);

        String all = (MT + "\n");
        return all;
    }
    @RequestMapping(path ="/timeZonesUTC", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String showTimeZonesUTC() {

        ZoneId zUTC = ZoneId.of("UTC");
        ZoneId zoneId = ZoneId.systemDefault();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a");

        String UTC_formatted;

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("local time " + localDateTime.format(formatter));

        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);

        ZonedDateTime zonedDateTimeUTC = zonedDateTime.withZoneSameInstant(zUTC);
        UTC_formatted = " UTC  time  " + zonedDateTimeUTC.format(formatter);

        String all = (UTC_formatted + "\n");
        return all;
    }

}
