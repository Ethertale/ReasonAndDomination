package io.ethertale.reasonanddominationspringdefenseproject.runnerTESTS;

import io.ethertale.reasonanddominationspringdefenseproject.item.model.ItemWear;
import io.ethertale.reasonanddominationspringdefenseproject.item.repo.ItemWearRepo;
import io.ethertale.reasonanddominationspringdefenseproject.item.service.ItemWearService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements CommandLineRunner {

    ItemWearService itemWearService;
    ItemWearRepo itemWearRepo;

    public StartupRunner(ItemWearService itemWearService, ItemWearRepo itemWearRepo) {
        this.itemWearService = itemWearService;
        this.itemWearRepo = itemWearRepo;
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
