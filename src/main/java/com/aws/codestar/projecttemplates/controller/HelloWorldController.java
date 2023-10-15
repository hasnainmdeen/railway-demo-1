package com.aws.codestar.projecttemplates.controller;

import com.aws.codestar.projecttemplates.model.CheckConflictRequest;
import com.aws.codestar.projecttemplates.model.CheckConflictResponse;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Basic Spring web service controller that handles all GET requests.
 */
@RestController
@RequestMapping("/")
public class HelloWorldController {

    private static final String MESSAGE_FORMAT = "Hello %s!";

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity helloWorldGet(@RequestParam(value = "name", defaultValue = "World - so the annotation thingy works!") String name) {
        return ResponseEntity.ok(createResponse(name));
    }

    //@PostMapping("/test")
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<CheckConflictResponse> helloWorldPost(@RequestBody CheckConflictRequest request) {
        return ResponseEntity.ok(new CheckConflictResponse(true));
        //return ResponseEntity.ok(createResponse(name));
    }

    private String createResponse(String name) {
        return new JSONObject().put("Output", String.format(MESSAGE_FORMAT, name)).toString();
    }
}
