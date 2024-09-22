package org.sriram.youtube_video_archive.dtos;

import lombok.Data;

import java.util.List;
@Data
public class FileDataCreateRequest {
    public String id;
    public String title;
    public String image_url;
    public String description;
    public String link;
    public List<String> keywords;
    public String script;
    public List<String> images;
    public String hashtags;

}
