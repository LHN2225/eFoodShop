//package com.example.userservice;
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import java.util.List;
//
//import com.example.userservice.entity.Role;
//import com.example.userservice.repository.RoleRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.annotation.Rollback;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
//@Rollback(false)
//public class RoleRepositoryTests {
//
//    @Autowired private RoleRepository repo;
//
//    @Test
//    public void testCreateRoles() {
//        Role user = new Role("Manager");
//        Role admin = new Role("Shipper");
//        Role customer = new Role("Customer");
//
//        repo.saveAll(List.of(user, admin, customer));
//
//        List<Role> listRoles = repo.findAll();
//
//        assertThat(listRoles.size()).isEqualTo(3);
//    }
//}
