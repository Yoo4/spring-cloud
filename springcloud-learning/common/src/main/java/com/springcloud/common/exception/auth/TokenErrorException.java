package com.springcloud.common.exception.auth;

import com.springcloud.common.constants.CommonConstants;
import com.springcloud.common.exception.BaseException;

public class TokenErrorException extends BaseException{

    public TokenErrorException(String message, int status) {
        super(message, CommonConstants.EX_TOKEN_ERROR_CODE);
    }
}
