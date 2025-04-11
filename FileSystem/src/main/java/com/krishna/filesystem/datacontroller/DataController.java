package com.krishna.filesystem.datacontroller;

import com.krishna.filesystem.models.Datas;
import com.krishna.filesystem.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/")
public class DataController {

   @Autowired
    private DataService dataService;

    @PostMapping("upload")
    public Datas uploadData(@RequestParam("data") MultipartFile file,
                            @RequestParam("name") String name) throws Exception {
        Datas data = new Datas();
        data.setName(name);
        data.setData(file.getBytes());
        return dataService.setDatas(data);
    }

    @GetMapping("download/{id}")
    public ResponseEntity<byte[]> downloadData(@PathVariable int id) {
        Datas datas = dataService.getDatasById(id);
        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=\"" + datas.getName() + "\"")
                .body(datas.getData());
    }
}