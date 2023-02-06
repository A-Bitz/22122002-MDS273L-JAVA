package LAB1;

import java.util.Scanner;

public class Employee1 {
      public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the name: ");
        String name = input.nextLine();
        
        System.out.print("Enter the age: ");
        int age = input.nextInt();
        
        System.out.print("Enter the gender (m/f): ");
        char gender = input.next().charAt(0);
        
        System.out.print("Enter the state: ");
        input.nextLine();
        String state = input.nextLine();
        
        System.out.print("Enter the company: ");
        String company = input.nextLine();
        
        System.out.println("\nName: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + (gender == 'm' ? "MALE" : "FEMALE"));
        System.out.println("State: " + state);
        System.out.println("Company: " + company);
        
        switch (state.toLowerCase()) {
          case "tamil nadu":
          case "tamilnadu":
          case "andhra pradesh":
          case "andhrapradesh":
          case "kerala":
          case "karnataka":
          
          case "telangana":
            System.out.println("The Employee is from the southern states of India; " +
                               "Preferable work location is in " + state);
            break;
          default:
            break;
        }
        switch (state.toLowerCase()) {
            case "haryana":
            case "himachal pradesh":
            case "himachalpradesh":
            case "rajasthan":
            case "chandigarh" :
            case "delhi":
            case "jammu and kashmir":
            case "jammu":
            case "kashmir":
            case "jammuandkashmir":
            case "punjab":
            case "ladakh":
              System.out.println("The Employee is from the northern states of India; " +
                                 "Preferable work location is in " + state);
              break;
            default:
              break;
          }
          switch (state.toLowerCase()) {
           
            case "bihar":
            case "jharkhand":
            case "Odisha":
            
            case "west bengal":
            case "westbengal":
            case "assam":
            case "arunachalpradesh":
            case "arunachal pradesh":
            case "nagaland":
            case "manipur":
            case "tripura":

            
              System.out.println("The Employee is from the eastern states of India; " +
                                 "Preferable work location is in " + state);
              break;
            default:
              break;
          }

          switch (state.toLowerCase()) {
            case "gujarat":
            case "rajasthan":
            case "goa":
            case"assam":
              System.out.println("The Employee is from the western states of India; " +
                                 "Preferable work location is in " + state);
              break;
            default:
              break;
          }
          switch (state.toLowerCase()) {
            case "chattisgarh":
            case "madhya pradesh":
            case "madhyapradesh":

              System.out.println("The Employee is from the central states of India; " +
                                 "Preferable work location is in " + state);
              break;
            default:
              break;
          }

          
      
        switch (company.toLowerCase()) {
          case "facebook":
          case "google":
          case "microsoft":
          case "samsung":
          case "ibm":
          case "apple":
            System.out.println("The employee is working in Top MNC Companies");
            break;
          default:

            break;
        }
      }
    }
    
    

