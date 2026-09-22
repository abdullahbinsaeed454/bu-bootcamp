import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
    private Contact contact;

    @BeforeEach
    void setUp() {
        contact = new Contact("Alice Johnson", "555-123-4567");
    }

    @Test
    void testGetName() {
        assertEquals("Alice Johnson", contact.getName());
    }

    @Test
    void testGetPhone() {
        assertEquals("555-123-4567", contact.getPhone());
    }

    @Test
    void testToStringFormat() {
        assertEquals("Alice Johnson - 555-123-4567", contact.toString());
    }

    @Test
    void testConstructor_setsNameCorrectly() {
        Contact other = new Contact("Bob Smith", "555-987-6543");
        assertEquals("Bob Smith", other.getName());
    }

    @Test
    void testConstructor_setsPhoneCorrectly() {
        Contact other = new Contact("Bob Smith", "555-987-6543");
        assertEquals("555-987-6543", other.getPhone());
    }

    @Test
    void testIndependentObjects_sameName() {
        Contact contact1 = new Contact("Sam Lee", "111-111-1111");
        Contact contact2 = new Contact("Sam Lee", "222-222-2222");
        assertNotSame(contact1, contact2);
        assertEquals("111-111-1111", contact1.getPhone());
        assertEquals("222-222-2222", contact2.getPhone());
    }

    @Test
    void testToString_withDifferentContact() {
        Contact other = new Contact("Maria Garcia", "333-444-5555");
        assertEquals("Maria Garcia - 333-444-5555", other.toString());
    }
}