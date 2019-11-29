package samples.spring.aop;

import org.springframework.stereotype.Service;

@Service
public class AopCustomerService {

    public String findName() {
        return "Bob";
    }
}
