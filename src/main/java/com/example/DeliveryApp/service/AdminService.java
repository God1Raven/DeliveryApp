package com.example.DeliveryApp.service;

import com.example.DeliveryApp.dto.AdminDto;
import com.example.DeliveryApp.mapper.AdminMapper;
import com.example.DeliveryApp.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService implements BaseService<AdminDto>{

    private final AdminRepository adminRepository;
    private final AdminMapper adminMapper;

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
