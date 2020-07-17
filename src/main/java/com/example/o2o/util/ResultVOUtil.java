package com.example.o2o.util;


import com.example.o2o.vo.ResultVO;

public class ResultVOUtil {

    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setMsg("success");
        resultVO.setCode(0);
        resultVO.setData(object);
        return resultVO;
    }


    public static ResultVO success(){
        return success(null);

    }

    public static ResultVO error(String msg, Integer code){
        ResultVO resultVO = new ResultVO();
        resultVO.setMsg(msg);
        resultVO.setCode(code);
        return resultVO;
    }

}
