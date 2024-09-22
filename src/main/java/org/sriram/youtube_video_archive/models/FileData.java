package org.sriram.youtube_video_archive.models;

import com.google.cloud.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.sriram.youtube_video_archive.dtos.FileDataCreateRequest;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class FileData {
    public String id;
    public String title;
    public String image_url;
    public String description;
    public String link;
    public List<String> keywords;
    public String script;
    public List<String> images;
    public String hashtags;
    public Timestamp updatedAt;

    public FileData (FileDataCreateRequest fileDataCreateRequest){
            this.id = fileDataCreateRequest.getId();
        this.title = fileDataCreateRequest.getTitle();
        this.image_url = fileDataCreateRequest.getImage_url();
        this.description = fileDataCreateRequest.getDescription();
        this.link = fileDataCreateRequest.getLink();
        this.keywords = fileDataCreateRequest.getKeywords();
        this.script = fileDataCreateRequest.getScript();
        this.images = fileDataCreateRequest.getImages();
        this.hashtags = fileDataCreateRequest.getHashtags();
        this.updatedAt = Timestamp.now();

    }


}
