package com.example.bootactiviti7.aspect;

import com.example.bootactiviti7.aspect.enums.BusinessType;
import com.example.bootactiviti7.aspect.log.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shaotianyou
 * @version 1.0.0
 * @ClassName LogImpl.java
 * @Description TODO
 * @createTime 2021年08月19日 17:18:00
 */
@RestController
public class LogController {

    @GetMapping("/testLog")
    @Log(title = "测试删除日志", businessType = BusinessType.DELETE)
    public String testLogTag(String name, Integer age){
        return "测试删除日志返回结果";
    }
}
