package com.service.file;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Slf4j
public class FileStorageReps {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void updateImagePath(String tableName, String imagePath, Long id) {
        String sqlUpdate = "UPDATE " + tableName + " SET IMAGE_PATH = :imagePath WHERE ID = :id";
        int count = entityManager.createNativeQuery(sqlUpdate)
                .setParameter("imagePath", imagePath)
                .setParameter("id", id)
                .executeUpdate();

        log.info("Row updated successfully and count is : " + count);
    }

    @Transactional
    public void updateImagePath(String tableName, String colName, String imagePath, Long id) {
        String sqlUpdate = "UPDATE " + tableName + " SET " + colName + " = :imagePath WHERE ID = :id";
        // Use parameters to prevent SQL injection
        int count = entityManager.createNativeQuery(sqlUpdate)
                .setParameter("imagePath", imagePath)
                .setParameter("id", id)
                .executeUpdate();

        log.info("Row updated successfully and count is : " + count);
    }
}
