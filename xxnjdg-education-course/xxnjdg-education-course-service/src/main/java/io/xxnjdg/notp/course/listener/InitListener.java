package io.xxnjdg.notp.course.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-28 下午4:26
 */
@WebListener
public class InitListener implements ServletContextListener {

    private static Logger logger = LoggerFactory.getLogger(InitListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.error("我要初始化了~~~~~~~~~~~~~~");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.error("我要销毁了~~~~~~~~~~~~~~");
    }
}
