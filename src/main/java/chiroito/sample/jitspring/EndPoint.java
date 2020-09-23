package chiroito.sample.jitspring;

import chiroito.sample.jitspring.api.Name;
import chiroito.sample.jitspring.db.Person;
import chiroito.sample.jitspring.db.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EndPoint {

    public EndPoint(RestTemplateBuilder builder){
        this.restTemplate = builder.build();
    }

    @Autowired
    private PersonRepository repository;

    private RestTemplate restTemplate;

    @RequestMapping(path = "/hello" , method = RequestMethod.GET)
    public String hello(){
        // 他の API へアクセスする
        Name forObject = restTemplate.getForObject("http://localhost:8081/hello", Name.class);

        // DB を更新する
        Person person = new Person();
        person.name = forObject.Name;
        repository.save(person);

        return "Hello";
    }
}
