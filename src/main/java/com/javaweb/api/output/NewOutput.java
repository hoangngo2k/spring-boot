package com.javaweb.api.output;

import com.javaweb.dto.NewDTO;

import java.util.ArrayList;
import java.util.List;

public class NewOutput {

    private int totalPage;
    private int page;
    private List<NewDTO> result = new ArrayList<>();

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<NewDTO> getResult() {
        return result;
    }

    public void setResult(List<NewDTO> result) {
        this.result = result;
    }
}
