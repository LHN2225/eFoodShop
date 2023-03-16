package com.example.shipper.controller;

import com.example.shipper.entity.Role;
import com.example.shipper.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("")
    public ResponseEntity<List<Role>> getAllRoles(@RequestParam(required = false) String roleName){
        try {
            List<Role> roles = new ArrayList<>();
            if (roleName == null) {
                roles = roleService.findAll();
            } else {
                roles = roleService.findByNameContaining(roleName);
            }
            if (roles.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(roles, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable("id") long id){
        Role role = roleService.findById(id);
        if (role != null) {
            return new ResponseEntity<>(role, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Role> createRole(@RequestBody Role role){
        try {
            Role tempRole = new Role();
            tempRole.setId(role.getId());
            tempRole.setRoleName(role.getRoleName());

            // save
            Role _role = roleService.saveRole(role);
            return new ResponseEntity<>(_role, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable("id") long id, @RequestBody Role role){
        Role _role = roleService.findById(id);
        if (_role!=null) {
            _role.setRoleName(role.getRoleName());
            return new ResponseEntity<>(roleService.saveRole(_role), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteRole(@PathVariable("id") long id){
        try{
            roleService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<HttpStatus> deleteAllRoles(){
        try{
            roleService.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
