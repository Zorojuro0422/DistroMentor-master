package com.group29.distromentorsystem.services;

import com.group29.distromentorsystem.models.ArchivedDealer;
import com.group29.distromentorsystem.repositories.ArchivedDealerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArchivedDealerService {

    @Autowired
    ArchivedDealerRepository archivedDealerRepository;

    public List<ArchivedDealer> getAllArchivedDealer(){
        return archivedDealerRepository.findAll();
    }

    public List<ArchivedDealer> getAllArchivedDealersByDistributorID(String distributorid) {
        return archivedDealerRepository.findAllByDistributor_Distributorid(distributorid);
    }
}
