package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import po.Moviecategory;
import po.MoviecategoryExample;

public interface MoviecategoryMapper {
    int countByExample(MoviecategoryExample example);

    int deleteByExample(MoviecategoryExample example);

    int deleteByPrimaryKey(Integer movcatid);

    int insert(Moviecategory record);

    int insertSelective(Moviecategory record);

    List<Moviecategory> selectByExample(MoviecategoryExample example);

    Moviecategory selectByPrimaryKey(Integer movcatid);

    int updateByExampleSelective(@Param("record") Moviecategory record, @Param("example") MoviecategoryExample example);

    int updateByExample(@Param("record") Moviecategory record, @Param("example") MoviecategoryExample example);

    int updateByPrimaryKeySelective(Moviecategory record);

    int updateByPrimaryKey(Moviecategory record);
}