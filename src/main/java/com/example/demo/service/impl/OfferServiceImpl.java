package com.example.demo.service.impl;

import com.example.demo.model.entities.OfferEntity;
import com.example.demo.model.service.OfferServiceModel;
import com.example.demo.model.view.OfferSummaryViewModel;
import com.example.demo.repository.ModelRepository;
import com.example.demo.repository.OfferRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.CurrentUser;
import com.example.demo.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserRepository userRepository;
    private final ModelRepository modelRepository;


    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper, CurrentUser currentUser, UserRepository userRepository, ModelRepository modelRepository) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userRepository = userRepository;
        this.modelRepository = modelRepository;
    }

    @Override
    public List<OfferSummaryViewModel> getAllOffers() {
        List<OfferSummaryViewModel> result = new ArrayList<>();
        List<OfferEntity> all = offerRepository.findAll();
        all.forEach(offer -> {
            OfferSummaryViewModel current = modelMapper.map(offer,
                    OfferSummaryViewModel.class);
            result.add(current);
        });
        return result;
    }

    @Override
    public long save(OfferServiceModel model) {
        OfferEntity offerEntity = asNewEntity(model);
        OfferEntity newOffer = offerRepository.save(offerEntity);
        return newOffer.getId();
    }

    @Override
    public void delete(long id) {
        offerRepository.deleteById(id);
    }

    private OfferEntity asNewEntity(OfferServiceModel model) {
        OfferEntity offerEntity = new OfferEntity();
        offerEntity = modelMapper.map(model, OfferEntity.class);
        offerEntity.setId(null);
        offerEntity.setModel(modelRepository.findById(model.getModelId()).get());
        offerEntity.setSeller(userRepository.findByUsername(currentUser.getName()).get());
        return offerEntity;

    }
}
