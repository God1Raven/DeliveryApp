package com.example.deliveryapp.service;

import com.example.deliveryapp.dto.AdminDto;
import com.example.deliveryapp.mapper.AdminMapper;
import com.example.deliveryapp.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<AdminDto> getAll() {
        return adminRepository.findAll().stream().map(adminMapper::mapEntityToDto).collect(Collectors.toList());
    }

}
