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
package com.example.controllers;

import com.example.bean.SuccessResult;
import com.example.service.DeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * *Controller for delete
 *
 * @author DinBT
 */

@RestController
@RequestMapping("delete")
public class DeleteController {
    @Autowired
    private DeleteService deleteService;

    /**
     * Solving and response data for request from client if user want to delete
     *
     * @param table: table to apply
     * @param id:    id about record
     * @return ResponseEntity<SuccessResult>: result
     */
    @RequestMapping(value = "/{table}/{id}", method = RequestMethod.GET)
    public ResponseEntity<SuccessResult> editData(@PathVariable(value = "table") String table, @PathVariable(value = "id") String id) {
        deleteService.deleteData(table, id);
        return new ResponseEntity<>(new SuccessResult("200", "delete successfully"), HttpStatus.OK);
    }
}
