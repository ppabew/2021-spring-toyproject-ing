package com.study.toypro.api.external.controller;

import com.study.toypro.api.external.dto.ReqDto;
import com.study.toypro.api.external.dto.SvcTypeDto;
import com.study.toypro.api.external.service.ExternalApiService;
import com.study.toypro.core.utilities.ApiResponseUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExternalApiController {
    @Autowired
    ExternalApiService externalApiService;

    /**
     * reqDto를 전달받아서 해당 요청 전문에 있는 svcType으로 이미 작성된 json 요청 전문을 반환하는 컨트롤러
     * @param reqDto
     * @return
     */
    @PostMapping("/v1/services")
    public ResponseEntity<Object> selectExternalApiResponse(@RequestBody ReqDto reqDto) {
        SvcTypeDto svcTypeDto = new SvcTypeDto();
        svcTypeDto.setPrprtyId(reqDto.getPrprtyId());
        svcTypeDto.setRoomNo(reqDto.getRoomNo());
        svcTypeDto.setSvcType(reqDto.getReqData().get(0).getSvcType());
        SvcTypeDto result = externalApiService.selectExternalApiResponse(svcTypeDto);
        return ApiResponseUtility.success(result);
    }
}
