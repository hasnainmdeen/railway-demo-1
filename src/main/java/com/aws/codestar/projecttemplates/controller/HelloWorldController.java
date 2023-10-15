package com.aws.codestar.projecttemplates.controller;

import com.aws.codestar.projecttemplates.model.CheckConflictRequest;
import com.aws.codestar.projecttemplates.model.CheckConflictResponse;
import com.aws.codestar.projecttemplates.service.PathFinderServiceImpl;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Basic Spring web service controller that handles all GET requests.
 */
@RestController
@RequestMapping("/railway")
public class HelloWorldController {

    @Autowired
    private PathFinderServiceImpl pathFinderServiceImpl;

    @PostMapping("/check_conflicts")
    public ResponseEntity<CheckConflictResponse> helloWorldPost(@RequestBody CheckConflictRequest request) {
        boolean isPathValid = pathFinderServiceImpl.checkConflicts(request);
        return ResponseEntity.ok(new CheckConflictResponse(isPathValid));
    }
}
