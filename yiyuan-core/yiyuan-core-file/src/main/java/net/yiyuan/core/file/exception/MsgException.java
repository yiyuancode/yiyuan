package net.yiyuan.core.file.exception;

/**
 * 消息型检查异常
 *
 * @author CPYF-YI MAO
 * @date 2020/5/15 0015 15:34
 */
public class MsgException extends Exception {

  public MsgException(String msg) {
    super(msg);
  }

  public MsgException(Throwable t) {
    super(t);
  }

  public MsgException(String msg, Throwable t) {
    super(msg, t);
  }
}
