package com.aixbox.codesandboxapi.service;

import com.aixbox.codesandbox.model.ExecuteMessage;
import com.aixbox.codesandbox.model.ExecuteRequest;

import java.util.List;

/**
 * @author <a href="https://github.com/Aixbox">Aixbox</a>
 * Date 2024/9/27
 */
public interface ExecutorService {

    public List<ExecuteMessage> execute(ExecuteRequest executeRequest);

}
