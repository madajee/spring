package org.learnspring.cashregister;

import java.sql.SQLException;

import org.learnspring.cashregister.model.Account;
import org.learnspring.cashregister.service.AccountService;
import org.learnspring.cashregister.service.AccountServiceImpl;

/**
 * Hello world!
 *
 */
public class App
{
	
    public static void main( String[] args ) throws SQLException
    {
    		System.out.println( "Hello World!" );
    		testAccountServcie();
    }
    
    private static void testAccountServcie() throws SQLException
    {
    		AccountService acct = new AccountServiceImpl();
    		Account acc1 = new Account ();
    		acct.createNewAccount(acc1);
    		
    }
}
