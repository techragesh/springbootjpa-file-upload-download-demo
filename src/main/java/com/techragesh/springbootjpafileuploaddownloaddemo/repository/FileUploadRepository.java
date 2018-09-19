package com.techragesh.springbootjpafileuploaddownloaddemo.repository;

import com.techragesh.springbootjpafileuploaddownloaddemo.model.FileUpload;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileUploadRepository extends JpaRepository<FileUpload, Long> {
}
