package service.impl;

import mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.Review;
import po.ReviewExample;
import service.ReviewService;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewMapper reviewMapper;

    @Override
    public List<Review> getReviewListByUserId(Integer id) {
        ReviewExample example = new ReviewExample();
        ReviewExample.Criteria criteria = example.createCriteria();
        criteria.andUseridEqualTo(id);
        List<Review> reviews = reviewMapper.selectByExample(example);
        return reviews;
    }
}
