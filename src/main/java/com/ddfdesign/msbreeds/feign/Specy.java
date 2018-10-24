package com.ddfdesign.msbreeds.feign;

import com.ddfdesign.msbreeds.feign.dto.SpecyDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@FeignClient(name = "species-ms")
public interface Specy {
    @RequestMapping("/saludo")
    public String saludo();
}
