import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Aditi", "Patil", "aditipatil200@gmail.com", "1234567890", "password123"));
        persons.add(new Person("Pooja", "Sahu", "poojas12@gmail.com", "9876543210", "password456"));

        // Lambda functions for validation
        Predicate<String> nameValidator = name -> name != null && !name.trim().isEmpty();
        Predicate<String> emailValidator = email -> Pattern.matches("^[a-z0-9]+[@][a-z]+[.][a-z]{2,3}", email);
        Predicate<String> mobileValidator = mobile -> Pattern.matches("[0-9]{10}", mobile);
        Predicate<String> passwordValidator = password -> password != null && password.length() >= 8;

        // Validate user entries
        persons.forEach(person -> {
            if (nameValidator.test(person.getFirstName())) {
                System.out.println(" first name: " + person.getFirstName());
            }
            if (nameValidator.test(person.getLastName())) {
                System.out.println(" last name: " + person.getLastName());
            }
            if (emailValidator.test(person.getEmail())) {
                System.out.println(" email: " + person.getEmail());
            }
            if (mobileValidator.test(person.getMobile())) {
                System.out.println(" mobile: " + person.getMobile());
            }
            if (passwordValidator.test(person.getPassword())) {
                System.out.println(" password: " + person.getPassword());
            }
        });
    }
}
