package org.learnspring.cashregister;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Before;
import org.junit.Test;

import org.learnspring.cashregister.service.AccountServiceImpl;
import org.learnspring.cashregister.service.ReceiptService;
import org.learnspring.cashregister.service.AccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.learnspring.cashregister.model.Account;
import org.learnspring.cashregister.model.Transaction;
import org.learnspring.cashregister.model.TransactionType;
import org.learnspring.cashregister.repository.AccountRepository;
import org.learnspring.cashregister.repository.JdbcAccountRepositoryImpl;


public class AppTest 
{
	private AccountService accountService;
	private ReceiptService receiptService;
	
	BasicDataSource dataSource;
	
	@Before
	public void init() throws Exception{
		/*dataSource= new BasicDataSource();
		dataSource.setUrl("jdbc:mysql://localhost/cashregisterdb");
		dataSource.setUsername("devuser");
		dataSource.setPassword("devwelcome123#");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		
		accountService= new AccountServiceImpl();
		setUpDb();
		accountService.retriveAccount(12L);*/
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml", "infrastructure-config.xml");
		dataSource = (BasicDataSource) context.getBean("dataSource");
		accountService = (AccountService) context.getBean("accountService");
		receiptService = (ReceiptService) context.getBean("receiptService");
		setUpDb();
		accountService.retriveAccount(1L);
		Account firstAccount= new Account(new Long(3),"Shiva",true,10000,"sivaprasad1.valluru@gmail.com","Bangalore","India");
		
		accountService.createNewAccount(firstAccount);
		Account retrieveAccount = accountService.retriveAccount(3L);
		System.out.println("Retrived Account Number: " + retrieveAccount.getAccountNumber());
		Transaction firstAccountReceipt = new Transaction(retrieveAccount.getAccountNumber(),new Date(),5,TransactionType.DEBIT);
		receiptService.createNewReceipt(firstAccountReceipt);
		List<Transaction> transactions = receiptService.getAllReceiptsByAccountNumber(retrieveAccount.getAccountNumber());
		for (Transaction transaction: transactions)
			System.out.println(transaction.getTransactionId());
		context.close();
	}
	
	@Test
	public void testAccountRepository() throws SQLException{
		System.out.println("AccountRepositoryTest");
    	
    }
	
	public void setUpDb() throws Exception{
		URL url=this.getClass().getClassLoader().getResource("dbscripts.sql");
		System.out.println(url);
		InputStream is=this.getClass().getClassLoader().getResourceAsStream("dbscripts.sql");
		BufferedReader reader= new BufferedReader(new InputStreamReader(is));
		List<String> queries= new ArrayList<String>();
		String line=reader.readLine();
		String query="";
		while(line!=null){
			query+=line;
			if(query.endsWith(";")){
				queries.add(query);
				System.out.println(query);
				query="";
			}
			line=reader.readLine();

		}
		Connection connection=dataSource.getConnection();
		Statement statmement=connection.createStatement();
		for(String sql:queries){
			statmement.executeUpdate(sql);
		}
		
		/*Account firstAccount= new Account(new Long(1),"Shiva",true,10000,"sivaprasad.valluru@gmail.com","Bangalore","India");
		Account secondAccount= new Account(new Long(2),"Prasad",true,20000,"siva@gmail.com","Bangalore","India");
		accountRepository.save(firstAccount);
		accountRepository.save(secondAccount);*/
	}
}
