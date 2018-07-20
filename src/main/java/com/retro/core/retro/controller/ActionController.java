package com.retro.core.retro.controller;

import com.retro.core.retro.model.Action;
import com.retro.core.retro.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/action")
public class ActionController {

    @Autowired
    ActionService actionService;

    @RequestMapping(value = "/create")
    public ResponseEntity createAction(@RequestBody Action action){
        actionService.create(action);
        return new ResponseEntity<>(action, HttpStatus.OK);
    }

    @RequestMapping("/load")
    public ResponseEntity loadAction(@RequestParam String retroKey){
        Action action = actionService.getActionByRetroKey(retroKey);
        return new ResponseEntity(action, HttpStatus.OK);
    }
}
