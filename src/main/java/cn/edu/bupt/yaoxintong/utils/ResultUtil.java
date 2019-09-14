package cn.edu.bupt.yaoxintong.utils;

import java.util.List;

import cn.edu.bupt.yaoxintong.domain.Result;

public class ResultUtil {

	public static  <T> Result<T> success(List<T> data)
	{
		Result<T> result =new Result<T>();
		result.setCode(200);
		result.setMsg("成功");
		result.setData(data);
		return result;
	}
	
	public static  <T> Result<T> failed(List<T> data)
	{
		Result<T> result =new Result<T>();
		result.setCode(400);
		result.setMsg("失败");
		result.setData(data);
		return result;
	}
}
