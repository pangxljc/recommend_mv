package service.impl;

import common.E3Result;
import mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.Review;
import service.StarService;

@Service
public class StarServiceImpl implements StarService {
    @Autowired
    private ReviewMapper reviewMapper;


    @Override
    public void  setStar(Review review){
        // 把数据插入到数据库中
        reviewMapper.insert(review);
        //返回成功
    }
    @Override
    public E3Result SortReviewByUseridandMovieid(Integer userid, Integer movieid)
    {
        Review review= reviewMapper.selectByUseridandMovieid(userid,movieid);
        return E3Result.ok(review);
    }

}