package ru.kataA.PP312.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kataA.PP312.dao.UserDAO;
import ru.kataA.PP312.model.User;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDAO.listUsers();
    }

    @Transactional
    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User userID(int id) {
        return userDAO.userID(id);
    }

    @Transactional
    @Override
    public void removeUserById(int id) {
        userDAO.removeUserById(id);
    }

    @Transactional
    @Override
    public void update(User user, int id) {
        userDAO.update(user, id);
    }
}
