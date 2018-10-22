package org.wisebone.springboot.service;

import org.wisebone.springboot.bean.City;
import java.util.List;

public interface ICityService {

    public List<City> findAll();
}
