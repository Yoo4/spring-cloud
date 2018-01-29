package com.springcloud.auth.service.impl;

import com.springcloud.auth.bean.ClientInfo;
import com.springcloud.auth.entity.Client;
import com.springcloud.auth.exception.ClientInvalidException;
import com.springcloud.auth.mapper.ClientMapper;
import com.springcloud.auth.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: James Wang
 * @Data: 2018/1/8 16:22
 */
@Service
public class DBClientService implements ClientService{
    @Autowired
    private ClientMapper clientMapper;

    @Override
    public ClientInfo apply(String clientId, String secret) {
        Client client = new Client();
        client.setCode(clientId);
        client = clientMapper.selectOne(client);
        if(client == null || !client.getSecret().equals(secret))
            throw new ClientInvalidException("Client not found or Client secret is Error");
        return null;
    }
}
