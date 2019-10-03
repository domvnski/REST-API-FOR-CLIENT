package com.example.demo.dao;

import com.example.demo.model.Geo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GeoDao {

    int insertGeo(UUID deviceId, Geo geo);

    default int insertGeo(Geo geo) {
        UUID devideId = UUID.randomUUID();
        return insertGeo(devideId, geo);
    }

    List<Geo> selectAllGeo();

    Optional<Geo> selectGeoById(UUID deviceId);

    int deleteGeoById(UUID deviceId);

    int updateGeoById(UUID deviceId, Geo newGeo);
}
