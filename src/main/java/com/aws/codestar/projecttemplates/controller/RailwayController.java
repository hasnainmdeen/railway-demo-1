package com.aws.codestar.projecttemplates.controller;

import com.aws.codestar.projecttemplates.model.CheckConflictRequest;
import com.aws.codestar.projecttemplates.model.CheckConflictResponse;
import com.aws.codestar.projecttemplates.service.PathFinderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/railway")
public class RailwayController {


    @Autowired
    private PathFinderServiceImpl pathFinderServiceImpl;


    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello, the service is up!");
    }

    //@RequestMapping(path = "/check_conflicts", method = RequestMethod.POST, produces = "application/json")
    @PostMapping("/check_conflicts")
    public ResponseEntity<?> checkConflicts(@RequestBody CheckConflictRequest request) {
        try {
            boolean isPathValid = pathFinderServiceImpl.checkConflicts(request);
            return ResponseEntity.ok(new CheckConflictResponse(isPathValid));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }

    }

}
