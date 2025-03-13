/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssp.benefitsapplytool.model;

/**
 *
 * @author khali
 */

public class BankAccountEvidence extends Evidence {
    private String accountNumber;

    public BankAccountEvidence(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
