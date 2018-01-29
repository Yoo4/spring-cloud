package com.springcloud.auth.exception;

import com.springcloud.common.constants.CommonConstants;
import com.springcloud.common.exception.BaseException;

/**
 * @Auther: James Wang
 * @Data: 2018/1/8 16:48
 */

public class ClientInvalidException extends BaseException {

    public ClientInvalidException(String message) {
        super(message, CommonConstants.EX_CLIENT_INVALID_CODE);
    }
}
