import java.util.*;

public class BankApp {
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        ArrayList<String[]> users = new ArrayList<>();

        String[] currentUser = null ;

        System.out.println("Welcome to the Bank App!");

        while(true){
            System.out.print("Enter command: ");
            String input = reader.nextLine().trim();

            if (input.isEmpty()){
                System.out.println("Error: empty command.");
                continue;
            }

            String[] parts = input.split(" ");
            String command = parts[0].toLowerCase();

             if (command.equals("exit")){
                System.out.println("Goodbye!");
                break;
            }

            else if (command.equals("register")){
                if (parts.length != 7){
                    System.out.println("Error: invalid register command.");
                    continue;
                }

                 String username = parts[1];
                 String password = parts[2];
                 String fullName = parts[3] + " " + parts[4];
                 String phoneNumber = parts[5];
                 String email = parts[6];

                 boolean usernameExists = false ;
                 for (String[] user : users){
                     if (user[0].equals(username)){
                         usernameExists = true ;
                         break ;
                     }
                 }


                 if(usernameExists){
                     System.out.println("Error: username already exists.");
                     continue;
                 }

                 if (phoneNumber.length() != 11){
                     System.out.println("Error: phone number must be exactly 11 digits.");
                     continue;
                 }

                 if (! phoneNumber.startsWith("09")){
                    System.out.println("Error: phone number must start with 09.");
                    continue;
                 }

                 boolean allDigits = true ;
                 for (int i = 0 ; i < phoneNumber.length() ; i++){
                     if (! Character.isDigit(phoneNumber.charAt(i))){
                         allDigits = false ;
                         break;
                     }
                 }

                 if(! allDigits){
                     System.out.println("Error: phone number must contain digits.");
                     continue;
                 }

                 int atIndex = email.indexOf('@');

                 if (atIndex <= 0 ){
                     System.out.println("Error: email must have a username before @.");
                     continue;
                 }

                 if (atIndex == email.length() - 1){
                     System.out.println("Error: email must have domain after @.");
                     continue;
                 }

                 if (email.charAt(0) == '.'){
                     System.out.println("Error: email can not start with dot.");
                     continue;
                 }

                 if (email.indexOf('@') != email.lastIndexOf('@')){
                     System.out.println("Error: email must contain exactly one @.");
                     continue;
                 }

            }








        }
        reader.close();
    }
}
