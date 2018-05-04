package mapper;

import org.apache.ibatis.annotations.Param;
import po.Alstab;
import po.AlstabExample;

import java.util.List;

public interface AlstabMapper {
    int countByExample(AlstabExample example);

    int deleteByExample(AlstabExample example);

    int insert(Alstab record);

    int insertSelective(Alstab record);

    List<Alstab> selectByExample(AlstabExample example);

    List<Integer> selectAlsByExampleStr(AlstabExample example);

    int updateByExampleSelective(@Param("record") Alstab record, @Param("example") AlstabExample example);

    int updateByExample(@Param("record") Alstab record, @Param("example") AlstabExample example);
}