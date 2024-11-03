package org.sriram.youtube_video_archive.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
@Service
public class FirebaseConfig {
    @PostConstruct
    public void configureFirebaseConnection() throws IOException {
        File file=ResourceUtils.getFile("/secrets/credentials.json");
        // Firebase configuration
        FileInputStream serviceAccount = new FileInputStream(file);
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();
        if(FirebaseApp.getApps().isEmpty()) { //<--- check with this line
            FirebaseApp.initializeApp(options);
        }

    }
}
