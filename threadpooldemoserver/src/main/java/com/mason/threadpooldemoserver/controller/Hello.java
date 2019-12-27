package com.mason.threadpooldemoserver.controller;

import com.mason.threadpooldemoserver.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 * @Author zhuyumeng
 * @Date 2019-12-27 11:26
 * @Version 1.0
 */
@RestController
public class Hello {

    private final Logger logger = LoggerFactory.getLogger(Hello.class);

    @Resource
    private AsyncService asyncService;

    @GetMapping("")
    public String submit(){
        logger.info("start submit");

        //调用service层的任务
        asyncService.executeAsync();

        logger.info("end submit");

        return "success";
    }
}
