package service.impl;

import mapper.RectabMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.Rectab;
import po.RectabExample;
import service.RectabService;

import java.util.List;

@Service
public class RectabServiceImpl implements RectabService {
    @Autowired
    private RectabMapper rectabMapper;

    @Override
    public Rectab getRectabByUserId(Integer userid) {
        RectabExample example = new RectabExample();
        RectabExample.Criteria criteria = example.createCriteria();
        criteria.andUseridEqualTo(userid);
        List<Rectab> rectabList=null;
        rectabList = rectabMapper.selectByExample(example);
        if(rectabList.size()!=0)
            return rectabList.get(0);
        else
            return null;
    }

    @Override
    public int insert(Rectab rectab) {
        return rectabMapper.insert(rectab);
    }

    @Override
    public void update(Rectab rectab) {
        rectabMapper.update(rectab);
    }
}
