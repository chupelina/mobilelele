package com.example.demo.service.impl;

import com.example.demo.model.entities.OfferEntity;
import com.example.demo.model.view.OfferSummaryViewModel;
import com.example.demo.repository.OfferRepository;
import com.example.demo.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<OfferSummaryViewModel> getAllOffers() {
        List<OfferSummaryViewModel> result = new ArrayList<>();
        List<OfferEntity> all = offerRepository.findAll();
        all.forEach(offer->{
            OfferSummaryViewModel current = modelMapper.map(offer,
                    OfferSummaryViewModel.class);
           result.add(current);
        });
        return result;
    }
}
