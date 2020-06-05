package com.example.controllers;

import com.example.bean.SuccessResult;
import com.example.service.AddService;
import com.example.service.EditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * *Controller for add
 *
 * @author DinBT
 */

@RestController
@RequestMapping("add")
public class AddController {
    @Autowired
    private AddService addService;

    @RequestMapping(value = "/{table}/{jsonData}", method = RequestMethod.GET)
    public ResponseEntity<SuccessResult> editData(@PathVariable(value = "table") String table, @PathVariable(value = "jsonData") String jsonData) {
        addService.addData(table, jsonData);
        return new ResponseEntity<>(new SuccessResult("200", "add successfully"), HttpStatus.OK);
    }
}
