package helloservice.endpoint;

public class Client 
{
	public static void main(String[] args)
	{
	 
		HelloService service = new HelloService();
		Hello greeting = service.getHelloPort();
		System.out.println("------->>  Call Started");
		System.out.println(greeting.sayHello("Lovely people  dfhdghdfh"));
		System.out.println("------->>  Call Ended");
		
		
	}
}

