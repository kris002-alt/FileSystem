package com.krishna.filesystem.services;

import com.krishna.filesystem.models.Datas;
import com.krishna.filesystem.repository.DatasRepo;
import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class DataService {
    @Autowired
    private DatasRepo datasRepo;

    public Datas getDatasById(int id) {
        return datasRepo.findById(id).get();
    }
    public Datas setDatas(Datas datas) {
        return datasRepo.save(datas);
    }

}
