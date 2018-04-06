package ru.bellintegrator.practice.user.service;

import ru.bellintegrator.practice.ResponseView;
import ru.bellintegrator.practice.user.view.UserView;

import java.util.List;

public interface UserService {

    ResponseView add(UserView user);

    ResponseView findById(String id);

    ResponseView users();

    ResponseView update(UserView user);

    ResponseView delete(UserView user);
}
