package com.zhonghui.auditcloud.core.provider.utils;

/**
 * 返回结果常量类,code和msg
 */
public class ResultConstants {
	// 成功
	public static final int SUCCESS_CODE = 200;
	// 服务器处理失败
	public static final int SERVER_ERROR_CODE = 500;
	// 请求错误
	public static final int REQ_ERROR_CODE = 400;
	// 授权错误
	public static final int AUTHORIZED_ERROR_CODE = 401;

	public static final String INSERT_SUCCESS_MSG = "写入数据成功";
	public static final String FILE_ERROR_MSG = "上传文件超过最大值";
	public static final String FILE_ERROR_MSG3 = "重复使用名称";
	public static final String FILE_ERROR_MSG2 = "上传文件超过剩余容量";
	public static final String INSERT_ERROR_MSG = "写入数据失败";
	public static final String SELECT_ERROR_MSG = "容量已超过上限值";
	public static final String SELECT_ERROR_MSG4 = "修改失败";
	public static final String SELECT_ERROR_MSG2 = "无此文件或已删除";
	public static final String SELECT_ERROR_MSG3 = "无权限访问该文件";
	public static final String RENAME_ERROR_MSG = "名称已存在";
	public static final String UERROLE_ERROR_MSG = "您无权限操作此文件";
	public static final String VOLUMED_ERROR_MSG = "查询容量失败";
	public static final String UPDATE_SUCCESS_MSG = "修改数据成功";
	public static final String UPDATE_ERROR_MSG = "修改数据失败";
	public static final String REMOVE_SUCCESS_MSG = "删除数据成功";
	public static final String REMOVE_ERROR_MSG = "删除数据失败";
	public static final String PARAMS_ERROR_MSG = "参数错误";
	public static final String AUTHORIZED_ERROR_MSG = "没有权限";
	public static final String REPLY_COMMENT_NOT_EXIST_MSG = "该评论已被删除，无法回复";
	public static final String TITLE_EMPTY_MSG = "标题不能为空";
	public static final String CONTENT_EMPTY_MSG = "内容不能为空";
	public static final String QUESTION_EMPTY_MSG = "问题不能为空";
	public static final String COMMENT_EMPTY_MSG = "评论不能为空";
	public static final String ARTICLE_NOT_EXIST = "文章已被删除";
	public static final String QUESTION_NOT_EXIST = "问题已被删除";
	public static final String AUTHORIZED_ERROR_MSG2 = "未绑定手机号";

}
