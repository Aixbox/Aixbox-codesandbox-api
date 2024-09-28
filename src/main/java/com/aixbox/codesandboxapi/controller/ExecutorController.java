package com.aixbox.codesandboxapi.controller;

import com.aixbox.codesandbox.model.ExecuteMessage;
import com.aixbox.codesandbox.model.ExecuteRequest;
import com.aixbox.codesandboxapi.common.BaseResponse;
import com.aixbox.codesandboxapi.common.ErrorCode;
import com.aixbox.codesandboxapi.common.ResultUtils;
import com.aixbox.codesandboxapi.exception.ThrowUtils;
import com.aixbox.codesandboxapi.service.ExecutorService;
import com.aixbox.codesandboxapi.service.ExecutorServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Description:
 *
 * @author <a href="https://github.com/Aixbox">Aixbox</a>
 * Date 2024/8/26 下午8:54
 */
@Slf4j
@RestController
@RequestMapping("/code")
public class ExecutorController {

    private static final String AUTH_HEADER = "Authorization";

    private static final String AUTH_HEADER_VALUE = "123456";

    @Resource
    private ExecutorService executorServiceImpl;

    @PostMapping("/executor")
    public BaseResponse<List<ExecuteMessage>> execute(@RequestBody ExecuteRequest executeRequest, HttpServletRequest httpServletRequest){
        doAuth(httpServletRequest);
        log.info("current interface is called, ip: {}", httpServletRequest.getRemoteAddr());

        List<ExecuteMessage> executeMessages = executorServiceImpl.execute(executeRequest);
        return ResultUtils.success(executeMessages);
    }



    private void doAuth(HttpServletRequest httpServletRequest){
        String auth = httpServletRequest.getHeader(AUTH_HEADER);
        ThrowUtils.throwIf(!AUTH_HEADER_VALUE.equals(auth), ErrorCode.NO_AUTH_ERROR);
    }


}
