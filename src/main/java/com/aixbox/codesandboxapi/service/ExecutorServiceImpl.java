package com.aixbox.codesandboxapi.service;

import com.aixbox.codesandbox.enums.LanguageCmdEnum;
import com.aixbox.codesandbox.executor.DockerSandbox;
import com.aixbox.codesandbox.model.ExecuteMessage;
import com.aixbox.codesandbox.model.ExecuteRequest;
import com.aixbox.rpcspringbootstarter.annotation.RpcService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author <a href="https://github.com/Aixbox">Aixbox</a>
 * Date 2024/9/27 上午10:13
 */
@Service
@RpcService
public class ExecutorServiceImpl implements ExecutorService{


    @Resource
    private DockerSandbox dockerSandbox;

    public List<ExecuteMessage> execute(ExecuteRequest executeRequest) {
        String language = executeRequest.getLanguage();
        String code = executeRequest.getCode();
        LanguageCmdEnum languageCmdEnum = LanguageCmdEnum.getEnumByValue(language);
        List<ExecuteMessage> executeMessages = new ArrayList<>();
        for (String input : executeRequest.getInputList()) {
            ExecuteMessage execute = dockerSandbox.execute(languageCmdEnum, code, input);
            executeMessages.add(execute);
        }
        return executeMessages;
    }

}
