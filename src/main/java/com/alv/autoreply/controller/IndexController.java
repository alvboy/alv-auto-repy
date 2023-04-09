package com.alv.autoreply.controller;

import com.alv.autoreply.common.BaseResponse;
import com.alv.autoreply.common.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * url定向
 * <p>
 *
 * @author lvjiangmin
 * @date 2023/04/09
 */
@RestController
@Slf4j
public class IndexController {

    @RequestMapping("/")
    public BaseResponse<String> toIndex() {
        return ResultUtils.success("我是首页，path = /");
    }
}
