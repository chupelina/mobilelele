package com.example.demo;

import com.example.demo.model.entities.*;
import com.example.demo.model.entities.enums.CategoryEnum;
import com.example.demo.model.entities.enums.EngineEnum;
import com.example.demo.model.entities.enums.TransmissionEnum;
import com.example.demo.repository.BrandRepository;
import com.example.demo.repository.ModelRepository;
import com.example.demo.repository.OfferRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Component
public class DBInit implements CommandLineRunner {
    private final BrandRepository brandRepository;
    private final ModelRepository modelRepository;
    private final OfferRepository offerRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public DBInit(BrandRepository brandRepository, ModelRepository modelRepository, OfferRepository offerRepository, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.brandRepository = brandRepository;
        this.modelRepository = modelRepository;
        this.offerRepository = offerRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        BrandEntity fordBrand = new BrandEntity();
        fordBrand.setName("Ford");
        setDateTimes(fordBrand);
        BrandEntity hondaBrand = new BrandEntity();
        hondaBrand.setName("Honda");
        setDateTimes(hondaBrand);
        brandRepository.saveAll(List.of(fordBrand, hondaBrand));
        ModelEntity fiesta = setFiesta(fordBrand);
        setEscort(fordBrand);
        setNc750s(hondaBrand);
        createFiestaOffer(fiesta);
        initAdmin();
    }

    private void createFiestaOffer(ModelEntity model) {
        OfferEntity fiestaOffer = new OfferEntity();
        fiestaOffer.setEngine(EngineEnum.GASOLINE)
                .setImageUrl("https://www.motopfohe.bg/files/news/archive/2017/08/blob-server2.jpg")
                .setMileage(80000)
                .setPrice(BigDecimal.valueOf(10000))
                .setYear(2019)
                .setDescription("Karana e ot nemska baba")
                .setTransmission(TransmissionEnum.MANUAL)
                .setModel(model);
        setDateTimes(fiestaOffer);
        offerRepository.save(fiestaOffer);
    }

    private void initAdmin() {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName("Stamat").setLastName("Karadaq").setUsername("admin")
                .setPassword(passwordEncoder.encode("topsecret"));
        setDateTimes(userEntity);
        userRepository.save(userEntity);
    }

    private void setNc750s(BrandEntity hondaBrand) {
        ModelEntity nc750s = new ModelEntity();
        nc750s.setName("NC750S")
                .setImageUrl("https://www.mitchellsmc.co.uk/wp-content/uploads/2020/07/IMG_0686.jpg")
                .setCategory(CategoryEnum.MOTORCYCLE)
                .setStartYear(2014)
                .setBrand(hondaBrand);
        setDateTimes(nc750s);
        modelRepository.save(nc750s);
    }

    private void setEscort(BrandEntity fordBrand) {
        ModelEntity escort = new ModelEntity();
        escort.setName("Escort")
                .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/3/39/Ford_Escort_RS2000_MkI.jpg")
                .setCategory(CategoryEnum.CAR)
                .setStartYear(1981)
                .setEndYear(2004)
                .setBrand(fordBrand);
        setDateTimes(escort);
        modelRepository.save(escort);
    }

    private ModelEntity setFiesta(BrandEntity brandEntity) {
        ModelEntity fiesta = new ModelEntity();
        fiesta.setName("Fiesta")
                .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/7/7d/2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg")
                .setCategory(CategoryEnum.CAR)
                .setStartYear(1976)
                .setBrand(brandEntity);
        setDateTimes(fiesta);
        modelRepository.save(fiesta);
        return fiesta;
    }

    private static void setDateTimes(BaseEntity entity) {
        entity.setCreated(Instant.now()).setUpdated(Instant.now());
    }
}
