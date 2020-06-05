package com.example.controllers;

import com.example.bean.SuccessResult;
import com.example.service.AddService;
import com.example.service.DeleteService;
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
@RequestMapping("delete")
public class DeleteController {
    @Autowired
    private DeleteService deleteService;

    @RequestMapping(value = "/{table}/{id}", method = RequestMethod.GET)
    public ResponseEntity<SuccessResult> editData(@PathVariable(value = "table") String table, @PathVariable(value = "id") String id) {
        deleteService.deleteData(table, id);
        return new ResponseEntity<>(new SuccessResult("200", "delete successfully"), HttpStatus.OK);
    }
}
