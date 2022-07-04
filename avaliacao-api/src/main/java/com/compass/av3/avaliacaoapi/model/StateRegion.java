package com.compass.av3.avaliacaoapi.model;


public enum StateRegion {

    NORTE("Norte"),
    NORDESTE("Nordeste"),
    SUL("Sul"),
    SUDESTE("Sudeste"),
    CENTRO_OESTE("Centro-Oeste");

    private String regions;

    private StateRegion(String regions) {
        this.regions = regions;
    }

    public String getRegions() {
        return regions;
    }

    public static StateRegion RegionValue(String regions) {
        for (StateRegion region : StateRegion.values()) {
            if (regions == region.getRegions()) {
                return region;
            }
        }


        //throw new InvalidFormatException("Região inválida");
        throw new IllegalArgumentException("Região inválida");
    }


}
