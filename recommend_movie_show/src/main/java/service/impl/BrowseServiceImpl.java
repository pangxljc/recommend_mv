package service.impl;

import mapper.BrowseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.Browse;
import po.BrowseExample;
import service.BrowseService;

import java.util.List;

@Service
public class BrowseServiceImpl implements BrowseService {

    @Autowired
    private BrowseMapper browseMapper;

    @Override
    public Browse getBrowseByUserId(Integer userid) {
        BrowseExample example = new BrowseExample();
        BrowseExample.Criteria criteria = example.createCriteria();
        criteria.andUseridEqualTo(userid);
        List<Browse> browseList = browseMapper.selectByExample(example);
        if(browseList.size()!=0)
         return browseList.get(0);
        else
            return  null;
    }
}
