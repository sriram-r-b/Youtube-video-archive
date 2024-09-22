package org.sriram.youtube_video_archive.dtos;

import lombok.Data;
import org.sriram.youtube_video_archive.models.FileData;

import java.util.List;
@Data
public class FileDataListResponse {
    private List<FileData> fileDataList;
}
