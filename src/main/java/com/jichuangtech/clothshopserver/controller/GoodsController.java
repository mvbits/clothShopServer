package com.jichuangtech.clothshopserver.controller;

import com.jichuangtech.clothshopserver.constant.GoodsCategoryConstant;
import com.jichuangtech.clothshopserver.constant.GoodsConstant;
import com.jichuangtech.clothshopserver.model.GoodsCategoryEntity;
import com.jichuangtech.clothshopserver.model.GoodsEntity;
import com.jichuangtech.clothshopserver.repository.GoodsCategoryRepository;
import com.jichuangtech.clothshopserver.repository.GoodsRepository;
import com.jichuangtech.clothshopserver.utils.JsonHelper;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Bingo on 2017/7/23.
 */

@Controller
@RequestMapping(GoodsConstant.API_GOODS)
public class GoodsController {

    @Autowired
    private GoodsRepository mGoodsRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "goods";
    }

    @RequestMapping(GoodsConstant.LIST)
    @ResponseBody
    public List<GoodsEntity> list() {
        return mGoodsRepository.findAll();
    }

    @RequestMapping(GoodsConstant.LIST + "/{goodsId}")
    @ResponseBody
    public GoodsEntity listOne(@PathVariable int goodsId) {
        System.out.print("listOne goodsId: " + goodsId +" \n");
        return mGoodsRepository.findOne(goodsId);
    }
}
