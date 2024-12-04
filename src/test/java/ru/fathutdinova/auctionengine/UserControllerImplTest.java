package ru.fathutdinova.auctionengine;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.multipart.MultipartFile;
import ru.fathutdinova.auctionengine.api.request.CreateAuctionLotRequest;
import ru.fathutdinova.auctionengine.api.request.CreateUserRequest;
import ru.fathutdinova.auctionengine.api.response.CreateAuctionLotResponse;
import ru.fathutdinova.auctionengine.api.response.CreateUserResponse;
import ru.fathutdinova.auctionengine.entity.Role;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class UserControllerImplTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    private static final String CREATE_USER_URL = "/user/create";
    private static final String CREATE_AUCTION_LOT_URL = "/auctionLot/create";
    private static final String UPDATE_AUCTION_LOT_URL = "/auctionLot/update";

    @Test
    void createUserMvc() throws Exception {
        CreateUserRequest createUserRequest = CreateUserRequest.builder()
                .login("login23")
                .password("password")
                .fullName("full name")
                .build();
        CreateUserResponse createUserResponse = CreateUserResponse.builder()
                .login(createUserRequest.getLogin())
                .balance(0)
                .roles(Set.of(Role.USER))
                .fullName(createUserRequest.getFullName())
                .build();
        mockMvc.perform(
                        post(CREATE_USER_URL)
                                .content(objectMapper.writeValueAsString(createUserRequest))
                                .header("Content-Type", "application/json")

                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.login").value(createUserResponse.getLogin()))
                .andExpect(jsonPath("$.fullName").value(createUserResponse.getFullName()))
                .andExpect(jsonPath("$.balance").value(createUserResponse.getBalance()))
                .andExpect(jsonPath("$.roles").value("USER"));
    }

    @Test
    void createUserWithDuplicatedLoginMvc() throws Exception {
        CreateUserRequest createUserRequest = CreateUserRequest.builder()
                .login("login333")
                .password("password")
                .fullName("full name")
                .build();
        mockMvc.perform(
                        post(CREATE_USER_URL)
                                .content(objectMapper.writeValueAsString(createUserRequest))
                                .header("Content-Type", "application/json")

                )
                .andExpect(status().isOk());
        mockMvc.perform(
                        post(CREATE_USER_URL)
                                .content(objectMapper.writeValueAsString(createUserRequest))
                                .header("Content-Type", "application/json")

                )
                .andExpect(status().isConflict());
    }

    @Test
    void createAuctionLotMvc() throws Exception {
        CreateAuctionLotRequest createAuctionLotRequest = CreateAuctionLotRequest.builder()
                .name("aaa")
                .description("aaaaaa")
                .startBet(1)
                .build();
        CreateAuctionLotResponse createAuctionLotResponse = CreateAuctionLotResponse.builder()
                .name(createAuctionLotRequest.getName())
                .description(createAuctionLotRequest.getDescription())
                .startBet(createAuctionLotRequest.getStartBet())
                .build();
        InputStream is = this.getClass().getResourceAsStream("backgroundDefault.jpg");
        MockMultipartFile image = new MockMultipartFile("lotImage", "111", MediaType.IMAGE_JPEG_VALUE, is);
        mockMvc.perform(
                        multipart(CREATE_AUCTION_LOT_URL).file(image)
                                .param("name", "aaa")
                                .param("description", "aaaaaa")
                                .param("startBet", "1")
                                .header("Content-Type", "multipart/form-data")

                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.name").value(createAuctionLotResponse.getName()))
                .andExpect(jsonPath("$.description").value(createAuctionLotResponse.getDescription()))
                .andExpect(jsonPath("$.startBet").value(createAuctionLotResponse.getStartBet()));
    }

}
