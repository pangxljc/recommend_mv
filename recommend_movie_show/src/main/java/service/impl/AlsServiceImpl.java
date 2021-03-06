package service.impl;

import mapper.AlstabMapper;
import mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.AlstabExample;
import po.Movie;
import service.AlsService;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlsServiceImpl implements AlsService {

    @Autowired
    private MovieMapper moivemapper;

    @Autowired
    private AlstabMapper alstabMapper;

    @Override
    public List<Movie> selectAlsMoviesByUserId(Integer userid) {
        AlstabExample alstabExample = new AlstabExample();
        AlstabExample.Criteria criteria = alstabExample.createCriteria();
        criteria.andUseridEqualTo(userid);
        List<Integer> alsMovieIds = alstabMapper.selectAlsByExampleStr(alstabExample);
        List<Movie> alsMovieList = new ArrayList<Movie>();
        Movie movie = null;
        for (Integer movieId : alsMovieIds) {
            movie = moivemapper.selectByPrimaryKey(movieId);
            if (movie != null) {
                alsMovieList.add(movie);
            }
        }

        return alsMovieList;
    }
}
