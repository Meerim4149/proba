package peaksoft.spring_res_api.api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
@PreAuthorize("hasAuthority('ADMIN')")
public class TestApi {

        @GetMapping("/hello")
        public String helloAdmin(){
            return "Hello I am Test, I am Admin";
        }

}
