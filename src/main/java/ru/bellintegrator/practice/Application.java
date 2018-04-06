package ru.bellintegrator.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import ru.bellintegrator.practice.office.controller.impl.OfficeControllerImpl;
import ru.bellintegrator.practice.office.dao.OfficeDao;
import ru.bellintegrator.practice.office.service.impl.OfficeServiceImpl;
import ru.bellintegrator.practice.organization.controller.impl.OrganizationControllerImpl;
import ru.bellintegrator.practice.organization.dao.OrganizationDao;
import ru.bellintegrator.practice.organization.service.impl.OrganizationServiceImpl;
import ru.bellintegrator.practice.user.controller.impl.UserControllerImpl;
import ru.bellintegrator.practice.user.dao.UserDao;
import ru.bellintegrator.practice.user.service.UserService;
import ru.bellintegrator.practice.user.service.impl.UserServiceImpl;

/**
 * Точка входа. Запуск приложения.
 */
@ImportResource("spring_mvc_config.xml")
@SpringBootApplication
@ComponentScan(basePackageClasses = {
        OfficeServiceImpl.class, OfficeControllerImpl.class, OfficeDao.class,
        OrganizationServiceImpl.class, OrganizationControllerImpl.class, OrganizationDao.class,
        UserService.class, UserControllerImpl.class, UserDao.class
        })
public class Application {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.run(args);
    }

}
