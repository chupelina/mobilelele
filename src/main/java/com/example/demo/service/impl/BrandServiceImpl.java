package com.example.demo.service.impl;

import com.example.demo.model.entities.BrandEntity;
import com.example.demo.model.entities.ModelEntity;
import com.example.demo.model.view.BrandViewModel;
import com.example.demo.model.view.ModelViewModel;
import com.example.demo.repository.ModelRepository;
import com.example.demo.service.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {
    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;

    public BrandServiceImpl(ModelRepository modelRepository, ModelMapper modelMapper) {
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BrandViewModel> getAllBrands() {
        List<BrandViewModel> result = new ArrayList<>();
        List<ModelEntity> allModels = modelRepository.findAll();
        allModels.forEach(me -> {
            BrandEntity brandEntity = me.getBrand();
            Optional<BrandViewModel> brandViewModelOptional = findByName(result, brandEntity.getName());
            if (!brandViewModelOptional.isPresent()) {
                BrandViewModel newBrandViewModel = new BrandViewModel();
                modelMapper.map(brandEntity, newBrandViewModel);
                result.add(newBrandViewModel);
                brandViewModelOptional = Optional.of(newBrandViewModel);
            }
            ModelViewModel newMVM = new ModelViewModel();
            modelMapper.map(me, newMVM);
           brandViewModelOptional.get().addingMVM(newMVM);

        });
        return result;
    }

    private static Optional<BrandViewModel> findByName(List<BrandViewModel> all, String name) {
        return all.stream().filter(m -> m.getName().equals(name)).findAny();
    }
}
