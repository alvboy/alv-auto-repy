package com.yupi.autoreply.controller;

import com.yupi.autoreply.answerer.Answerer;
import com.yupi.autoreply.answerer.OpenAiAnswerer;
import com.yupi.autoreply.common.BaseResponse;
import com.yupi.autoreply.common.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 开放接口
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
@RestController
@RequestMapping("/openai")
@Slf4j
public class MainController {

    @GetMapping("/quiz")
    public BaseResponse<String> quziAnswer(String quizContext) {
        try {
            Answerer answerer = new OpenAiAnswerer();
            String answer = answerer.doAnswer(quizContext);
            return ResultUtils.success(answer);
        } catch (Exception e) {
            log.error("【提问异常】msg = {}, e = {}", e.getMessage(), e);
            return ResultUtils.error(500, e.getMessage());
        }
    }

}
