package net.yiyuan.core.file.operator;

import lombok.extern.slf4j.Slf4j;
import net.yiyuan.core.file.exception.FileOperatorException;
import net.yiyuan.core.file.pojo.dto.ObjectResponse;
import net.yiyuan.core.file.pojo.dto.UploadRequestParam;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;


@Slf4j
public class ExternalFileOperator extends AbstractFileOperator {

    @Override
    public void init(Map<String, String> params) {
    }

    @Override
    public ObjectResponse uploadFile(UploadRequestParam requestParam, InputStream inputStream) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void getFileAsStream(String storePath, Consumer<InputStream> streamConsumer) {
        try (InputStream stream = new FileInputStream(storePath)) {
            streamConsumer.accept(stream);
        } catch (Exception e) {
            throw new FileOperatorException("文件下载异常", e);
        }
    }

    @Override
    public ObjectResponse copyFile(String storePath, UploadRequestParam targetParam) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteFile(String storePath) {

    }

    @Override
    public String getFileDownloadUrl(String storePath, int duration, TimeUnit unit) {
        throw new UnsupportedOperationException();
    }
}
