package ru.bellintegrator.practice.office.service;

import ru.bellintegrator.practice.ResponseView;
import ru.bellintegrator.practice.office.view.OfficeFilter;
import ru.bellintegrator.practice.office.view.OfficeView;

public interface OfficeService {

    ResponseView add(OfficeView office);

    ResponseView findById(String id);

    ResponseView offices(OfficeFilter filter);

    ResponseView update(OfficeView office);

    ResponseView delete(OfficeView office);

}
