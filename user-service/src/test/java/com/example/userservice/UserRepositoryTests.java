//package com.example.userservice;
//import static org.assertj.core.api.Assertions.assertThat;
//
//import com.example.userservice.entity.Role;
//import com.example.userservice.entity.User;
//import com.example.userservice.repository.RoleRepository;
//import com.example.userservice.repository.UserRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.annotation.Rollback;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
//@Rollback(false)
//public class UserRepositoryTests {
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Autowired
//    private UserRepository userRepo;
//
//    @Autowired
//    private RoleRepository roleRepo;
//
//    @Test
//    public void testCreateUser() {
//        User user = new User();
//        user.setEmail("phanha@gmail.com");
//        user.setPassword("haha123");
//        user.setFullname("Phan Ha");
//
//
//        User savedUser = userRepo.save(user);
//
//        User existUser = entityManager.find(User.class, savedUser.getId());
//
//        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
//
//    }
//
//    @Test
//    public void testAddRoleToNewUser() {
//        Role roleAdmin = roleRepo.findByName("Manager");
//
//        User user = new User();
//        user.setEmail("ha@gmail.com");
//        user.setPassword("haha123");
//        user.setFullname("Ha");
//
//        user.addRole(roleAdmin);
//
//        User savedUser = userRepo.save(user);
//
//        assertThat(savedUser.getRoles().size()).isEqualTo(1);
//    }
//
//    @Test
//    public void testAddRoleToExistingUser() {
//        User user = userRepo.findById(1L).get();
//        Role roleUser = roleRepo.findByName("Customer");
//        Role roleCustomer = new Role(3l);
//
//        user.addRole(roleUser);
//        user.addRole(roleCustomer);
//
//        User savedUser = userRepo.save(user);
//
//        assertThat(savedUser.getRoles().size()).isEqualTo(2);
//    }
//
//    @Test
//    public void testFindByEmail() {
//        String email = "phanha@gmail.com";
//        User user = userRepo.findByEmail(email);
//
//        assertThat(user.getEmail()).isEqualTo(email);
//    }
//}
