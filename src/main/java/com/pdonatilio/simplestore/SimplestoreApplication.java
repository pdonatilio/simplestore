package com.pdonatilio.simplestore;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pdonatilio.simplestore.domain.Address;
import com.pdonatilio.simplestore.domain.CardPayment;
import com.pdonatilio.simplestore.domain.Category;
import com.pdonatilio.simplestore.domain.City;
import com.pdonatilio.simplestore.domain.Client;
import com.pdonatilio.simplestore.domain.PurchaseOrder;
import com.pdonatilio.simplestore.domain.Payment;
import com.pdonatilio.simplestore.domain.PaymentSlip;
import com.pdonatilio.simplestore.domain.Product;
import com.pdonatilio.simplestore.domain.State;
import com.pdonatilio.simplestore.domain.enums.ClientType;
import com.pdonatilio.simplestore.domain.enums.PaymentState;
import com.pdonatilio.simplestore.repositories.AddressRepository;
import com.pdonatilio.simplestore.repositories.CategoryRepository;
import com.pdonatilio.simplestore.repositories.CityRepository;
import com.pdonatilio.simplestore.repositories.ClientRepository;
import com.pdonatilio.simplestore.repositories.PurchaseOrderRepository;
import com.pdonatilio.simplestore.repositories.PaymentRepository;
import com.pdonatilio.simplestore.repositories.ProductRepository;
import com.pdonatilio.simplestore.repositories.StateRepository;

@SpringBootApplication
public class SimplestoreApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private StateRepository stateRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;
	@Autowired
	private PaymentRepository paymentRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SimplestoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Escritório");
		
		Product p1 = new Product(null, "Computador", 2000.00);
		Product p2 = new Product(null, "Impressora", 800.00);
		Product p3 = new Product(null, "Mouse", 80.00);
		
		cat1.getProducts().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProducts().addAll(Arrays.asList(p2));
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1,cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2));
		productRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		State st1 = new State(null, "Minas Gerais");
		State st2 = new State(null, "São Paulo");
		
		City c1 = new City(null, "Uberlandia", st1);
		City c2 = new City(null, "São Paulo", st2);
		City c3 = new City(null, "Campinas", st2);
		
		stateRepository.saveAll(Arrays.asList(st1,st2));
		cityRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Client cli1 = new Client(null, "Maria Silva", "maria@gmail.com", "36378912377", ClientType.INDIVIDUAL);
		cli1.getPhoneNumbers().addAll(Arrays.asList("27363323","93838393"));
		
		Address a1 = new Address(null, "Rua Flores", "300", "Apto 203", "Jardim", "38220834", c1, cli1);
		Address a2 = new Address(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", c2, cli1);
		
		cli1.getAddresses().addAll(Arrays.asList(a1,a2));
		
		clientRepository.saveAll(Arrays.asList(cli1));
		addressRepository.saveAll(Arrays.asList(a1,a2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		PurchaseOrder pOrd1 = new PurchaseOrder(null, sdf.parse("30/09/2018 10:32"), cli1, a1);
		PurchaseOrder pOrd2 = new PurchaseOrder(null, sdf.parse("10/10/2018 19:35"), cli1, a2);
		
		Payment pay1 = new CardPayment(null, PaymentState.LIQUIDATED, pOrd1, 6);
		pOrd1.setPayment(pay1);
		
		Payment pay2 = new PaymentSlip(null, PaymentState.PENDING, pOrd2, sdf.parse("20/10/2018 00:00"), null);
		pOrd2.setPayment(pay2);
		
		cli1.getOrders().addAll(Arrays.asList(pOrd1, pOrd2));
		
		purchaseOrderRepository.saveAll(Arrays.asList(pOrd1, pOrd2));
		paymentRepository.saveAll(Arrays.asList(pay1, pay2));
		
	}

}

