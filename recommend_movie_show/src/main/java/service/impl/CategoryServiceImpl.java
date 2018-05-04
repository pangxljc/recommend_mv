package service.impl;

import common.E3Result;
import mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.Category;
import po.CategoryExample;
import service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper ;
    @Override
    public E3Result GetAllCategory()
    {
        CategoryExample example = new CategoryExample();
        CategoryExample.Criteria criteria = example.createCriteria();
        // 执行查询
        List<Category> list = categoryMapper.selectByExample(example);
        if (list == null || list.size() == 0) {
            return E3Result.build(400, "获取分类标签错误");
        }
        return E3Result.ok(list);

    }
}
