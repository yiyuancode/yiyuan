package net.yiyuan.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import icu.mhb.mybatisplus.plugln.base.service.JoinIService;
import net.yiyuan.dto.UmIntegralAddDTO;
import net.yiyuan.dto.UmIntegralEditDTO;
import net.yiyuan.dto.UmIntegralListDTO;
import net.yiyuan.dto.UmIntegralPageDTO;
import net.yiyuan.model.UmIntegral;
import net.yiyuan.vo.UmIntegralQueryVO;

import java.util.List;

/**
 * 积分移动端Service层接口
 *
 * @author  spring
 * @date 2023-12-19
 */
public interface UmIntegralAppService extends JoinIService<UmIntegral> {

    boolean add(UmIntegral request) throws Exception;

    Page<UmIntegral> page(UmIntegralPageDTO request) throws Exception;

}
