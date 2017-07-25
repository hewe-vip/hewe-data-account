package vip.hewe.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class HeweDataAccountApplication {

    private static final Logger log = LoggerFactory.getLogger(HeweDataAccountApplication.class);


    public static void main(String[] args) throws IOException {
        SpringApplication.run(HeweDataAccountApplication.class, args);
        System.in.read();
    }

}


//	String add(Mprofile mprofile);
//
//	String remove(String id);
//
//	Mprofile get(String id);
//
//	String update(Mprofile mprofile);
//
//	String validate(String identity, String passwd);
