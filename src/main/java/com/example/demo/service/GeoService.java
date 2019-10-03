package com.example.demo.service;

import com.example.demo.dao.GeoDao;
import com.example.demo.model.Geo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GeoService {

    private final GeoDao geoDao;

    @Autowired
    public GeoService(@Qualifier("fakeDao") GeoDao geoDao) {
        this.geoDao = geoDao;
    }

    public int addGeo(Geo geo){
        return  geoDao.insertGeo(geo);
    }

    public List<Geo> getAllGeo() {
        return geoDao.selectAllGeo();

    }

    public Optional<Geo> getGeoById(UUID devideId){
        return geoDao.selectGeoById(devideId);
    }

    public int deleteGeo(UUID deviceId) {
        return geoDao.deleteGeoById(deviceId);
    }

    public int updateGeo(UUID deviceId, Geo newGeo) {
        return geoDao.updateGeoById(deviceId, newGeo);
    }

}
