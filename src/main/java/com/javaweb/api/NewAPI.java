package com.javaweb.api;

import com.javaweb.api.output.NewOutput;
import com.javaweb.dto.NewDTO;
import com.javaweb.services.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class NewAPI {

    @Autowired
    INewService newService;

    @PostMapping(value = "/new")
    public NewDTO createNew(@RequestBody NewDTO newDTO) {
        return newService.save(newDTO);
    }

    @GetMapping(value = "/new")
    public NewOutput showNew(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit) {
        NewOutput newOutput = new NewOutput();
        if (page != null && limit != null) {
            newOutput.setPage(page);
            Pageable pageable = new PageRequest(page - 1 , limit);
            newOutput.setResult(newService.findAll(pageable));
            newOutput.setTotalPage((int) Math.ceil((double) (newService.totalItems()) / limit));
        } else {
            newOutput.setResult(newService.findAll());
        }
        return newOutput;
    }

    @PutMapping(value = "/new/{id}")
    public NewDTO updateNew(@RequestBody NewDTO newDTO, @PathVariable("id") long id) {
        newDTO.setId(id);
        return newService.save(newDTO);
    }

    @DeleteMapping(value = "/new")
    public void deleteNew(@RequestBody long[] ids) {
        newService.delete(ids);
    }
}
