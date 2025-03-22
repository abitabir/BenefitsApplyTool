/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssp.benefitsapplytool.model;

/**
 *
 * @author khali
 */

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Participant {
    private final LocalDate registrationDate;
    private NationalInsuranceNumber nationalInsuranceNumber;
    private LocalDate dateOfBirth;
    private String primaryTelephone;
    private String primaryEmail;

    private List<FirstNameEvidence> firstNameHistory = new ArrayList<>();
    private List<SurnameEvidence> surnameHistory = new ArrayList<>();
    private List<AddressEvidence> addressHistory = new ArrayList<>();
    private List<BankAccountEvidence> bankAccountHistory = new ArrayList<>();

    public Participant(LocalDate registrationDate, LocalDate dateOfBirth, String firstName, String surname, 
                       String primaryAddress, String bankAccount, String nationalInsuranceNumber, 
                       String primaryTelephone, String primaryEmail) {
        this.registrationDate = registrationDate;
        this.dateOfBirth = dateOfBirth;
        this.primaryTelephone = primaryTelephone;
        this.primaryEmail = primaryEmail;

        // Set initial evidence
        addFirstNameToHistoryAndSetAsActive(firstName);
        addSurnameToHistoryAndSetAsActive(surname);
        addAddressToHistoryAndSetAsActive(primaryAddress);
        addBankAccountToHistoryAndSetAsActive(bankAccount);
        
        this.nationalInsuranceNumber = new NationalInsuranceNumber(Optional.ofNullable(nationalInsuranceNumber));
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    public boolean isProspect() {
        return nationalInsuranceNumber.isProspect();
    }

    public String getNationalInsuranceNumber() {
        return nationalInsuranceNumber.getNumber();
    }

    public void setNationalInsuranceNumber(String nino) {
        this.nationalInsuranceNumber.setNumber(nino);
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setPrimaryTelephone(String telephone) {
        if (validateTelephone(telephone)) {
            this.primaryTelephone = telephone;
        }
    }

    public String getPrimaryTelephone() {
        return primaryTelephone;
    }

    public void setPrimaryEmail(String email) {
        if (validateEmail(email)) {
            this.primaryEmail = email;
        }
    }

    public String getPrimaryEmail() {
        return primaryEmail;
    }

    // First Name Evidence
    public void addFirstNameToHistoryAndSetAsActive(String firstName) {
        FirstNameEvidence evidence = new FirstNameEvidence(firstName);
        firstNameHistory.add(evidence);
    }

    public String getActiveFirstName() {
        if (!firstNameHistory.isEmpty()) {
            return firstNameHistory.get(firstNameHistory.size() - 1).getFirstName();
        }
        return null;
    }

    // Surname Evidence
    public void addSurnameToHistoryAndSetAsActive(String surname) {
        SurnameEvidence evidence = new SurnameEvidence(surname);
        surnameHistory.add(evidence);
    }

    public String getActiveSurname() {
        if (!surnameHistory.isEmpty()) {
            return surnameHistory.get(surnameHistory.size() - 1).getSurname();
        }
        return null;
    }

    // Address Evidence
    public void addAddressToHistoryAndSetAsActive(String address) {
        AddressEvidence evidence = new AddressEvidence(address);
        addressHistory.add(evidence);
    }

    public String getActiveAddress() {
        if (!addressHistory.isEmpty()) {
            return addressHistory.get(addressHistory.size() - 1).getAddress();
        }
        return null;
    }

    // Bank Account Evidence
    public void addBankAccountToHistoryAndSetAsActive(String accountNumber) {
        BankAccountEvidence evidence = new BankAccountEvidence(accountNumber);
        bankAccountHistory.add(evidence);
    }

    public String getActiveBankAccount() {
        if (!bankAccountHistory.isEmpty()) {
            return bankAccountHistory.get(bankAccountHistory.size() - 1).getAccountNumber();
        }
        return null;
    }

    // Validation Methods
    
    public static boolean validateDOB(String dob) {
        return dob.matches("^(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$");
    }
    
    public static boolean validateName(String name) {
        return name.matches("^[A-Za-zÀ-ÿ' -]{1,100}$");
    }
    
    public static boolean validateUKAddress(String address) {
        return address.matches("^([0-9]{1,5})\\s([A-Za-z0-9\\s]{2,50}),\\s*([A-Za-z\\s]{2,50}),\\s*([A-Za-z\\s]{2,50}),\\s*([A-Za-z]{1,2}[0-9]{1,2}[A-Za-z]{0,1}\\s*[0-9]{1,2}[A-Za-z]{2})$");
    }
    
    public static boolean validateBankAccNo(String bankaccno) {
        return bankaccno.matches("^\\d{8}$");
    }

    public static boolean validateNino(String nino) {
        String regex1 = "^(?!BG|GB|KN|NK|NT|TN|ZZ)\\w{2}\\s?\\d{2}\\s?\\d{2}\\s?\\d{2}\\s?[A-D]$";
        String regex2 = "^[ABCEGHJKLMNOPRSTWXYZ][ABCEGHJKLMNPRSTWXYZ]\\s?\\d{2}\\s?\\d{2}\\s?\\d{2}\\s?[A-D]$";
        return nino.matches(regex1) && nino.matches(regex2);
    }
    
    public static boolean validateTelephone(String telephone) {
        return telephone.matches("^\\d{10,15}$");
    }

    public static boolean validateEmail(String email) {
        return email.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }
    
    @Override
    public String toString() {
        return "Registration Date: " + registrationDate + "\n" +
               "First Name: " + getActiveFirstName() + "\n" +
               "Surname: " + getActiveSurname() + "\n" +
               "Primary Address: " + getActiveAddress() + "\n" +
               "Bank Account: " + getActiveBankAccount() + "\n" +
               "Prospect Status: " + (isProspect() ? "Yes" : "No") + "\n" +
               "National Insurance Number: " + (getNationalInsuranceNumber() == null ? "None (Prospect)" : getNationalInsuranceNumber()) + "\n" +
               "Primary Telephone: " + (getPrimaryTelephone() == null ? "Not provided" : getPrimaryTelephone()) + "\n" +
               "Primary Email: " + (getPrimaryEmail() == null ? "Not provided" : getPrimaryEmail()) + "\n";
    }

    
}

