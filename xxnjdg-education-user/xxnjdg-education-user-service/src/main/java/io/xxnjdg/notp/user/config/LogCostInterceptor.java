package io.xxnjdg.notp.user.config;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;

/**
 * @author xxnjdg
 * @version 1.0
 * @date 20-4-25 上午10:55
 */
public class LogCostInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        ServletInputStream inputStream = request.getInputStream();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        IOUtils.copy(inputStream, byteArrayOutputStream);

        byte[] bytes = byteArrayOutputStream.toByteArray();
        String body = new String(bytes, Charset.forName("UTF-8"));

        System.out.println("=======================" + body);
        return false;
    }
}
