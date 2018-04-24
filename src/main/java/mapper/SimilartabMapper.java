package mapper;

import org.apache.ibatis.annotations.Param;
import po.Similartab;
import po.SimilartabExample;

import java.util.List;

public interface SimilartabMapper {
    int countByExample(SimilartabExample example);

    int deleteByExample(SimilartabExample example);

    int insert(Similartab record);

    int insertSelective(Similartab record);

    List<Similartab> selectByExample(SimilartabExample example);

    List<Similartab> select5ByExample(SimilartabExample example);

    List<String> select5ByExampleStr(SimilartabExample example);

    int updateByExampleSelective(@Param("record") Similartab record, @Param("example") SimilartabExample example);

    int updateByExample(@Param("record") Similartab record, @Param("example") SimilartabExample example);

}