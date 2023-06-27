package org.javaboy.permiss_demo.controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * @author xyma
 * @version 1.0
 * @data 2023/6/27 12:35
 */
@RestController
public class HelloController {
    @GetMapping("hello")
    public void hello() {
        Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        for (GrantedAuthority authority : authorities) {
            System.out.println("authority" + authority);
        }
    }
}
