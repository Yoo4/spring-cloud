package com.springcloud.uc.biz;

import com.springcloud.common.biz.BaseBiz;
import com.springcloud.common.exception.BaseException;
import com.springcloud.uc.dao.BaseUserDao;
import com.springcloud.uc.entity.BaseUser;
import com.springcloud.uc.mapper.BaseUserMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class BaseUserBiz extends BaseBiz<BaseUserMapper,BaseUser>{
//    @Override
//    public BaseUser selectById(Object id) throws BaseException {
//        throw new BaseException("Test Global Exception");
//    }
}
