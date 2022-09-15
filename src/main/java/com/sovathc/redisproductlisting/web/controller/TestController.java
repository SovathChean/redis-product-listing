package com.sovathc.redisproductlisting.web.controller;

import com.sovathc.redisproductlisting.web.vo.response.ResponseBuilderMessage;
import com.sovathc.redisproductlisting.web.vo.response.ResponseMessage;
import com.sovathc.redisproductlisting.web.vo.response.test.TestResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @GetMapping("/api/test")
    public ResponseMessage<TestResponse> test()
    {
        TestResponse testResponse = new TestResponse();
        testResponse.setMessage("HI");
        return new ResponseBuilderMessage<TestResponse>().success().build();
    }
    @GetMapping("/api/list-test")
    public ResponseMessage<List<TestResponse>> getListTest()
    {
        TestResponse testResponse = new TestResponse();
        testResponse.setMessage("HI");
        return new ResponseBuilderMessage<List<TestResponse>>().success().build();
    }
}
