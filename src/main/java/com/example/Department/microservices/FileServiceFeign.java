package com.example.Department.microservices;


import com.example.Department.microservices.json.FileServiceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "${micro.file-service.name}", url = "${micro.file-service.url}")
public interface FileServiceFeign {

  String boundary = Long.toHexString(System.currentTimeMillis());

    @PostMapping(value = "/api/v1/file/upload", consumes = "multipart/form-data")
    FileServiceResponse upload(@RequestPart MultipartFile file);
}
