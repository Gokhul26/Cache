package com.goks.cache;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheController {
    private final UserService userService;

    public CacheController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getUser() {
        String user1 = userService.getUser("101");
        String user2 = userService.getUser("101");

        return user1 + " | " + user2;
    }

}
