package com.sky.controller.user;

import com.sky.entity.Setmeal;
import com.sky.mapper.SetmealDishMapper;
import com.sky.mapper.SetmealMapper;
import com.sky.result.Result;
import com.sky.service.DishService;
import com.sky.service.SetmealService;
import com.sky.vo.DishItemVO;
import com.sky.vo.DishVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController("userSetmealController")
@RequestMapping("/user/setmeal")
@Slf4j
public class SetmealController {

    @Autowired
    SetmealService setmealService;

    /**
     * 根据分类id查询套餐
     * @param categoryId
     * @return
     */
    @GetMapping("/list")
    public Result<List<Setmeal>> findByCategoryId(Long categoryId) {
        log.info("根据分类id查询套餐：{}", categoryId);

        List<Setmeal> setmealList = setmealService.findByCategoryId(categoryId);

        return Result.success(setmealList);
    }

    /**
     * 根据套餐id查询包含的菜品
     * @param setmealId
     * @return
     */
    @GetMapping("/dish/{id}")
    public Result<List<DishItemVO>> findDishsById(@PathVariable("id") Long setmealId) {
        log.info("根据套餐id查询包含的菜品: {}", setmealId);

        List<DishItemVO> dishItemVOList = setmealService.findDishesById(setmealId);

        return Result.success(dishItemVOList);
    }
}
