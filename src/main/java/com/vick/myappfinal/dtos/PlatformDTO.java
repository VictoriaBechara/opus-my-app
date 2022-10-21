package com.vick.myappfinal.dtos;

import com.vick.myappfinal.domain.Platform;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class PlatformDTO {
    private Integer platformId;
    private String platformName;

    public PlatformDTO(){
        super();
    }

    public PlatformDTO(@NotNull Platform obj) {
        super();
        this.platformId = obj.getPlatformId();
        this.platformName = obj.getPlatformName();
    }

    public Integer getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Integer platformId) {
        this.platformId = platformId;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlatformDTO that = (PlatformDTO) o;

        return Objects.equals(platformId, that.platformId);
    }

    @Override
    public int hashCode() {
        return platformId != null ? platformId.hashCode() : 0;
    }
}