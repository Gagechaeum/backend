package com.gagechaeum.backend.user.mapper;

import com.gagechaeum.backend.user.domain.BusinessInfoVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BusinessInfoMapper {

    //사업자정보 저장
    void save(BusinessInfoVO vo);

    //사업자 정보 조회
    List<BusinessInfoVO> selectByUserId(Long userId);

    //시압자 정보 수정(region_id)
    void update(BusinessInfoVO vo);

    //사업자 정보 삭제
    void delete (Long businessInfoId);
}
