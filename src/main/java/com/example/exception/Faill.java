package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * ResponseStatus when resquest not pass requeiment
 *
 * @author DinBT
 */
@ResponseStatus(HttpStatus.SEE_OTHER)
public class Faill extends RuntimeException {

    String mesage;

    public String getMesage() {
        return mesage;
    }

    public void setMesage(String mesage) {
        this.mesage = mesage;
    }

    public Faill(String message) {
        this.mesage = message;
    }
}
