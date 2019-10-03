package com.example.demo.api;

import com.example.demo.model.Geo;
import com.example.demo.service.GeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/geo")
@RestController
public class GeoController {

    private final GeoService geoService;

    @Autowired
    public GeoController(GeoService geoService) {
        this.geoService = geoService;
    }

    @PostMapping
    public void addGeo(@Valid @NonNull @RequestBody Geo geo) {
        geoService.addGeo(geo);
    }

    @GetMapping
    public List<Geo> getAllGeo(){
        return geoService.getAllGeo();
    }

    @GetMapping(path = "{deviceId}")
    public Geo getGeoByID(@PathVariable("deviceId") UUID deviceId){
        return geoService.getGeoById(deviceId)
                .orElse(null);
    }

    @DeleteMapping (path = "{deviceId}")
    public void deleteGeoById (@PathVariable("deviceId") UUID deviceId){
        geoService.deleteGeo(deviceId);
    }

    @PutMapping (path = "{deviceId}")
    public void updateGeoById (@PathVariable("deviceId") UUID deviceId, @Valid @NonNull @RequestBody Geo newGeo){
        geoService.updateGeo(deviceId, newGeo);
    }


}
