package com.group29.distromentorsystem.controllers;

import com.group29.distromentorsystem.services.ArchivedDealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/archived")
public class ArchivedDealerController {

    @Autowired
    ArchivedDealerService archivedDealerService;


    @GetMapping("/getAllArchivedDealers")
    public ResponseEntity<Object> getAllArchivedDealer(){
        return new ResponseEntity<>(archivedDealerService.getAllArchivedDealer(), HttpStatus.OK);
    }

    @GetMapping("/getAllArchivedDealersByDistributorID/{distributorid}")
    public ResponseEntity<Object> getAllArchivedDealersByDistributorID(@PathVariable String distributorid) {
        return new ResponseEntity<>(archivedDealerService.getAllArchivedDealersByDistributorID(distributorid), HttpStatus.OK);
    }

}
