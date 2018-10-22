package org.wisebone.springboot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wisebone.springboot.repository.CityRepository;
import org.wisebone.springboot.bean.City;

@Service
public class CityService implements ICityService {

    @Autowired
    private CityRepository repository;

    @Override
    public List<City> findAll() {

        List<City> cities = (List<City>) repository.findAll();
        
        return cities;
    }
}