package ru.fathutdinova.auctionengine.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.fathutdinova.auctionengine.dto.AuctionLotDto;
import ru.fathutdinova.auctionengine.entity.AuctionLot;
import ru.fathutdinova.auctionengine.entity.Image;
import ru.fathutdinova.auctionengine.entity.User;
import ru.fathutdinova.auctionengine.mapper.DtoMapper;
import ru.fathutdinova.auctionengine.repository.AuctionLotRepository;
import ru.fathutdinova.auctionengine.repository.UserRepository;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class AuctionLotServiceImpl implements AuctionLotService{
    private final AuctionLotRepository auctionLotRepository;
    private final UserRepository userRepository;

    @Override
    public AuctionLotDto createAuctionLot(AuctionLotDto auctionLotDto, MultipartFile lotImage) {
        byte[] imageData;
        try {
            imageData = lotImage.getBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Image image = new Image();
        image.setImageData(imageData);
        image.setName(lotImage.getName());
        auctionLotDto.setImage(image);
        AuctionLot auctionLot = convertToAuctionLot(auctionLotDto);
        AuctionLot savedAuctionLot = auctionLotRepository.save(auctionLot);
        return DtoMapper.convertToAuctionLotDto(savedAuctionLot);
    }
    private AuctionLot convertToAuctionLot(AuctionLotDto auctionLotDto) {
        AuctionLot auctionLot = new AuctionLot();
        auctionLot.setName(auctionLotDto.getName());
        auctionLot.setDescription(auctionLotDto.getDescription());
        auctionLot.setStartBet(auctionLotDto.getStartBet());
        auctionLot.setUser(getCurrentUser());
        auctionLot.setImage(auctionLotDto.getImage());
        auctionLot.setFinalBet(auctionLotDto.getFinalBet());
        return auctionLot;
    }
    private User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userRepository.findByLogin(auth.getName());
    }
    @Override
    public AuctionLotDto getAuctionLotById(int id) {
        AuctionLot auctionLot = auctionLotRepository.findById(id).orElse(null);
        return auctionLot == null ? null : DtoMapper.convertToAuctionLotDto(auctionLot);
    }
    @Override
    public AuctionLotDto updateAuctionLot(AuctionLotDto auctionLotDto, MultipartFile lotImage) {
        byte[] imageData = null;
        if (lotImage != null) {
            try {
                imageData = lotImage.getBytes();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        AuctionLot auctionLot = auctionLotRepository.findById(auctionLotDto.getId()).orElse(null);
        if (auctionLot == null) {
            return null;
        }

        if (auctionLotDto.getName() != null) {
           auctionLot.setName(auctionLotDto.getName());
        }
        if (auctionLotDto.getDescription() != null) {
            auctionLot.setDescription(auctionLotDto.getDescription());
        }
        if (auctionLotDto.getStartBet() != 0) {
            auctionLot.setStartBet(auctionLotDto.getStartBet());
        }
        if (lotImage != null) {
            Image image = new Image();
            image.setImageData(imageData);
            image.setName(lotImage.getName());
            auctionLotDto.setImage(image);
        }

        AuctionLot updatedLot = auctionLotRepository.save(auctionLot);
        return DtoMapper.convertToAuctionLotDto(updatedLot);
    }
    @Override
    public void deleteAuctionLot(int id) {
        AuctionLot auctionLot = auctionLotRepository.findById(id).orElse(null);
        if (auctionLot != null) {
            auctionLotRepository.delete(auctionLot);
        }
    }
}
