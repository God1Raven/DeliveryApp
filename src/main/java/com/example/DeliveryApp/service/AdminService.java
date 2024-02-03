package com.example.DeliveryApp.service;

import com.example.DeliveryApp.dto.AdminDto;
import com.example.DeliveryApp.mapper.AdminMapper;
import com.example.DeliveryApp.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class AdminService implements BaseService<AdminDto>{
    private AdminRepository adminRepository;
    private AdminMapper adminMapper;

    @Autowired
    public AdminService(AdminRepository adminRepository, AdminMapper adminMapper) {
        this.adminRepository = adminRepository;
        this.adminMapper = adminMapper;
    }

    public AdminDto create(AdminDto adminDto) {
        return adminMapper.mapEntityToDto(adminRepository.save(adminMapper.mapDtoToEntity(adminDto)));
    }

    public AdminDto update(AdminDto adminDto) {
        return adminMapper.mapEntityToDto(adminRepository.save(adminMapper.mapDtoToEntity(adminDto)));
    }

    public AdminDto get(Long id) {
        return adminRepository.findById(id).map(x -> adminMapper.mapEntityToDto(x)).orElse(null);
    }

    public void delete(Long id) {
        adminRepository.deleteById(id);
    }
}
