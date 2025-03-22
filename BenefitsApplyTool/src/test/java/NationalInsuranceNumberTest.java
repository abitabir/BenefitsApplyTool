/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.ssp.benefitsapplytool.model.NationalInsuranceNumber;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author khali
 */


import org.junit.jupiter.api.Test;

import java.util.Optional;

class NationalInsuranceNumberTest {

    @Test
    void testConstructorWithNumber() {
        NationalInsuranceNumber nino = new NationalInsuranceNumber(Optional.of("QQ123456C"));
        assertEquals("QQ123456C", nino.getNumber());
        assertFalse(nino.isProspect());
    }

    @Test
    void testConstructorWithoutNumber() {
        NationalInsuranceNumber nino = new NationalInsuranceNumber(Optional.empty());
        assertNull(nino.getNumber());
        assertTrue(nino.isProspect());
    }

    @Test
    void testSetNumber() {
        NationalInsuranceNumber nino = new NationalInsuranceNumber(Optional.empty());
        nino.setNumber("QQ123456C");
        assertEquals("QQ123456C", nino.getNumber());
        assertFalse(nino.isProspect());
    }
}
