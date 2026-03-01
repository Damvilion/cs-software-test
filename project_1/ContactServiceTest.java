import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    private ContactService service;

    @BeforeEach
    void setUp() {
        service = new ContactService();
    }

    private Contact createContact(String id) {
        return new Contact(id, "John", "Doe", "1234567890", "123 Main St");
    }

    @Test
    void addContact_valid_storesContact() {
        service.addContact(createContact("C1"));

        Contact stored = service.getContactById("C1");
        assertNotNull(stored);
        assertEquals("C1", stored.getContactId());
    }

    @Test
    void addContact_nullContact_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> service.addContact(null));
    }

    @Test
    void addContact_duplicateId_throwsIllegalArgumentException() {
        service.addContact(createContact("C1"));

        assertThrows(IllegalArgumentException.class, () -> service.addContact(createContact("C1")));
    }

    @Test
    void deleteContact_existing_removesContact() {
        service.addContact(createContact("C1"));

        service.deleteContact("C1");

        assertThrows(IllegalArgumentException.class, () -> service.getContactById("C1"));
    }

    @Test
    void deleteContact_nullOrMissingId_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact(null));
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("missing"));
    }

    @Test
    void updateFirstName_valid_updatesOnlyFirstName() {
        service.addContact(createContact("C1"));

        service.updateFirstName("C1", "Jane");

        Contact contact = service.getContactById("C1");
        assertEquals("Jane", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
        assertEquals("C1", contact.getContactId());
    }

    @Test
    void updateLastName_valid_updatesLastName() {
        service.addContact(createContact("C1"));

        service.updateLastName("C1", "Smith");

        assertEquals("Smith", service.getContactById("C1").getLastName());
    }

    @Test
    void updatePhone_valid_updatesPhone() {
        service.addContact(createContact("C1"));

        service.updatePhone("C1", "0987654321");

        assertEquals("0987654321", service.getContactById("C1").getPhone());
    }

    @Test
    void updateAddress_valid_updatesAddress() {
        service.addContact(createContact("C1"));

        service.updateAddress("C1", "456 Oak Ave");

        assertEquals("456 Oak Ave", service.getContactById("C1").getAddress());
    }

    @Test
    void updateMethods_missingId_throwIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("missing", "Jane"));
        assertThrows(IllegalArgumentException.class, () -> service.updateLastName("missing", "Smith"));
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("missing", "0987654321"));
        assertThrows(IllegalArgumentException.class, () -> service.updateAddress("missing", "456 Oak Ave"));
    }

    @Test
    void updateMethods_invalidValues_throwIllegalArgumentException() {
        service.addContact(createContact("C1"));

        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("C1", null));
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("C1", "12345678901"));
        assertThrows(IllegalArgumentException.class, () -> service.updateLastName("C1", null));
        assertThrows(IllegalArgumentException.class, () -> service.updateLastName("C1", "12345678901"));
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("C1", null));
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("C1", "12345"));
        assertThrows(IllegalArgumentException.class, () -> service.updateAddress("C1", null));
        assertThrows(IllegalArgumentException.class,
                () -> service.updateAddress("C1", "1234567890123456789012345678901"));
    }

    @Test
    void getContactById_nullOrMissing_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> service.getContactById(null));
        assertThrows(IllegalArgumentException.class, () -> service.getContactById("missing"));
    }
}
