package org.sriram.youtube_video_archive.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sriram.youtube_video_archive.dtos.FileDataCreateRequest;
import org.sriram.youtube_video_archive.dtos.FileDataCreateResponse;
import org.sriram.youtube_video_archive.dtos.FileDataListResponse;
import org.sriram.youtube_video_archive.services.FileDataService;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/file")
public class FileDataController {
    FileDataService fileDataService;
    @Autowired
    public FileDataController(FileDataService fileDataService) {
        this.fileDataService = fileDataService;
    }

    @PostMapping
    public FileDataCreateResponse createFileData(@RequestBody FileDataCreateRequest fileDataCreateRequest) {
        return this.fileDataService.createFileData(fileDataCreateRequest);
        // Create file
    }
    @GetMapping("/")
    public FileDataListResponse getFileDataList() throws ExecutionException, InterruptedException {
        return this.fileDataService.getFileDataList();
        // Get file list
    }
    @GetMapping("/public")
    public FileDataListResponse getPublicFileData() throws ExecutionException, InterruptedException {
        return this.fileDataService.getPublicFileDataList();
        // Get public file
    }
}
