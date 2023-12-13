package net.yiyuan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.dto.UmIntegralPageDTO;
import net.yiyuan.model.UmIntegral;

public interface UmIntegralService extends JoinIService<UmIntegral> {

    Page<UmIntegral> list(UmIntegralPageDTO request) throws Exception;


}
