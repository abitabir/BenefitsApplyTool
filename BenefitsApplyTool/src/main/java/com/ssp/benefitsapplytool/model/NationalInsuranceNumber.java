/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssp.benefitsapplytool.model;

/**
 *
 * @author khali
 */

import java.util.Optional;

public class NationalInsuranceNumber {
    private String number;
    private boolean isProspect;

    public NationalInsuranceNumber(Optional<String> number) {
        if (number.isPresent()) {
            this.number = number.get();
            this.isProspect = false;
        } else {
            this.isProspect = true;
        }
    }

    public boolean isProspect() {
        return isProspect;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
        this.isProspect = number == null;
    }
}
