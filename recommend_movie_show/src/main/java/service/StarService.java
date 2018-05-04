package service;

import common.E3Result;
import po.Review;

public interface StarService {
    public void  setStar(Review review);
    //搜索影评,用于用户评价一部电影后立即获取其评价的信息
    E3Result SortReviewByUseridandMovieid(Integer userid, Integer movieid);
}
