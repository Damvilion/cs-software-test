import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ContactTest {

    private Contact createValidContact() {
        return new Contact("C123", "John", "Doe", "1234567890", "123 Main St");
    }

    @Test
    void constructor_validContact_createsContact() {
        Contact contact = createValidContact();

        assertEquals("C123", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    void constructor_boundaryLengths_allowed() {
        Contact contact = new Contact(
                "1234567890",
                "1234567890",
                "ABCDEFGHIJ",
                "0123456789",
                "123456789012345678901234567890");

        assertEquals("1234567890", contact.getContactId());
        assertEquals("1234567890", contact.getFirstName());
        assertEquals("ABCDEFGHIJ", contact.getLastName());
        assertEquals("0123456789", contact.getPhone());
        assertEquals(30, contact.getAddress().length());
    }

    @Test
    void constructor_invalidId_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact(null, "John", "Doe", "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    void constructor_invalidFirstName_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", null, "Doe", "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "12345678901", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    void constructor_invalidLastName_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "John", null, "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "John", "12345678901", "1234567890", "123 Main St"));
    }

    @Test
    void constructor_invalidPhone_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "John", "Doe", null, "123 Main St"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "John", "Doe", "123456789", "123 Main St"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "John", "Doe", "12345678901", "123 Main St"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "John", "Doe", "12345abcde", "123 Main St"));
    }

    @Test
    void constructor_invalidAddress_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "John", "Doe", "1234567890", null));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1", "John", "Doe", "1234567890",
                        "1234567890123456789012345678901"));
    }

    @Test
    void setters_validValues_updateAllowedFields() {
        Contact contact = createValidContact();

        contact.setFirstName("Jane");
        contact.setLastName("Smith");
        contact.setPhone("0987654321");
        contact.setAddress("456 Oak Ave");

        assertEquals("Jane", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("0987654321", contact.getPhone());
        assertEquals("456 Oak Ave", contact.getAddress());
    }

    @Test
    void setFirstName_invalidValues_throwIllegalArgumentException() {
        Contact contact = createValidContact();

        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("12345678901"));
    }

    @Test
    void setLastName_invalidValues_throwIllegalArgumentException() {
        Contact contact = createValidContact();

        assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName("12345678901"));
    }

    @Test
    void setPhone_invalidValues_throwIllegalArgumentException() {
        Contact contact = createValidContact();

        assertThrows(IllegalArgumentException.class, () -> contact.setPhone(null));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("12345"));
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("123456789A"));
    }

    @Test
    void setAddress_invalidValues_throwIllegalArgumentException() {
        Contact contact = createValidContact();

        assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
        assertThrows(IllegalArgumentException.class,
                () -> contact.setAddress("1234567890123456789012345678901"));
    }

    @Test
    void contactId_isImmutableAfterUpdates() {
        Contact contact = createValidContact();
        String originalId = contact.getContactId();

        contact.setFirstName("Jane");
        contact.setLastName("Smith");
        contact.setPhone("0987654321");
        contact.setAddress("999 New St");

        assertEquals(originalId, contact.getContactId());
    }
}
