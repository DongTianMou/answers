package com.edongtian.answers.dao;

import com.edongtian.answers.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface QuestionDao {
    String TABLE_NAME = " question ";
    String INSERT_FIELDS = " title, content, createdDate, userId, commentCount ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Insert("insert into "+TABLE_NAME+"("+INSERT_FIELDS+") values " +
            "(#{title},#{content},#{createdDate},#{userId},#{commentCount})")
    void addQuestion(Question question);
    @Select("select "+SELECT_FIELDS+" from"+TABLE_NAME+"where userId=#{userId}  ORDER BY id DESC lime #{offset}, #{limit}")
    List<Question> selectLastestQuestion(@Param("userId") int userId, @Param("offset") int offset,
                                         @Param("limit") int limit);

}
