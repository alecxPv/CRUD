package com.zegel.zegel.exam_device.negocio;

import com.zegel.zegel.exam_device.entidades.device;
import com.zegel.zegel.exam_device.repositorio.deviceRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class deviceService {
    @Autowired
    private deviceRepositorio deviceRepository;
    public device createDevice(device device) {
        return deviceRepository.save(device);
    }
    public List<device> getAllDevices() {
        return (List<device>) deviceRepository.findAll();
    }
    public device updateDevice(device device) {
        device d = deviceRepository.findById(device.getId()).get();
        if (d != null) {
            return deviceRepository.save(device);
        } else {
            return null;
        }
    }
    public device deleteDevice(Long id) {
        device d = deviceRepository.findById(id).get();
        if (d != null) {
            deviceRepository.delete(d);
        } else {
            return null;
        }
        return d;
    }
}
