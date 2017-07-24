package vip.hewe.data;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vip.hewe.data.service.SignService;

@SpringBootApplication
public class HeweDataAccountApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(HeweDataAccountApplication.class);

    @Autowired
    private SignService signService;

    private static Server server;


    public static void main(String[] args) {
        SpringApplication.run(HeweDataAccountApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        int port = 50051;

        server = ServerBuilder.forPort(port).addService(signService).build().start();
        log.info("server started, listen on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                if (server != null) {
                    server.shutdown();
                }
                System.err.println("*** server shut down");
            }
        });

        if (server != null) {
            server.awaitTermination();
        }

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
