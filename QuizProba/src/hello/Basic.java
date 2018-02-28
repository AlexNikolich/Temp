package hello;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Basic {
	
	private ObjectFactory of;
	private Student stu;
	private Student stu2;
	
	

	public Basic() {
		of = new ObjectFactory();
		stu = of.createStudent();
		stu2 = of.createStudent();
	}
	
	



	public static void main(String[] args) {
		Basic basic = new Basic();
		basic.populateStudent();
		basic.marshalResponse();
		
		

	}

	private void marshalResponse()  {
//		JAXBElement<Student> gl = of.createResponse(stu);
		SearchStudentsResponse ssp = new SearchStudentsResponse();
		ssp.getResponse().add(stu);
		ssp.getResponse().add(stu2);

		try {
			JAXBContext jc = JAXBContext.newInstance("hello");
			Marshaller m = jc.createMarshaller();
			m.marshal(ssp, System.out);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}





	private void populateStudent() {
		stu.setName("Alex");
		stu2.setName("Diana");
		
		
		
	}




}
