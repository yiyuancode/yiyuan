package net.yiyuan.vo;

import lombok.Data;
import net.yiyuan.model.UmBrowseRecord;
import net.yiyuan.model.UmUserAddress;

import java.util.List;

@Data
public class TestVO {

  private List<UmUserAddress> addressList;

  private List<UmBrowseRecord> browseRecordList;

  private String phone;
}
