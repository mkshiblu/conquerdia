package ca.concordia.encs.conquerdia.engine.map;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Continent {
    private String name;
    private String value;
    private WorldMap worldMap;

    private Continent() {
    }

    public String addContinentToWorldMap() {
        if (!worldMap.getContinents().contains(this)) {
            worldMap.getContinents().add(this);
            return String.format("Continent with name \"%s\" successfully added to World Map", name);
        } else {
            return String.format("Continent with name \"%s\" is already exists in World Map!", name);
        }
    }

    public String removeContinentFromWorldMap() {
        if (worldMap.getContinents().contains(this)) {
            worldMap.getContinents().remove(this);
            return String.format("Continent with name \"%s\" successfully removed from World Map", name);
        } else {
            return String.format("Continent with name \"%s\" is not exists in World Map!", name);
        }
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Continent continent = (Continent) o;

        return new EqualsBuilder()
                .append(name, continent.name)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(name)
                .toHashCode();
    }

    public static class Builder {
        private final Continent continent = new Continent();

        public Builder(String name) {
            continent.name = name;
        }

        public Builder setValue(String value) {
            continent.value = value;
            return this;
        }

        public Builder setWorldMap(WorldMap worldMap) {
            continent.worldMap = worldMap;
            return this;
        }

        public Continent build() {
            return this.continent;
        }
    }
}
