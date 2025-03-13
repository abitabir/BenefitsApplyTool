/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ssp.benefitsapplytool.model;

/**
 *
 * @author khali
 */

public class AddressEvidence extends Evidence {
    private String address;

    public AddressEvidence(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}