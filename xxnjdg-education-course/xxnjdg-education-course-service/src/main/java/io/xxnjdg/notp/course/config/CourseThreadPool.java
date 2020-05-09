package io.xxnjdg.notp.course.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;


/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-28 下午4:33
 */
@Configuration(proxyBeanMethods = false)
public class CourseThreadPool {

    @Bean
    public ThreadPoolExecutor courseThreadPoolExecutorService(){

        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("course-thread-%d").build();

        return new ThreadPoolExecutor(
                50, 200, 0L, TimeUnit.MICROSECONDS,
                new LinkedBlockingQueue<>(1024), threadFactory, new ThreadPoolExecutor.AbortPolicy());
    }

}
