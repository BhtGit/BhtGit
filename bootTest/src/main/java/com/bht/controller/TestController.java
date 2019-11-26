package com.bht.controller;

import com.alibaba.fastjson.JSONObject;
import com.bht.dao.localDao.LocalTestDao;
import com.bht.dao.matrixDao.MatrixTestDao;
import com.bht.dao.msggwDao.MsggwTestDao;
import com.bht.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "/test")
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Resource
    private MatrixTestDao matrixTestDao;

    @Resource
    private MsggwTestDao msggwTestDao;

    @Resource
    private LocalTestDao localTestDao;

    @Resource
    private ThreadPoolTaskExecutor testExecutor;

    @Resource
    private AsyncService asyncService;

    @RequestMapping(path = "/test1")
    @ResponseBody
    public JSONObject test1() {
        JSONObject result = new JSONObject();

//        String realName = matrixTestDao.testSelect("MR04640592");
//        String bussType = msggwTestDao.testSelect("141");
//
//        result.put(realName, bussType);

        String s = localTestDao.select1();
        result.put("s", s);


        return result;
    }

    private static int i = 0;

    @RequestMapping(path = "/testPool1")
    @ResponseBody
    public JSONObject testPoo1() {
        JSONObject result = new JSONObject();

        i++;
        asyncService.testTaskExecutor(i);
        System.out.println("testPool1");

        return result;
    }

    @RequestMapping(path = "/testPool2")
    @ResponseBody
    public JSONObject testPoo2() {
        JSONObject result = new JSONObject();

        i++;
        asyncService.testTaskExecutor2(i);
        System.out.println("testPool2");

        return result;
    }

    @RequestMapping(path = "/testPool3")
    @ResponseBody
    public JSONObject testPoo3() {
        JSONObject result = new JSONObject();

        i++;
        testExecutor.execute(() -> {
            logger.info("taskExecutor.execute" + i);
            try {
                Thread.sleep(1000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        return result;
    }

    @RequestMapping(path = "/test0001")
    @ResponseBody
    public String test0001(HttpServletRequest request) {

        String queryString = request.getQueryString();
        System.out.println(queryString);



        return "123";
    }




}
