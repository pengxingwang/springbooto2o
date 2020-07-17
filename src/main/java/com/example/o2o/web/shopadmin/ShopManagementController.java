package com.example.o2o.web.shopadmin;

import com.example.o2o.domain.TbArea;
import com.example.o2o.domain.TbPersonInfo;
import com.example.o2o.domain.TbShop;
import com.example.o2o.domain.TbShopCategory;
import com.example.o2o.dto.ShopExecution;
import com.example.o2o.enums.ResultEnum;
import com.example.o2o.enums.ShopStateEnum;
import com.example.o2o.params.TbShopParmas;
import com.example.o2o.service.impl.TbAreaServiceImpl;
import com.example.o2o.service.impl.TbShopCategoryServiceImpl;
import com.example.o2o.service.impl.TbShopServiceImpl;
import com.example.o2o.util.CodeUtil;
import com.example.o2o.util.ResultVOUtil;
import com.example.o2o.vo.ResultVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/shopadmin")
public class ShopManagementController {
    @Autowired
    private TbShopServiceImpl shopService;

    @Autowired
    private TbShopCategoryServiceImpl shopCategoryService;

    @Autowired
    private TbAreaServiceImpl tbAreaService;

    @GetMapping("/getshopinitinfo")
    public ResultVO getshopinitinfo(){
        try {
            Map<String,Object> map = new HashMap<>();
            List<TbShopCategory> byParentIdOrderByPriorityDesc = shopCategoryService.findByParentIdOrderByPriorityDesc(null);
            List<TbArea> byAll = tbAreaService.findByAll();
            map.put("areaList", byAll);
            map.put("shopCategoryList", byParentIdOrderByPriorityDesc);
            return ResultVOUtil.success(map);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultVOUtil.error(ResultEnum.ERROR.getMsg(), ResultEnum.ERROR.getCode());
        }
    }


    @GetMapping("/getshopbyid")
    public ResultVO getShopbyId(@RequestParam Integer shopId){
        if(shopId>1){
            Map<String,Object> map = new HashMap<>();
            List<TbShopCategory> byParentIdOrderByPriorityDesc = shopCategoryService.findByParentIdOrderByPriorityDesc(null);
            List<TbArea> byAll = tbAreaService.findByAll();
            TbShop tbShop = shopService.selectByPrimaryKey(shopId);
            map.put("areaList", byAll);
            map.put("shopCategoryList", byParentIdOrderByPriorityDesc);
            map.put("shop", tbShop);
            return ResultVOUtil.success(map);
        }else {
            return ResultVOUtil.error(ResultEnum.SHOPID_ISNULL.getMsg(), ResultEnum.SHOPID_ISNULL.getCode());
        }
    }



    @PostMapping("/registershop")
    private ResultVO registerShop(@RequestBody TbShopParmas tbShopParmas, HttpServletRequest httpServletRequest){
        /**
         * 验证码校验
         */
        log.info("httpServletRequest:{}", httpServletRequest);
        if(!CodeUtil.checkVerifyCode(httpServletRequest, tbShopParmas.getVerifyCodeActual())){
            return ResultVOUtil.error(ResultEnum.CODE_ERROR.getMsg(), ResultEnum.CODE_ERROR.getCode());
        }
        if(tbShopParmas != null ){
            TbShop shop = new TbShop();
            BeanUtils.copyProperties(tbShopParmas, shop);
            // 从session里取用户ID
//            TbPersonInfo personInfo = (TbPersonInfo) httpServletRequest.getSession().getAttribute("user");
//            shop.setOwnerId(personInfo.getUserId());

            ShopExecution shopExecution = shopService.addShop(shop);
            if(shopExecution.getState() == ShopStateEnum.CHECK.getState()){
                // 店铺可以操作的店铺列表
                List<TbShop> shopList = (List<TbShop>) httpServletRequest.getSession().getAttribute("shopList");
                if(shopList == null || shopList.size() == 0){
                    shopList = new ArrayList<TbShop>();
                }
                shopList.add(shopExecution.getShop());
                httpServletRequest.getSession().setAttribute("shopList", shopList);
               return ResultVOUtil.success();
            }else {
               return ResultVOUtil.error(ResultEnum.ERROR.getMsg(), ResultEnum.ERROR.getCode());
            }
        }else {
            return ResultVOUtil.error(ResultEnum.SHOP_ISNULL.getMsg(), ResultEnum.SHOP_ISNULL.getCode());
        }
    }


    @PostMapping("/modifyshop")
    private ResultVO modifyshop(@RequestBody TbShopParmas tbShopParmas, HttpServletRequest httpServletRequest){
        /**
         * 验证码校验
         */
        log.info("httpServletRequest:{}", httpServletRequest);
        if(!CodeUtil.checkVerifyCode(httpServletRequest, tbShopParmas.getVerifyCodeActual())){
            return ResultVOUtil.error(ResultEnum.CODE_ERROR.getMsg(), ResultEnum.CODE_ERROR.getCode());
        }
        if(tbShopParmas != null && tbShopParmas.getShopId() != null ){
            TbShop shop = new TbShop();
            BeanUtils.copyProperties(tbShopParmas, shop);

            int shopExecution = shopService.updateByPrimaryKeySelective(shop);
            if(shopExecution > 0){
                return ResultVOUtil.success();
            }else {
                return ResultVOUtil.error(ResultEnum.ERROR.getMsg(), ResultEnum.ERROR.getCode());
            }
        }else {
            return ResultVOUtil.error(ResultEnum.SHOP_ISNULL.getMsg(), ResultEnum.SHOP_ISNULL.getCode());
        }
    }



    @GetMapping("/getshopmanagementinfo")
    public ResultVO getShopManageMentInfo(@RequestParam(required = false) Integer shopId, HttpServletRequest httpServletRequest){
        // 如果shopId<0，则从缓存中取
        HashMap<String, Object> map = new HashMap<>();
        if(shopId == null){
            Object currentShopObj = httpServletRequest.getSession().getAttribute("currentShop");
            if(currentShopObj == null){
                map.put("redirect", true);
                map.put("url", "/o2o/shopadmin/shoplist");
            }else {
                TbShop currentShop = (TbShop) currentShopObj;
                map.put("redirect", false);
                map.put("shopId", currentShop.getShopId());
            }
        }else {
            TbShop currentShop = new TbShop();
            currentShop.setShopId(shopId);
            httpServletRequest.getSession().setAttribute("currentShop", currentShop);
            map.put("redirect", false);
        }
        return ResultVOUtil.success(map);
    }


    /**
     * 获取列表
     * @param page
     * @param pageSize
     * @param httpServletRequest
     * @return
     */
    @GetMapping("/getshoplist")
    public ResultVO page(@RequestParam(required = false, defaultValue = "1") Integer page, @RequestParam(required = false, defaultValue = "10") Integer pageSize,HttpServletRequest httpServletRequest){

        TbPersonInfo user = new TbPersonInfo();
        user.setUserId(1);
        user.setName("test");
        httpServletRequest.getSession().setAttribute("user", user);
        user = (TbPersonInfo) httpServletRequest.getSession().getAttribute("user");

        PageHelper.startPage(page, pageSize);
        TbShop tbShop = new TbShop();
        tbShop.setOwnerId(user.getUserId());
        List<TbShop> list = shopService.list(tbShop);
        PageInfo<TbShop> pageInfo = new PageInfo<>(list);

        HashMap<String, Object> map = new HashMap<>();
        map.put("shopList", pageInfo.getList());
        map.put("user", user);
        return ResultVOUtil.success(map);
    }


}
