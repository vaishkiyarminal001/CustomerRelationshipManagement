package com.masai.ui;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

import org.mindrot.jbcrypt.BCrypt;

import com.masai.dao.CSRDaoImpl;
import com.masai.enm.Category;
import com.masai.enm.Feedback;
import com.masai.enm.IssueStatus;
import com.masai.entity.CSR;
import com.masai.entity.Customer;
import com.masai.entity.Issue;
import com.masai.entity.LoggedCustomerId;
import com.masai.services.CustomerImpl;
import com.masai.services.Customerser;
import com.masai.services.GetCustomerCred;
import com.masai.services.GetCustomerCredImpl;
import com.masai.utility.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

public class App {
    static EntityManagerFactory emf = HibernateUtil.getEntityManagerFactory();
    
    
    private static final String DB_URL = "jdbc:mysql://localhost:3306/crm";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root1234";

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        while (true) {
            displayMenu();
            int choice = getUserChoice();

            if (choice == 0) {
                System.out.println("Exiting...");
                break;
            } else if (choice == 1) {
                register(sc);
            } else if (choice == 2) {
                login(sc);
            } else if (choice == 3) {
            	customerRegistration(sc);
            } else if (choice == 4) {
            	customerLogin(sc);
            } else if (choice == 5) {
                getFeedback();
            } else if (choice == 6) {
//                checkStatus();
            } else if (choice == 7) {
                getIssue();
            } else if (choice == 8) {
            	raiseIssue();
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }



    private static String getCustomerId() {
        System.out.print("Enter your customer ID: ");
        return scanner.nextLine();
    }

    private static void raiseIssue() {

    }

    private static void displayStatus(String status) {
        System.out.println("Status: " + status);
    }

    private static void displayMenu() {
        System.out.println("Welcome to the Application!");
        System.out.println("1. CSR Register");
        System.out.println("2. CSR Login");
        System.out.println("3. Customer Register");
        System.out.println("4. Customer Login");
        System.out.println("5. Provide Feedback");
        System.out.println("6. Check Status");
        System.out.println("7. Raise Issue");
        System.out.println("0. Exit");
    }

    private static int getUserChoice() {
        while (true) {
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a number.");
            }
        }
    }

    private static String getUsername() {
        System.out.print("Enter your username: ");
        return scanner.nextLine();
    }

    private static String getPassword() {
        System.out.print("Enter your password: ");
        return scanner.nextLine();
    }

    private static String getFeedback() {
        String username = getUsername();


        return scanner.nextLine();
    }



    //Admin register
    
    private static void register(Scanner sc ) {
    	System.out.println("Enter username");
        String username = sc.next();
        
        System.out.println("Enter password");
        String password = sc.next();
        
        
        System.out.println("Enter name");
        String name = sc.next();
        
        
        System.out.println("Enter email");
        String email = sc.next();
        
        System.out.println("Enter address");
        String address = sc.next();
        
        CSRDaoImpl csrDao = new CSRDaoImpl();

        csrDao.addNewCSR(new CSR(username, password, name, email, address, null));
        

    }
    
   
    
    // Admin login
    

    private static void login(Scanner sc) {

		System.out.println("Enter Username ");
		String userName = sc.next();
		
		System.out.println("Enter Password ");
		String passWord = sc.next();
		System.out.println();

     List<CSR> resultList = null;
		
     try{
    	 EntityManager em = emf.createEntityManager();
         String getCredsQue = "SELECT c FROM CSR c";
			
			Query createQuery = em.createQuery(getCredsQue);
			
			 resultList =  createQuery.getResultList();
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		  
		
			 resultList.forEach( c -> {
			if(c.getUserName().equals(userName)&&c.getPassWord().equals(passWord)) {	
				System.out.println("Welcome CSR:- "+c.getName());
				System.out.println();
				
			  }
		});
    	

    }
    
    // customer register
    
     public static void customerRegistration(Scanner sc) {
		
		System.out.println("Enter Username");
		String userName = sc.nextLine();
		System.out.println("Enter Password");
		String passWord = sc.nextLine();
		System.out.println("Enter Name");
		String name = sc.nextLine();
		System.out.println("Enter Email");
		String email = sc.nextLine();
		System.out.println("Enter Address");
		String address = sc.nextLine();
		
		
		Customer cus = new Customer(userName, passWord, name, email, address , new HashSet<>() , new HashSet<>());
		String hashedPassword = BCrypt.hashpw(cus.getPassWord(), BCrypt.gensalt());
		boolean checkpw = BCrypt.checkpw(passWord, hashedPassword);
		System.out.println(checkpw);
		Customerser cusSer = new CustomerImpl();
	
		
		cusSer.addNewCustomer(cus);
		
	}
     
	
     public static void customerLogin(Scanner sc) {
    	    System.out.println("Enter Customer UseName ");
    	    String userName = sc.next();

    	    System.out.println("Enter Customer PassWord ");
    	    String passWord = sc.next();
    	    System.out.println();

    	   
    	    String hashedPassword = BCrypt.hashpw(passWord, BCrypt.gensalt());

    	    GetCustomerCred getCustomerCreds = new GetCustomerCredImpl();
    	    Customer csr = getCustomerCreds.getCustomerCredentials(userName, hashedPassword);

    	    if (csr != null && csr.getUserName().equals(userName) && BCrypt.checkpw(passWord, csr.getPassWord())) {
    	        System.out.println("Welcome Customer:- " + csr.getName());
    	        System.out.println();
    	        customerFieldsExc(sc);
    	    } else {
    	        System.out.println("Invalid username or password");
    	    }
    	}

    
    

      public static void customerFieldsExc(Scanner sc) {
	
	      String opt;
	
	      do {
	    	  System.out.println("Enter Your Preference...");
		      displayCustomerFields();
		      opt = sc.next();
		
		      switch(opt) {
		
		      case "1" -> raiseIssue(sc);
		      case "2" -> viewAllIssuesRaiseByMeAndGiveFeed(sc);
		      case "3" -> viewStatusOfRaisedIssue();
		      case "0" -> System.out.println("Logged Out From Customer");
		
		      }
		
	      }while(!opt.equals("0"));
	
	
      }

      private static  void raiseIssue(Scanner sc) {
	          Category cate = null;
    	      String opt ;
    		  System.out.println("Select Issue Category"
    				      +"\n"+
    				      "1. PRODUCT ,"
    				      +"\n"+
    				      "2. SERVICE ,"
    				      +"\n"+
    				      "3. REFERRAL ,"
    				      +"\n"+
    				      "4. SUPPORT ,"
    				      +"\n"+
    				      "5. LEAVE ,"
    				      +"\n"+
    				      "Press Any. SUBMISSION ,"
    				      +"\n"
    				  );
    		  System.out.println();
        	  opt = sc.next();
        	
    		  if(opt.equals("1")) cate = Category.PRODUCT;
    		  else if(opt.equals("2")) cate = Category.SERVICES;
    		  else if(opt.equals("3")) cate = Category.SUPPORT;
    		  else cate = Category.SUBMISSION;
    		 
    	  Issue issue = new Issue(cate , LocalDate.now() , IssueStatus.OPEN , Feedback.YET_TO_BE_CLOSED , null);
    		  
    	  Customerser cusSer = new CustomerImpl();
    	  
    	  cusSer.createIssue(issue);
    	 
	 
      }

      private static void  viewAllIssuesRaiseByMeAndGiveFeed(Scanner sc) {
	  
    	  Customerser cusSer = new CustomerImpl();
    	  int id = LoggedCustomerId.loggedCustomerId;
    	  
    	  Feedback feed;
    	  List<Issue> issueList = cusSer.viewAllIssuesAndGiveFeed(id);
    	  issueList.forEach(System.out::println);
    	  
    	  System.out.println(
    			  "Enter id of Issue you want give feedback to (Issue Must Be Closed) :-"
    			  );
    	  int opt = sc.nextInt();
    	  System.out.println("Choose Feedback Options...");
    	  System.out.println(
    			  "1. GREAT_EXP "
    			     +"\n"+
    			     "2. GOOD_EXP "
    			     +"\n"+
    			     "3. BAD_EXP "
    			     +"\n"+
    			     "Press Any. HORRIBLE_EXP "
    			  );
    	  String choice = sc.next();
    	  if(choice.equals("1")) feed = Feedback.GREAT_EXP;
    	  else if(choice.equals("2")) feed = Feedback.GOOD_EXP;
    	  else  if(choice.equals("3")) feed = Feedback.BAD_EXP;
    	  else  feed = Feedback.HORRIBLE_EXP;
    	  
    	  cusSer.giveFeedBackToIssues(opt , feed);
    	  
    	  
      }

      private static  void viewStatusOfRaisedIssue() {
	  
    	  Customerser cusSer = new CustomerImpl();
    	  
    	  int id = LoggedCustomerId.loggedCustomerId;
    	  
    	  List<Issue> issueList =  cusSer.viewAllIssuesAndGiveFeed(id);
	 
    	  issueList.forEach(i->System.out.println("Issue id:- "+i.getId()+", Status of the Issue:- "+i.getStatus()));
    	  
      }

      public static void displayCustomerFields() {

	      System.out.println(
			
		               "1. Raise an Issue"
	                           + "\n" +
	                   "2. View All Issues Raise By Me And Impart Feedback on"
	                           + "\n" +	  
	                   "3. View Status Of Raised Issue"
	                           + "\n" +
		               "0. Log out from the customer account"
			             );

      }
    private static void updateIssueFeedback(int issueId, String feedback) {

    }

    private static String getIssue() {
        System.out.print("Enter the issue you want to raise: ");
        return scanner.nextLine();
    }

    private static EntityManager getConnection() throws SQLException {
    	
    	
    	EntityManagerFactory em = HibernateUtil.getEntityManagerFactory();
    	
        return em.createEntityManager();
    }
}
