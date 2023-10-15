package com.aws.codestar.projecttemplates.controller;

import com.aws.codestar.projecttemplates.model.CheckConflictRequest;
import com.aws.codestar.projecttemplates.model.CheckConflictResponse;
import com.aws.codestar.projecttemplates.service.PathFinderServiceImpl;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(path = "/check_conflicts", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<CheckConflictResponse> checkConflicts(@RequestBody CheckConflictRequest request) {
        boolean isPathValid = pathFinderServiceImpl.checkConflicts(request);
        return ResponseEntity.ok(new CheckConflictResponse(isPathValid));
    }

}
