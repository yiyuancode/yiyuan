package net.yiyuan.exception;

/**
 * Created by YF-zhuf on 2019/1/28 18:06.
 */
public class CustomUnifiedException extends RuntimeException {
    /**
     * 错误编码
     * 需要与CustomUnifiedExceptionEnum中定义的错误编码一致
     */
    private final String errorCode;

    /**
     * 消息异常
     *
     * @param cuee     CustomUnifiedExceptionEnum.MSG_EXCEPTION
     * @param errorMsg 消息体
     */
    public CustomUnifiedException(CustomUnifiedExceptionEnum cuee, String errorMsg) {
        super(errorMsg);
        this.errorCode = cuee.getErrorCode();
    }

    /**
     * 通用消息异常
     *
     * @param msg
     * @return
     */
    public static CustomUnifiedException buildMsgExp(String msg) {
        return new CustomUnifiedException(CustomUnifiedExceptionEnum.MSG_EXCEPTION, msg);
    }

    /**
     * 通用消息异常 带异常跟踪堆栈
     *
     * @param msg
     * @param e
     * @return
     */
    public static CustomUnifiedException buildMsgExp(String msg, Exception e) {
        return new CustomUnifiedException(CustomUnifiedExceptionEnum.MSG_EXCEPTION, msg, e);
    }

    /**
     * 通用消息异常
     *
     * @param msg
     * @return
     */
    public static CustomUnifiedException msg(String msg) {
        return new CustomUnifiedException(CustomUnifiedExceptionEnum.MSG_EXCEPTION, msg);
    }

    /**
     * 通用消息异常 带异常跟踪堆栈
     *
     * @param msg
     * @param e
     * @return
     */
    public static CustomUnifiedException msg(String msg, Exception e) {
        return new CustomUnifiedException(CustomUnifiedExceptionEnum.MSG_EXCEPTION, msg, e);
    }

    /**
     * 附加原始消息异常的异常
     *
     * @param msg
     * @return
     */
    public static CustomUnifiedException aom(String msg) {
        return new CustomUnifiedException(CustomUnifiedExceptionEnum.AOM_EXCEPTION, msg);
    }

    /**
     * 附加原始消息异常的异常 带异常跟踪堆栈
     *
     * @param msg
     * @param e
     * @return
     */
    public static CustomUnifiedException aom(String msg, Exception e) {
        return new CustomUnifiedException(CustomUnifiedExceptionEnum.AOM_EXCEPTION, msg, e);
    }

    /**
     * 附加原始异常的异常
     *
     * @param cuee      CustomUnifiedExceptionEnum.AOM_EXCEPTION
     * @param errorMsg  消息体
     * @param throwable 原始异常
     */
    public CustomUnifiedException(CustomUnifiedExceptionEnum cuee, String errorMsg, Throwable throwable) {
        super(errorMsg, throwable);
        this.errorCode = cuee.getErrorCode();
    }

    public String getErrorCode() {
        return errorCode;
    }
}
