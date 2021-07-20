package com.huzhihui.flowable.utils;

/**
 * @author huzhi
 */
public class ResponseMessage<T> {
    /**
     * 操作成功失败
     */
    private boolean success = false;
    /**
     * 返回码
     */
    private Integer code;

    /**
     * 返回信息提示
     */
    private String codeMessage;

    /**
     * 返回数据
     */
    private T data;

    /**
     * 成功返回结果
     *
     * @return 返回结果
     */
    public static <T> ResponseMessage<T> success() {
        return success(HttpCode.SUCCESS.getCodeMessage());
    }

    /**
     * 成功返回结果
     *
     * @param codeMessage 返回编码提示
     * @return
     */
    public static <T> ResponseMessage<T> success(String codeMessage) {
        return new ResponseMessage<T>(true, HttpCode.SUCCESS.getCode(), codeMessage, null);
    }

    /**
     * 成功返回结果
     *
     * @param codeMessage 返回编码提示
     * @return
     */
    public static <T> ResponseMessage<T> success(Integer code, String codeMessage) {
        return new ResponseMessage<T>(true, code, codeMessage, null);
    }

    /**
     * 成功返回结果
     *
     * @param data 返回数据内容
     * @param <T>  数据类型
     * @return 返回结果
     */
    public static <T> ResponseMessage<T> success(T data) {
        return new ResponseMessage<T>(true, HttpCode.SUCCESS.getCode(), HttpCode.SUCCESS.getCodeMessage(), data);
    }

    /**
     * 成功返回结果
     *
     * @param data 返回数据内容
     * @param <T>  数据类型
     * @return 返回结果
     */
    public static <T> ResponseMessage<T> success(String codeMessage, T data) {
        return new ResponseMessage<T>(true, HttpCode.SUCCESS.getCode(), codeMessage, data);
    }

    /**
     * 成功返回结果
     *
     * @param data 返回数据内容
     * @param <T>  数据类型
     * @return 返回结果
     */
    public static <T> ResponseMessage<T> success(T data, Long count) {
        return new ResponsePageMessage(true, HttpCode.SUCCESS.getCode(), HttpCode.SUCCESS.getCodeMessage(), data, count, null);
    }

    /**
     * 成功返回结果
     *
     * @param data 返回数据内容
     * @param <T>  数据类型
     * @return 返回结果
     */
    public static <T> ResponseMessage<T> success(T data, Long count, Long pages) {
        return new ResponsePageMessage(true, HttpCode.SUCCESS.getCode(), HttpCode.SUCCESS.getCodeMessage(), data, count, pages);
    }


    /**
     * 成功返回结果
     *
     * @param codeMessage
     * @param data
     * @param count
     * @param <T>
     * @return
     */
    public static <T> ResponseMessage<T> success(String codeMessage, T data, Long count, Long pages) {
        return new ResponsePageMessage(true, HttpCode.SUCCESS.getCode(), codeMessage, data, count, pages);
    }

    /**
     * 失败返回结果
     *
     * @return
     */
    public static <T> ResponseMessage<T> failure() {
        return new ResponseMessage<T>(false, HttpCode.ERROR.getCode(), HttpCode.ERROR.getCodeMessage(), null);
    }

    /**
     * 失败返回结果
     *
     * @param codeMessage 失败消息
     * @return
     */
    public static <T> ResponseMessage<T> failure(String codeMessage) {
        return new ResponseMessage<T>(false, HttpCode.ERROR.getCode(), codeMessage, null);
    }

    public static <T> ResponseMessage<T> failurePage(String codeMessage) {
        return new ResponseMessage.ResponsePageMessage(false, HttpCode.ERROR.getCode(), codeMessage, null, 0L, 0L);
    }

    /**
     * 失败返回结果
     *
     * @param data
     * @return
     */
    public static <T> ResponseMessage<T> failure(T data) {
        return new ResponseMessage<T>(false, HttpCode.ERROR.getCode(), HttpCode.ERROR.getCodeMessage(), data);
    }

    /**
     * 失败返回结果
     *
     * @param codeMessage 失败消息
     * @return
     */
    public static <T> ResponseMessage<T> failure(Integer code, String codeMessage) {
        return new ResponseMessage<T>(false, code, codeMessage, null);
    }

    public ResponseMessage(boolean success, Integer code, String codeMessage, T data) {
        this.success = success;
        this.code = code;
        this.codeMessage = codeMessage;
        this.data = data;
    }

    public ResponseMessage() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getCodeMessage() {
        return codeMessage;
    }

    public void setCodeMessage(String codeMessage) {
        this.codeMessage = codeMessage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 分页返回数据
     *
     * @param <T>
     */
    public static class ResponsePageMessage<T> extends ResponseMessage<T> {

        /**
         * 总记录数
         */
        private Long count;

        /**
         * 总页数
         */
        private Long pages;

        public Long getCount() {
            return count;
        }

        public void setCount(Long count) {
            this.count = count;
        }

        public Long getPages() {
            return pages;
        }

        public void setPages(Long pages) {
            this.pages = pages;
        }

        public ResponsePageMessage(boolean success, Integer code, String codeMessage, T data, Long count, Long pages) {
            super(success, code, codeMessage, data);
            this.count = count;
            this.pages = pages;
        }

        public ResponsePageMessage() {
        }

        public static <T> ResponseMessage<T> failure(String codeMessage) {
            return new ResponsePageMessage(false, HttpCode.ERROR.getCode(), HttpCode.ERROR.getCodeMessage(), codeMessage, 0L, 0L);
        }
    }
}
