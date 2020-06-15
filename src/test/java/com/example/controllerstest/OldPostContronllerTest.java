package com.example.controllerstest;

import com.example.controllers.ExceptionController;
import com.example.controllers.OldPostController;
import com.example.entities.TblOldPostEntity;
import com.example.exception.NotFound;
import com.example.reposistories.TblOldPostReponsitory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OldPostContronllerTest {

    private MockMvc mvc;

    @Mock
    private TblOldPostReponsitory tblOldPostReponsitory;

    @InjectMocks
    private OldPostController oldPostController;

    @Autowired
    private ObjectMapper mapper;

//    @Before
//    public void setup() {
//      JacksonTester.initFields(this, new ObjectMapper());
//       mvc = MockMvcBuilders.standaloneSetup(oldPostController).setControllerAdvice(new ExceptionController()).build();
//        mapper = new HttpBodyObjectMapper();
//        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
//        JacksonTester.initFields(this, mapper);
//        assert jsonCity != null;
//    }

//    @Test
//    public void add() throws Exception {
//
//        TblOldPostEntity tblOldPostEntity = new TblOldPostEntity("1234");
//        mvc.perform(post("/address/old_post", 42L)
//                .contentType("application/json")
//                .param("sendWelcomeMail", "true")
//                .content(mapper.writeValueAsString(tblOldPostEntity)))
//                .andExpect(status().isOk());
//
//      TblOldPostEntity oldPostEntity = tblOldPostReponsitory.getOne(tblOldPostEntity.getOldPostId());
//        assertEquals(oldPostEntity.getOldPostCode(), "1234");
//        verify(tblOldPostReponsitory, times(1)).save(tblOldPostEntity);
//        verifyNoMoreInteractions(tblOldPostReponsitory);
//    }


//    @Test
//    public void notFound() throws Exception {
//        // given
//        given(tblOldPostReponsitory.getOne( 2L))
//                .willThrow(new NotFound(""));
//
//        // when
//        MockHttpServletResponse response = mvc.perform(
//                get("/old_post/edit")
//                        .accept(MediaType.APPLICATION_JSON))
//                .andReturn().getResponse();
//
//        // then
//        assertEquals(response.getStatus(), HttpStatus.NOT_FOUND.value());
//    }
}
