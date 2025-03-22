package com.ssp.benefitsapplytool.view;


import com.ssp.benefitsapplytool.model.Participant;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author khali
 */

public class ParticipantView {

    // Method to display the participant's registration information
    public static void displayParticipantInfo(Participant participant) {
        System.out.println(participant); // Uses overridden toString() in Participant class
        System.out.println("\n");
    }

    // Method to display an error message
    public static void displayError(String message) {
        System.out.println("Error: " + message);
    }

    // Method to display options for editing
    public static void displayEditOptions() {
        System.out.println("\n");
        System.out.println("Which detail would you like to edit?");
        System.out.println("1. First Name");
        System.out.println("2. Surname");
        System.out.println("3. Address");
        System.out.println("4. Bank Account");
        System.out.println("5. Telephone");
        System.out.println("6. Date of Birth");
        System.out.println("7. National Insurance Number");
        System.out.println("8. Exit editing");
    }
}


