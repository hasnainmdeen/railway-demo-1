package com.aws.codestar.projecttemplates.controller;

import com.aws.codestar.projecttemplates.model.CheckConflictResponse;
import com.aws.codestar.projecttemplates.service.PathFinderServiceImpl;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Basic Spring web service controller that handles all GET requests.
 */
@RestController
@RequestMapping("/")
public class HelloWorldController {


    @Autowired
    private PathFinderServiceImpl pathFinderServiceImpl;
    private static final String MESSAGE_FORMAT = "Hello %s!";

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity helloWorldGet(@RequestParam(value = "name", defaultValue = "World") String name) {
        return ResponseEntity.ok(createResponse(name));
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<CheckConflictResponse> helloWorldPost(@RequestParam(value = "name", defaultValue = "World") String name) {
        //return ResponseEntity.ok(createResponse(name));
        boolean isPathValid = pathFinderServiceImpl.checkConflicts(request);
        return ResponseEntity.ok(new CheckConflictResponse(isPathValid));
    }

    private String createResponse(String name) {
        return new JSONObject().put("Output", String.format(MESSAGE_FORMAT, name)).toString();
    }
}
