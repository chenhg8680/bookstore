package com.stark.service.impl;

/**
 * User: C.H.G
 * Date: 2021/8/11
 * Time: 下午5:02
 */
import com.stark.dao.UserDao;
import com.stark.dao.impl.UserDaoImpl;
import com.stark.pojo.User;
import com.stark.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {

        if (userDao.queryUserByUsername(username) == null) {
            // 等于null,说明没查到，没查到表示可用
            return false;
        }

        return true;

    }
}
