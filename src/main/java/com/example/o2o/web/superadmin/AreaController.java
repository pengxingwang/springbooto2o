package com.example.o2o.web.superadmin;

import com.example.o2o.domain.TbArea;
import com.example.o2o.enums.ResultEnum;
import com.example.o2o.service.impl.TbAreaServiceImpl;
import com.example.o2o.util.ResultVOUtil;
import com.example.o2o.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/superadmin")
public class AreaController {
   @Autowired
   private TbAreaServiceImpl tbAreaService;

   @GetMapping("/listarea")
   public ResultVO listArea(){
      try {
         List<TbArea> byAll = tbAreaService.findByAll();
         Map<String, Object> objectMap = new HashMap<>();
         objectMap.put("row", byAll);
         objectMap.put("total", byAll.size());
         return ResultVOUtil.success(objectMap);
      } catch (Exception e) {
         log.error(e.toString());
         e.printStackTrace();
         return ResultVOUtil.error(ResultEnum.ERROR.getMsg(), ResultEnum.ERROR.getCode());
      }
   }


}
