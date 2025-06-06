package com.sg00170.delivery.service;

import com.sg00170.delivery.exception.NotFoundException;
import com.sg00170.delivery.model.Delivery;
import com.sg00170.delivery.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    public List<Delivery> getAllDeliveries() {
        return deliveryRepository.findAll();
    }

    public Delivery findDeliveryById(Long id) {
        return deliveryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Delivery not found"));
    }

    public Long saveDelivery(Delivery delivery) {
        return deliveryRepository.save(delivery).getId();
    }
}
