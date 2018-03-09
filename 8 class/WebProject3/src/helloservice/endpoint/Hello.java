package helloservice.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebService;


@WebService
public class Hello {
    private String message = new String("Hello, ");

    
    public String sayHello(String name) {
        return message + name + ".";
    }
    
    public int sayHelloInt(int int1, int int2) {
        return int1+int2;
    }
    
}
