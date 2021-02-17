package com.example.demo.web;

import com.example.demo.model.entities.enums.EngineEnum;
import com.example.demo.model.entities.enums.TransmissionEnum;
import com.example.demo.service.BrandService;
import com.example.demo.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/offers")
public class OffersController {
    private final OfferService offerService;
    private final BrandService brandService;


    public OffersController(OfferService offerService, BrandService brandService) {
        this.offerService = offerService;
        this.brandService = brandService;
    }


    @GetMapping("/all")
    public String getAllOffers(Model model){
    model.addAttribute("models", offerService.getAllOffers());
        return "offers";
    }

    @GetMapping("/add")
    public String addOffer(Model model){
        model.addAttribute("brands", brandService.getAllBrands());
        model.addAttribute("engines",EngineEnum.values());
        model.addAttribute("transmissions", TransmissionEnum.values());
        System.out.println();
        return "offer-add";
    }
}
