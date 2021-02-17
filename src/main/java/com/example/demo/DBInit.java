package com.example.demo;

import com.example.demo.model.entities.*;
import com.example.demo.model.entities.enums.CategoryEnum;
import com.example.demo.model.entities.enums.EngineEnum;
import com.example.demo.model.entities.enums.Role;
import com.example.demo.model.entities.enums.TransmissionEnum;
import com.example.demo.repository.*;
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
    private final RolesRepository rolesRepository;

    public DBInit(BrandRepository brandRepository, ModelRepository modelRepository, OfferRepository offerRepository, PasswordEncoder passwordEncoder, UserRepository userRepository, RolesRepository rolesRepository) {
        this.brandRepository = brandRepository;
        this.modelRepository = modelRepository;
        this.offerRepository = offerRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.rolesRepository = rolesRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        BrandEntity fordBrand = new BrandEntity();
        fordBrand.setName("Ford");
        BrandEntity hondaBrand = new BrandEntity();
        hondaBrand.setName("Honda");
        brandRepository.saveAll(List.of(fordBrand, hondaBrand));
        ModelEntity fiesta = setFiesta(fordBrand);
        setEscort(fordBrand);
        setNc750s(hondaBrand);
        createFiestaOffer(fiesta);
        initUsers();
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
        offerRepository.save(fiestaOffer);
    }

    private void initUsers() {
        UserRoleEntity adminRole = new UserRoleEntity();
        adminRole.setRole(Role.ADMIN);
        UserRoleEntity userRole = new UserRoleEntity();
        userRole.setRole(Role.USER);
        rolesRepository.saveAll(List.of(adminRole, userRole));
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName("Stamat").setLastName("Karadaq").setUsername("admin")
                .setPassword(passwordEncoder.encode("admin"))
                .setRoles(List.of(adminRole, userRole));
        UserEntity user = new UserEntity();
        user.setFirstName("Pesho").setLastName("Ivanov").setUsername("user")
                .setPassword(passwordEncoder.encode("user"))
                .setRoles(List.of(userRole));
        userRepository.saveAll(List.of(user, userEntity));
    }

    private void setNc750s(BrandEntity hondaBrand) {
        ModelEntity nc750s = new ModelEntity();
        nc750s.setName("NC750S")
                .setImageUrl("https://www.mitchellsmc.co.uk/wp-content/uploads/2020/07/IMG_0686.jpg")
                .setCategory(CategoryEnum.MOTORCYCLE)
                .setStartYear(2014)
                .setBrand(hondaBrand);
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
        modelRepository.save(escort);
    }

    private ModelEntity setFiesta(BrandEntity brandEntity) {
        ModelEntity fiesta = new ModelEntity();
        fiesta.setName("Fiesta")
                .setImageUrl("https://upload.wikimedia.org/wikipedia/commons/7/7d/2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg")
                .setCategory(CategoryEnum.CAR)
                .setStartYear(1976)
                .setBrand(brandEntity);
        modelRepository.save(fiesta);
        return fiesta;
    }

}
