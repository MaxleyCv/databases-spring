package iot.lviv.films.service;

import iot.lviv.films.domain.Country;
import iot.lviv.films.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService implements AbstractService<Country, Integer>{
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country getById(Integer integer) {
        return countryRepository.getOne(integer);
    }

    @Override
    public Country create(Country newObject) {
        return countryRepository.save(newObject);
    }

    @Override
    public Country update(Integer integer, Country object) {
        if (countryRepository.findById(integer).isPresent()){
            return countryRepository.save(object);
        }
        else return null;
    }

    @Override
    public void deleteById(Integer integer) {
        if (countryRepository.findById(integer).isPresent()){
            countryRepository.deleteById(integer);
        }
    }
}
