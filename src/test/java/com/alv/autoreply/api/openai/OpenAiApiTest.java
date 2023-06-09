package com.alv.autoreply.api.openai;

import com.alv.autoreply.api.openai.model.CreateCompletionRequest;
import com.alv.autoreply.api.openai.model.CreateCompletionResponse;
import com.alv.autoreply.api.openai.model.ModelConstant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * OpenAiApi 测试
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 **/
@SpringBootTest
class OpenAiApiTest {

    @Resource
    private OpenAiApi openAiApi;

    private static final String OPENAI_API_KEY = "你的Api key";

    @Test
    void createCompletion() {
        CreateCompletionRequest request = new CreateCompletionRequest();
        request.setModel(ModelConstant.GPT_3_5_TURBO);
        request.setPrompt("帮我用java写一个对接图片生成api");
        CreateCompletionResponse response = openAiApi.createCompletion(request, OPENAI_API_KEY);
        Assertions.assertNotNull(response);
    }
}