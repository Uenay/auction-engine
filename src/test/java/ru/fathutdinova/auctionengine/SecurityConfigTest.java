package ru.fathutdinova.auctionengine;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.fathutdinova.auctionengine.api.request.ByIdRequest;
import ru.fathutdinova.auctionengine.api.request.CreateAuctionRequest;
import ru.fathutdinova.auctionengine.api.request.GetFilteredAuctionRequest;
import ru.fathutdinova.auctionengine.api.request.UpdateAuctionLotRequest;
import ru.fathutdinova.auctionengine.api.request.UpdateAuctionRequest;
import ru.fathutdinova.auctionengine.api.request.UpdateUserRequest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class SecurityConfigTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @WithMockUser
    public void testUserCannotAccessAuctionUpdate() throws Exception {
        mockMvc.perform(post("/auction/update"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser
    public void testUserCannotAccessAuctionCreate() throws Exception {
        mockMvc.perform(post("/auction/create"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser
    public void testUserCanAccessAuctionGet() throws Exception {
        ByIdRequest byIdRequest = ByIdRequest.builder()
                .id(1)
                .build();
        mockMvc.perform(get("/auction/get")
                        .content(objectMapper.writeValueAsString(byIdRequest))
                        .header("Content-Type", "application/json"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = "AUCTIONEER")
    public void testAuctioneerCanAccessAuctionCreate() throws Exception {
        CreateAuctionRequest createAuctionRequest = CreateAuctionRequest.builder()
                .name("auction")
                .build();
        mockMvc.perform(post("/auction/create")
                        .content(objectMapper.writeValueAsString(createAuctionRequest))
                        .header("Content-Type", "application/json"))
                .andExpect(status().isOk());
    }
    @Test
    @WithMockUser(roles = "ADMIN")
    public void testAdminCanAccessUserUpdate() throws Exception {
        UpdateUserRequest updateUserRequest = UpdateUserRequest.builder()
                .id(1)
                .build();
        mockMvc.perform(post("/user/update")
                        .content(objectMapper.writeValueAsString(updateUserRequest))
                        .header("Content-Type", "application/json"))
                .andExpect(status().isOk());
    }
    @Test
    @WithMockUser(roles = "ADMIN")
    public void testAdminCanAccessAuctionUpdate() throws Exception {
        UpdateAuctionRequest updateAuctionRequest = UpdateAuctionRequest.builder()
                .id(1)
                .build();
        mockMvc.perform(post("/auction/update")
                        .content(objectMapper.writeValueAsString(updateAuctionRequest))
                        .header("Content-Type", "application/json"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = "AUCTIONEER")
    public void testAuctioneerCanNotAccessAuctionLotUpdate() throws Exception {
        UpdateAuctionLotRequest updateAuctionLotRequest = UpdateAuctionLotRequest.builder()
                .id(1)
                .build();
        mockMvc.perform(post("/auctionLot/update")
                        .content(objectMapper.writeValueAsString(updateAuctionLotRequest))
                        .header("Content-Type", "application/json"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    public void testAdminCanNotAccessAuctionCreate() throws Exception {
        CreateAuctionRequest createAuctionRequest = CreateAuctionRequest.builder()
                .name("auction")
                .build();
        mockMvc.perform(post("/auction/create")
                        .content(objectMapper.writeValueAsString(createAuctionRequest))
                        .header("Content-Type", "application/json"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser
    public void testUserCanNotAccessAuctionDelete() throws Exception {
        ByIdRequest byIdRequest = ByIdRequest.builder()
                .id(1)
                .build();
        mockMvc.perform(delete("/auction/delete")
                        .content(objectMapper.writeValueAsString(byIdRequest))
                        .header("Content-Type", "application/json"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser
    public void testUserCanAccessFilteredAuctionGet() throws Exception {
        GetFilteredAuctionRequest getFilteredAuctionRequest = GetFilteredAuctionRequest.builder()
                .name("auction")
                .build();
        mockMvc.perform(get("/auction/getFiltered")
                        .content(objectMapper.writeValueAsString(getFilteredAuctionRequest))
                        .header("Content-Type", "application/json"))
                .andExpect(status().isOk());
    }
}
