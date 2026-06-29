import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * CS320
 * May 24th, 2026
 */
class ContactServiceTest {

    private ContactService service;

    @BeforeEach
    void setUp() {
        service = new ContactService();
        service.addContact(new Contact("ID1", "John", "Doe", "1234567890", "123 Main St"));
    }

    // addContact

    @Test
    void testAddContact() {
        Contact c = new Contact("ID2", "Jane", "Smith", "9876543210", "456 Oak Ave");
        service.addContact(c);
        assertSame(c, service.getContact("ID2"));
    }

    @Test
    void testAddContactDuplicateId() {
        Contact dup = new Contact("ID1", "Jane", "Smith", "9876543210", "456 Oak Ave");
        assertThrows(IllegalArgumentException.class, () -> service.addContact(dup));
    }

    @Test
    void testAddNullContact() {
        assertThrows(IllegalArgumentException.class, () -> service.addContact(null));
    }

    // deleteContact

    @Test
    void testDeleteContact() {
        service.deleteContact("ID1");
        assertNull(service.getContact("ID1"));
    }

    @Test
    void testDeleteContactInvalidId() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("NOPE"));
    }

    // updateFirstName

    @Test
    void testUpdateFirstName() {
        service.updateFirstName("ID1", "Jane");
        assertEquals("Jane", service.getContact("ID1").getFirstName());
    }

    @Test
    void testUpdateFirstNameInvalidId() {
        assertThrows(IllegalArgumentException.class,
            () -> service.updateFirstName("NOPE", "Jane"));
    }

    @Test
    void testUpdateFirstNameInvalidValue() {
        assertThrows(IllegalArgumentException.class,
            () -> service.updateFirstName("ID1", "JohnathanXX"));
    }

    // updateLastName

    @Test
    void testUpdateLastName() {
        service.updateLastName("ID1", "Smith");
        assertEquals("Smith", service.getContact("ID1").getLastName());
    }

    @Test
    void testUpdateLastNameInvalidId() {
        assertThrows(IllegalArgumentException.class,
            () -> service.updateLastName("NOPE", "Smith"));
    }

    @Test
    void testUpdateLastNameInvalidValue() {
        assertThrows(IllegalArgumentException.class,
            () -> service.updateLastName("ID1", null));
    }

    // updatePhone

    @Test
    void testUpdatePhone() {
        service.updatePhone("ID1", "9876543210");
        assertEquals("9876543210", service.getContact("ID1").getPhone());
    }

    @Test
    void testUpdatePhoneInvalidId() {
        assertThrows(IllegalArgumentException.class,
            () -> service.updatePhone("NOPE", "9876543210"));
    }

    @Test
    void testUpdatePhoneInvalidValue() {
        assertThrows(IllegalArgumentException.class,
            () -> service.updatePhone("ID1", "123"));
    }

    // updateAddress

    @Test
    void testUpdateAddress() {
        service.updateAddress("ID1", "456 Oak Ave");
        assertEquals("456 Oak Ave", service.getContact("ID1").getAddress());
    }

    @Test
    void testUpdateAddressInvalidId() {
        assertThrows(IllegalArgumentException.class,
            () -> service.updateAddress("NOPE", "456 Oak Ave"));
    }

    @Test
    void testUpdateAddressInvalidValue() {
        assertThrows(IllegalArgumentException.class,
            () -> service.updateAddress("ID1", "1234567890123456789012345678901"));
    }

    // Combined sanity check

    @Test
    void testMultipleUpdatesOnSameContact() {
        service.updateFirstName("ID1", "Jane");
        service.updateLastName("ID1", "Smith");
        service.updatePhone("ID1", "9998887777");
        service.updateAddress("ID1", "789 Pine Rd");

        Contact c = service.getContact("ID1");
        assertEquals("Jane",        c.getFirstName());
        assertEquals("Smith",       c.getLastName());
        assertEquals("9998887777",  c.getPhone());
        assertEquals("789 Pine Rd", c.getAddress());
        // contactId must remain unchanged
        assertEquals("ID1", c.getContactId());
    }
}
