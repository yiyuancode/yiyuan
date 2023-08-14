package net.yiyuan.core.file.exception;

/**
 * Created by YF-zhuf on 2019/1/28 18:05.
 */
public enum CustomUnifiedExceptionEnum {

    /**
     * 通用性消息异常
     */
    MSG_EXCEPTION("MSG000", "通用性消息异常", "MSG"),
    /**
     * 附加原始消息异常的异常
     */
    AOM_EXCEPTION("AOM000", "附加原始异常的异常", "AOM"),
    /**
     * 根据实际业务扩展的自定义异常类型
     * 通常情况下MSG以及AOM类型的异常都足够使用
     * 但为适应多变的业务需求，允许根据实际情况进行扩展
     * 该DEF不允许对外使用，只是给与一个例子，要使用请根据实际情况自定义
     * 使用方式建议：
     * 如果自定义的是消息类型如通知消息出现中断，此时可以MSGBREAK_EXCEPTION("MSG001","消息出现中断","MSG")
     * 如果自定义的是附加原始异常信息的异常，如文件无法读取，此时可以FILERE_EXCEPTION("AOM001","文件无法读取","AOM")
     */
    DEF_EXCEPTION("DEF000", "根据实际业务自定的异常类型", "DEF");

    /**
     * 错误编码
     */
    private String errorCode;
    /**
     * 描述
     */
    private String errorDescrible;
    /**
     * 错误类型
     */
    private String errorType;


    private CustomUnifiedExceptionEnum(String errorCode, String errorDescrible, String errorType) {
        this.errorCode = errorCode;
        this.errorDescrible = errorDescrible;
        this.errorType = errorType;
    }


    public String getErrorCode() {
        return errorCode;
    }


    public String getErrorDescrible() {
        return errorDescrible;
    }


    public String getErrorType() {
        return errorType;
    }


}
