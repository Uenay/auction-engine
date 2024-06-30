package ru.fathutdinova.auctionengine;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import ru.fathutdinova.auctionengine.api.CreateUserRequest;
import ru.fathutdinova.auctionengine.api.CreateUserResponse;
import ru.fathutdinova.auctionengine.entity.Role;
import ru.fathutdinova.auctionengine.service.UserService;


import java.util.Set;

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
    @Autowired
    private UserService userService;

    private static final String CREATE_USER_URL = "/user/create";

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
}
