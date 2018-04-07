package ru.bellintegrator.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import ru.bellintegrator.practice.Error.ExceptionHandlerController;
import ru.bellintegrator.practice.dictionary.controller.impl.CountryControllerImpl;
import ru.bellintegrator.practice.dictionary.dao.CountryDao;
import ru.bellintegrator.practice.dictionary.service.impl.CountryServiceImpl;
import ru.bellintegrator.practice.office.controller.impl.OfficeControllerImpl;
import ru.bellintegrator.practice.office.dao.OfficeDao;
import ru.bellintegrator.practice.office.service.impl.OfficeServiceImpl;
import ru.bellintegrator.practice.organization.controller.impl.OrganizationControllerImpl;
import ru.bellintegrator.practice.organization.dao.OrganizationDao;
import ru.bellintegrator.practice.organization.service.impl.OrganizationServiceImpl;
import ru.bellintegrator.practice.user.controller.impl.UserControllerImpl;
import ru.bellintegrator.practice.user.service.impl.UserServiceImpl;
import ru.bellintegrator.practice.user.dao.UserDao;

import java.util.Locale;

/**
 * Точка входа. Запуск приложения.
 */
@ImportResource("spring_mvc_config.xml")
@SpringBootApplication
@ComponentScan(basePackageClasses = {
        OfficeServiceImpl.class, OfficeControllerImpl.class, OfficeDao.class,
        OrganizationServiceImpl.class, OrganizationControllerImpl.class, OrganizationDao.class,
        UserServiceImpl.class, UserControllerImpl.class, UserDao.class,
        CountryServiceImpl.class, CountryControllerImpl.class, CountryDao.class,
        ExceptionHandlerController.class
        })
public class Application {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.run(args);
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(Locale.US);
        return sessionLocaleResolver;
    }

}
