package com.springcloud.auth.exception;

import com.springcloud.common.constants.CommonConstants;
import com.springcloud.common.exception.BaseException;

/**
 * @Auther: James Wang
 * @Data: 2018/1/4 15:13
 */

public class UserInvalidException extends BaseException {

    public UserInvalidException(String message) {
        super(message, CommonConstants.EX_USER_INVALID_CODE);
    }
}
