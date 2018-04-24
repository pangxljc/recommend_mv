package service.impl;

import mapper.TopdefaultmoviesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.Movie;
import service.TopDefaultMoviesService;

import java.util.List;

@Service
public class TopDefaultMoviesServiceImpl implements TopDefaultMoviesService {
    @Autowired
    private TopdefaultmoviesMapper topdefaultmoviesMapper;
    public List<Movie> SelectRegDefaultMovie(){
        List<Movie> list = topdefaultmoviesMapper.selectRegDefaultMovie();
        return list;
    }
}
