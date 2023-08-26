package net.yiyuan.exception;

/**
 * 文件操作运行时异常
 *
 * @author CPYF-YI MAO
 * @date 2021/5/12 9:29
 */
public class FileOperatorException extends RunMsgException {

  public FileOperatorException(String msg) {
    super(msg);
  }

  public FileOperatorException(String msg, Exception e) {
    super(msg, e);
  }
}
