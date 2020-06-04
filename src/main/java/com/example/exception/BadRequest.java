/*
 * Copyright 2015-2016 Classmethod, Inc.
 * All Rights Reserved.
 *
 * NOTICE:  All source code, documentation and other information
 * contained herein is, and remains the property of Classmethod, Inc.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Classmethod, Inc.
 */
package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * ResponseStatus when resquest not pass requeiment
 *
 * @author DinBT
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequest extends RuntimeException {

    public BadRequest(String message) {
        super(message);
    }
}
