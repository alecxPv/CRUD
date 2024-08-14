package com.zegel.zegel.exam_device.rest;

import com.zegel.zegel.exam_device.entidades.device;
import com.zegel.zegel.exam_device.entidades.Seguridad.User;
import com.zegel.zegel.exam_device.negocio.deviceService;
import com.zegel.zegel.exam_device.negocio.UserNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class servicioRest {
    @Autowired
    private deviceService deviceService;
    @Autowired
    private UserNegocio Usernegocio;

    @PostMapping("/devices")
    public device createDevice(@RequestBody device device) {

        return deviceService.createDevice(device);
    }

    @GetMapping("/device")
    public List<device> getAllDevices() {
        try {
            return deviceService.getAllDevices();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No es posible obtener los datos");
        }
    }

    @PutMapping("/device")
    public device updateDevice(@RequestBody device device) {
        try {
            return deviceService.updateDevice(device);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No es posible actualizar");
        }
    }

    @DeleteMapping("/devices/{id}")
    public device deleteDevice(@PathVariable(value = "id") Long id) {
        return deviceService.deleteDevice(id);
    }


    // User

    @PostMapping("/api/users")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        User newUser = Usernegocio.grabar(user);
        return ResponseEntity.ok("User created successfully with id: " + newUser.getId());
    }

    @GetMapping("/api/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = Usernegocio.obtenerUsuarios();
        return ResponseEntity.ok(users);
    }
}



