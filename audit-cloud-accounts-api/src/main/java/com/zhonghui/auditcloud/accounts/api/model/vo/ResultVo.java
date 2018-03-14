package com.zhonghui.auditcloud.accounts.api.model.vo;

/**
 * 中汇自定义响应结构
 */
public class ResultVo<T> {

	// 响应业务状态
	private Integer code;

	// 响应消息
	private String msg;

	// 响应中的数据
	private T data;

	private PageInfoVo pageInfo;

	public ResultVo() {

	}

	public ResultVo(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public ResultVo(Integer code, T data) {
		this.code = code;
		this.data = data;
	}

	public ResultVo(Integer code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public ResultVo(PageInfoVo pageInfo, T data) {
		this.code = 200;
		this.msg = "succ";
		this.pageInfo = pageInfo;
		this.data = data;
	}

	public PageInfoVo getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfoVo pageInfo) {
		this.pageInfo = pageInfo;
	}

	public String getMsg() {
		return msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public static ResultVo<Object> build(Integer status, String msg) {
		return new ResultVo<Object>(status, msg, null);
	}

	public static ResultVo<String> succ() {
		return new ResultVo<String>(200, "succ", null);
	}

	public static ResultVo<String> succ(String msg) {
		return new ResultVo<String>(200, msg, null);
	}

	public static ResultVo<String> fail() {
		return new ResultVo<String>(400, "fail", null);
	}

	public static ResultVo<String> fail(String msg) {
		return new ResultVo<String>(200, msg, null);
	}

	public static ResultVo<String> error() {
		return new ResultVo<String>(500, "error", null);
	}

	public static ResultVo<String> error(String msg) {
		return new ResultVo<String>(500, msg, null);
	}

}
