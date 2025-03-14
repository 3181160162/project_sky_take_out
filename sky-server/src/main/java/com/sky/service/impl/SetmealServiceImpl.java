package com.sky.service.impl;

import com.sky.entity.Dish;
import com.sky.entity.Setmeal;
import com.sky.entity.SetmealDish;
import com.sky.mapper.DishMapper;
import com.sky.mapper.SetmealDishMapper;
import com.sky.mapper.SetmealMapper;
import com.sky.service.SetmealService;
import com.sky.vo.DishItemVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SetmealServiceImpl implements SetmealService {

    @Autowired
    SetmealMapper setmealMapper;

    @Autowired
    SetmealDishMapper setmealDishMapper;

    @Autowired
    DishMapper dishMapper;

    @Override
    public List<Setmeal> findByCategoryId(Long categoryId) {

        return setmealMapper.findByCate(categoryId);
    }

    @Override
    public List<DishItemVO> findDishesById(Long setmealId) {
        List<SetmealDish> setmealDishList = setmealDishMapper.getBySetmealId(setmealId);

        List<Long> dishIds = new ArrayList<>();
        for (SetmealDish setmealDish : setmealDishList) {
            dishIds.add(setmealDish.getDishId());
        }

        List<Dish> dishes =  dishMapper.getBatchByIds(dishIds);

        List<DishItemVO> dishItemVOList = new ArrayList<>();
        for (Dish dish : dishes) {
            DishItemVO dishItemVO = new DishItemVO();
            BeanUtils.copyProperties(dish, dishItemVO);
            dishItemVOList.add(dishItemVO);
        }

        for (SetmealDish setmealDish : setmealDishList) {
            for (DishItemVO dishItemVO : dishItemVOList) {
                if (dishItemVO.getName().equals(setmealDish.getName())) dishItemVO.setCopies(setmealDish.getCopies());
            }
        }

        return dishItemVOList;
    }
}
