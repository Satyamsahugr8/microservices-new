package com.programming.techie.inventoryservice.service;

import com.programming.techie.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {

    private final InventoryRepository inventoryRepository;

//    @Transactional(readOnly = true)
//    @SneakyThrows
//    public List<InventoryResponse> isInStock(List<String> skuCode) {
//        log.info("Checking Inventory");
//        return inventoryRepository.findBySkuCodeIn(skuCode).stream()
//                .map(inventory ->
//                        InventoryResponse.builder()
//                                .skuCode(inventory.getSkuCode())
//                                .isInStock(inventory.getQuantity() > 0)
//                                .build()
//                ).toList();
//    }

    @Transactional(readOnly = true)
    public boolean isInStock(String skuCode) {
        return inventoryRepository.findBySkuCode(skuCode).isPresent();
    }
}
