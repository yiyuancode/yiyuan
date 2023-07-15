package net.yiyuan.core.file.exception;

/**
 * 运行时消息异常
 *
 * @author YI.MAO
 * @date 2020/3/21 0021 15:01
 */
public class RunMsgException extends RuntimeException {

    public RunMsgException(String msg) {
        super(msg);
    }

    public RunMsgException(String msg, Throwable t) {
        super(msg, t);
    }
}
