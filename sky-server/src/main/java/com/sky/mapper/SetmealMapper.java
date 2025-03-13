package com.sky.mapper;

import com.sky.entity.Setmeal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SetmealMapper {

    @Select("SELECT * FROM setmeal WHERE category_id = #{id}")
    List<Setmeal> findByCate(long id);
}
