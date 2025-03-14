package com.sky.mapper;

import com.sky.annotation.AutoFill;
import com.sky.entity.Dish;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DishMapper {

    @Select("SELECT * FROM dish WHERE category_id = #{id}")
    List<Dish> findByCate(long id);

    @AutoFill(value = OperationType.INSERT)
    void insert(Dish dish);
}
