package com.masai.ui;

import java.util.Scanner;

public class App {
	
	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {
	        while (true) {
	            displayMenu();
	            int choice = getUserChoice();

	            if (choice == 0) {
	                System.out.println("Exiting...");
	                break;
	            } else if (choice == 1) {
	                register();
	            } else if (choice == 2) {
	                login();
	            } else if (choice == 3) {
	                provideFeedback();
	            } else if (choice == 4) {
	                checkStatus();
	            } else if (choice == 5) {
	                raiseIssue();
	            } else {
	                System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }

	    private static void displayMenu() {
	        System.out.println("Welcome to the Application!");
	        System.out.println("1. Register");
	        System.out.println("2. Login");
	        System.out.println("3. Provide Feedback");
	        System.out.println("4. Check Status");
	        System.out.println("5. Raise Issue");
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
	        System.out.print("Enter your feedback: ");
	        return scanner.nextLine();
	    }

	    private static String getIssue() {
	        System.out.print("Enter the issue you want to raise: ");
	        return scanner.nextLine();
	    }

	    private static void register() {
	        getUsername();
	        getPassword();
	       
	    }

	    private static void login() {
	        getUsername();
	        getPassword();
	     
	    }

	    private static void provideFeedback() {
	        getFeedback();
	        
	    }

	    private static void checkStatus() {
	       
	        String status = "Status";
	        displayStatus(status);
	    }

	    private static void raiseIssue() {
	        getIssue();
	       
	    }

	    private static void displayStatus(String status) {
	        System.out.println("Status: " + status);
	    }
	}

