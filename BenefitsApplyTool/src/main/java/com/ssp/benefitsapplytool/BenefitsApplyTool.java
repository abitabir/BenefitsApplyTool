/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.ssp.benefitsapplytool;

/**
 *
 * @author khali
 */

import com.ssp.benefitsapplytool.view.ParticipantView;
import com.ssp.benefitsapplytool.model.Participant;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class BenefitsApplyTool {

    private static final Scanner scanner = new Scanner(System.in);

    // Method to prompt for input
    public static String promptForInput(String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }

    // Method to handle Date of Birth validation
    public static LocalDate getValidDateOfBirth() {
        String dateOfBirthString;
        LocalDate dateOfBirth = null;
        do {
            dateOfBirthString = promptForInput("Enter Date of Birth (YYYY-MM-DD): ");
            if (!Participant.validateDOB(dateOfBirthString)) {
                ParticipantView.displayError("Invalid date. Please use YYYY-MM-DD format, where year is between 1900 and 2999.");
            } else {                
                try {
                    dateOfBirth = LocalDate.parse(dateOfBirthString);
                } catch (DateTimeParseException e) {
                    ParticipantView.displayError("Invalid date format. Please use YYYY-MM-DD format.");
                }
            }
        } while (dateOfBirth == null);
        return dateOfBirth;
    }

    // Method to handle name validation (for first name and surname)
    public static String getValidName(String field) {
        String name;
        do {
            name = promptForInput("Enter " + field + ": ");
            if (!Participant.validateName(name)) {
                ParticipantView.displayError("Invalid " + field.toLowerCase() + " format.");
            }
        } while (!Participant.validateName(name));
        return name;
    }

    // Method to handle address validation
    public static String getValidAddress() {
        String address;
        do {
            address = promptForInput("Enter Primary Address (UK address format): ");
            if (!Participant.validateUKAddress(address)) {
                ParticipantView.displayError("Invalid UK address format. Please enter your address in the format: [House Number] [Street Name], [City], [Region], [Postcode].");
            }
        } while (!Participant.validateUKAddress(address));
        return address;
    }

    // Method to handle bank account number validation
    public static String getValidBankAccount() {
        String bankAccount;
        do {
            bankAccount = promptForInput("Enter Primary Bank Account: ");
            if (!Participant.validateBankAccNo(bankAccount)) {
                ParticipantView.displayError("Invalid Bank Account Number. Must be exactly 8 digits.");
            }
        } while (!Participant.validateBankAccNo(bankAccount));
        return bankAccount;
    }

    // Method to handle telephone validation
    public static String getValidTelephone() {
        String telephone;
        do {
            telephone = promptForInput("Enter Primary Telephone (or press Enter to skip): ");
            if (!telephone.isEmpty() && !Participant.validateTelephone(telephone)) {
                ParticipantView.displayError("Invalid telephone number format. Must be 10-15 digits.");
            }
        } while (!telephone.isEmpty() && !Participant.validateTelephone(telephone));
        return telephone;
    }

    // Method to handle National Insurance Number validation
    public static String getValidNino() {
        String nino;
        do {
            nino = promptForInput("Enter National Insurance Number (or press Enter to skip): ");
            if (!nino.isEmpty() && !Participant.validateNino(nino)) {
                ParticipantView.displayError("Invalid National Insurance Number format. Must follow UK Gov guidelines.");
            }
        } while (!nino.isEmpty() && !Participant.validateNino(nino));
        return nino;
    }

    // Method to handle email validation
    public static String getValidEmail() {
        String email;
        do {
            email = promptForInput("Enter Primary Email (or press Enter to skip): ");
            if (!email.isEmpty() && !Participant.validateEmail(email)) {
                ParticipantView.displayError("Invalid email format.");
            }
        } while (!email.isEmpty() && !Participant.validateEmail(email));
        return email;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Benefits Apply Tool!");

        LocalDate registrationDate = LocalDate.now();
        
        LocalDate dateOfBirth = getValidDateOfBirth();
        String firstName = getValidName("First Name");
        String surname = getValidName("Surname");
        String primaryAddress = getValidAddress();  
        String bankAccount = getValidBankAccount();
        String nino = getValidNino();
        String telephone = getValidTelephone();
        String email = getValidEmail();

        // Create participant
        Participant participant = new Participant(registrationDate, dateOfBirth, firstName, surname, primaryAddress, bankAccount,
                nino.isEmpty() ? null : nino, telephone.isEmpty() ? null : telephone, email.isEmpty() ? null : email);

        System.out.println("Participant Registration Complete.");
        ParticipantView.displayParticipantInfo(participant);

        String editChoice = promptForInput("Would you like to edit any editable details? (yes/no) ");
        if (editChoice.equalsIgnoreCase("yes")) {
            boolean editing = true;

            while (editing) {
                ParticipantView.displayEditOptions();

                String choice = promptForInput("Please enter the corresponding number of the detail you want to edit: ");

                switch (choice) {
                    case "1":
                        String newFirstName = getValidName("First Name");
                        participant.addFirstNameToHistoryAndSetAsActive(newFirstName);
                        System.out.println("First Name updated.");
                        break;
                    case "2":
                        String newSurname = getValidName("Surname");
                        participant.addSurnameToHistoryAndSetAsActive(newSurname);
                        System.out.println("Surname updated.");
                        break;
                    case "3":
                        String newAddress = getValidAddress();
                        participant.addAddressToHistoryAndSetAsActive(newAddress);
                        System.out.println("Address updated.");
                        break;
                    case "4":
                        String newBankAccount = getValidBankAccount();
                        participant.addBankAccountToHistoryAndSetAsActive(newBankAccount);
                        System.out.println("Bank Account updated.");
                        break;
                    case "5":
                        String newTelephone = getValidTelephone();
                        participant.setPrimaryTelephone(newTelephone);
                        System.out.println("Telephone updated.");
                        break;
                    case "6":
                        LocalDate newDob = getValidDateOfBirth();
                        participant.setDateOfBirth(newDob);
                        System.out.println("Date of Birth updated.");
                        break;
                    case "7":
                        String newNino = getValidNino();
                        participant.setNationalInsuranceNumber(newNino);
                        System.out.println("National Insurance Number updated.");
                        break;
                    case "8":
                        editing = false;
                        System.out.println("Participant Registration Editing Complete.");
                        ParticipantView.displayParticipantInfo(participant);
                        break;
                    default:
                        ParticipantView.displayError("Invalid choice. Please select a valid option.");
                        break;
                }
            }
        } else {
            ParticipantView.displayError("Terminating program.");
        }

        scanner.close();
    }
}

