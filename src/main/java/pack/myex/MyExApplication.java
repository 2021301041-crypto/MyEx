package pack.myex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MyExApplication {

    @GetMapping("/")
    public String hello() {
        System.out.println("MyEx");
        return "MyEx Test: Am 16:43";
    }

    public static void main(String[] args) {
        SpringApplication.run(MyExApplication.class, args);
    }
}
