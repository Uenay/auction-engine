package ru.fathutdinova.auctionengine;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.fathutdinova.auctionengine.api.request.CreateAuctionRequest;
import ru.fathutdinova.auctionengine.api.request.CreateUserRequest;
import ru.fathutdinova.auctionengine.api.response.CreateAuctionResponse;
import ru.fathutdinova.auctionengine.api.response.CreateUserResponse;
import ru.fathutdinova.auctionengine.dto.AuctionLotDto;
import ru.fathutdinova.auctionengine.entity.Image;
import ru.fathutdinova.auctionengine.entity.Role;
import ru.fathutdinova.auctionengine.service.AuctionLotService;

import java.io.InputStream;
import java.util.Date;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class AuctioneerControllerImplTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private AuctionLotService auctionLotService;
    private static final String CREATE_AUCTION_URL = "/auction/create";
    @Test
    @WithMockUser(username = "auctioneer")
    void createAuctionMvc() throws Exception {
        InputStream is = this.getClass().getResourceAsStream("backgroundDefault.jpg");
        MockMultipartFile image = new MockMultipartFile("lotImage", "111", MediaType.IMAGE_JPEG_VALUE, is);
//        Image image = new Image();
//        image.setName("aaa");
//        image.setImageData(is.readAllBytes());
        AuctionLotDto auctionLotDto = AuctionLotDto.builder()
                .name("a")
                .description("aaa")
                .startBet(1)
//                .image(image)
                .build();
        AuctionLotDto createdAuctionLot = auctionLotService.createAuctionLot(auctionLotDto, image);
        CreateAuctionRequest createAuctionRequest = CreateAuctionRequest.builder()
                .startTime(new Date(122, 1, 1))
                .auctionLotId(createdAuctionLot.getId())
                .build();
        CreateAuctionResponse createAuctionResponse = CreateAuctionResponse.builder()
                .id(1)
                .endTime(null)
                .currentUser(null)
                .currentBet(0)
                .auctionLotId(createdAuctionLot.getId())
                .startTime(new Date(122, 1, 1))
                .build();



        mockMvc.perform(
                        post(CREATE_AUCTION_URL)
                                .content(objectMapper.writeValueAsString(createAuctionRequest))
                                .header("Content-Type", "application/json")

                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.startTime").value(objectMapper.writeValueAsString(createAuctionRequest.getStartTime()).replaceAll("\"", "")))
                .andExpect(jsonPath("$.endTime").value(createAuctionResponse.getEndTime()))
                .andExpect(jsonPath("$.currentUser").value(createAuctionResponse.getCurrentUser()))
                .andExpect(jsonPath("$.currentBet").value(createAuctionResponse.getCurrentBet()))
                .andExpect(jsonPath("$.auctionLotId").value(createAuctionResponse.getAuctionLotId()));
    }
}
