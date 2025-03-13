/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ssp.benefitsapplytool;

import com.ssp.benefitsapplytool.model.Participant;
import java.time.LocalDate;

/**
 *
 * @author khali
 */
public class BenefitsApplyTool {

    public static void main(String[] args) {
        Participant participant = new Participant(
            LocalDate.of(1990, 1, 1), 
            "John", 
            "Doe", 
            "123 Main Street", 
            "12345678", 
            null, 
            "07123456789", 
            "john.doe@example.com"
        );

        System.out.println("Age: " + participant.getAge());
    }
}

