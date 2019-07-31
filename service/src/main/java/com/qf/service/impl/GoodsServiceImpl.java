package com.qf.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.common.http.GoodsState;
import com.qf.entity.dto.Goods;
import com.qf.mapper.GoodsMapper;
import org.springframework.stereotype.Service;

/**
 * @Author-izumi
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> {
    public void up(Long id) {
        UpdateWrapper<Goods> wrapper = new UpdateWrapper<>();
        wrapper.lambda().eq(Goods::getId,id).set(Goods::getState, GoodsState.UP.getCode());
        this.update(wrapper);
    }

    public void down(Long id) {
        UpdateWrapper<Goods> wrapper = new UpdateWrapper<>();
        wrapper.lambda().eq(Goods::getId, id).set(Goods::getState, GoodsState.DOWN.getCode());
        this.update(wrapper);
    }

    public void del(Long id) {
        this.removeById(id);
    }
}
