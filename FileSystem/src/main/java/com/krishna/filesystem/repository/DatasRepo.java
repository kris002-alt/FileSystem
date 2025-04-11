package com.krishna.filesystem.repository;

import com.krishna.filesystem.models.Datas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatasRepo extends JpaRepository<Datas, Integer> {
}
