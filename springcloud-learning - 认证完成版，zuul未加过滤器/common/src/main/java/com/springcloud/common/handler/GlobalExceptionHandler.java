package com.springcloud.common.handler;

import com.springcloud.common.constants.CommonConstants;
import com.springcloud.common.exception.BaseException;
import com.springcloud.common.vo.BaseResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice("com.springcloud")
@ResponseBody
public class GlobalExceptionHandler {
    @ExceptionHandler(BaseException.class)
    public BaseResponse baseExceptionHandler(HttpServletResponse response,BaseException ex) {
        return new BaseResponse(ex.getStatus(),ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public BaseResponse otherExceptionHandler(HttpServletResponse response,Exception ex) {
        return new BaseResponse(CommonConstants.EX_OTHER_CODE,ex.getMessage());
    }
}
