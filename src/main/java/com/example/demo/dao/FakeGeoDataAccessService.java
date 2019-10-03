package com.example.demo.dao;

import com.example.demo.model.Geo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakeGeoDataAccessService implements GeoDao {

    private static List<Geo> DB = new ArrayList<>();

    @Override
    public int insertGeo(UUID deviceId, Geo geo) {
        DB.add(new Geo(deviceId, geo.getLatitude(), geo.getLongitude()));
        return 1;
    }

    @Override
    public List<Geo> selectAllGeo() {
        return DB;
    }

    @Override
    public Optional<Geo> selectGeoById(UUID deviceId) {
        return DB.stream()
                .filter(geo -> geo.getDeviceId().equals(deviceId))
                .findFirst();
    }

    @Override
    public int deleteGeoById(UUID deviceId) {
        Optional<Geo> geoMaybe = selectGeoById(deviceId);
        if (geoMaybe.isPresent()) {
            DB.remove(geoMaybe.get());
            return 1;
        }
        return 0;
    }

    @Override
    public int updateGeoById(UUID deviceId, Geo newGeo) {
        return selectGeoById(deviceId)
                .map(g -> {
                    int indexOfGeoToUpdate = DB.indexOf(g);
                    if (indexOfGeoToUpdate >= 0){
                        DB.set(indexOfGeoToUpdate, new Geo(deviceId, newGeo.getLatitude(), newGeo.getLongitude()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);

    }
}
