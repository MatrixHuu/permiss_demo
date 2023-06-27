package org.javaboy.permiss_demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xyma
 * @version 1.0
 * @data 2023/6/27 12:45
 */
@RestController
public class UserController {
    @RequestMapping("/add")
//    @PreAuthorize("hasPermission('/add','system:user:add')")
    @PreAuthorize("hasPermission('system:user:add')")
    public String add() {
        return "add";
    }

    //    @PreAuthorize("hasPermission('/delete','system:user:delete')")
    @PreAuthorize("hasAnyPermission('system:user:add', 'system:user:delete')")
    @RequestMapping("/delete")
    public String delete() {
        return "delete";
    }

    //    @PreAuthorize("hasPermission('/update','system:user:update')")
    @PreAuthorize("hasAllPermission('system:user:add', 'system:user:delete')")
    @RequestMapping("/update")
    public String update() {
        return "update";
    }

    //    @PreAuthorize("hasPermission('/select','system:user:select')")
    @PreAuthorize("hasAllPermission('system:user:add', 'system:user:delete', 'system:user:select')")
    @RequestMapping("/select")
    public String select() {
        return "select";
    }
}
