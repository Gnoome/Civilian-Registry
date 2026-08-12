
import java.util.Scanner;

public class Menu {
      private static void SearchCivilian() {

        System.out.println("You have selected to view some civilian records");

        Person person = new Person();
        Scanner scan = new Scanner(System.in);

        System.out.println("search by id (optional press Enter to skip): ");
        String id = scan.nextLine();
         if (!id.isEmpty() && !id.matches("\\d{8}")) {
            System.out.println("Invalid ID format. ID must be 8 digits.");
            return;
        }
        if(id.isEmpty()){
            id = null;
        }
        person.setid(id);
        

        System.out.println("search by name (optional press Enter to skip): ");
        String firstName = scan.nextLine();
        if (firstName.isEmpty()) {
            firstName = null;
        }
        person.setName(firstName);

        System.out.println("search by surname (optional press Enter to skip): ");
        String surname = scan.nextLine();
        if (surname.isEmpty()) {
            surname = null;
        }
        person.setSurname(surname);

        System.out.println("search by birthdate (optional press Enter to skip): ");
        String birthdate = scan.nextLine();
        if (!birthdate.matches("\\d{2}-\\d{2}-\\d{4}")&& !birthdate.isEmpty()) {
            System.out.println("Invalid Birthdate format. Please use DD-MM-YYYY.");
            return;
        }
        if(birthdate.isEmpty()){
            birthdate = null;
        }
        person.setBirthdate(birthdate);

        System.out.println("search by gender (optional press Enter to skip): ");
        String gender = scan.nextLine();
        if (gender.isEmpty()) {
            gender = null;
        }else{
            if (!gender.equalsIgnoreCase("M") && !gender.equalsIgnoreCase("F")) {
            System.out.println("Invalid Gender format. Please enter M or F.");
            return;
        }
        }
        
        person.setGender(gender);

        System.out.println("Search by civilian's address(optional to ignore press Enter): ");
        String address = scan.nextLine();
        if (address.isEmpty()) {
            address = null; 
        }
        person.setAddress(address);

        System.out.println("Search by civilian's Tax number(optional 9 digits to ignore press Enter): ");
        String taxNumber = scan.nextLine();
        if (!taxNumber.isEmpty() && !taxNumber.matches("\\d{9}")) {
            System.out.println("Invalid Tax number format. Tax number must be 9 digits.");
            return;
        }
        if (taxNumber.isEmpty()) {
            taxNumber = null; 
        }
        person.setTax(taxNumber);

        Database_Manager.searchperson(person);
        
    
}

    private static void AddCivilian() {

        System.out.println("You have selected to add a new civilian");

        Person person = new Person();
        Scanner scan = new Scanner(System.in);

        System.out.println("PLease enter the civilian's ID number(8 digits): ");
        String id = scan.nextLine();
         if (!id.matches("\\d{8}")) {
            System.out.println("Invalid ID format. ID must be 8 digits.");
            return;
        }
        if (Database_Manager.existperson(id)) {
            System.out.println("Civilian with this ID already exists.");
            return;
        }
        person.setid(id);
        

        System.out.println("Please enter the civilian's first name: ");
        String firstName = scan.nextLine();
        if (firstName.isEmpty()) {
            System.out.println("First name cannot be empty.");
            return;
        }
        person.setName(firstName);

        System.out.println("Please enter the civilian's surname: ");
        String surname = scan.nextLine();
        if (surname.isEmpty()) {
            System.out.println("Surname cannot be empty.");
            return;
        }
        person.setSurname(surname);

        System.out.println("Please enter the civilian's birthdate(DD-MM-YYYY): ");
        String birthdate = scan.nextLine();
        if (!birthdate.matches("\\d{2}-\\d{2}-\\d{4}")) {
            System.out.println("Invalid Birthdate format. Please use DD-MM-YYYY.");
            return;
        }
        person.setBirthdate(birthdate);

        System.out.println("Please enter the civilian's Gender(M or F): ");
        String gender = scan.nextLine();
        if (!gender.equalsIgnoreCase("M") && !gender.equalsIgnoreCase("F")) {
            System.out.println("Invalid Gender format. Please enter M or F.");
            return;
        }
        person.setGender(gender);

        System.out.println("Please enter the civilian's address(optional to ignore press Enter): ");
        String address = scan.nextLine();
        if (address.isEmpty()) {
            address = null;
        }
        person.setAddress(address);

        System.out.println("Please enter the civilian's Tax number(optional 9 digits to ignore press Enter): ");
        String taxNumber = scan.nextLine();
        if (!taxNumber.isEmpty() && !taxNumber.matches("\\d{9}")) {
            System.out.println("Invalid Tax number format. Tax number must be 9 digits.");
            return;
        }
        if (taxNumber.isEmpty()) {
            taxNumber = null; 
        }
        person.setTax(taxNumber);

        if(Database_Manager.addperson(person)){
            System.out.println("Civilian " + person + " added successfully.");
        } else {
            System.out.println("Failed to add civilian.");
        }
        
    }

    private static void RemoveCivilian(){
        
        System.out.println("You have selected to remove a civilian");

        System.out.println("Please enter the civilian's ID number(8 digits): ");
        Scanner scan = new Scanner(System.in);
        String id = scan.nextLine();
        if (!id.matches("\\d{8}")) {
            System.out.println("Invalid ID format. ID must be 8 digits.");
            return;
        }
        if (!Database_Manager.existperson(id)) {
            System.out.println("Civilian with this ID does not exist.");
            return;
        }
        if (Database_Manager.deleteperson(id)) {
            System.out.println("Civilian with ID " + id + " removed successfully.");
        } else {
            System.out.println("Failed to remove civilian.");
        }
    }

    private static void UpdateCivilian(){
        System.out.println("You have selected to update a civilian");
        System.out.println("you can only update the address and tax number of a civilian");
        System.out.println("Please enter the civilian's ID number(8 digits): ");
        Scanner scan = new Scanner(System.in);
        String id = scan.nextLine();
        if (!id.matches("\\d{8}")) {
            System.out.println("Invalid ID format. ID must be 8 digits.");
            return;
        }
        if (!Database_Manager.existperson(id)) {
            System.out.println("Civilian with this ID does not exist.");
            return;
        }
        System.out.println("Please enter the new address of the civilian (optional to ignore press Enter): ");
        String address = scan.nextLine();
        if (address.isEmpty()) {
            address = null; 
        }
        System.out.println("Please enter the new tax number of the civilian (optional to ignore press Enter): ");

        String taxNumber = scan.nextLine();
        if (!taxNumber.isEmpty() && !taxNumber.matches("\\d{9}")) {
            System.out.println("Invalid Tax number format. Tax number must be 9 digits.");
            return;
        }
        if (taxNumber.isEmpty()) {
            taxNumber = null; 
        }

        Person person = new Person();
        person.setid(id);
        person.setAddress(address);
        person.setTax(taxNumber);

        if (Database_Manager.updateperson(person)) {
            System.out.println("Civilian with ID " + id + " updated successfully.");
        } else {
            System.out.println("Failed to update civilian.");
        }
    }

    private static void Start() {

        System.out.println("Welcome to the Database");
        System.out.println("Please select one of the following options:");

        System.out.println("1. Add a new civilian");
        System.out.println("2. View all civilians");
        System.out.println("3. Update a civilian");
        System.out.println("4. Delete a civilian");
        System.out.println("5. Search for a civilian");
        System.out.println("6. Exit");
        System.out.print("Enter your choice (1-6): ");

        Scanner scan = new Scanner(System.in);
        switch (scan.nextInt()) {

            case 1:
                AddCivilian();
                break;
            case 2:
                Database_Manager.viewallpersons();
                break;
            case 3:
                UpdateCivilian();
                break;
            case 4:
                RemoveCivilian();
                break;
            case 5:
                SearchCivilian();
                break;
            default:
                scan.close();
                System.exit(0);
                break;
        }

    }

    public static void SetDatabaseState(){
        System.out.println("Checking connection to the database...");
        boolean exists = Database_Manager.existsDatabase();
        if (!exists) {
            System.out.println("Database does not exist. Creating database...");
            Database_Manager.createDatabase();
        } else {
            System.out.println("Database connection established successfully.");
        }
    }

    public static void main(String[] args) {
        SetDatabaseState();

        boolean flag = true;
        while (flag) {
            Start();
        }
        

    }
}
