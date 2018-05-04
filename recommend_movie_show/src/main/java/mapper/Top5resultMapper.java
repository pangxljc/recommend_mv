package mapper;

import org.apache.ibatis.annotations.Param;
import po.Top5result;
import po.Top5resultExample;

import java.util.List;

public interface Top5resultMapper {
    int countByExample(Top5resultExample example);

    int deleteByExample(Top5resultExample example);

    int insert(Top5result record);

    int insertSelective(Top5result record);

    List<Top5result> selectByExample(Top5resultExample example);

    int updateByExampleSelective(@Param("record") Top5result record, @Param("example") Top5resultExample example);

    int updateByExample(@Param("record") Top5result record, @Param("example") Top5resultExample example);
}