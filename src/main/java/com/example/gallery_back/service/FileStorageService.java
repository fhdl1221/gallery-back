package com.example.gallery_back.service;

import org.springframework.web.multipart.MultipartFile;

// 로컬에서 서비스를 돌릴 때는 컴퓨터 내부에 파일 저장
// 배포환경에서는 S3에 파일 저장
// 그래서 인터페이스 만들고 구현체를 2개 만들어서 하나는 로컬환경, 하나는 배포환경
// 파일을 주면 저장, 이미지url을 주면 삭제하는 메서드
public interface FileStorageService {
    String upload(MultipartFile file);
    void delete(String imageUrl);
}
