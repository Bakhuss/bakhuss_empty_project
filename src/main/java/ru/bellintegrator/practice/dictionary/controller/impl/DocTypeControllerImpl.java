package ru.bellintegrator.practice.dictionary.controller.impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.dictionary.controller.DocTypeController;
import ru.bellintegrator.practice.dictionary.view.DocTypeView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/docs", produces = APPLICATION_JSON_VALUE)
public class DocTypeControllerImpl implements DocTypeController {


    @Override
    @RequestMapping(method = {POST})
    public List<DocTypeView> getAllDocTypes() {
        return null;
    }
}
