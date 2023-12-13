package net.yiyuan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.dto.UmIntegralPageDTO;
import net.yiyuan.dto.UmUserAddressPageDTO;
import net.yiyuan.model.UmIntegral;
import net.yiyuan.vo.UmUserAddressQueryVO;

import java.util.List;

public interface UmIntegralAppService extends JoinIService<UmIntegral> {


    boolean add(UmIntegral request) throws Exception;

    Page<UmIntegral> page(UmIntegralPageDTO request) throws Exception;
}
