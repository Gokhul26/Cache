package com.goks.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    private final FakeDatabase fakeDatabase = new FakeDatabase();
    private final CustomCache<String> customCache = new CustomCache<>();

    public String getUser(String userId){
        String key = "user:" + userId;

        String cachedvalue = customCache.get(key);
        if( cachedvalue != null){
            log.info("CACHE HIT: {}", cachedvalue);
            return cachedvalue;
        }

        log.info("CACHE MISS -> DB CALL");
        String user = fakeDatabase.getUser(userId);

        customCache.put(key, user, 5000);
        return user;
    }
}
