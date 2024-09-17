package my.spring.core.commandApp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@SpringBootApplication
public class CommandApplication {

    @Component
    @Slf4j
    public static class LogCommandLineRunner implements CommandLineRunner {


        //secara otomatis di ekseskusi ketika Springnya Berjalan, dan paramternya akan dikirim dari main methodnya
        @Override
        public void run(String... args) throws Exception {
            log.info("log command line runner {}", Arrays.toString(args));//untuk mendapatkan data argumen yang ada di main method otomatis method run akan di eksekusi langsung ketika aplikasinya berjalan
        }
    }


    public static void main(String[] args) {
        SpringApplication.run(CommandApplication.class, args);
    }

}
