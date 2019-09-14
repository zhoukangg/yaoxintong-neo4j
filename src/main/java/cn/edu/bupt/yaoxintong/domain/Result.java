package cn.edu.bupt.yaoxintong.domain;

import java.util.List;
import java.util.Set;

/**
 * http请求返回的最外层对象
 * 
 * @author kang
 *
 * @param <T>
 */

public class Result<T> {

	/** 错误码 */
	private Integer code;

	/** 提示信息 */
	private String msg;

	/** 具体内容 */
	private List<T> data;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public void setResult(Integer code, String msg, List<T> data) {
		this.setCode(code);
		this.setMsg(msg);
		this.setData(data);
	}

}
