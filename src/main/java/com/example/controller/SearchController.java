package com.example.controller;

import com.example.Entity.AddressByPostCodeEntity;
import com.example.Entity.CityByPrefectureEntity;
import com.example.responsitory.SearchByPostCode;
import com.example.responsitory.SearchByPrefecture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@RestControllerAdvice
@RequestMapping("/address")
public class SearchController {

    @Autowired
    private SearchByPostCode searchByPostCode;

    @Autowired
    private SearchByPrefecture searchByPrefecture;


    @GetMapping("/post/{pc}")
    public String searchAddress(
            @PathVariable(value = "pc") String postCode) {
        postCode = postCode.replaceAll("-", "").replaceAll(" ", "");
        if (postCode == null || !postCode.matches("^[0-9]{1,}$")) {
            return "400: BadRequest!";
        }
        AddressByPostCodeEntity result = searchByPostCode.searchByPostCode(postCode);
        if (result == null) {
            return "404: NotFound!!";
        }
        return "{\"data\":[" + result.toString() + "],\"result\":\"success\"}";
    }

    @GetMapping("/prefectures/{pr}")
    public String searchByPrefectureCode(
            @RequestParam(value = "pr") String prefectureCode) {
        prefectureCode = prefectureCode.replaceAll("-", "").replaceAll(" ", "");
        if (prefectureCode == null || !prefectureCode.matches("^[0-9]{1,}$")) {
            return "400: BadRequest!";//HttpStatus.BAD_REQUEST
        }
        List<CityByPrefectureEntity> listResult = searchByPrefecture.searchByPrefectureCode(prefectureCode);
        if (listResult == null || listResult.isEmpty()) {
            return "404: NotFound!!";
        }
        StringBuilder result = new StringBuilder();
        listResult.forEach(record -> result.append(record.toString() + ","));
        return "{\"data\":[" + result.toString() + "],\"result\":\"success\"}";
    }


    /**
     * Tất cả các Exception không được khai báo sẽ được xử lý tại đây
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleAllException(Exception ex, WebRequest request) {
        // quá trình kiểm soat lỗi diễn ra ở đây
        return "bạn nhập sai rồi";
    }
}
