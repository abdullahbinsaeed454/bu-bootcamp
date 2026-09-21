import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class ContactManager {
    public static void main(String[] args) {
        HashMap<String, Contact> contactMap = new HashMap<>();
        ArrayList<Contact> contactList = new ArrayList<>();

        Contact[] contacts = {
            new Contact("Saba", "0300-1234567"),
            new Contact("Ali", "0321-7654321"),
            new Contact("Zara", "0333-1112223"),
            new Contact("Bilal", "0345-9998887")
        };

        for (Contact c : contacts) {
            contactMap.put(c.getName(), c);
            contactList.add(c);
        }

        // Fast lookup by name using HashMap
        String searchName = "Ali";
        System.out.println("=== Lookup: " + searchName + " ===");
        Contact found = contactMap.get(searchName);
        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println(searchName + " not found.");
        }

        String missing = "Omar";
        System.out.println("\n=== Lookup: " + missing + " ===");
        Contact notFound = contactMap.get(missing);
        System.out.println(notFound != null ? "Found: " + notFound : missing + " not found.");

        // Sort ArrayList alphabetically by name
        Collections.sort(contactList, Comparator.comparing(Contact::getName));
        System.out.println("\n=== All contacts (sorted by name) ===");
        for (Contact c : contactList) {
            System.out.println(c);
        }
    }
}
