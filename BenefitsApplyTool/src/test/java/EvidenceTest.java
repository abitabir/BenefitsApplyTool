/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.ssp.benefitsapplytool.model.AddressEvidence;
import com.ssp.benefitsapplytool.model.BankAccountEvidence;
import com.ssp.benefitsapplytool.model.FirstNameEvidence;
import com.ssp.benefitsapplytool.model.SurnameEvidence;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author khali
 */



import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EvidenceTest {

    @Test
    void testFirstNameEvidenceCreation() {
        FirstNameEvidence evidence = new FirstNameEvidence("John");
        assertEquals("John", evidence.getFirstName());
        assertNotNull(evidence.getCreatedOn());
    }

    @Test
    void testSurnameEvidenceCreation() {
        SurnameEvidence evidence = new SurnameEvidence("Doe");
        assertEquals("Doe", evidence.getSurname());
        assertNotNull(evidence.getCreatedOn());
    }

    @Test
    void testAddressEvidenceCreation() {
        AddressEvidence evidence = new AddressEvidence("123 Street");
        assertEquals("123 Street", evidence.getAddress());
        assertNotNull(evidence.getCreatedOn());
    }

    @Test
    void testBankAccountEvidenceCreation() {
        BankAccountEvidence evidence = new BankAccountEvidence("12345678");
        assertEquals("12345678", evidence.getAccountNumber());
        assertNotNull(evidence.getCreatedOn());
    }
}