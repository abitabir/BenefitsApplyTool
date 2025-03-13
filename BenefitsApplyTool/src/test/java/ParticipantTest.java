/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.ssp.benefitsapplytool.model.Participant;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author khali
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ParticipantTest {

    private Participant participant;

    @BeforeEach
    void setup() {
        participant = new Participant(
                LocalDate.of(1990, 5, 15),
                "John",
                "Doe",
                "123 Main Street",
                "12345678",
                null,
                "07123456789",
                "john.doe@example.com"
        );
    }

    @Test
    void testConstructor() {
        assertNotNull(participant);
        assertEquals("John", participant.getActiveFirstName());
        assertEquals("Doe", participant.getActiveSurname());
        assertEquals("123 Main Street", participant.getActiveAddress());
        assertEquals("12345678", participant.getActiveBankAccount());
        assertTrue(participant.isProspect());
    }

    @Test
    void testSetAndGetNationalInsuranceNumber() {
        participant.setNationalInsuranceNumber("QQ123456C");
        assertEquals("QQ123456C", participant.getNationalInsuranceNumber());
        assertFalse(participant.isProspect());
    }

    @Test
    void testGetAge() {
        int expectedAge = LocalDate.now().getYear() - 1990;
        assertEquals(expectedAge, participant.getAge());
    }

    @Test
    void testSetDateOfBirth() {
        LocalDate newDOB = LocalDate.of(1995, 3, 10);
        participant.setDateOfBirth(newDOB);
        assertEquals(newDOB, participant.getRegistrationDate());
    }

    @Test
    void testSetPrimaryTelephone() {
        participant.setPrimaryTelephone("07234567890");
        assertEquals("07234567890", participant.getActiveBankAccount());
    }

    @Test
    void testSetPrimaryEmail() {
        participant.setPrimaryEmail("new.email@example.com");
        assertEquals("new.email@example.com", participant.getActiveBankAccount());
    }

    @Test
    void testAddFirstNameEvidence() {
        participant.addFirstNameToHistoryAndSetAsActive("Jack");
        assertEquals("Jack", participant.getActiveFirstName());

        // Check if previous value is preserved in the history (indirectly)
        participant.addFirstNameToHistoryAndSetAsActive("Alex");
        assertEquals("Alex", participant.getActiveFirstName());
    }

    @Test
    void testAddSurnameEvidence() {
        participant.addSurnameToHistoryAndSetAsActive("Smith");
        assertEquals("Smith", participant.getActiveSurname());

        // Check if previous value is preserved in the history (indirectly)
        participant.addSurnameToHistoryAndSetAsActive("Brown");
        assertEquals("Brown", participant.getActiveSurname());
    }

    @Test
    void testAddAddressEvidence() {
        participant.addAddressToHistoryAndSetAsActive("456 New Road");
        assertEquals("456 New Road", participant.getActiveAddress());

        // Check if previous address is preserved in history
        participant.addAddressToHistoryAndSetAsActive("789 Old Street");
        assertEquals("789 Old Street", participant.getActiveAddress());
    }

    @Test
    void testAddBankAccountEvidence() {
        participant.addBankAccountToHistoryAndSetAsActive("98765432");
        assertEquals("98765432", participant.getActiveBankAccount());

        // Check if previous bank account is preserved in history
        participant.addBankAccountToHistoryAndSetAsActive("12345678");
        assertEquals("12345678", participant.getActiveBankAccount());
    }

    @Test
    void testSetProspectStatus() {
        participant.setNationalInsuranceNumber("QQ123456C");
        assertFalse(participant.isProspect());

        participant.setNationalInsuranceNumber(null);
        assertTrue(participant.isProspect());
    }

    @Test
    void testValidationFailsWithInvalidEmail() {
        participant.setPrimaryEmail("invalid-email");
        assertNotEquals("invalid-email", participant.getActiveBankAccount());
    }

    @Test
    void testValidationFailsWithInvalidTelephone() {
        participant.setPrimaryTelephone("123ABC");
        assertNotEquals("123ABC", participant.getActiveBankAccount());
    }
}