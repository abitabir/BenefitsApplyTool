/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssp.benefitsapplytool.model;

/**
 *
 * @author khali
 */
public class SurnameEvidence extends Evidence {
    private String surname;

    public SurnameEvidence(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }
}