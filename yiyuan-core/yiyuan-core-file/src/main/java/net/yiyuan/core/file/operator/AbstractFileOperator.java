package net.yiyuan.core.file.operator;

import org.apache.commons.lang3.StringUtils;

/**
 * 抽象基础文件处理器
 */
public abstract class AbstractFileOperator implements FileOperatorInter {

    /**
     * 文件存储地址分隔符标识
     * 例如：区分桶名、组名等
     */
    protected static final String STORE_SPLIT = "-@-";
    /**
     * 当前指定默认文件存储桶名
     */
    public static final String BUCKET_NAME = "default-bucket";

    /**
     * 桶名称为空时，返回默认桶名
     *
     * @param bucket 桶名称
     * @return 桶名称
     */
    public String getOrDefaultBucket(String bucket) {
        return StringUtils.isBlank(bucket) ? BUCKET_NAME : bucket;
    }

    @Override
    public void destroy() {

    }
}
