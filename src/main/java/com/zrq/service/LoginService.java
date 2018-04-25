package com.zrq.service;

import com.zrq.dao.examinee.ExamineeDao;
import com.zrq.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zrq on 2018-4-23.
 */
@Service
public class LoginService {
    @Autowired
    private ExamineeDao examineeDao;

    public User findUser(User user) {
        return examineeDao.findByUser(user.getUsername(),user.getPassword());
    }
}
