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

public abstract class Evidence {
    private LocalDate createdOn;

    public Evidence() {
        this.createdOn = LocalDate.now();
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }
}