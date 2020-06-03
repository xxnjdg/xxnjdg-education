package io.xxnjdg.notp.course.util;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 2020/5/28 15:28
 */
public class CourseLock {

    private static CourseLock ourInstance = new CourseLock();
    private ConcurrentHashMap<Long,ReentrantLock> concurrentHashMap = new ConcurrentHashMap<>();

    public static CourseLock getInstance() {
        return ourInstance;
    }

    private CourseLock() {
    }

    public ReentrantLock getLock(Long key){
        return concurrentHashMap.computeIfAbsent(key,s -> new ReentrantLock());
    }
}
