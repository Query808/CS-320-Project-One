import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * CS320
 * May 24th, 2026
 */
class ContactTest {

    private Contact contact;

    @BeforeEach
    void setUp() {
        contact = new Contact("ID1", "John", "Doe", "1234567890", "123 Main St");
    }

    @Test
    void testValidContactCreation() {
        Contact c = new Contact("ABC123", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("ABC123",      c.getContactId());
        assertEquals("John",        c.getFirstName());
        assertEquals("Doe",         c.getLastName());
        assertEquals("1234567890",  c.getPhone());
        assertEquals("123 Main St", c.getAddress());
    }

    @Test
    void testBoundaryValuesAccepted() {
        Contact c = new Contact("1234567890", "FirstNameX", "LastNameXX",
                                "9876543210", "123456789012345678901234567890");
        assertEquals("1234567890", c.getContactId());
        assertEquals(30, c.getAddress().length());
    }

    // contactId validation

    @Test
    void testContactIdNull() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact(null, "John", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    void testContactIdEmpty() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("", "John", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    void testContactIdTooLong() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St"));
    }

    // contactId is not updatable (there is no setter)

    @Test
    void testContactIdNotUpdatable() {
        contact.setFirstName("Jane");   // change another field
        assertEquals("ID1", contact.getContactId());
    }

    // firstName validation

    @Test
    void testFirstNameNull() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("ID1", null, "Doe", "1234567890", "123 Main St"));
    }

    @Test
    void testFirstNameEmpty() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("ID1", "", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    void testFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("ID1", "JohnathanXX", "Doe", "1234567890", "123 Main St"));
    }

    // lastName validation

    @Test
    void testLastNameNull() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("ID1", "John", null, "1234567890", "123 Main St"));
    }

    @Test
    void testLastNameEmpty() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("ID1", "John", "", "1234567890", "123 Main St"));
    }

    @Test
    void testLastNameTooLong() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("ID1", "John", "DoeingtonXX", "1234567890", "123 Main St"));
    }

    // phone validation

    @Test
    void testPhoneNull() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("ID1", "John", "Doe", null, "123 Main St"));
    }

    @Test
    void testPhoneTooShort() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("ID1", "John", "Doe", "123456789", "123 Main St"));
    }

    @Test
    void testPhoneTooLong() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("ID1", "John", "Doe", "12345678901", "123 Main St"));
    }

    @Test
    void testPhoneNonNumeric() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("ID1", "John", "Doe", "12345abcde", "123 Main St"));
    }

    // address validation

    @Test
    void testAddressNull() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("ID1", "John", "Doe", "1234567890", null));
    }

    @Test
    void testAddressTooLong() {
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("ID1", "John", "Doe", "1234567890",
                              "1234567890123456789012345678901"));
    }

    // setFirstName

    @Test
    void testSetFirstName() {
        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());
    }

    @Test
    void testSetFirstNameNull() {
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
    }

    @Test
    void testSetFirstNameEmpty() {
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(""));
    }

    @Test
    void testSetFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("JohnathanXX"));
    }

    // setLastName

    @Test
    void testSetLastName() {
        Contact c = new Contact("ID1", "John", "Doe", "1234567890", "123 Main St");
        c.setLastName("Smith");
        assertEquals("Smith", c.getLastName());
    }

    @Test
    void testSetLastNameNull() {
        Contact c = new Contact("ID1", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> c.setLastName(null));
    }

    @Test
    void testSetLastNameEmpty() {
        Contact c = new Contact("ID1", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> c.setLastName(""));
    }

    @Test
    void testSetLastNameTooLong() {
        Contact c = new Contact("ID1", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> c.setLastName("SmithersonX"));
    }

    // setPhone

    @Test
    void testSetPhone() {
        Contact c = new Contact("ID1", "John", "Doe", "1234567890", "123 Main St");
        c.setPhone("9876543210");
        assertEquals("9876543210", c.getPhone());
    }

    @Test
    void testSetPhoneNull() {
        Contact c = new Contact("ID1", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> c.setPhone(null));
    }

    @Test
    void testSetPhoneInvalidLength() {
        Contact c = new Contact("ID1", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> c.setPhone("12345"));
    }

    @Test
    void testSetPhoneNonNumeric() {
        Contact c = new Contact("ID1", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> c.setPhone("abcdefghij"));
    }

    // setAddress

    @Test
    void testSetAddress() {
        Contact c = new Contact("ID1", "John", "Doe", "1234567890", "123 Main St");
        c.setAddress("456 Oak Avenue");
        assertEquals("456 Oak Avenue", c.getAddress());
    }

    @Test
    void testSetAddressNull() {
        Contact c = new Contact("ID1", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> c.setAddress(null));
    }

    @Test
    void testSetAddressTooLong() {
        Contact c = new Contact("ID1", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class,
            () -> c.setAddress("1234567890123456789012345678901"));
    }
}
