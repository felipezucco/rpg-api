package com.fzucco.core.configuration;

import com.fzucco.core.model.Place;
import com.fzucco.core.model.Profile;
import com.fzucco.core.model.WorldMap;
import com.fzucco.core.model.bag.Bag;
import com.fzucco.core.model.bag.bag_items.Money;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {

    @Bean
    public WorldMap getWorld() {
        WorldMap worldMap = new WorldMap();

        Place ancientHouse = new Place();
        ancientHouse.setName("Citizen's House");
        ancientHouse.setDescription("Ancient's house");
        ancientHouse.setUrl("/ancient");

        Place bar = new Place();
        bar.setName("Bar");
        bar.setDescription("The bar of the village.");
        bar.setUrl("/bar");

        Place[] places = {ancientHouse, bar};
        worldMap.setPlaces(places);

        return worldMap;
    }

    @Bean
    public Bag getBag() {
        Bag bag = new Bag();
        Money money = new Money();
        money.setQuantity(50d);
        bag.add(money);

        return bag;
    }

    @Bean
    public Profile getProfile() {
        return new Profile();
    }


}
