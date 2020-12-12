package iot.lviv.films.service;

import iot.lviv.films.domain.Review;
import iot.lviv.films.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService implements AbstractService<Review, Integer> {
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<Review> getAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getById(Integer integer) {
        return reviewRepository.getOne(integer);
    }

    @Override
    public Review create(Review newObject) {
        return reviewRepository.save(newObject);
    }

    @Override
    public Review update(Integer integer, Review object) {
        if (reviewRepository.findById(integer).isPresent()){
            return reviewRepository.save(object);
        } else return null;
    }

    @Override
    public void deleteById(Integer integer) {
        if (reviewRepository.findById(integer).isPresent()) {
            reviewRepository.deleteById(integer);
        }
    }
}
