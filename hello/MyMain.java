package hello;

import java.util.GregorianCalendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class MyMain {

	public static void main(String[] args) {

		MyMain mm = new MyMain();
		mm.make();
		mm.marshal();

	}

	private ObjectFactory of;
	private PurchaseOrderType pot;

	public MyMain() {
		of = new ObjectFactory();
		pot = of.createPurchaseOrderType();
	}

	public void marshal() {
		try {
			JAXBElement<PurchaseOrderType> gl = of.createPurchaseOrder(pot);
			PurchaseOrders ppo = of.createPurchaseOrders();
			
			
			JAXBContext jc = JAXBContext.newInstance("hello");
			Marshaller m = jc.createMarshaller();
			m.marshal(gl, System.out);
		} catch (JAXBException jbe) {
			// ...
		}
	}

	private void make(){
		
		GregorianCalendar gcal = new GregorianCalendar();
	      try {
			XMLGregorianCalendar xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
			pot.setOrderDate(xgcal);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		USAddress aa = new USAddress();
		aa.setCity("novi Sad");
		aa.setState("serbia");
		
		
		pot.setComment("sale");
//		pot.setOrderDate(xgcal);
		pot.setBillTo(aa);
	}

}
