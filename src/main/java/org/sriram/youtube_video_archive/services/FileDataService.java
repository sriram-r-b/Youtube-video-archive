package org.sriram.youtube_video_archive.services;


import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;
import org.sriram.youtube_video_archive.dtos.FileDataCreateRequest;
import org.sriram.youtube_video_archive.dtos.FileDataCreateResponse;
import org.sriram.youtube_video_archive.dtos.FileDataListResponse;
import org.sriram.youtube_video_archive.models.FileData;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
public class FileDataService {

    public static void printDocumentFields(QueryDocumentSnapshot document) {
        Map<String, Object> data = document.getData();

        for (Map.Entry<String, Object> entry : data.entrySet()) {
            String fieldName = entry.getKey();
            Object fieldValue = entry.getValue();

            // Determine data type and print accordingly
            if (fieldValue instanceof String) {
                System.out.println(fieldName + ": String - " + fieldValue);
            } else if (fieldValue instanceof Long) {
                System.out.println(fieldName + ": Long - " + fieldValue);
            } else if (fieldValue instanceof Double) {
                System.out.println(fieldName + ": Double - " + fieldValue);
            } else if (fieldValue instanceof Boolean) {
                System.out.println(fieldName + ": Boolean - " + fieldValue);
            } else if (fieldValue instanceof Map) {
                System.out.println(fieldName + ": Map - " + fieldValue); // Handle nested maps
            } else if (fieldValue instanceof List) {
                System.out.println(fieldName + ": List - " + fieldValue); // Handle lists
            } else {
                System.out.println(fieldName + ": Unknown type - " + fieldValue);
                System.out.println("Type: " + fieldValue.getClass().getName());
            }
        }
    }
    public FileDataCreateResponse createFileData(FileDataCreateRequest fileDataCreateRequest) {
        FileDataCreateResponse fileDataCreateResponse = new FileDataCreateResponse();
        // Create file
        FileData fileData = new FileData(fileDataCreateRequest);
        Firestore firestore =FirestoreClient.getFirestore();
        DocumentReference documentReference = firestore.collection("files").document();
        fileData.setId(documentReference.getId());
        ApiFuture<WriteResult> apiFuture=documentReference.set(fileData);
        fileDataCreateResponse.setUpdatedAt(fileData.getUpdatedAt().toString());
        fileDataCreateResponse.setId(fileData.getId());
        return fileDataCreateResponse;

    }
    public FileDataListResponse getFileDataList() throws ExecutionException, InterruptedException {
        Firestore firestore =FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> apiFuture = firestore.collection("files").get();
        List<QueryDocumentSnapshot> documents = apiFuture.get().getDocuments();
        List<FileData> fileDataList=documents.stream().map((document)->document.toObject(FileData.class)).collect(Collectors.toList());

        FileDataListResponse fileDataListResponse = new FileDataListResponse();
        fileDataListResponse.setFileDataList(fileDataList);
        return fileDataListResponse;
        // Get file list
    }

    public FileDataListResponse getPublicFileDataList() throws ExecutionException, InterruptedException {
        Firestore firestore =FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> apiFuture = firestore.collection("files").get();
        List<QueryDocumentSnapshot> documents = apiFuture.get().getDocuments();
        List<FileData> fileDataList=documents.stream().map((document)->document.toObject(FileData.class)).collect(Collectors.toList());
        List<FileData> tail = fileDataList.subList(Math.max(fileDataList.size() - 3, 0), fileDataList.size());
        FileDataListResponse fileDataListResponse = new FileDataListResponse();
        fileDataListResponse.setFileDataList(tail);
        return fileDataListResponse;
        // Get file list
    }
}
