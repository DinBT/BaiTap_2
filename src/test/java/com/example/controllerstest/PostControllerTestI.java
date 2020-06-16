package com.example.controllerstest;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import com.example.bean.AddressByPostCode;
import com.example.bean.PostDto;
import com.example.entities.TblPostEntity;
import com.example.exception.NotFound;
import com.example.service.TblPostService;
import org.json.simple.JSONValue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Test for {@link com.example.controllers.PostController}
 *
 * @author DinBT
 */
@SuppressWarnings("JavaDoc")
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class PostControllerTestI {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private TblPostService postService;


    /**
     * Test GET method with searchByPostCode() - Code 200: OK
     *
     * @throws Exception
     */
    @Test
    public void searchByPostCode() throws Exception {
        List<AddressByPostCode> resultList = new ArrayList<>();
        resultList.add(new AddressByPostCode("01101", "北海道", "札幌市中央区", "以下に掲載がない場合", "060", "0600000", "ﾎｯｶｲﾄﾞｳ",
                "ｻｯﾎﾟﾛｼﾁｭｳｵｳｸ", "ｲｶﾆｹｲｻｲｶﾞﾅｲﾊﾞｱｲ", 0, 0, 0, 0, 0, 0, "01"));
        when(postService.searchByPostCode("0600000")).thenReturn(resultList);

        mockMvc.perform(get("/address/post/search/0600000"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("@.data[0].code", is("01101")))
                .andExpect(jsonPath("@.data[0].prefecture", is("北海道")))
                .andExpect(jsonPath("@.data[0].city", is("札幌市中央区")))
                .andExpect(jsonPath("@.data[0].area", is("以下に掲載がない場合")))
                .andExpect(jsonPath("@.data[0].old_post_code", is("060")))
                .andExpect(jsonPath("@.data[0].post_code", is("0600000")))
                .andExpect(jsonPath("@.data[0].prefecture_kana", is("ﾎｯｶｲﾄﾞｳ")))
                .andExpect(jsonPath("@.data[0].city_kana", is("ｻｯﾎﾟﾛｼﾁｭｳｵｳｸ")))
                .andExpect(jsonPath("@.data[0].area_kana", is("ｲｶﾆｹｲｻｲｶﾞﾅｲﾊﾞｱｲ")))
                .andExpect(jsonPath("@.data[0].multi_area", is(0)))
                .andExpect(jsonPath("@.data[0].koaza_area", is(0)))
                .andExpect(jsonPath("@.data[0].chome_area", is(0)))
                .andExpect(jsonPath("@.data[0].multi_post_area", is(0)))
                .andExpect(jsonPath("@.data[0].update_show", is(0)))
                .andExpect(jsonPath("@.data[0].change_reason", is(0)))
                .andExpect(jsonPath("@.data[0].prefecture_code", is("01")));

        verify(postService, times(1)).searchByPostCode("0600000");
    }

    /**
     * Test GET method with searchByPostCode() - Code 404: Record Not Found
     *
     * @throws Exception
     */
    @Test
    public void searchByPostCode_RecordNotFoundException() throws Exception {
        when(postService.searchByPostCode("1234567")).thenThrow(new NotFound("No Record"));

        mockMvc.perform(get("/address/post/search/1234567"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.error", is("404")))
                .andExpect(jsonPath("$.error_description", is("resource not found!!!!")));

        verify(postService, times(1)).searchByPostCode("1234567");
    }

    /**
     * Test POST method with insertTblPost() - Code 200: OK
     *
     * @throws Exception
     */
    @Test
    public void insertTblPost() throws Exception {
        PostDto postDto = new PostDto();
        postDto.setPostCode("8-88-88");
        postDto.setMultiArea(1);
        postDto.setChangeReason(2);
        postDto.setUpdateShow(3);
        TblPostEntity tblPostEntity = new TblPostEntity();
        tblPostEntity.setPostId(17041996);
        tblPostEntity.setPostCode("8-88-88");
        tblPostEntity.setMultiArea(1);
        tblPostEntity.setUpdateShow(2);
        tblPostEntity.setChangeReason(3);
        when(postService.saveTblPost(postDto)).thenReturn(tblPostEntity);

        mockMvc.perform(post("/address/post/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(postDto)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.post_id", is(17041996)))
                .andExpect(jsonPath("$.post_code", is("8-88-88")))
                .andExpect(jsonPath("$.multi_area", is(1)))
                .andExpect(jsonPath("$.update_show", is(2)))
                .andExpect(jsonPath("$.change_reason", is(3)));

        verify(postService, times(1)).saveTblPost(postDto);
    }

    /**
     * Test POST method with insertTblPost() - Code 409: Data Conflict
     *
     * @throws Exception
     */
    @Test
    public void insertTblPost_DataIntegrityViolationException() throws Exception {
        PostDto postDto = new PostDto();
        postDto.setPostCode("8-88-88");
        postDto.setMultiArea(1);
        postDto.setChangeReason(2);
        postDto.setUpdateShow(3);

        when(postService.saveTblPost(postDto)).thenThrow(new DataIntegrityViolationException("data is already existed"));

        mockMvc.perform(post("/address/post/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(postDto)))
                .andDo(print())
                .andExpect(status().isSeeOther())
                .andExpect(jsonPath("$.error", is("303")))
                .andExpect(jsonPath("$.error_description", is("wrong manipulation !!!")));

        verify(postService, times(1)).saveTblPost(postDto);
    }

    /**
     * Test PUT method with updateTblPost() - Code 200: OK
     *
     * @throws Exception
     */
    @Test
    public void updateTblPost() throws Exception {
        PostDto postDto = new PostDto();
        postDto.setPostId(17041996);
        postDto.setPostCode("8-88-88");
        postDto.setMultiArea(1);
        postDto.setChangeReason(2);
        postDto.setUpdateShow(3);
        TblPostEntity tblPostEntity = new TblPostEntity();
        tblPostEntity.setPostId(17041996);
        tblPostEntity.setPostCode("1-22-33");
        tblPostEntity.setMultiArea(5);
        tblPostEntity.setUpdateShow(6);
        tblPostEntity.setChangeReason(7);
        when(postService.updateTblPost(postDto)).thenReturn(tblPostEntity);

        mockMvc.perform(put("/address/post/edit")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(postDto)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.post_id", is(postDto.getPostId())))
                .andExpect(jsonPath("$.post_code", is("1-22-33")))
                .andExpect(jsonPath("$.update_show", is(6)))
                .andExpect(jsonPath("$.multi_area", is(5)))
                .andExpect(jsonPath("$.change_reason", is(7)));

        verify(postService, times(1)).updateTblPost(postDto);
    }

    /**
     * Test PUT method with updateTblPost() - Code 404: Record Not Found
     *
     * @throws Exception
     */
    @Test
    public void updateTblPost_RecordNotFoundException() throws Exception {
        PostDto postDto = new PostDto();
        postDto.setPostId(17041996);
        postDto.setPostCode("8-88-88");
        postDto.setMultiArea(1);
        postDto.setChangeReason(2);
        postDto.setUpdateShow(3);

        when(postService.updateTblPost(postDto)).thenThrow(new NotFound("Not Found"));

        mockMvc.perform(put("/address/post/edit")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(postDto)))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.error", is("404")))
                .andExpect(jsonPath("$.error_description", is("resource not found!!!!")));

        verify(postService, times(1)).updateTblPost(postDto);
    }

    /**
     * Test PUT method with deleteTblPost() - Code 404: Record Not Found
     *
     * @throws Exception
     */
    @Test
    public void updateTblPost_DataIntegrityViolationException() throws Exception {
        PostDto postDto = new PostDto();
        postDto.setPostId(17041996);
        postDto.setPostCode("8-88-88");
        postDto.setMultiArea(1);
        postDto.setChangeReason(2);
        postDto.setUpdateShow(3);

        when(postService.updateTblPost(postDto)).thenThrow(new DataIntegrityViolationException("data is already existed"));

        mockMvc.perform(put("/address/post/edit")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(postDto)))
                .andDo(print())
                .andExpect(status().isSeeOther())
                .andExpect(jsonPath("$.error", is("303")))
                .andExpect(jsonPath("$.error_description", is("wrong manipulation !!!")));

        verify(postService, times(1)).updateTblPost(postDto);
    }

    /**
     * Test DELETE method with deleteTblPost() - Code 200: OK
     *
     * @throws Exception
     */
    @Test
    public void deleteTblPost() throws Exception {
        doNothing().when(postService).delete(17041996);
        mockMvc.perform(delete("/address/post/delete/17041996"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.success", is("200")))
                .andExpect(jsonPath("$.success_description", is("delete record successfully")));
        verify(postService, times(1)).delete(17041996);
    }

    /**
     * Test DELETE method with deleteTblPost() - Code 404: Record Not Found
     *
     * @throws Exception
     */
    @Test
    public void deleteTblPost_RecordNotFoundException() throws Exception {
        doThrow(new NotFound("resource not found")).when(postService).delete(17041996);
        mockMvc.perform(delete("/address/post/delete/17041996"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.error", is("404")))
                .andExpect(jsonPath("$.error_description", is("resource not found!!!!")));
        verify(postService, times(1)).delete(17041996);
    }

}

