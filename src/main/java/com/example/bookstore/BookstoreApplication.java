package com.example.bookstore;

import io.sentry.Sentry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookstoreApplication {

    public static void main(String[] args) {

        Sentry.init(options -> {
            // your Sentry project/dashboard
            options.setDsn("https://cc4e69e7e9694d9e9e33ccb7b6ff528a@o1029631.ingest.sentry.io/6138345");
            options.setRelease("senttry-demo@1.1.0+1");
            options.setEnvironment("Development");
            options.setBeforeSend((event, hint) -> {
                // Drop an event altogether:
                if (event.getTag("SomeTag") != null) {
                    return null;
                }
                return event;
            });
        });
        SpringApplication.run(BookstoreApplication.class, args);
    }

}
